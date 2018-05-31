package com.example.butur.whitetile.GameLogic;
import android.util.Log;
import java.util.Random;
import java.util.ArrayList;

public class Logic {

    private Position startPosition = new Position(0, 0);

    private ArrayList<Tile> tiles = new ArrayList<Tile>();

    private int score = 0;

    private int tickCount = 0;

    private boolean playing = true;

    private float width;
    private float height;

    private Random random = new Random();

    public int getScore() {
        return score;
    }

    public int getTickCount() {
        return tickCount;
    }

    public void generateRow() {
        float tileSize = this.width / 5;
        float tilePadding = (this.width - (tileSize * 4)) / 4;
        for (int i = 0; i < 4; i++) {
            TileType type = random.nextBoolean() ? TileType.Black : TileType.White;

            float x = i * (tileSize + tilePadding) + tilePadding / 2;
            Tile tile = new Tile(new Position(x, 50), type);
            tile.setSize(tileSize);
            tiles.add(tile);
        }
    }

    public void updateTiles() {
        for (Tile tile : tiles) {
            Position position = tile.getPosition();
            position.y += 15;
            tile.setPosition(position);
        }
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    public void tick() {
        this.tickCount++;
        Log.i("Tick", this.tickCount + "");
        if (this.tickCount == 40) {
            this.tickCount = 0;
        }
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public void setSize(float width, float height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Check if the touch coors is collide with a tile
     * @param x
     * @param y
     */
    public int checkCollide(float x, float y) {
        for (Tile tile : tiles) {
            boolean isCollide = tile.checkCollide(x, y);

            if (isCollide) {
                if (tile.isBlack()) {
                    tile.hide();
                    this.score++;
                    return 1;
                } else {
                    this.playing = false;
                    return 2;
                }
            }
        }

        return 0;
    }

}
