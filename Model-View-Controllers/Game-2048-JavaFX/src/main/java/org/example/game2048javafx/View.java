package org.example.game2048javafx;

import javafx.animation.ScaleTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/** View class to represent the view of the game */
public class View extends GridPane {

  /** SIZE constant to represent the size of the grid */
  private final int SIZE = 4;

  /** 2D array to represent the tiles in the grid */
  private final StackPane[][] tiles = new StackPane[SIZE][SIZE];

  /** Label to display the current score */
  private final Label scoreLabel = new Label("SCORE: 0");

  /** Label to display the best score */
  private final Label bestScoreLabel = new Label("BEST: 0");

  /** Constructor for the View class */
  public View() {
    setHgap(10);
    setVgap(10);
    setAlignment(Pos.CENTER);
    setStyle("-fx-padding: 10; -fx-background-color: #bbada0;");
  }

  /** Setup the grid with the tiles */
  public void setupGrid() {
    Font poppinsBold =
        Font.loadFont(
            getClass().getResourceAsStream("/org/example/game2048javafx/fonts/Poppins-Bold.ttf"),
            30);

    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {
        StackPane stack = new StackPane();
        Rectangle bg = new Rectangle(100, 100);
        bg.setArcWidth(15);
        bg.setArcHeight(15);
        bg.setFill(Color.web("#cdc1b4"));

        Text text = new Text();
        text.setFont(poppinsBold);
        text.setFill(Color.web("#776e65"));
        stack.getChildren().addAll(bg, text);
        tiles[row][col] = stack;
        add(stack, col, row);
      }
    }
  }

  /**
   * Get the header of the game
   *
   * @return HBox object representing the header
   */
  public HBox getHeader() {
    Font poppinsBold =
        Font.loadFont(
            getClass().getResourceAsStream("/org/example/game2048javafx/fonts/Poppins-Bold.ttf"),
            32);

    Label titleLabel = new Label("2048 Game");
    titleLabel.setFont(poppinsBold);
    titleLabel.setStyle(
        "-fx-font-size: 32px; "
            + "-fx-background-color: #edc22e; "
            + "-fx-text-fill: white; "
            + "-fx-padding: 15; "
            + "-fx-border-radius: 15; "
            + "-fx-background-radius: 15;");

    HBox header = new HBox(20, titleLabel, scoreLabel, bestScoreLabel);
    header.setAlignment(Pos.CENTER_LEFT);
    return header;
  }

  /**
   * Get the footer of the game
   *
   * @return Label object representing the footer
   */
  public Label getFooter() {
    return new Label("Join the numbers and get to the 2048 tile!");
  }

  /**
   * Update the UI with the new board and score
   *
   * @param board The 2D array representing the game board
   * @param score The current score of the game
   * @param bestScore The best score achieved in the game
   */
  public void updateUI(int[][] board, int score, int bestScore) {
    scoreLabel.setText("SCORE: " + score);
    bestScoreLabel.setText("BEST: " + bestScore);
    // Update tiles
    // Similar logic as in the original
  }
}
