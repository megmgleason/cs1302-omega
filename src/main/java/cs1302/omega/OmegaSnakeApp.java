package cs1302.omega;

import cs1302.game.SnakeGame;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * In the retro snake game, users move a snake with arrow keys. The user tries to collect
 * as many apples as possible, with each apple adding to the length of the snake. If the snake
 * crashes into itself, the game is over and the user loses. If the user eats 252 apples,
 * the game is over and they win.
 */
public class OmegaSnakeApp extends Application {

    /**
     * Constructs an {@code OmegaSnakeApp} object. This default (i.e., no argument)
     * constructor is executed in Step 2 of the JavaFX Application Life-Cycle.
     */
    public OmegaSnakeApp() {}

    /** {@inheritDoc} */
    @Override
    public void start(Stage stage) {

//        // demonstrate how to load local asset using "file:resources/"
//        Image bannerImage = new Image("file:resources/readme-banner.png");
//        ImageView banner = new ImageView(bannerImage);
//        banner.setPreserveRatio(true);
//        banner.setFitWidth(640);

        // some labels to display information
//        Label notice = new Label("Modify the starter code to suit your needs.");
//        Label instructions
//            = new Label("Move left/right with arrow keys; click rectangle to teleport.");

        // demo game provided with the starter code
        SnakeGame game = new SnakeGame(640, 240);

        // setup scene
        VBox root = new VBox(game);
        Scene scene = new Scene(root);

        // setup stage
        stage.setTitle("OmegaSnakeApp!");
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> Platform.exit());
        stage.sizeToScene();
        stage.show();

        // play the game
        game.play();

    } // start

} // OmegaSnakeApp
