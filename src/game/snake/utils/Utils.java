package game.snake.utils;

import java.util.Random;

public class Utils {

    public static int genX() {
        Random r = new Random();
        return r.nextInt(Values.WINDOW_WIDTH/10)*10;
    }

    public static int genY() {
        Random r = new Random();
        return r.nextInt(Values.WINDOW_HEIGHT/10)*10;
    }
}
