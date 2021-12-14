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
//        textPoints.setFont(Font.font("Lato", FontWeight.BOLD, 40));
//        textPoints.setFill(Color.BLUE);
//        textPoints.setStroke(Color.BLACK);
//        textPoints.setX(getWidth() * size + 50);
//        textPoints.setY(getHeight() * size / 6);
        textPoints.setText("Points: 0");

        textGameOver = new Text("GAME OVER");
//        textGameOver.setTextAlignment(TextAlignment.CENTER);
        textGameOver.setFill(Color.RED);
//        textGameOver.setX(game.width / 2.0);
//        textGameOver.setY(game.height / 2.0);
        textGameOver.setVisible(false);


        buttonRestart = new Button("RESTART");
        buttonRestart.setVisible(false);
//        buttonRestart.setPrefWidth(125);
//        buttonRestart.setPrefHeight(75);
//        buttonRestart.setLayoutX(getWidth() * size + 65);
//        buttonRestart.setLayoutY(getHeight() * size / 6 + 175);

        buttonExit = new Button("EXIT");
        buttonExit.setVisible(false);
//        buttonExit.setPrefWidth(125);
//        buttonExit.setPrefHeight(75);
//        buttonExit.setLayoutX(getWidth() * size + 65);
//        buttonExit.setLayoutY(getHeight() * size / 6 + 275);

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
//        textGameOver.setText(textGameOver + "\n" + points + " points");
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
