package org.example.game2048javafx;

/** The Controller class is responsible for handling user input and updating the model and view */
public class Controller {

  /** The model of the game */
  private final Model model;

  /** The view of the game */
  private final View view;

  /**
   * Constructor for the Controller class
   *
   * @param model The model of the game
   * @param view The view of the game
   */
  public Controller(Model model, View view) {
    this.model = model;
    this.view = view;
  }

  /** Starts the game by resetting the board and adding two random tiles */
  public void startGame() {
    model.resetBoard();
    model.addRandomTile();
    model.addRandomTile();
    view.updateUI(model.getBoard(), model.getScore(), model.getBestScore());
  }

  /**
   * Handles the key press event by moving the tiles in the specified direction
   *
   * @param direction The direction to move the tiles
   */
  public void handleKeyPress(String direction) {
    if (model.move(direction)) {
      model.addRandomTile();
      view.updateUI(model.getBoard(), model.getScore(), model.getBestScore());
      if (model.checkGameOver()) {
        System.out.println("Game Over!");
      }
    }
  }
}
