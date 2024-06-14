package ShayMayer.Entities;

public abstract class Box {
    protected int x, y;
    protected int width, height;

    public Box(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() { return x; }
    public int getY() {
        return y;
    }

    public void set(int x, int y) { this.setX(x); this.setY(y);}
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
