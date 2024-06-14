package ShayMayer;

import ShayMayer.GameManagement.PongGame;

public class Main {

    public static void main(String[] args) {
        PongGame pong = new PongGame();
        while(true)
            pong.update();
    }
}
