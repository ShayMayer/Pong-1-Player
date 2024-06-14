package ShayMayer.Entities;

public abstract class MovingBox extends Box {
    protected int velocityX, velocityY;

    public MovingBox(int x, int y, int width, int height, int velocityX, int velocityY) {
        super(x, y, width, height);

        this.setVelocity(velocityX, velocityY);
    }

    public void updatePosition() { this.updatePositionX(); this.updatePositionY(); }
    public void updatePositionX() {
        this.x += this.velocityX;
    }
    public void updatePositionY() {
        this.y += this.velocityY;
    }

    public void negateVelocity() { this.negateVelocityX(); this.negateVelocityY(); }
    public void negateVelocityX() {
        this.velocityX *= -1;
    }
    public void negateVelocityY() {
        this.velocityY *= -1;
    }

    public void setVelocity(int velocityX, int velocityY) { this.setVelocityX(velocityX); this.setVelocityY(velocityY); }
    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }
    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    public int getVelocityX() {
        return velocityX;
    }
    public int getVelocityY() {
        return velocityY;
    }
}
