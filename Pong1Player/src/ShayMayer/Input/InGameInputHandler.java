package ShayMayer.Input;

import java.awt.event.KeyEvent;
import java.util.HashSet;

public class InGameInputHandler extends InputHandler {
    private static final int LEFT_OPTION_1 = KeyEvent.VK_A;
    private static final int LEFT_OPTION_2 = KeyEvent.VK_LEFT;
    private static final int RIGHT_OPTION_1 = KeyEvent.VK_D;
    private static final int RIGHT_OPTION_2 = KeyEvent.VK_RIGHT;

    private HashSet<Integer> pressedKeys;

    public InGameInputHandler() {
        this.pressedKeys = new HashSet<Integer>();
    }

    public boolean leftPressed() { return (this.pressedKeys.contains(LEFT_OPTION_1) || this.pressedKeys.contains(LEFT_OPTION_2)); }

    public boolean rightPressed() { return (this.pressedKeys.contains(RIGHT_OPTION_1) || this.pressedKeys.contains(RIGHT_OPTION_2)); }

    @Override
    public void keyPressed(KeyEvent e) {
        this.pressedKeys.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.pressedKeys.remove(e.getKeyCode());
    }
}