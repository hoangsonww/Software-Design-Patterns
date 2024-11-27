package org.example.game2048javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Objects;

/** Main class to launch the 2048 game */
public class Main extends Application {

  /**
   * The start method is called after the init method has returned, and after the system is ready
   * for the application to begin running.
   *
   * @param primaryStage The primary stage for this application, onto which the application scene
   *     can be set.
   */
  @Override
  public void start(Stage primaryStage) {
    // Set the favicon
    primaryStage
        .getIcons()
        .add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/favicon.png"))));

    showWelcomeScene(primaryStage);
  }

  /**
   * Shows the welcome scene of the game
   *
   * @param stage The stage to show the welcome scene on
   */
  private void showWelcomeScene(Stage stage) {
    VBox welcomeLayout = new VBox(20);
    Font poppinsBold =
        Font.loadFont(
            getClass().getResourceAsStream("/org/example/game2048javafx/fonts/Poppins-Bold.ttf"),
            40);
    Font poppinsRegular =
        Font.loadFont(
            getClass().getResourceAsStream("/org/example/game2048javafx/fonts/Poppins-Regular.ttf"),
            20);

    welcomeLayout.setStyle(
        "-fx-padding: 20; -fx-alignment: center; -fx-background-color: #bbada0;");

    Text title = new Text("Welcome to 2048!");
    title.setFont(poppinsBold);
    title.setStyle("-fx-font-family: 'Poppins'; -fx-fill: #736352; -fx-font-weight: bold;");

    Button startButton = new Button("Start Game");
    startButton.setFont(poppinsRegular);
    startButton.setStyle(
        "-fx-padding: 10; -fx-background-color: #8f7a66; -fx-text-fill: white; -fx-font-size: 20px; -fx-background-radius: 10; -fx-font-family: 'Poppins';");
    startButton.setOnAction(event -> showGameScene(stage));

    startButton.setOnMouseEntered(
        event ->
            startButton.setStyle(
                "-fx-padding: 10; -fx-background-color: #736352; -fx-text-fill: white; -fx-font-size: 20px; -fx-background-radius: 10; -fx-font-family: 'Poppins'; -fx-cursor: hand;"));
    startButton.setOnMouseExited(
        event ->
            startButton.setStyle(
                "-fx-padding: 10; -fx-background-color: #8f7a66; -fx-text-fill: white; -fx-font-size: 20px; -fx-background-radius: 10; -fx-font-family: 'Poppins';"));

    // Instructions Button
    Button instructionsButton = new Button("Instructions");
    instructionsButton.setStyle(
        "-fx-padding: 10; -fx-background-color: #8f7a66; -fx-text-fill: white; -fx-font-size: 20px; -fx-background-radius: 10; -fx-font-family: 'Poppins';");
    instructionsButton.setOnAction(event -> showInstructionsScene(stage));
    instructionsButton.setFont(poppinsRegular);

    instructionsButton.setOnMouseEntered(
        event ->
            instructionsButton.setStyle(
                "-fx-padding: 10; -fx-background-color: #736352; -fx-text-fill: white; -fx-font-size: 20px; -fx-background-radius: 10; -fx-font-family: 'Poppins'; -fx-cursor: hand;"));
    instructionsButton.setOnMouseExited(
        event ->
            instructionsButton.setStyle(
                "-fx-padding: 10; -fx-background-color: #8f7a66; -fx-text-fill: white; -fx-font-size: 20px; -fx-background-radius: 10; -fx-font-family: 'Poppins';"));

    welcomeLayout.getChildren().addAll(title, startButton, instructionsButton);
    Scene welcomeScene = new Scene(welcomeLayout, 550, 700);

    stage.setScene(welcomeScene);
    stage.setTitle("2048 - Welcome");
    stage.show();
  }

  /**
   * Shows the instructions scene of the game
   *
   * @param stage The stage to show the instructions on
   */
  private void showInstructionsScene(Stage stage) {
    VBox instructionsLayout = new VBox(20);
    instructionsLayout.setStyle(
        "-fx-padding: 20; -fx-alignment: center; -fx-background-color: #bbada0;");

    Text instructionsTitle = new Text("How to Play 2048");
    instructionsTitle.setFont(Font.font("Poppins", 40));
    instructionsTitle.setStyle(
        "-fx-font-family: 'Poppins'; -fx-fill: #736352; -fx-font-weight: bold;");

    Text instructionsText =
        new Text(
            "1. Use arrow keys to move tiles up, down, left, or right.\n"
                + "2. Tiles with the same number merge into one when they touch.\n"
                + "3. Your goal is to reach the 2048 tile!\n"
                + "4. The game ends when there are no valid moves left.\n"
                + "5. Press 'Start Game' to begin playing!");
    instructionsText.setFont(Font.font("Poppins", 20));
    instructionsText.setStyle("-fx-font-family: 'Poppins'; -fx-fill: black;");
    instructionsText.setWrappingWidth(500);

    Button backButton = new Button("Back to Welcome");
    backButton.setStyle(
        "-fx-padding: 10; -fx-background-color: #8f7a66; -fx-text-fill: white; -fx-font-size: 20px; -fx-background-radius: 10; -fx-font-family: 'Poppins';");
    backButton.setOnAction(event -> showWelcomeScene(stage));

    backButton.setOnMouseEntered(
        event ->
            backButton.setStyle(
                "-fx-padding: 10; -fx-background-color: #736352; -fx-text-fill: white; -fx-font-size: 20px; -fx-background-radius: 10; -fx-font-family: 'Poppins'; -fx-cursor: hand;"));
    backButton.setOnMouseExited(
        event ->
            backButton.setStyle(
                "-fx-padding: 10; -fx-background-color: #8f7a66; -fx-text-fill: white; -fx-font-size: 20px; -fx-background-radius: 10; -fx-font-family: 'Poppins';"));

    Button startButton = new Button("Start Game");
    startButton.setStyle(
        "-fx-padding: 10; -fx-background-color: #8f7a66; -fx-text-fill: white; -fx-font-size: 20px; -fx-background-radius: 10; -fx-font-family: 'Poppins';");
    startButton.setOnAction(event -> showGameScene(stage));

    startButton.setOnMouseEntered(
        event ->
            startButton.setStyle(
                "-fx-padding: 10; -fx-background-color: #736352; -fx-text-fill: white; -fx-font-size: 20px; -fx-background-radius: 10; -fx-font-family: 'Poppins'; -fx-cursor: hand;"));
    startButton.setOnMouseExited(
        event ->
            startButton.setStyle(
                "-fx-padding: 10; -fx-background-color: #8f7a66; -fx-text-fill: white; -fx-font-size: 20px; -fx-background-radius: 10; -fx-font-family: 'Poppins';"));

    instructionsLayout
        .getChildren()
        .addAll(instructionsTitle, instructionsText, startButton, backButton);
    Scene instructionsScene = new Scene(instructionsLayout, 550, 700);

    stage.setScene(instructionsScene);
    stage.setTitle("2048 - Instructions");
  }

  /**
   * Shows the game scene of the game
   *
   * @param stage The stage to show the game scene on
   */
  private void showGameScene(Stage stage) {
    Game2048 game = new Game2048();

    BorderPane root = new BorderPane();
    root.setTop(game.getHeader()); // Add header
    root.setCenter(game); // Add game grid
    root.setBottom(game.getFooter()); // Add footer

    Scene gameScene = new Scene(root, 550, 700);
    gameScene
        .getStylesheets()
        .add(getClass().getResource("styles.css").toExternalForm()); // Load CSS

    gameScene.setOnKeyPressed(event -> game.fireEvent(event)); // Ensure focus remains on grid

    stage.setScene(gameScene);
    stage.setTitle("Play 2048!");
    stage.show();

    game.requestFocus(); // Focus on the game grid
    game.startGame(); // Start the game
  }

  /**
   * Shows the losing scene of the game
   *
   * @param stage The stage to show the losing scene on
   */
  private void showLosingScene(Stage stage) {
    VBox losingLayout = new VBox(20);
    losingLayout.setStyle("-fx-background-color: #bbada0; -fx-padding: 20; -fx-alignment: center;");

    Text losingText = new Text("Game Over");
    losingText.setFont(Font.font("Poppins", 40));
    losingText.setStyle("-fx-fill: red; -fx-font-weight: bold;");

    Button retryButton = new Button("Retry");
    retryButton.setStyle(
        "-fx-padding: 10; -fx-background-color: #8f7a66; -fx-text-fill: white; -fx-font-size: 20px; -fx-background-radius: 10;");
    retryButton.setOnAction(event -> showGameScene(stage));

    Button exitButton = new Button("Exit");
    exitButton.setStyle(
        "-fx-padding: 10; -fx-background-color: #8f7a66; -fx-text-fill: white; -fx-font-size: 20px; -fx-background-radius: 10;");
    exitButton.setOnAction(event -> System.exit(0));

    losingLayout.getChildren().addAll(losingText, retryButton, exitButton);
    Scene losingScene = new Scene(losingLayout, 550, 700);

    stage.setScene(losingScene);
    stage.setTitle("2048 - Game Over");
  }

  /**
   * The main method is ignored in JavaFX applications. main serves only as a fallback in case the
   * application can not be launched through deployment artifacts, e.g., in IDEs with limited FX
   * support. NetBeans ignores main.
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
}
