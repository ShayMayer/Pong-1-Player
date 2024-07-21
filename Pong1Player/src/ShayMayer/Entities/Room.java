package ShayMayer.Entities;

import ShayMayer.LogicUtils.CollisionInfo;

import java.awt.*;

public class Room extends Rect {
    private static final Color ROOM_COLOR = Color.BLACK;

    public Room(int x, int y, int width, int height, Color color, boolean filled) {
        super(x, y, width, height, color, filled);
    }

    public Room(int x, int y, int width, int height) {
        this(x, y, width, height, ROOM_COLOR, false);
    }

    @Override
    public CollisionInfo collided(Rect box) {
        if (box instanceof Bat) {
            Bat bat = (Bat)box;
            if(bat.x <= this.x) return CollisionInfo.LEFT;
            if(bat.x + bat.width >= this.x + this.width) return CollisionInfo.RIGHT;
        } else if (box instanceof Ball) {
            Ball ball = (Ball)box;
            if(ball.x <= this.x) return CollisionInfo.LEFT;
            if(ball.x + ball.getSize() >= this.x + this.width) return CollisionInfo.RIGHT;
            if(ball.y <= this.y) return CollisionInfo.UP;
            if(ball.y + ball.height >= this.y + this.height) return CollisionInfo.DOWN;
        }

        return CollisionInfo.NONE;
    }
}
