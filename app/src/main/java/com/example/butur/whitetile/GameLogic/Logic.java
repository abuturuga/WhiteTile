package com.example.butur.whitetile.GameLogic;
import android.util.Log;

import java.util.ArrayList;

public class Logic {

    private Position startPosition = new Position(0, 0);

    private ArrayList<Tile> tiles = new ArrayList<Tile>();

    private int score = 0;

    private int tickCount = 0;

    public int getScore() {
        return score;
    }

    public int getTickCount() {
        return tickCount;
    }

    public void generateRow() {
        tiles.add(new Tile(new Position(0, 0), TileType.White));
        tiles.add(new Tile(new Position(300, 0), TileType.Black));
        Log.i("Generate tiles", "haide");
    }

    public void updateTiles() {
        for (Tile tile : tiles) {
            Position position = tile.getPosition();
            position.y += 1;
            tile.setPosition(position);
        }
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    public void tick() {
        this.tickCount++;
        Log.i("Tick", this.tickCount + "");
        if (this.tickCount == 20) {
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
                if (tile.isWhite()) {
                    this.score++;
                }
            }
        }
    }

}
