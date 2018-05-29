package com.example.butur.whitetile;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.butur.whitetile.GameLogic.Logic;
import com.example.butur.whitetile.GameLogic.Position;
import com.example.butur.whitetile.GameLogic.Tile;

import java.util.ArrayList;

public class CanvasView extends SurfaceView implements Runnable {

    Logic logic = new Logic();

    Thread gameThread = null;

    Canvas canvas;

    SurfaceHolder surfaceHolder;

    float width;

    boolean playing;

    Context context;

    public CanvasView(Context context) {
        super(context);
        surfaceHolder = getHolder();
        playing = true;
        logic.generateRow();
        this.context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        this.draw();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        logic.checkCollide(x, y);
        return super.onTouchEvent(event);
    }

    private void drawTiles() {
        ArrayList<Tile> tiles = logic.getTiles();

        for (Tile tile : tiles) {
            if (tile.isVisible()) {
                drawTile(tile);
            }
        }
    }

    private void drawTile(Tile tile) {
        Paint paint = new Paint();
        switch (tile.getType()) {
            case White:
                paint.setColor(Color.WHITE);
                break;
            case Black:
                paint.setColor(Color.BLACK);
                break;
        }

        Position position = tile.getPosition();
        float x = position.x;
        float y = position.y;

        float width = x + tile.getSize();
        float height = y + tile.getSize();

        canvas.drawRect(x, y, width, height, paint);
    }

    public void drawScore() {
        String text = "Score: " + logic.getScore();

        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(60);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(text, this.width / 2, 70, paint);
    }

    public void draw() {
        canvas = surfaceHolder.lockCanvas();

        if (canvas != null) {
            canvas.drawColor(Color.BLUE);
            this.drawScore();
            drawTiles();
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    public void update() {
        int tick = logic.getTickCount();
        if (logic.getTickCount() == 19) {
            logic.generateRow();
        }

        logic.tick();
        logic.updateTiles();
    }

    public void resume() {
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void pause() {
        playing = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            Log.e("Error:", "joining thread");
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.width = w;
        logic.setSize(w, h);
    }

    @Override
    public void run() {
        while (logic.isPlaying()) {
            try {
                update();
                draw();
            } catch (Exception e) {

            }
        }

        Intent intent = new Intent(context, Score.class);
        context.startActivity(intent);
    }

}
