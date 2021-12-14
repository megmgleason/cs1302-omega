package cs1302.game;

import java.util.Iterator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
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

    public int score;
    public int moveHoriz; // left/ right ~ N/S , x variable
    public int moveVert; //up and down ~ E/W, y variable
    public boolean gameOver;
    public String currentDirection;
    public int width; //width of the playable board
    public int height; //height of the playable board


    /**
     * Construct na {@code SnakeGame} object.
     * @param width scene width
     * @param height scene height
     */
    public SnakeGame(int width, int height) {
        super(width, height, 60);            // call parent constructor
        setLogLevel(Level.INFO);             // enable logging
        this.menu = new Menu (this);
        this.apple = new Apple(this);
        System.out.println("apple image: " + apple.getImage());
//        System.out.println("is there an error w image:" + apple.getImage().getException());
//        this.snake = new Snake();
        this.gameOver = false;
        this.currentDirection = "-";

        this.width = width;
        this.height = height;

        this.moveHoriz = 0;
        this.moveVert = 0;
    } // SnakeGame

    /** {@inheritDoc} */
    @Override
    protected void init() {
        // setup subgraph for this component
        getChildren().addAll(menu, apple); //delete this, use next line when Snake read
        for (Rectangle rect : s) {
            getChildren().add(rect);

        }
        s.get(0).setFill(Color.RED);

        menu.buttonExit.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Stage stage = (Stage) menu.buttonExit.getScene().getWindow();

                    stage.close();
                }
            });

        menu.buttonRestart.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    menu.menuRestart();
                    restartSnake();
                    resetInformation(); //call method w following in it
                    play();
                }
            });

    } // init

    /** {@inheritDoc} */
    @Override
    protected void update() {
//        snake.moveSnake(direction); must make snake first, its always moving
//        isAppleEaten();
//        isBoundsCollison();
//        checkSelfCollision();
        // (x, y)         In computer graphics, coordinates along an x-axis and
        // (0, 0) -x--->  y-axis are used. When compared to the standard
        // |              Cartesian plane that most students are familiar with,
        // y              the x-axis behaves the same, but the y-axis increases
        // |              in the downward direction! Keep this in mind when
        // v              adjusting the x and y positions of child nodes.

        // update snake position

        isKeyPressed (KeyCode.LEFT, () -> isDifferentDirection("W"));
        isKeyPressed (KeyCode.RIGHT, () -> isDifferentDirection("E"));
        isKeyPressed (KeyCode.DOWN, () -> isDifferentDirection("S"));
        isKeyPressed (KeyCode.UP, () -> isDifferentDirection("N"));





        if (isAppleEaten()) {
            score++;
            System.out.println("score: " + score);
            menu.changePoints(this.score);
            growSnake();
        }



// <--------------------------------------------------------------------
// try adding the code to make the snake move up and down!
// <--------------------------------------------------------------------

// update idle cat
//        cat.update();

    } // update

/**
 * Checks if the direction the user is currently set to be moving in is the same direection
 * the user put in on the keyboard. If its a diferent direction, update the direction and movement
 * variables, then call the {@code updatePosition} menthod. *
 * @param userDirection  the current direction the snake is in
 */
    public void isDifferentDirection (String userDirection) {
        if (! (this.currentDirection.equals(userDirection))) {
            this.currentDirection = userDirection; //switch the iv
            switch (currentDirection) {
            case "N": this.moveVert = -1; //y var
                this.moveHoriz = 0;
                break;
            case "S": this.moveVert = 1; //y var down
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
 * Calls on helper methods to update the position of the {@code Snake} object.*
 * @param direction the direction the snake is heading.
 */
    public void updatePosition(String direction) {
        if (!isBoundsCollision()) {
            this.lastSeenTailX = (int) s.get(s.size() - 1).getX();
            this.lastSeenTailY = (int) s.get(s.size() - 1).getY();

            for (int i = s.size() - 1; i >= 1; i--) {
                s.get(i).setX(s.get(i - 1).getX());
                System.out.println(s.get(i).getX());
                s.get(i).setY(s.get(i - 1).getY());
                System.out.println(s.get(i).getY());
            } //for


            s.get(0).setX(s.get(0).getX() + snakeSize * this.moveHoriz);
            s.get(0).setY(s.get(0).getY() + snakeSize * this.moveVert);
//            checkSelfCollision();
        } //if

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
        //      this.gameOver = true;
        menu.gameOverInfo();
        menu.textGameOver.setVisible(true);
        pause(); //must prompt user to try again, show gameOver

        System.out.println("GAME OVER - gameOver() method called");
    } //gameOver

/**
 * Checks if where the snake is trying to move to is an edge of the board,
 * resulting in it being out of bounds and the game being over.
 *
 * @return true if the snake is out of bounds, else false.
 */
    public boolean isBoundsCollision() {
        boolean isCollision = true;
        if (s.get(0).getX() <= 0 || s.get(0).getX() >= width) {
            System.out.println("GAME OVER - x boundary hit!");
            gameOver();
        } else if (s.get(0).getY() <= 0 || s.get(0).getY() >= height) {
            System.out.println("GAME OVER - y boundary hit!");
            gameOver();
        } else {
            isCollision = false;
        }
        return isCollision;
    } //isBoundsCollision

    /**
     * Checks if snake runs into itself.
     */
    public void checkSelfCollision () {
        if (s.size() > 3) {
            for (int i = 3; i < s.size(); i++) {
                if (s.get(0).getX() == s.get(i).getX() && s.get(0).getY() == s.get(i).getY()) {
                    System.out.println("collided with self, Game over!");
                    gameOver();
                }
            } //for
        }
    } //checkSelfCollision

    /**
     * Resets the snake for future plays.
     */
    public void restartSnake() {
        if (s.size() > 3) {
            for (int i = 3; i < s.size() ; i++ ) {
                s.get(i).setVisible(false);
            }
        }

        int index = 0;
        for (Iterator<Rectangle> iterator = s.iterator(); iterator.hasNext(); ) {
            Rectangle block = iterator.next();
            index++;
            if (index > 3) {
                iterator.remove();
            }
        }

        this.headX = 100;
        this.headY = 100;
        s.get(0).setX(headX);
        s.get(0).setY(headY);
        s.get(1).setX(headX);
        s.get(1).setY((headY + snakeSize));
        s.get(2).setX(headX);
        s.get(2).setY((headY + snakeSize + snakeSize));
    } //restartSnake

    /**
     * Resets the information variables relating to the game.
     */
    public void resetInformation() {
        apple.changeLocation();
        this.score = 0;
        this.moveHoriz = 0;
        this.moveVert = 1;
        this.currentDirection = "N";
        this.gameOver = false;
    } //resetInformation

} // SnakeGame
