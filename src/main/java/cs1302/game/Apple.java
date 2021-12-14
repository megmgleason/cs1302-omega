package cs1302.game;

import java.lang.Math;
import javafx.scene.layout.Region;
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
    Rectangle r;
    private Random rng;       // random number generator
    public static int size = 25;
    public double appleWidth = 40;
    public double  appleHeight = 40;
    public static int width = 75, height = 75;

    /**
     * Constructs an {@code Apple} object.
     *
     * @param game the game object, representing one round.
     */
    public Apple(Game game) {
        super("file:resources/apple.jpg");
        this.setFitHeight(appleHeight);
        this.setFitWidth(appleWidth);
        this.rng = new Random();             // random number generator
        this.setY(rng.nextDouble() * (game.getGameBounds().getMaxY() - appleHeight));
        this.setX(rng.nextDouble() * (game.getGameBounds().getMaxX() - appleWidth));

        System.out.println("Apple log: " + this.getY() + " " + this.getX());
        System.out.println("Game height and width : "
            + game.getGameBounds().getHeight() + " " + game.getGameBounds().getWidth());
        this.game = game;
    } //Apple

    /**
     * Uses setters to change the location of the apple.
     */
    public void changeLocation() {
        this.setX((Math.random() * (this.game.getGameBounds().getMaxX()  - appleWidth)));
        this.setY ((Math.random() * (this.game.getGameBounds().getMaxY() - appleHeight )));
    } //changeLocation

//use setters and getters tha ImageView has
} //Apple
