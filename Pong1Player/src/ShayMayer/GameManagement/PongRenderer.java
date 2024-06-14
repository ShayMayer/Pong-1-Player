package ShayMayer.GameManagement;

import ShayMayer.Entities.Ball;
import ShayMayer.Entities.Bat;
import ShayMayer.Entities.Room;
import ShayMayer.LogicUtils.Lives;
import ShayMayer.LogicUtils.Score;

import javax.swing.*;
import java.awt.*;

public class PongRenderer extends JPanel {
    private static final Color BAT_COLOR = Color.BLACK;
    private static final Color BALL_COLOR = Color.GREEN;

    private static final int SCORE_BOARD_FONT_SIZE = 40;
    private static final int SCORE_BOARD_MARGIN = 24;

    private static final int LIVES_BOARD_MARGIN = 140;

    private Room room;
    private Bat bat;
    private Ball ball;
    private Score score;
    private Lives lives;

    private int originX, originY;

    public PongRenderer(int originX, int originY) {
        this.originX = originX;
        this.originY = originY;
    }

    public void setParts(Room room, Bat bat, Ball ball, Score score, Lives lives) {
        this.room = room;
        this.bat = bat;
        this.ball = ball;
        this.score = score;
        this.lives = lives;
    }

    public void paintRoom(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(4));
        g.drawLine(this.originX + this.room.getX(), this.originY + this.room.getY(), this.originX + this.room.getX() + this.room.getWidth(), this.originY + this.room.getY());
        g.drawLine( this.originX + this.room.getX() + this.room.getWidth(), this.originY + this.room.getY(), this.originX + this.room.getX() + this.room.getWidth(), this.originY + this.room.getY() + this.room.getHeight());
        g.drawLine(this.originX + this.room.getX() + this.room.getWidth(), this.originY + this.room.getY() + this.room.getHeight(), this.originX + this.room.getX(), this.originY + this.room.getY() + this.room.getHeight());
        g.drawLine(this.originX + this.room.getX(), this.originY + this.room.getY() + this.room.getHeight(), this.originX + this.room.getX(), this.originY + this.room.getY());
    }

    private void paintBat(Graphics g) {
        g.setColor(BAT_COLOR);
        g.fillRect(this.originX + this.bat.getX(), this.originY + this.bat.getY(), this.bat.getWidth(), this.bat.getHeight());
    }

    private void paintBall(Graphics g) {
        g.setColor(BALL_COLOR);
        g.fillOval(this.originX + this.ball.getX(), this.originY + this.ball.getY(), this.ball.getSize(), this.ball.getSize());
    }

    private void paintScore(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, SCORE_BOARD_FONT_SIZE));
        g.drawString("Score: " + this.score.getScore(), originX, originY - SCORE_BOARD_MARGIN);
    }

    private void paintLives(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, SCORE_BOARD_FONT_SIZE));
        g.drawString("Lives: " + this.lives.getLives(), originX + this.room.getWidth() - LIVES_BOARD_MARGIN, originY - SCORE_BOARD_MARGIN);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.paintRoom(g);
        this.paintBat(g);
        this.paintBall(g);
        this.paintScore(g);
        this.paintLives(g);
    }
}
