package com.comp301.a02adventure;

/**
 * The MapImpl class implements the Map interface and represents a 2D grid of cells. Each cell
 * contains a name, description, and an inventory of items. The map also contains a number of items
 * that need to be collected in order for the player to win.
 */
public class MapImpl implements Map {

  // Field to store the grid of cells
  private Cell[][] grid;
  // Field to store the number of items that need to be collected
  private int numItems;

  /**
   * Constructs a new MapImpl object with the specified width, height, and number of items.
   *
   * @param width The width of the map
   * @param height The height of the map
   * @param numItems The number of items that need to be collected
   */
  public MapImpl(int width, int height, int numItems) {
    if (width <= 0) {
      throw new IllegalArgumentException("Width and height must be positive integers");
    }

    if (height <= 0) {
      throw new IllegalArgumentException("Width and height must be positive integers");
    }

    // Initializes the grid with the specified width and height & number of items
    this.grid = new Cell[width][height];
    this.numItems = numItems;
  }

  /**
   * A method that returns the width of the map.
   *
   * @return the width of the map
   */
  @Override
  public int getWidth() {
    return this.grid.length;
  }

  /**
   * A method that returns the height of the map.
   *
   * @return the height of the map
   */
  @Override
  public int getHeight() {
    return this.grid[0].length;
  }

  /**
   * A method that returns the cell at the specified coordinates. Throws an
   * IndexOutOfBoundsException for coordinate parameters that are not on the map.
   *
   * @param x the x-coordinate of the cell
   * @param y the y-coordinate of the cell
   * @return the cell at the specified coordinates
   */
  @Override
  public Cell getCell(int x, int y) {
    // Check the arguments to ensure they are within the bounds of the map
    if (x < 0) {
      throw new IndexOutOfBoundsException("Coordinates are not on the map");
    }

    if (y < 0) {
      throw new IndexOutOfBoundsException("Coordinates are not on the map");
    }

    if (x >= this.getWidth()) {
      throw new IndexOutOfBoundsException("Coordinates are not on the map");
    }

    if (y >= this.getHeight()) {
      throw new IndexOutOfBoundsException("Coordinates are not on the map");
    }

    // Get the cell at the specified coordinates once the checks pass
    Cell cell = this.grid[x][y];

    return cell;
  }

  /**
   * Overloaded getter method for a specific cell on the map. Throws an IndexOutOfBoundsException
   * for coordinate parameters that are not on the map.
   *
   * @param position the position of the cell
   * @return the cell at the specified position
   */
  @Override
  public Cell getCell(Position position) {
    // Check if the position is null
    if (position == null) {
      throw new IllegalArgumentException("Position cannot be null");
    }

    // Get the x and y coordinates of the position
    int x = position.getX();
    int y = position.getY();
    Cell cell = this.getCell(x, y);

    return cell;
  }

  /**
   * A method that initializes a new CellImpl object at the specified location on the map,
   * overwriting any existing Cell at that location. Throws an IndexOutOfBoundsException for
   * coordinate parameters that are not on the map.
   *
   * @param x the x-coordinate of the cell
   * @param y the y-coordinate of the cell
   */
  @Override
  public void initCell(int x, int y) {
    // Check the arguments to ensure they are within the bounds of the map
    if (x < 0) {
      throw new IndexOutOfBoundsException("Coordinates are not on the map");
    }

    if (y < 0) {
      throw new IndexOutOfBoundsException("Coordinates are not on the map");
    }

    if (x >= this.getWidth()) {
      throw new IndexOutOfBoundsException("Coordinates are not on the map");
    }

    if (y >= this.getHeight()) {
      throw new IndexOutOfBoundsException("Coordinates are not on the map");
    }

    // Initialize a new cell at the specified coordinates once the checks pass
    this.grid[x][y] = new CellImpl(x, y);
  }

  /**
   * A method that returns the total number of items that need to be collected in order for the
   * player to win.
   *
   * @return the number of items that need to be collected
   */
  @Override
  public int getNumItems() {
    // Total number of items on the map
    return this.numItems;
  }
}
