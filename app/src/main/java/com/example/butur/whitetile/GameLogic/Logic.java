package com.example.butur.whitetile.GameLogic;
import android.util.Log;
import java.util.Random;
import java.util.ArrayList;

public class Logic {

    private Position startPosition = new Position(0, 0);

    private ArrayList<Tile> tiles = new ArrayList<Tile>();

    private int score = 0;

    private int tickCount = 0;

    private Random random = new Random();

    public int getScore() {
        return score;
    }

    public int getTickCount() {
        return tickCount;
    }

    public void generateRow() {
        for (int i = 0; i < 5; i++) {
            TileType type = random.nextBoolean() ? TileType.Black : TileType.White;

            float x = i * 200;

            tiles.add(new Tile(new Position(x, 0), type));
        }
    }

    public void updateTiles() {
        for (Tile tile : tiles) {
            Position position = tile.getPosition();
            position.y += 5;
            tile.setPosition(position);
        }
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    public void tick() {
        this.tickCount++;
        Log.i("Tick", this.tickCount + "");
        if (this.tickCount == 60) {
            this.tickCount = 0;
        }
    }

    /**
     * Check if the touch coors is collide with a tile
     * @param x
     * @param y
     */
    public void checkCollide(float x, float y) {
        for (Tile tile : tiles) {
            boolean isCollide = tile.checkCollide(x, y);

            if (isCollide) {
                if (tile.isBlack()) {
                    tile.hide();
                    this.score++;
                }
            }
        }
    }

}
