package com.comp301.a02adventure;

import java.util.List;

/** The GameImpl class implements the Game interface and represents a game of Adventure. The game */
public class GameImpl implements Game {

  // Field to store the map of the game
  private Map map;
  // Field to store the player of the game
  private Player player;

  /**
   * Constructs a new Game object with the specified map and player.
   *
   * @param map the map of the game
   * @param player the player of the game
   */
  public GameImpl(Map map, Player player) {
    if (map == null) {
      throw new IllegalArgumentException("Map cannot be null");
    }

    if (player == null) {
      throw new IllegalArgumentException("Player cannot be null");
    }

    this.map = map;
    this.player = player;
  }

  /**
   * A method that returns the player's current position.
   *
   * @return the player's current position
   */
  @Override
  public Position getPlayerPosition() {
    return this.player.getPosition();
  }

  /**
   * A method that returns the player's name.
   *
   * @return the player's name
   */
  @Override
  public String getPlayerName() {
    return this.player.getName();
  }

  /**
   * A method that returns the player's inventory.
   *
   * @return the player's inventory
   */
  @Override
  public List<Item> getPlayerItems() {
    return this.player.getInventory().getItems();
  }

  /**
   * A method that returns whether the player has won the game.
   *
   * @return true if the player has won the game, false otherwise
   */
  @Override
  public boolean getIsWinner() {
    // Get the number of items in the map
    int numItems = this.map.getNumItems();

    // Get the number of items collected by the player
    Player currentPlayer = this.player;
    Inventory currentInventory = currentPlayer.getInventory();
    List<Item> currentPlayerItems = currentInventory.getItems();
    int numItemsCollected = currentPlayerItems.size();

    // Check if the player has collected all the items in the map
    boolean isWinner = false;

    if (numItemsCollected == numItems) {
      isWinner = true;
    }

    return isWinner;
  }

  /** A method that prints the information of the current cell. */
  @Override
  public void printCellInfo() {
    // Get the current player and cell
    Player currentPlayer = this.player;
    Position currentPosition = currentPlayer.getPosition();
    Cell currentCell = this.map.getCell(currentPosition);

    // Print the current cell's information
    System.out.println("Location: " + currentCell.getName());
    System.out.println(currentCell.getDescription());

    // Print additional information based on the current cell's visited state
    if (currentCell.getIsVisited()) {
      System.out.println("You have already visited this location.");
    }

    // Print additional information based on the current cell's chest state
    if (currentCell.hasChest()) {
      System.out.println("You found a chest! Type 'open' to see what's inside, or keep moving.");
    }

    // Mark the current cell as visited
    currentCell.visit();
  }

  /** A method that opens the chest in the current cell. */
  @Override
  public void openChest() {
    // Get the current player and cell
    Player currentPlayer = this.player;
    Position currentPosition = currentPlayer.getPosition();
    Cell currentCell = this.map.getCell(currentPosition);

    // Get the current chest and its items
    Inventory chest = currentCell.getChest();

    if (chest == null) {
      System.out.println("No chest to open, sorry!");
      return;
    }

    // Get all the items in the chest
    List<Item> chestItems = chest.getItems();

    // Get the current player's inventory
    Inventory playerInventory = currentPlayer.getInventory();

    // Check if the current cell has a chest
    if (!currentCell.hasChest()) {
      System.out.println("No chest to open, sorry!");
    } else {
      // Check if the chest is empty
      if (chestItems.isEmpty()) {
        System.out.println("The chest is empty.");
      } else {
        // Transfer all the chest items to the player's inventory
        playerInventory.transferFrom(chest);

        // Print out all the chest items that were collected by the player
        System.out.println("You collected these items: " + chestItems);
      }
    }
  }

  /**
   * A method that checks if the player can move in a specified direction.
   *
   * @param direction the direction in which the player wants to move
   * @return true if the player can move in the specified direction, false otherwise
   */
  @Override
  public boolean canMove(Direction direction) {
    // Keeps track if the current player can move in the given direction
    boolean canMove = false;

    // Get the current player and cell
    Player currentPlayer = this.player;
    Position currentPosition = currentPlayer.getPosition();

    // Get the new position by moving in the given direction
    Position newPosition = currentPosition.getNeighbor(direction);

    // Store the new position's x and y coordinates
    int newX = newPosition.getX();
    int newY = newPosition.getY();

    // Check if the new position is within the map bounds
    if (newX >= 0 && newY >= 0 && newX < this.map.getWidth() && newY < this.map.getHeight()) {
      // Check if the new position has a non-null cell
      Cell newCell = this.map.getCell(newPosition);

      // Only allow the player to move if the new cell is not null
      if (newCell != null) {
        canMove = true;
        return canMove;
      }
    }

    // Return the result of the checks
    return canMove;
  }

  /**
   * A method that moves the player in a specified direction.
   *
   * @param direction the direction in which the player wants to move
   */
  @Override
  public void move(Direction direction) {
    // Check if the player can move in the specified direction
    boolean isValidMove = canMove(direction);

    // Print an error message if the player can't move in the specified direction
    if (!isValidMove) {
      System.out.println("You can't go that way! Try another direction.");
    } else {
      // If the player can move, then move the player and print the new cell's information
      // Get the current player and cell
      Player currentPlayer = this.player;
      // Move the player in the specified direction
      currentPlayer.move(direction);
      // Print the new cell's information after moving successfully
      printCellInfo();
    }
  }
}
