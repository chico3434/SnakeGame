package game.snake.objects;

public enum Direction {
    UP(1), DOWN(2), LEFT(3), RIGHT(4);

    private int direction;

    Direction(int num) {
        direction = num;
    }

    public int getDirection() {
        return direction;
    }
}
