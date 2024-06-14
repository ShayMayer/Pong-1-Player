package ShayMayer.GameManagement;

import ShayMayer.Entities.Ball;
import ShayMayer.Entities.Bat;
import ShayMayer.Entities.Room;
import ShayMayer.Input.GameOverInputHandler;
import ShayMayer.Input.InGameInputHandler;
import ShayMayer.LogicUtils.Lives;
import ShayMayer.LogicUtils.Score;
import ShayMayer.LogicUtils.StopWatch;

import javax.swing.*;

public class PongGame extends JFrame {
    private static final int SCREEN_WIDTH = 1200;
    private static final int SCREEN_HEIGHT = 800;

    private static final int FRAME_DELAY = 20;

    private PongLogic logic;
    private PongRenderer renderer;

    private InGameInputHandler inGameInputHandler;
    private GameOverInputHandler gameOverInputHandler;

    private StopWatch stopWatch;

    public PongGame() {
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        Room room = new Room(0, 0, (int)(SCREEN_WIDTH * 0.8), (int)(SCREEN_HEIGHT * 0.8));
        Bat bat = new Bat(((room.getX() + room.getX() + room.getWidth()) / 2), room.getY() + (int)((room.getY() + room.getHeight()) * 0.85));
        Ball ball = new Ball(room.getX() + room.getX() + room.getWidth() / 2, (room.getX() + room.getHeight()) / 3);
        Score score = new Score();
        Lives lives = new Lives();

        this.initializeListeners();

        this.logic = new PongLogic(room, bat, ball, score, lives ,inGameInputHandler);

        this.renderer = new PongRenderer((int)(SCREEN_WIDTH * 0.1), (int)(SCREEN_HEIGHT * 0.1));
        this.renderer.setParts(room, bat, ball, score, lives);

        this.setStopWatch();

        this.add(this.renderer);

        this.setVisible(true);
    }

    private void initializeListeners() {
        this.inGameInputHandler = new InGameInputHandler();
        this.addKeyListener(inGameInputHandler);
        this.gameOverInputHandler = new GameOverInputHandler();
        this.addKeyListener(gameOverInputHandler);
    }

    private void setStopWatch() {
        this.stopWatch = new StopWatch(FRAME_DELAY);
    }

    private void updateLogic() {
        this.logic.update();

        if (this.logic.gameOver())
            if (this.gameOverInputHandler.toRestart()) {
                this.logic.reset();
                this.gameOverInputHandler.reset();
            }
    }

    private void updateGraphics() {
        this.renderer.repaint();
    }

    public void update() {
        if(this.stopWatch.timePassed()) {
            this.updateLogic();
            this.updateGraphics();

            this.stopWatch.reset();
        }
    }
}
