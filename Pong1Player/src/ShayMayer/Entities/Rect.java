package ShayMayer.Entities;

import ShayMayer.LogicUtils.CollisionInfo;

import java.awt.*;

public abstract class Rect {
    protected int x, y;
    protected int width, height;
    protected Color color;
    protected boolean toFill;

    public Rect(int x, int y, int width, int height, Color color, boolean toFill) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.toFill = toFill;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public void set(int x, int y) { this.setX(x); this.setY(y);}
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    public void move(int x, int y) {
        moveX(x);
        moveY(y);
    }

    public void moveX(int x) { this.x += x; }
    public void moveY(int y) { this.y += y; }

    public void setColor(Color color) { this.color = color; }

    public void setToFill(boolean toFill) { this.toFill = toFill; }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public Color getColor() { return color; }

    public boolean toFill() { return this.toFill; }

    public abstract CollisionInfo collided(Rect box);
}
