package com.comp301.a02adventure;

import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * This class contains a set of test cases that can be used to test the implementation of the Game
 * interface - the GameImpl class.
 */
public class GameImplTest {

  /**
   * Default constructor for the GameImplTest class.
   * This constructor is intentionally left empty since no specific initialization is needed for the tests.
   */
  public GameImplTest() {
    // No initialization required for this test class.
  }

  /** This test case tests the constructor and getter methods of the Game interface. */
  @Test
  public void testConstructorAndGetters() {
    Player player = new PlayerImpl("John", 1, 1);
    Map map = new MapImpl(3, 3, 1);
    Game game = new GameImpl(map, player);

    assertEquals(player.getPosition(), game.getPlayerPosition());
    assertEquals(player.getName(), game.getPlayerName());
    assertEquals(player.getInventory().getItems(), game.getPlayerItems());
    assertFalse(game.getIsWinner());
  }

  /** This test case tests the constructor with a null player. */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithNullPlayer() {
    Map map = new MapImpl(3, 3, 1);
    new GameImpl(map, null);
  }

  /** This test case tests the constructor with a null map. */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithNullMap() {
    Player player = new PlayerImpl("John", 1, 1);
    new GameImpl(null, player);
  }

  /** This test case tests the getIsWinner method of the Game interface. */
  @Test
  public void testGetIsWinner() {
    // Case 1: Player has not collected all items
    Player player = new PlayerImpl("John", 1, 1);
    Map map = new MapImpl(3, 3, 1);
    Game game = new GameImpl(map, player);

    assertFalse(game.getIsWinner());

    // Case 2: Player has collected all items
    player.getInventory().addItem(new ItemImpl("Gold"));

    assertTrue(game.getIsWinner());
  }

  /** This test case tests the printCellInfo method of the Game interface. */
  @Test
  public void testPrintCellInfo() {
    Player player = new PlayerImpl("Alice", 1, 1);
    Map map = new MapImpl(3, 3, 1);
    map.initCell(1, 1);
    map.getCell(1, 1).setName("Polk Place");
    map.getCell(1, 1).setDescription("A beautiful park surrounded by college buildings.");
    Game game = new GameImpl(map, player);

    // Capture the output of printCellInfo()
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    game.printCellInfo();

    String expectedOutput =
        "Location: Polk Place\nA beautiful park surrounded by college buildings.\n";
    assertTrue(outContent.toString().startsWith(expectedOutput));
  }

  /** This test case tests the openChest method of the Game interface. */
  @Test
  public void testOpenChest() {
    Player player = new PlayerImpl("Bob", 0, 0);
    Map map = new MapImpl(2, 2, 1);
    map.initCell(0, 0);
    Inventory chest = new InventoryImpl();
    chest.addItem(new ItemImpl("Gold"));
    map.getCell(0, 0).setChest(chest);

    Game game = new GameImpl(map, player);

    // Capture the output of openChest()
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    game.openChest();

    // Check that the player's inventory contains the item from the chest
    assertEquals(1, player.getInventory().getNumItems());
    assertEquals("Gold", player.getInventory().getItems().get(0).getName());

    String expectedOutput = "You collected these items: [Gold]\n";
    assertTrue(outContent.toString().contains(expectedOutput));
  }

  /**
   * This test case tests the openChest method of the Game interface when the chest is empty (no
   * chest).
   */
  @Test
  public void testOpenChestNoChest() {
    Player player = new PlayerImpl("Charlie", 0, 0);
    Map map = new MapImpl(2, 2, 1);
    map.initCell(0, 0);
    Game game = new GameImpl(map, player);

    // Capture the output of openChest()
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    game.openChest();

    String expectedOutput = "No chest to open, sorry!\n";
    assertEquals(expectedOutput, outContent.toString());
  }

  /** This test case tests the canMove method of the Game interface. */
  @Test
  public void testCanMove() {
    Player player = new PlayerImpl("David", 1, 1);
    Map map = new MapImpl(3, 3, 1);
    map.initCell(1, 1);
    map.initCell(1, 2);
    Game game = new GameImpl(map, player);

    // Check valid move direction
    assertTrue(game.canMove(Direction.NORTH));

    // Check invalid move direction
    assertFalse(game.canMove(Direction.SOUTH));
  }

  /** This test case tests the move method of the Game interface with a valid move. */
  @Test
  public void testValidMove() {
    Player player = new PlayerImpl("Eva", 0, 0);
    Map map = new MapImpl(2, 2, 1);
    map.initCell(0, 0);
    map.initCell(0, 1);
    map.getCell(0, 1).setName("North Hall");
    map.getCell(0, 1).setDescription("A large hall with a grand staircase.");
    Game game = new GameImpl(map, player);

    // Capture the output of move()
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    game.move(Direction.NORTH);

    assertEquals(0, player.getPosition().getX());
    assertEquals(1, player.getPosition().getY());

    String expectedOutput = "Location: North Hall\nA large hall with a grand staircase.\n";
    assertTrue(outContent.toString().contains(expectedOutput));
  }

  /** This test case tests the move method of the Game interface with an invalid move. */
  @Test
  public void testInvalidMove() {
    // Set up the player and game environment
    Player player = new PlayerImpl("Eva", 0, 0);
    Map map = new MapImpl(2, 2, 1);
    map.initCell(0, 0);
    map.initCell(0, 1);
    map.getCell(0, 1).setName("North Hall");
    map.getCell(0, 1).setDescription("A large hall with a grand staircase.");
    Game game = new GameImpl(map, player);

    // Prepare to capture the output
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out; // Save the original System.out
    System.setOut(new PrintStream(outContent));

    try {
      // Perform an invalid move (attempt to move SOUTH)
      game.move(Direction.SOUTH);

      // Verify the player's position remains unchanged
      assertEquals(0, player.getPosition().getX());
      assertEquals(0, player.getPosition().getY());

      // Capture the actual output
      String actualOutput = outContent.toString().trim();

      // Define the expected output
      String expectedOutput = "You can't go that way! Try another direction.";

      // Verify the output contains the expected message
      assertTrue("Expected message not found in output", actualOutput.contains(expectedOutput));
    } finally {
      // Restore the original output stream
      System.setOut(originalOut);
    }
  }
}
