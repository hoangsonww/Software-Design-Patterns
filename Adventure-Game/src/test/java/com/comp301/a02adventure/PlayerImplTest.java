package com.comp301.a02adventure;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class contains a set of test cases that can be used to test the implementation of the Player
 * interface - the PlayerImpl class.
 */
public class PlayerImplTest {

  /**
   * Default constructor for the PlayerImplTest class.
   * This constructor is intentionally left empty since no specific initialization is needed for the tests.
   */
  public PlayerImplTest() {
    // No initialization required for this test class.
  }

  /** This test case tests the constructor and getter methods of the Player interface. */
  @Test
  public void testConstructorAndGetters() {
    // Initialize player with name and starting position (x, y)
    Player player = new PlayerImpl("John", 2, 3);

    // Test name getter
    assertEquals("John", player.getName());

    // Test position getter
    Position startPosition = player.getPosition();
    assertEquals(2, startPosition.getX());
    assertEquals(3, startPosition.getY());

    // Test inventory getter
    assertTrue(player.getInventory().isEmpty());

    // Add an item to the inventory
    Item item = new ItemImpl("Sword");
    player.getInventory().addItem(item);
    assertFalse(player.getInventory().isEmpty());
    assertEquals(1, player.getInventory().getNumItems());
  }

  /** This test case tests the constructor with a null name. */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithNullName() {
    // Test for exception when initializing with a null name
    new PlayerImpl(null, 1, 1);
  }

  /** This test case tests the move method of the Player interface. Case 1: Move North */
  @Test
  public void testMoveNorth() {
    Player player = new PlayerImpl("Alice", 2, 2);
    player.move(Direction.NORTH);

    // After moving north, y should decrease by 1
    assertEquals(2, player.getPosition().getX());
    assertEquals(3, player.getPosition().getY());
  }

  /** This test case tests the move method of the Player interface. Case 2: Move South */
  @Test
  public void testMoveSouth() {
    Player player = new PlayerImpl("Bob", 2, 2);
    player.move(Direction.SOUTH);

    // After moving south, y should increase by 1
    assertEquals(2, player.getPosition().getX());
    assertEquals(1, player.getPosition().getY());
  }

  /** This test case tests the move method of the Player interface. Case 3: Move East */
  @Test
  public void testMoveEast() {
    Player player = new PlayerImpl("Charlie", 2, 2);
    player.move(Direction.EAST);

    // After moving east, x should increase by 1
    assertEquals(3, player.getPosition().getX());
    assertEquals(2, player.getPosition().getY());
  }

  /** This test case tests the move method of the Player interface. Case 4: Move West */
  @Test
  public void testMoveWest() {
    Player player = new PlayerImpl("David", 2, 2);
    player.move(Direction.WEST);

    // After moving west, x should decrease by 1
    assertEquals(1, player.getPosition().getX());
    assertEquals(2, player.getPosition().getY());
  }

  /** This test case tests the various inventory operations of the Player interface. */
  @Test
  public void testInventoryOperations() {
    Player player = new PlayerImpl("Eva", 0, 0);
    Inventory inventory = player.getInventory();

    // Test that the inventory starts empty
    assertTrue(inventory.isEmpty());

    // Add an item to the inventory
    Item item = new ItemImpl("Key");
    inventory.addItem(item);
    assertFalse(inventory.isEmpty());
    assertEquals(1, inventory.getNumItems());
    assertTrue(inventory.getItems().contains(item));

    // Remove the item and check the inventory is empty again
    inventory.removeItem(item);
    assertTrue(inventory.isEmpty());
  }
}
