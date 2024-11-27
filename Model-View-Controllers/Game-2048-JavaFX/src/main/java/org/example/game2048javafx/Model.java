package org.example.game2048javafx;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** This class represents the game model for the 2048 game */
public class Model {

  /** The size of the board */
  private final int SIZE = 4;

  /** The 2D array that represents the game board */
  private final int[][] board = new int[SIZE][SIZE];

  /** The current score of the game */
  private int score = 0;

  /** The best score achieved in the game */
  private int bestScore = 0;

  /**
   * Getter method for the board of the game
   *
   * @return The 2D array that represents the game board
   */
  public int[][] getBoard() {
    return board;
  }

  /**
   * Getter method for the current score of the game
   *
   * @return The current score of the game
   */
  public int getScore() {
    return score;
  }

  /**
   * Getter method for the best score achieved in the game
   *
   * @return The best score achieved in the game
   */
  public int getBestScore() {
    return bestScore;
  }

  /** Resets the game board and score */
  public void resetBoard() {
    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {
        board[row][col] = 0;
      }
    }
    score = 0;
  }

  /** Adds a random tile (either 2 or 4) to an empty space on the board */
  public void addRandomTile() {
    List<int[]> emptySpaces = new ArrayList<>();
    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {
        if (board[row][col] == 0) {
          emptySpaces.add(new int[] {row, col});
        }
      }
    }

    if (!emptySpaces.isEmpty()) {
      Random rand = new Random();
      int[] space = emptySpaces.get(rand.nextInt(emptySpaces.size()));
      board[space[0]][space[1]] = rand.nextDouble() < 0.9 ? 2 : 4;
    }
  }

  /**
   * Moves the tiles in the specified direction and merges them if possible
   *
   * @param direction The direction to move the tiles
   * @return True if the tiles were moved, false otherwise
   */
  public boolean move(String direction) {
    boolean moved = false;
    for (int i = 0; i < SIZE; i++) {
      int[] line = getLine(direction, i);
      int[] merged = mergeLine(line);
      if (!arrayEquals(line, merged)) moved = true;
      setLine(direction, i, merged);
    }
    return moved;
  }

  /**
   * Gets a line of tiles from the board in the specified direction
   *
   * @param direction The direction to get the line from
   * @param index The index of the line
   * @return The line of tiles
   */
  private int[] getLine(String direction, int index) {
    int[] line = new int[SIZE];
    for (int i = 0; i < SIZE; i++) {
      switch (direction) {
        case "UP" -> line[i] = board[i][index];
        case "DOWN" -> line[i] = board[SIZE - 1 - i][index];
        case "LEFT" -> line[i] = board[index][i];
        case "RIGHT" -> line[i] = board[index][SIZE - 1 - i];
      }
    }
    return line;
  }

  /**
   * Sets a line of tiles on the board in the specified direction
   *
   * @param direction The direction to set the line
   * @param index The index of the line
   * @param line The line of tiles to set
   */
  private void setLine(String direction, int index, int[] line) {
    for (int i = 0; i < SIZE; i++) {
      switch (direction) {
        case "UP" -> board[i][index] = line[i];
        case "DOWN" -> board[SIZE - 1 - i][index] = line[i];
        case "LEFT" -> board[index][i] = line[i];
        case "RIGHT" -> board[index][SIZE - 1 - i] = line[i];
      }
    }
  }

  /**
   * Merges the tiles in a line if possible
   *
   * @param line The line of tiles to merge
   * @return The merged line of tiles
   */
  private int[] mergeLine(int[] line) {
    int[] merged = new int[SIZE];
    int pos = 0;

    for (int i = 0; i < SIZE; i++) {
      if (line[i] == 0) continue;
      if (pos > 0 && merged[pos - 1] == line[i]) {
        merged[pos - 1] *= 2;
        score += merged[pos - 1];
      } else {
        merged[pos++] = line[i];
      }
    }

    if (score > bestScore) bestScore = score;
    return merged;
  }

  /**
   * Compares two arrays of integers
   *
   * @param a The first array of integers
   * @param b The second array of integers
   * @return True if the arrays are equal, false otherwise
   */
  private boolean arrayEquals(int[] a, int[] b) {
    for (int i = 0; i < SIZE; i++) {
      if (a[i] != b[i]) return false;
    }
    return true;
  }

  /**
   * Checks if the game is over
   *
   * @return True if the game is over, false otherwise
   */
  public boolean checkGameOver() {
    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {
        if (board[row][col] == 0) return false;
        if (row < SIZE - 1 && board[row][col] == board[row + 1][col]) return false;
        if (col < SIZE - 1 && board[row][col] == board[row][col + 1]) return false;
      }
    }
    return true;
  }
}
