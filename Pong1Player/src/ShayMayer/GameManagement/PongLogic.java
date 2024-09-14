package ShayMayer.GameManagement;

import ShayMayer.Entities.Ball;
import ShayMayer.Entities.Bat;
import ShayMayer.Entities.Room;
import ShayMayer.Input.InGameInputHandler;
import ShayMayer.LogicUtils.CollisionInfo;
import ShayMayer.LogicUtils.Lives;
import ShayMayer.LogicUtils.Score;

public class PongLogic {
    private Room room;
    private Bat bat;
    private Ball ball;
    private Score score;
    private Lives lives;
    private InGameInputHandler inputHandler;

    public PongLogic(Room room, Bat bat, Ball ball, Score score, Lives lives, InGameInputHandler inputHandler) {
        this.room = room;
        this.bat = bat;
        this.ball = ball;
        this.score = score;
        this.lives = lives;
        this.inputHandler = inputHandler;
    }

    public void updateBatPosition() {
        boolean leftPressed = this.inputHandler.leftPressed();
        boolean rightPressed = this.inputHandler.rightPressed();

        if((leftPressed && rightPressed) || (!leftPressed && !rightPressed)) return;

        if(leftPressed) this.bat.moveLeft();
        else this.bat.moveRight();

        CollisionInfo roomWithBatCollision = this.room.collided(this.bat);
        if(roomWithBatCollision != CollisionInfo.NONE) {
            switch (roomWithBatCollision) {
                case LEFT: this.bat.setX(this.room.getX()); break;
                case RIGHT: this.bat.setX(this.room.getX() + this.room.getWidth() - this.bat.getWidth()); break;
                default: break;
            }
        }
    }

    public void updateBallPosition() {
        this.ball.updatePosition();

        CollisionInfo roomWithBallCollision = this.room.collided(this.ball);
        if(roomWithBallCollision != CollisionInfo.NONE) {
            switch (roomWithBallCollision) {
                case LEFT: this.ball.setX(this.room.getX()); this.ball.negateVelocityX(); break;
                case RIGHT: this.ball.setX(this.room.getX() + this.room.getWidth() - this.ball.getWidth()); this.ball.negateVelocityX(); break;
                case UP: this.ball.setY(this.room.getY()); this.ball.negateVelocityY(); break;
                case DOWN:
                    this.lives.update();

                    if(gameOver()) {
                        this.ball.setVelocity(0, 0);
                        this.bat.setVelocityX(0);
                        return;
                    }

                    this.ball.set((room.getX() + room.getX() + room.getWidth() / 2) - this.ball.getSize() / 2, (room.getX() + room.getHeight()) / 3);
                    this.ball.resetVelocity();

                    break;
                default: break;
            }
        }

        CollisionInfo batWithBallCollision = this.bat.collided(this.ball);
        if(batWithBallCollision != CollisionInfo.NONE) {
            switch (batWithBallCollision) {
                case UP: this.ball.setY(this.bat.getY() - this.ball.getSize()); this.ball.negateVelocityY(); break;
                case LEFT: this.ball.setX(this.bat.getX() - this.ball.getSize()); this.ball.negateVelocity(); break;
                case RIGHT: this.ball.setX(this.bat.getX() + this.bat.getWidth()); this.ball.negateVelocity(); break;
                default: break;
            }
            this.ball.increaseVelocity();
            this.score.update();
        }
    }

    public boolean gameOver() { return this.lives.getLives() == 0; }

    public void updatePosition() {
        if(this.gameOver()) return;

        this.updateBatPosition();
        this.updateBallPosition();
    }

    public void reset() {
        this.lives.reset();
        this.score.reset();

        this.bat.setX(((room.getX() + room.getX() + room.getWidth()) / 2) - this.bat.getWidth() / 2);
        this.bat.resetVelocity();

        this.ball.set((room.getX() + room.getX() + room.getWidth() / 2) - this.ball.getSize() / 2, (room.getX() + room.getHeight()) / 3);
        this.ball.resetVelocity();
    }

    public void update() {
        this.updatePosition();
    }
}
