package ShayMayer.Entities;

import ShayMayer.LogicUtils.CollisionInfo;

public class Room extends Box {
    public Room(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    
    public CollisionInfo collided(Bat bat) {
        if(bat.x <= this.x) return CollisionInfo.LEFT;
        if(bat.x + bat.width >= this.x + this.width) return CollisionInfo.RIGHT;
        return CollisionInfo.NONE;
    }

    public CollisionInfo collided(Ball ball) {
        if(ball.x <= this.x) return CollisionInfo.LEFT;
        if(ball.x + ball.getSize() >= this.x + this.width) return CollisionInfo.RIGHT;
        if(ball.y <= this.y) return CollisionInfo.UP;
        if(ball.y + ball.height >= this.y + this.height) return CollisionInfo.DOWN;
        return CollisionInfo.NONE;
    }
}
