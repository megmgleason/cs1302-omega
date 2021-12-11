package cs1302.game;

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

//    Image image;
//    ImageView apple;
    int appleY;
    int appleX;
    Rectangle r;
    public static int size = 25;
    public static int width = 24, height = 24;

    /**
     * Constructs an {@code Apple} object.
     *
     * @param game the game object, representing one round.
     */
    public Apple(Game game) {
        super("https://image.shutterstock.com/image-illustration/pixel-apple-260nw-630750482.jpg");
        this.appleX = (int) (Math.random() * (width - 2) + 1);
        this.appleY = (int) (Math.random() * (height - 2) + 1);
        System.out.println("Apple log: " + appleX + " " + appleY);
//        this.appleX *= size;
//        this.appleY *= size;

        this.r = new Rectangle(appleX, appleY, size - 1, size - 1);
        this.r.setFill(Color.RED);
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
        return this.appleX;
    } //getAppleX


    /**
     * Get method for y coordinate.
     *
     * @return appleY the y coordinate
     */
    public int getAppleY () {
        return this.appleY;
    } //getAppleY

    /**
     * Sets the x coordinate for {@code appleX}.
     *
     * @param x the x coordinate.
     */
    public void setAppleX (int x) {
        this.appleX = x;
    } //setAppleX

    /**
     * Sets the y coordinate for {@code appleY}.
     *
     * @param y the new y coordiante.
     */
    public void setAppleY (int y) {
        this.appleY = y;
    } //setAppleY

    //use setters and getters tha ImageView has
} //Apple
