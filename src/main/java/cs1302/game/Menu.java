package cs1302.game;

import javafx.scene.layout.VBox;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.layout.HBox;

/**
 * Class representing a menu, which is a line containing other menu elements.
 */

public class Menu extends HBox {


    public Text textPoints;
    public Text textGameOver;
    public Button buttonRestart;
    public Button buttonExit;
    public int size = 25;
    Game game;

    /**
     * Constructs the menu at the top of the scene.
     *
     * @param game the game in play.
     */
    public Menu(Game game) {
        super(10);
        Line line = new Line(0, 250, game.getWidth(), 250);
        this.game = game;

        textPoints = new Text();
        this.textPoints.setTextAlignment(TextAlignment.CENTER);
        textPoints.setText("Points: 0");

        textGameOver = new Text("GAME OVER");
        textGameOver.setFill(Color.RED);
        textGameOver.setVisible(false);


        buttonRestart = new Button("RESTART");
        buttonRestart.setVisible(false);

        buttonExit = new Button("EXIT");
        buttonExit.setVisible(false);

        this.getChildren().addAll(buttonRestart, textPoints, buttonExit);
        this.getChildren().add(textGameOver);
    } //Menu

    /**
     * Adjusts the text denoting the poitns.
     *
     * @param n the points to add.
     */
    public void changePoints (int n) {
        textPoints.setText("Points: " + n);
    } //changePoints


    /**
     * Displays the game over info when called.
     */

    public void gameOverInfo() {
        VBox gameOverBox = new VBox();

        textGameOver.setX(game.getWidth() / 2);
        textGameOver.setY(game.getHeight() / 2);
        textGameOver.setVisible(true);
        buttonRestart.setVisible(true);
        buttonExit.setVisible(true);
    } //gameOverInfo

    /**
     * Resets the info for when a game is restarted.
     */
    public void menuRestart() {
        textGameOver.setVisible(false);
        buttonRestart.setVisible(false);
        buttonExit.setVisible(false);
        textPoints.setText("Points: 0");

    } //MenuRestart
} //Menu
