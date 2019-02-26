package game.snake.objects;

import game.snake.utils.Values;
import javafx.scene.canvas.GraphicsContext;

public class Cell {

    private int x;

    private int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(Cell next) {
        x = next.getX();
        y = next.getY();
    }

    public void draw(GraphicsContext gc) {
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
