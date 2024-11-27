package org.example.game2048javafx;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * This class contains JUnit tests for the 2048 game model implementation. The tests cover the Model
 * class - which is the main logic component of the 2048 game.
 */
public class ModelTest {

  /** The model object */
  private Model model;

  /** Default constructor */
  public ModelTest() {}

  /** Sets up the Model object for testing */
  @Before
  public void setUp() {
    model = new Model();
  }

  /**
   * Test the resetBoard method of the Model class. This method should reset the game board and
   * score to their initial states.
   */
  @Test
  public void testResetBoard() {
    model.resetBoard();
    int[][] board = model.getBoard();

    // Ensure all tiles are reset to 0
    for (int row = 0; row < 4; row++) {
      for (int col = 0; col < 4; col++) {
        assertEquals(0, board[row][col]);
      }
    }

    // Ensure score is reset
    assertEquals(0, model.getScore());
  }

  /**
   * Test the addRandomTile method of the Model class. This method should add a random tile (either
   * 2 or 4) to an empty space on the board.
   */
  @Test
  public void testAddRandomTile() {
    model.resetBoard();
    model.addRandomTile();
    int[][] board = model.getBoard();

    // Count non-zero tiles
    int nonZeroCount = 0;
    for (int row = 0; row < 4; row++) {
      for (int col = 0; col < 4; col++) {
        if (board[row][col] != 0) {
          nonZeroCount++;
          // Ensure tile is either 2 or 4
          assertTrue(board[row][col] == 2 || board[row][col] == 4);
        }
      }
    }

    // Ensure only one tile is added
    assertEquals(1, nonZeroCount);
  }

  /**
   * Test the move method of the Model class. This method should move the tiles in the specified
   * direction and merge them if possible.
   */
  @Test
  public void testMove() {
    model.resetBoard();
    int[][] board = model.getBoard();

    // Set up a specific board state
    board[0][0] = 2;
    board[0][1] = 2;
    board[0][2] = 4;
    board[0][3] = 4;

    boolean moved = model.move("LEFT");

    // Check that the board was updated correctly
    assertTrue(moved);
    assertArrayEquals(new int[] {4, 8, 0, 0}, board[0]);
    assertEquals(12, model.getScore());
  }

  /**
   * Test the checkGameOver method of the Model class. This method should return true if no more
   * moves are possible on the board.
   */
  @Test
  public void testNoMovePossible() {
    model.resetBoard();
    int[][] board = model.getBoard();

    // Fill the board with non-mergeable tiles
    board[0] = new int[] {2, 4, 8, 16};
    board[1] = new int[] {32, 64, 128, 256};
    board[2] = new int[] {512, 1024, 2048, 4096};
    board[3] = new int[] {8192, 16384, 32768, 65536};

    boolean moved = model.move("UP");

    // Ensure no move is possible
    assertFalse(moved);
    assertArrayEquals(new int[] {2, 4, 8, 16}, board[0]);
    assertArrayEquals(new int[] {32, 64, 128, 256}, board[1]);
    assertArrayEquals(new int[] {512, 1024, 2048, 4096}, board[2]);
    assertArrayEquals(new int[] {8192, 16384, 32768, 65536}, board[3]);
  }

  /**
   * Test the checkGameOver method of the Model class. This method should return false if a move is
   * still possible on the board.
   */
  @Test
  public void testMergeLine() {
    model.resetBoard();
    int[][] board = model.getBoard();

    // Set up a specific board state
    board[0] = new int[] {2, 2, 4, 4};

    boolean moved = model.move("LEFT");

    // Ensure merging occurred correctly
    assertTrue(moved);
    assertArrayEquals(new int[] {4, 8, 0, 0}, board[0]);
    assertEquals(12, model.getScore());
  }

  /**
   * Test the checkGameOver method of the Model class. This method should return false if a move is
   * still possible on the board.
   */
  @Test
  public void testCheckGameOverFalse() {
    model.resetBoard();
    int[][] board = model.getBoard();

    // Partially filled board with a move possible
    board[0] = new int[] {2, 4, 8, 16};
    board[1] = new int[] {32, 64, 128, 256};
    board[2] = new int[] {512, 1024, 2048, 0}; // Empty space
    board[3] = new int[] {8192, 16384, 32768, 65536};

    assertFalse(model.checkGameOver());
  }

  /**
   * Test the checkGameOver method of the Model class. This method should return true if no more
   * moves are possible on the board.
   */
  @Test
  public void testCheckGameOverTrue() {
    model.resetBoard();
    int[][] board = model.getBoard();

    // Fill the board with non-mergeable tiles
    board[0] = new int[] {2, 4, 8, 16};
    board[1] = new int[] {32, 64, 128, 256};
    board[2] = new int[] {512, 1024, 2048, 4096};
    board[3] = new int[] {8192, 16384, 32768, 65536};

    assertTrue(model.checkGameOver());
  }

  /**
   * Test the getScore method of the Model class. This method should return the current score of the
   * game.
   */
  @Test
  public void testBestScore() {
    model.resetBoard();
    int[][] board = model.getBoard();

    // Set up a scenario to update the score
    board[0][0] = 2;
    board[0][1] = 2;

    model.move("LEFT");

    // Ensure score and best score are updated
    assertEquals(4, model.getScore());
    assertEquals(4, model.getBestScore());

    // Simulate a new game and ensure best score persists
    model.resetBoard();
    assertEquals(0, model.getScore());
    assertEquals(4, model.getBestScore());
  }
}
