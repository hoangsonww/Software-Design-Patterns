package com.comp301.a02adventure;

/**
 * The CellImpl class implements the Cell interface and represents a cell in the game map. Each cell
 * contains a name, description, and an inventory of items. The cell also contains a boolean value
 * to indicate if the cell has been visited.
 */
public class CellImpl implements Cell {

  // Field to store the position of the cell
  private Position position;
  // Field to store the name of the cell
  private String name;
  // Field to store the description of the cell
  private String description;
  // Field to store the inventory of the cell
  private Inventory chest;
  // Field to store a boolean value to indicate if the cell has been visited
  private boolean isVisited;

  /**
   * Constructs a new Cell object with the specified position, name, and description.
   *
   * @param x The x-coordinate of the cell
   * @param y The y-coordinate of the cell
   * @param name The name of the cell
   * @param description The description of the cell
   */
  public CellImpl(int x, int y, String name, String description) {
    if (name == null) {
      throw new IllegalArgumentException("Name cannot be null");
    }

    if (description == null) {
      throw new IllegalArgumentException("Description cannot be null");
    }

    PositionImpl position = new PositionImpl(x, y);

    this.position = position;
    this.name = name;
    this.description = description;
    this.isVisited = false;
  }

  /**
   * Constructs a new Cell object with the specified position.
   *
   * @param x The x-coordinate of the cell
   * @param y The y-coordinate of the cell
   */
  public CellImpl(int x, int y) {
    // Using constructor chaining to call the other constructor
    this(x, y, "", "");
  }

  /**
   * A method that returns the name of the cell.
   *
   * @return the name of the cell
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * A method that returns the description of the cell.
   *
   * @return the description of the cell
   */
  @Override
  public String getDescription() {
    return this.description;
  }

  /**
   * A method that returns the position of the cell.
   *
   * @return the position of the cell
   */
  @Override
  public Position getPosition() {
    return this.position;
  }

  /**
   * A method that returns the chest of the cell.
   *
   * @return the chest of the cell
   */
  @Override
  public Inventory getChest() {
    return this.chest;
  }

  /**
   * A method that returns true if the cell has been visited.
   *
   * @return true if the cell has been visited, false otherwise
   */
  @Override
  public boolean getIsVisited() {
    return this.isVisited;
  }

  /**
   * A method that returns true if the cell has a chest.
   *
   * @return true if the cell has a chest, false otherwise
   */
  @Override
  public boolean hasChest() {
    boolean hasChest = false;

    // Only return true if the current cell has a chest
    if (this.chest != null) {
      hasChest = true;
    }

    return hasChest;
  }

  /**
   * A method that sets the name of the cell.
   *
   * @param name the name of the cell
   */
  @Override
  public void setName(String name) {
    if (name == null) {
      throw new IllegalArgumentException("Name cannot be null");
    }

    this.name = name;
  }

  /**
   * A method that sets the description of the cell.
   *
   * @param description the description of the cell
   */
  @Override
  public void setDescription(String description) {
    if (description == null) {
      throw new IllegalArgumentException("Description string cannot be null");
    }

    this.description = description;
  }

  /**
   * A method that sets the chest of the cell.
   *
   * @param chest the chest of the cell
   */
  @Override
  public void setChest(Inventory chest) {
    if (chest == null) {
      throw new IllegalArgumentException("Chest cannot be null");
    }

    this.chest = chest;
  }

  /** A method that marks that the cell has been visited. */
  @Override
  public void visit() {
    this.isVisited = true;
  }
}
