package com.comp301.a02adventure;

/**
 * The Player interface represents a player in the game. The player has a position, an inventory,
 * and a name.
 */
public interface Player {
  /**
   * Getter method for the player's current position
   *
   * @return the player's current position
   */
  Position getPosition();

  /**
   * Getter method for the player's inventory
   *
   * @return the player's inventory
   */
  Inventory getInventory();

  /**
   * Getter method for the player's name
   *
   * @return the player's name
   */
  String getName();

  /**
   * Blindly moves the player's position one unit in the indicated direction, without checking
   * whether the new location is valid
   *
   * @param direction the direction in which to move the player
   */
  void move(Direction direction);
}
