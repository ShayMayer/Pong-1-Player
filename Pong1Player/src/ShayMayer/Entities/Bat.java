package ShayMayer.Entities;

import ShayMayer.LogicUtils.CollisionInfo;

import java.awt.*;

public class Bat extends MovingBox {
    private static final int DEFAULT_BAT_WIDTH = 120;
    private static final int DEFAULT_BAT_HEIGHT = 20;
    private static final int DEFAULT_BAT_VELOCITY = 15;
    private static final Color BAT_COLOR = Color.BLACK;

    public Bat(int x, int y, int width, int height, int velocity, Color color, boolean filled) {
        super(x, y, width, height, velocity, 0, color, filled);
    }

    public Bat(int x, int y) {
        this(x, y, DEFAULT_BAT_WIDTH, DEFAULT_BAT_HEIGHT, DEFAULT_BAT_VELOCITY, BAT_COLOR, true);
    }

    public CollisionInfo collided(Rect box) {
        if(!(box instanceof Ball)) return CollisionInfo.NONE;
        Ball ball = (Ball)box;

        Rectangle batRect = new Rectangle(this.x, this.y, this.width, this.height);
        Rectangle ballRect = new Rectangle(ball.x, ball.y, ball.width, ball.height);
        if(!batRect.intersects(ballRect)) return CollisionInfo.NONE;

        if(ball.y <= this.y && ball.y + ball.getSize() >= this.y) return CollisionInfo.UP;
        if(ball.x <= this.x && ball.x + ball.getSize() >= this.x) return CollisionInfo.LEFT;
        if(ball.x <= this.x + this.width && ball.x + ball.getSize() >= this.x + this.width) return CollisionInfo.RIGHT;
        //if(ball.y >= this.y && ball.y <= this.y + this.height) return CollisionInfo.DOWN;
        return CollisionInfo.NONE;
    }

    public void resetVelocity() { this.setVelocityX(DEFAULT_BAT_VELOCITY); }
    @Override
    public void set(int x, int y) { this.setX(y); }
    @Override
    public void setY(int y) {}
    @Override
    public void setVelocityY(int velocityY) {}
    @Override
    public void setVelocity(int velocityX, int velocityY) { this.setVelocityX(velocityX); }
}
