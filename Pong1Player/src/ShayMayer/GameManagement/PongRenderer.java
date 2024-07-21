package ShayMayer.GameManagement;

import ShayMayer.Entities.Rect;
import ShayMayer.LogicUtils.Lives;
import ShayMayer.LogicUtils.Score;

import javax.swing.*;
import java.awt.*;

public class PongRenderer extends JPanel {
    private static final int SCORE_BOARD_FONT_SIZE = 40;
    private static final int SCORE_BOARD_MARGIN = 24;

    private static final int LIVES_BOARD_MARGIN = 820;

    private Score score;
    private Lives lives;
    private Rect[] gameParts;

    private int originX, originY;

    public PongRenderer(int originX, int originY) {
        this.originX = originX;
        this.originY = originY;
    }

    public void setCosmeticParts(Score score, Lives lives) {
        this.score = score;
        this.lives = lives;
    }

    public void setGameParts(Rect[] gameParts) {
        this.gameParts = gameParts;
    }

    private void paintGameParts(Graphics g) {
        for(Rect part : this.gameParts) {
            g.setColor(part.getColor());

            if(part.toFill())
                g.fillRect(this.originX + part.getX(), this.originY + part.getY(), part.getWidth(), part.getHeight());
            else {
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(4));
                g.drawLine(this.originX + part.getX(), this.originY + part.getY(), this.originX + part.getX() + part.getWidth(), this.originY + part.getY());
                g.drawLine( this.originX + part.getX() + part.getWidth(), this.originY + part.getY(), this.originX + part.getX() + part.getWidth(), this.originY + part.getY() + part.getHeight());
                g.drawLine(this.originX + part.getX() + part.getWidth(), this.originY + part.getY() + part.getHeight(), this.originX + part.getX(), this.originY + part.getY() + part.getHeight());
                g.drawLine(this.originX + part.getX(), this.originY + part.getY() + part.getHeight(), this.originX + part.getX(), this.originY + part.getY());
            }
        }
    }

    private void paintScore(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, SCORE_BOARD_FONT_SIZE));
        g.drawString("Score: " + this.score.getScore(), originX, originY - SCORE_BOARD_MARGIN);
    }

    private void paintLives(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, SCORE_BOARD_FONT_SIZE));
        g.drawString("Lives: " + this.lives.getLives(), originX + LIVES_BOARD_MARGIN, originY - SCORE_BOARD_MARGIN);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.paintGameParts(g);
        this.paintScore(g);
        this.paintLives(g);
    }
}
