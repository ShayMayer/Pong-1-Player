package ShayMayer.LogicUtils;

public class Lives {
    private static final int DEFAULT_LIVES = 3;

    private int lives;

    public Lives() {
        this.lives = DEFAULT_LIVES;
    }

    public void reset() { this.lives = DEFAULT_LIVES; }

    public int getLives() { return this.lives; }

    public void update() { this.lives--; }
}
