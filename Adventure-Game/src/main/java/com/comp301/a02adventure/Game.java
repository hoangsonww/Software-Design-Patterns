package com.comp301.a02adventure;

import java.util.List;

/** The Game interface represents a game of Adventure. */
public interface Game {
  /**
   * Getter method for the Player's current location as a Position object
   *
   * @return the Player's current location as a Position object
   */
  Position getPlayerPosition();

  /**
   * Getter method for the Player's name
   *
   * @return the Player's name
   */
  String getPlayerName();

  /**
   * Getter method for a cloned List of the the Items in the Player's Inventory
   *
   * @return a cloned List of the the Items in the Player's Inventory
   */
  List<Item> getPlayerItems();

  /**
   * Returns true if all items on the map have been collected by the player
   *
   * @return true if all items on the map have been collected by the player
   */
  boolean getIsWinner();

  /**
   * This method prints information about the Cell where the Player is currently located, according
   * to the following format:
   *
   * <p>First, print "Location: " followed by the Cell's name. For example, if the Cell is named
   * "Polk Place", then this should print: "Location: Polk Place"
   *
   * <p>Next, print the Cell's description on its own line. For example, a description of Polk Place
   * might be: "A beautiful park surrounded by college buildings and an old library. This is the
   * heart of UNC's campus."
   *
   * <p>Next, if the Cell has already been visited before, print the following text on a new line:
   * "You have already visited this location."
   *
   * <p>Next, if there is a chest in the Cell, print the following text on the next line of output:
   * "You found a chest! Type 'open' to see what's inside, or keep moving."
   *
   * <p>Finally, this method should formally mark the Cell "visited" by calling the Cell's visit()
   * method
   */
  void printCellInfo();

  /**
   * This method handles a user's interaction when they try to open a treasure chest at the current
   * location. If a chest exists in the current Cell, it should be opened and its contents
   * transferred to the Player's Inventory. Hint: Use the transferFrom() method.
   *
   * <p>If there is no chest at the current Cell, print: "No chest to open, sorry!"
   *
   * <p>If there is a chest at the current Cell, but it is empty, print: "The chest is empty."
   *
   * <p>If the chest is not empty, transfer the chest contents to the Player's Inventory and print:
   * "You collected these items: [list of chest items]"
   *
   * <p>Hint: If you correctly set up the toString() method in the ItemImpl class, you should be
   * able to print the whole inventory by simply printing the chest items list. For example
   * something like: System.out.println("You collected these items: " + chest.getItems());
   */
  void openChest();

  /**
   * Returns true if the player can indeed move in a specified direction. A player can only move in
   * a direction if there is a non-null cell in that direction and if the direction is within the
   * map grid bounds.
   *
   * @param direction the direction in which the player is trying to move
   * @return true if the player can move in the specified direction, false otherwise
   */
  boolean canMove(Direction direction);

  /**
   * Attempts to move the player one unit in the indicated direction. If the player cannot be moved
   * in that direction (i.e., canMove() returns false), this method should instead print the
   * following String on its own line: "You can't go that way! Try another direction." If the move
   * operation was successful, then print the new cell's info to the console using the
   * printCellInfo() method.
   *
   * @param direction the direction in which the player is trying to move
   */
  void move(Direction direction);
}
