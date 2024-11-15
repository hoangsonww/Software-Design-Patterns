package com.comp301.a02adventure;

/** The Map interface represents a 2D grid of cells. The map is defined by its width and height */
public interface Map {
  /**
   * Getter method for the width of the map
   *
   * @return the width of the map
   */
  int getWidth();

  /**
   * Getter method for the height of the map
   *
   * @return the height of the map
   */
  int getHeight();

  /**
   * Getter method for a specific cell on the map. Throws an IndexOutOfBoundsException for
   * coordinate parameters that are not on the map
   *
   * @param x the x-coordinate of the cell
   * @param y the y-coordinate of the cell
   * @return the cell at the specified coordinates
   */
  Cell getCell(int x, int y);

  /**
   * Overloaded getter method for a specific cell on the map. Throws an IndexOutOfBoundsException
   * for coordinate parameters that are not on the map
   *
   * @param position the position of the cell
   * @return the cell at the specified position
   */
  Cell getCell(Position position);

  /**
   * Initializes a new CellImpl object at the specified location on the map, overwriting any
   * existing Cell at that location. Throws an IndexOutOfBoundsException for coordinate parameters
   * that are not on the map
   *
   * @param x the x-coordinate of the cell
   * @param y the y-coordinate of the cell
   */
  void initCell(int x, int y);

  /**
   * Getter method for the total number of items that need to be collected in order for the player
   * to win. This field is immutable.
   *
   * @return the total number of items that need to be collected
   */
  int getNumItems();
}
