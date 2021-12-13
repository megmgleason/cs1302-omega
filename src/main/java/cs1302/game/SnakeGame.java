package cs1302.game;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;
import java.util.Random;
import java.util.logging.Level;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.ImageView;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;

/**
 * An example of a simple game in JavaFX. The play can move the rectangle left/right
 * with the arrow keys or teleport the rectangle by clicking it!
 */
public class SnakeGame extends Game {

//    public ArrayList <Rectangle> s = new ArrayList<>(1);
    Apple apple;
//    Snake snake;
    int score;
    boolean gameOver;
    String direction;
    public int width; //width of the playable board
    public int height; //height of the playable board
    Group group;


//    private Rectangle player; // some rectangle to represent the player
//    private Apple cat;      // the not so idle cat (see Apple.java)

    /**
     * Construct a {@code SnakeGame} object.
     * @param width scene width
     * @param height scene height
     */
    public SnakeGame(int width, int height) {
        super(width, height, 60);            // call parent constructor
        setLogLevel(Level.INFO);             // enable logging

        this.apple = new Apple(this);
        System.out.println("apple image: " + apple.getImage());
//        System.out.println("is there an error w image:" + apple.getImage().getException());
//        this.snake = new Snake();
        this.gameOver = false;
        this.direction = "N";
        this.width = width;
        this.height = height;


//        int headX = (int) (Math.random() * (width - 1)) + 2;
//        int headY = (int) (Math.random() * (height - 4)) + 2;

//        s.add(new Rectangle(headX * size, headY * size, size - 1, size - 1));
//        s.add(new Rectangle(headX * size, (headY + 1) * size, size - 1, size - 1));
//        s.add(new Rectangle(headX * size, (headY + 2) * size, size - 1, size - 1));

        for (Rectangle rect : s) {
            rect.setFill(Color.RED);
//            getChildren().add(rect);
        }
//        this.player = new Rectangle(20, 20); // some rectangle to represent the player
//        this.cat  = new Apple(this);       // the not so idle cat (see Apple.java)
    } // SnakeGame

    /** {@inheritDoc} */
    @Override
    protected void init() {
        // setup subgraph for this component
        getChildren().add(apple); //delete this, use next line when Snake read
        for (Rectangle rect : s) {
            getChildren().add(rect);
        }
//        getChildren().addAll(snake, apple);         // add to main container
        // setup player
//        snake.setX(50);                           // 50px in the x direction (right)
//        snake.setY(50);                           // 50ps in the y direction (down)
//        snake.setOnMouseClicked(event -> handleClickSnake(event));
        // setup the cat

//        apple.setX(0);
//        apple.setY(0);
    } // init

    /** {@inheritDoc} */
    @Override
    protected void update() {
//        snake.moveSnake(direction); must make snake first, its always moving
//        isAppleEaten();
//        isBoundsCollison();

        // (x, y)         In computer graphics, coordinates along an x-axis and
        // (0, 0) -x--->  y-axis are used. When compared to the standard
        // |              Cartesian plane that most students are familiar with,
        // y              the x-axis behaves the same, but the y-axis increases
        // |              in the downward direction! Keep this in mind when
        // v              adjusting the x and y positions of child nodes.

        // update snake position
        isKeyPressed (KeyCode.LEFT, () -> updatePosition("W")); //do check for already this directin
        isKeyPressed (KeyCode.RIGHT, () -> updatePosition("E"));
        isKeyPressed (KeyCode.DOWN, () -> updatePosition("S"));
        isKeyPressed (KeyCode.UP, () -> updatePosition("N"));



// <--------------------------------------------------------------------
// try adding the code to make the snake move up and down!
// <--------------------------------------------------------------------

// update idle cat
//        cat.update();

    } // update


    //dont need this method, maybe refactor for the start button
/**
 * Move the snake rectangle to a random position.
 * @param event associated mouse event
 */
//    private void handleClickSnake(MouseEvent event) {
//        logger.info(event.toString());
//        snake.setX(rng.nextDouble() * (getWidth() - snake.getWidth()));
//        snake.setY(rng.nextDouble() * (getHeight() - snake.getHeight()));
//    } // handleClickSnake

/**
 * Getter method for the {@code direction} variable.
 *
 * @return direction
 */
    public String getDirection () {
        throw new UnsupportedOperationException("not yet implemented");
    } //This should be in SNake!

/**
 * Calls on helper methods to update the position of the {@code Snake} object.
 */
    public void updatePosition(String currentDirection) {
        throw new UnsupportedOperationException("not yet implemented");
    } //updatePosition

/**
 * Checks to see if the position of the head of the snake is the same location as the
 * apple.. If the apple is eaten, the location of the apple is changed,
 * one is added to the tail,  and the score is updated.
 *
 * @return true if it is, false otherwise.
 */
    public boolean isAppleEaten() {
        throw new UnsupportedOperationException("not yet implemented");
    } //isppleEaten

    /**
     * The game is over, the main game loop will not continue.
     * Game over is caused by: the snake colliding with itself, the snake hitting
     * the edge of the playable board, or the snake collection 252 fruits,
     * the only instance when the player would win the game.
     * {@code isGameOver} is set to true
     */
    public void gameOver() {
        throw new UnsupportedOperationException("not yet implemented");
    } //gameOver

    /**
     * Checks if where the snake is trying to move to is an edge of the board,
     * resulting in it being out of bounds and the game being over.
     *
     * @return true if the snake is out of bounds, else false.
     */
    public boolean isBoundsCollision() {
        throw new UnsupportedOperationException("not yet implemented");
    } //isBoundsCollision
} // SnakeGame
