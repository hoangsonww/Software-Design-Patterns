package com.comp301.a02adventure;

/**
 * The Position interface represents a position on a 2D grid. The position is defined by its x and y
 * coordinates. The Position interface provides methods to get the x and y coordinates of the
 * position and to get a neighbor position in a specified direction.
 */
public interface Position {
  /**
   * Getter method for the x-coordinate of the position
   *
   * @return the x-coordinate of the position
   */
  int getX();

  /**
   * Getter method for the y-coordinate of the position
   *
   * @return the y-coordinate of the position
   */
  int getY();

  /**
   * Constructs and returns a new Position object located one unit in the indicted direction from
   * the "this" object
   *
   * @param direction the direction in which to find the neighbor
   * @return a new Position object located one unit in the indicted direction from the "this" object
   */
  Position getNeighbor(Direction direction);
}
