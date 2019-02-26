package game.snake.objects;

import game.snake.utils.Values;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Snake {

    private List<Cell> cells;
    private Direction direction;

    public Snake() {
        cells = new ArrayList<>();
        cells.add(new Cell(360, 290));
        cells.add(new Cell(370, 290));
        cells.add(new Cell(380, 290));
        setDirection(Direction.LEFT);
    }

    public void setDirection(Direction d) {
        direction = d;
    }

    public boolean hasCollision(Apple apple){
        Cell head = cells.get(0);
        if ((head.getX() == apple.getX()) && (head.getY() == apple.getY())){
            return true;
        }
        return false;
    }

    public void move() {
        int last = cells.size() - 1;
        for(int i = last; i > 0; i--){
            cells.get(i).move(cells.get(i-1));
        }
        // move the Snake's head
        Cell head = cells.get(0);
        int d = direction.getDirection();
        if (d == 1) {
            head.setY(head.getY() - Values.CELL_HEIGHT);
        }
        if (d == 2) {
            head.setY(head.getY() + Values.CELL_HEIGHT);
        }
        if (d == 3) {
            head.setX(head.getX() - Values.CELL_WIDTH);
        }
        if (d == 4) {
            head.setX(head.getX() + Values.CELL_WIDTH);
        }
        if (head.getX() > Values.WINDOW_WIDTH) {
            head.setX(0);
        }
        if (head.getX() < 0) {
            head.setX(Values.WINDOW_WIDTH);
        }
        if (head.getY() > Values.WINDOW_HEIGHT) {
            head.setY(0);
        }
        if (head.getY() < 0) {
            head.setY(Values.WINDOW_HEIGHT);
        }
    }

    public void draw(GraphicsContext gc) {
        Iterator<Cell> it = cells.iterator();
        while(it.hasNext()){
            Cell cell = it.next();
            cell.draw(gc);
        }
    }

    public void appendCell() {
        Cell last = cells.get(cells.size()-1);
        int d = direction.getDirection();
        int x = last.getX(), y = last.getY();
        if (d == 1) {
            y -= Values.CELL_HEIGHT;
        }
        if (d == 2) {
            y += Values.CELL_HEIGHT;
        }
        if (d == 3) {
            x += Values.CELL_WIDTH;
        }
        if (d == 4) {
            x -= Values.CELL_WIDTH;
        }
        cells.add(new Cell(x, y));
    }

    public int getLenght() {
        return cells.size();
    }

}
