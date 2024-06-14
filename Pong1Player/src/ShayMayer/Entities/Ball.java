package ShayMayer.Entities;

public class Ball extends MovingBox {
    private static final int DEFAULT_BALL_VELOCITY_X = 10;
    private static final int DEFAULT_BALL_VELOCITY_Y = -10;
    private static final double DEFAULT_VELOCITY_FACTOR = 1.05;
    private static final int DEFAULT_BALL_SIZE = 20;

    public Ball(int x, int y, int size, int velocityX, int velocityY) {
        super(x - DEFAULT_BALL_SIZE / 2, y, size, size, velocityX, velocityY);
    }

    public Ball(int x, int y) {
        this(x, y, DEFAULT_BALL_SIZE, DEFAULT_BALL_VELOCITY_X, DEFAULT_BALL_VELOCITY_Y);
    }

    public void resetVelocity() { this.setVelocity(DEFAULT_BALL_VELOCITY_X, DEFAULT_BALL_VELOCITY_Y); }

    public void increaseVelocity() { this.setVelocity((int)(this.velocityX * DEFAULT_VELOCITY_FACTOR), (int)(this.velocityY * DEFAULT_VELOCITY_FACTOR)); }

    public int getSize() { return this.width; }
}
