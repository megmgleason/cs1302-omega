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

    int score;
    int moveHoriz; // left/ right ~ N/S , x variable
    int moveVert; //up and down ~ E/W, y variable
    boolean gameOver;
    String currentDirection;
    public int width; //width of the playable board
    public int height; //height of the playable board
    Group group;

    /**
     * Construct na {@code SnakeGame} object.
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
        this.currentDirection = "N";

        this.width = width;
        this.height = height;

        this.moveHoriz = 0;
        this.moveVert = 1;

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
        if ( gameOver == false) {
            isKeyPressed (KeyCode.LEFT, () -> isDifferentDirection("W"));
            isKeyPressed (KeyCode.RIGHT, () -> isDifferentDirection("E"));
            isKeyPressed (KeyCode.DOWN, () -> isDifferentDirection("S"));
            isKeyPressed (KeyCode.UP, () -> isDifferentDirection("N"));
//            isDifferentDirection(this.currentDirection);
        }

        if (isAppleEaten()) {
            score++;
        }
//        updatePosition(this.currentDirection);


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
 * Checks if the direction the user is currently set to be moving in is the same direection
 * the user put in on the keyboard. If its a diferent direction, update the direction and movement
 * variables, then call the {@code updatePosition} menthod.
 *
 */
    public void isDifferentDirection (String userDirection) {
        if (!(this.currentDirection.equals(userDirection))) {
            this.currentDirection = userDirection; //switch the iv
            switch (currentDirection) {
            case "N": this.moveVert = 1; //y var
                this.moveHoriz = 0;
                break;
            case "S": this.moveVert = -1; //y var down
                this.moveHoriz = 0;
                break;
            case "E": this.moveHoriz = 1; //x var Right
                this.moveVert = 0;
                break;
            case "W": this.moveHoriz = -1; //x var left
                this.moveVert = 0;
                break;
            } //switch
            updatePosition(this.currentDirection); //now call updatePosition() w proper direction
        } else {
            updatePosition(this.currentDirection);
        }
    } //getDirection

/**
 * Calls on helper methods to update the position of the {@code Snake} object.
 */
    public void updatePosition(String direction) {

        this.lastSeenTailX = (int) s.get(s.size() - 1).getX();
        this.lastSeenTailY = (int) s.get(s.size() - 1).getY();

        for (int i = s.size() - 1; i >= 1; i--) {
            s.get(i).setX(s.get(i - 1).getX());
            System.out.println(s.get(i).getX());
            s.get(i).setY(s.get(i - 1).getY());
            System.out.println(s.get(i).getY());
        }//for


        s.get(0).setX(s.get(0).getX() + snakeSize * this.moveHoriz);
        s.get(0).setY(s.get(0).getY() + snakeSize * this.moveVert);

        if (s.get(0).getX() < 0) {
            pause(); //x is off the board, deal w game over later
        }
        if (s.get(0).getX() >= this.width) { //if its = or greater than width of gameboard
            pause();
        }
        if (s.get(0).getY() < 0) {
            pause();
        }
        if (s.get(0).getY() >= this.height) {
            pause();
        }
    } //updatePosition

/**
 * Checks to see if the position of the head of the snake is the same location as the
 * apple.. If the apple is eaten, the location of the apple is changed,
 * one is added to the tail,  and the score is updated.
 *
 * @return true if it is, false otherwise.
 */
    public boolean isAppleEaten() {
        if (((Math.abs(s.get(0).getX() - apple.getX()) <= 50)) &&
        (Math.abs(s.get(0).getY() - apple.getY()) <= 50)) {
            apple.changeLocation();
            return true;
        } else {
            return false;
        }
    } //isppleEaten

    /**
     * Increases the tail of the snake by increasing the arraylist.
     */
    public void growSnake() {
        s.add(new Rectangle(lastSeenTailX, lastSeenTailY, this.snakeSize - 1, this.snakeSize - 1));
        getChildren().add(s.get(s.size() - 1));
    }
/**
 * The game is over, the main game loop will not continue.
 * Game over is caused by: the snake colliding with itself, the snake hitting
 * the edge of the playable board, or the snake collection 252 fruits,
 * the only instance when the player would win the game.
 * {@code isGameOver} is set to true
 */
    public void gameOver() {
        this.gameOver = true;
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
