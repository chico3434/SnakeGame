package game.snake;

import game.snake.objects.Apple;
import game.snake.objects.Direction;
import game.snake.objects.Snake;
import game.snake.utils.Utils;
import game.snake.utils.Values;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    VBox root = new VBox();

    Scene scene = new Scene(root, Values.WINDOW_WIDTH, Values.WINDOW_HEIGHT);

    Canvas canvas = new Canvas(Values.WINDOW_WIDTH, Values.WINDOW_HEIGHT);

    GraphicsContext gc;

    Snake snake = new Snake();

    Apple apple = new Apple(Utils.genX(), Utils.genY());

    AnimationTimer at = null;

    @Override
    public void start(Stage stage) {

        gc = canvas.getGraphicsContext2D();

        root.getChildren().add(canvas);

//        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle(Values.WINDOW_TITLE);
        stage.setScene(scene);
        stage.show();

        at = new AnimationTimer() {
            @Override
            public void handle(long l) {
                scene.setOnKeyPressed(e -> {
                    if (e.getCode().toString().equals("UP")) {
                        snake.setDirection(Direction.UP);
                    }
                    if (e.getCode().toString().equals("DOWN")) {
                        snake.setDirection(Direction.DOWN);
                    }
                    if (e.getCode().toString().equals("LEFT")) {
                        snake.setDirection(Direction.LEFT);
                    }
                    if (e.getCode().toString().equals("RIGHT")) {
                        snake.setDirection(Direction.RIGHT);
                    }
                    if (e.getCode().toString().equals("P")) {
                        at.stop();
                        new Thread() {
                            @Override
                            public void run() {
                                scene.setOnKeyPressed(e -> {
                                    if (e.getCode().toString().equals("P")) {
                                        at.start();
                                    }
                                });
                            }
                        }.run();
                    }
                });

                gc.clearRect(0, 0, Values.WINDOW_WIDTH, Values.WINDOW_HEIGHT);
                gc.setFill(Color.BLACK);
                gc.fillRect(0,0,  Values.WINDOW_WIDTH, Values.WINDOW_HEIGHT);
                gc.setFill(Color.WHITE);
                gc.fillText("Comprimento: " + snake.getLenght(), 10, 10);

                snake.move();
                snake.draw(gc);
                apple.draw(gc);
                if (snake.hasCollision(apple)) {
                    snake.appendCell();
                    apple = null;
                    apple = new Apple(Utils.genX(), Utils.genY());
                }

                try {
                    Thread.sleep(1000/24);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        at.start();
    }
}
