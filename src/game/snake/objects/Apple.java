package game.snake.objects;

import game.snake.utils.Values;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Apple {

    private int x;

    private int y;

    public Apple(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(Color.RED);
        gc.fillRect(x, y, Values.CELL_WIDTH, Values.CELL_HEIGHT);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
