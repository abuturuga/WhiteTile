package com.example.butur.whitetile.GameLogic;


public class Tile {

    private Position position;
    private TileType type;
    private float size = 100;
    private boolean visible = true;

    public Tile(Position position, TileType type) {
        this.position = position;
        this.type = type;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public TileType getType() {
        return type;
    }

    public void setType(TileType type) {
        this.type = type;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public boolean isWhite() {
        return this.type == TileType.White;
    }

    public boolean isBlack() { return this.type == TileType.Black; }

    public void hide() {
        this.visible = false;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public boolean checkCollide(float x, float y) {
        return (x >= position.x && x <= position.x + this.size &&
                y >= position.y && y <= position.y + this.size);
    }
}
