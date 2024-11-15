package com.comp301.a02adventure;

/** The PlayerImpl class implements the Player interface and represents a player in the game. */
public class PlayerImpl implements Player {

  // Field to store the player's name
  private String name;
  // Field to store the player's inventory
  private Inventory inventory;
  // Field to store the player's position
  private Position position;

  /**
   * Constructs a new Player object with the specified name and starting position.
   *
   * @param name the name of the player
   * @param startX the x-coordinate of the player's starting position
   * @param startY the y-coordinate of the player's starting position
   */
  public PlayerImpl(String name, int startX, int startY) {
    if (name == null) {
      throw new IllegalArgumentException("Name string cannot be null");
    }

    // Initialize the player's name, inventory, and position
    this.name = name;
    this.inventory = new InventoryImpl();
    this.position = new PositionImpl(startX, startY);
  }

  /**
   * A method that returns the name of the player.
   *
   * @return the name of the player
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * A method that returns the player's inventory.
   *
   * @return the player's inventory
   */
  @Override
  public Inventory getInventory() {
    return this.inventory;
  }

  /**
   * A method that returns the player's current position.
   *
   * @return the player's current position
   */
  @Override
  public Position getPosition() {
    return this.position;
  }

  /**
   * A method that moves the player in the specified direction.
   *
   * @param direction the direction in which to move the player
   */
  @Override
  public void move(Direction direction) {
    if (direction == null) {
      throw new IllegalArgumentException("Direction cannot be null");
    }

    // Get the new position by moving in the given direction
    Position newPosition = this.position.getNeighbor(direction);

    // Move the player to the new position
    this.position = newPosition;
  }
}
