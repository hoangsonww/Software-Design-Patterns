package com.comp301.a02adventure;

/**
 * The Cell interface represents a cell in the game map. Each cell has a name, description, and
 * position.
 */
public interface Cell {
  // ********************************************************************************
  // GETTER METHODS

  /**
   * Getter method for the cell's name
   *
   * @return the name of the cell
   */
  String getName();

  /**
   * Getter method for the cell's description
   *
   * @return the description of the cell
   */
  String getDescription();

  /**
   * Getter method for the position of the cell
   *
   * @return the position of the cell
   */
  Position getPosition();

  /**
   * Getter method for the "chest" Inventory object stored at the cell
   *
   * @return the chest of the cell
   */
  Inventory getChest();

  /**
   * Getter method which returns true if the cell has been visited
   *
   * @return true if the cell has been visited, false otherwise
   */
  boolean getIsVisited();

  /**
   * Returns true if the cell has a chest
   *
   * @return true if the cell has a chest, false otherwise
   */
  boolean hasChest();

  // ********************************************************************************
  // SETTER METHODS

  // Note: The setName(), setDescription(), and setChest() methods should perform setter validation
  // and throw an IllegalArgumentException for incoming "null" values

  /**
   * Setter method for changing the cell's name
   *
   * @param name the name of the cell
   */
  void setName(String name);

  /**
   * Setter method for changing the cell's description
   *
   * @param description the description of the cell
   */
  void setDescription(String description);

  /**
   * Setter method for the "chest" Inventory object stored at the cell
   *
   * @param chest the chest of the cell
   */
  void setChest(Inventory chest);

  /** Marks that the cell has been visited */
  void visit();
}
