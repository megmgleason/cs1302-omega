package cs1302.game;

import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/**
 * A simple "sprite" of an Apple.
 */
public class Apple extends ImageView {

    private Game game;


//    Image image = new Image
//            ("https://image.shutterstock.com/image-illustration/pixel-apple-260nw-630750482.jpg",
//            10.0, 10.0, true, true);
//    ImageView apple;
//    int appleY;
//    int appleX;
    Rectangle r;
    private Random rng;       // random number generator
    public static int size = 25;
    public static int width = 75, height = 75;

    /**
     * Constructs an {@code Apple} object.
     *
     * @param game the game object, representing one round.
     */
    public Apple(Game game) {
        super("https://image.shutterstock.com/image-illustration/pixel-apple-260nw-630750482.jpg");
        this.setFitHeight(height);
        this.setFitWidth(width);
        this.rng = new Random();             // random number generator
        this.setY(rng.nextDouble() * (game.getGameBounds().getMaxY() - height));
        this.setX(rng.nextDouble() * (game.getGameBounds().getMaxX() - width));
//        this.appleY = setY((Math.random() * (height - 2) + 1));
        System.out.println("Apple log: " + this.getY() + " " + this.getX());
        System.out.println("Game height and width : "
            + game.getGameBounds().getHeight() + " " + game.getGameBounds().getWidth());
//        this.appleX *= size;
//        this.appleY *= size;

//        this.r = new Rectangle(appleX, appleY, size - 1, size - 1);
//        this.r.setFill(Color.RED);
//        game.getChildren().add(this.r);

//        super("file:resources/apple.png"); // call parent constructor
//        this.setPreserveRatio(true);
//        this.setFitWidth(getImage().getWidth());
        this.game = game;
//        game.getChildren.add(this);
//        this.appleY = Math.floor(((Math.random() * (game.getWidth()))));
//        apple.setFitWidth(30);
    } //Apple



    /**
     * Get method for x coordinate.
     *
     * @return appleX the x coordinate
     */
    public int getAppleX () {
        return 1;
//        return this.appleX;
    } //getAppleX


    /**
     * Get method for y coordinate.
     *
     * @return appleY the y coordinate
     */
    public int getAppleY () {
        return 1;
//        return this.appleY;
    } //getAppleY

    /**
     * Sets the x coordinate for {@code appleX}.
     *
     * @param x the x coordinate.
     */
    public void setAppleX (int x) {
//        this.appleX = x;
    } //setAppleX

    /**
     * Sets the y coordinate for {@code appleY}.
     *
     * @param y the new y coordiante.
     */
    public void setAppleY (int y) {
//        this.appleY = y;
    } //setAppleY

    /**
     * Uses setters to change the location of the apple.
     */
    public void changeLocation() {
        this.setX((Math.random() * this.game.getGameBounds().getMaxX() - width));
        this.setY ((Math.random() * this.game.getGameBounds().getMaxY() - height));
//        this.r.setX(x);
        //this.r.setY(y);
    }

    //use setters and getters tha ImageView has
} //Apple
