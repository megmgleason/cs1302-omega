package cs1302.game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Bounds;

/**
 * A simple "sprite" of an Apple.
 */
public class Apple extends ImageView {

    private Game game;

//    Image image;
//    ImageView apple;
    int appleY;
    int appleX;

    public Apple(Game game) {
        super("file:resources/apple.png"); // call parent constructor
        this.setPreserveRatio(true);
        this.setFitWidth(getImage().getWidth());
        this.game = game;
//        game.getChildren.add(this);
//        this.appleY = Math.floor(((Math.random() * (game.getWidth()))));
//        apple.setFitWidth(30);
    } //Apple



    //use setters and getters tha ImageView has
} //Apple
