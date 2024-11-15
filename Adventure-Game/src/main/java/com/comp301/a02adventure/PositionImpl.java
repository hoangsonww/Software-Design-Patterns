package com.comp301.a02adventure;

/**
 * A Position object that represents a location in a 2D grid (Cartesian system). A Position object
 * can be used to represent the location of a player, an item, or any other object in the game.
 */
public class PositionImpl implements Position {

  // Field to store the x coordinate of the position
  private int x;
  // Field to store the y coordinate of the position
  private int y;

  /**
   * Constructs a new Position object with the specified x and y coordinates.
   *
   * @param x the x coordinate of the position
   * @param y the y coordinate of the position
   */
  public PositionImpl(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * A method that returns the x-coordinate of the position.
   *
   * @return the x-coordinate of the position
   */
  @Override
  public int getX() {
    return this.x;
  }

  /**
   * A method that returns the y-coordinate of the position.
   *
   * @return the y-coordinate of the position
   */
  @Override
  public int getY() {
    return this.y;
  }

  /**
   * A method that constructs and returns a new Position object located one unit in the indicted
   * direction from the "this" object.
   *
   * @param direction the direction in which to find the neighbor
   * @return a new Position object located one unit in the indicted direction from the "this" object
   */
  @Override
  public Position getNeighbor(Direction direction) {
    if (direction == null) {
      throw new IllegalArgumentException(
          "Invalid direction selected. Choose either NORTH, SOUTH, EAST, or WEST");
    }

    int newX = this.x;
    int newY = this.y;

    // Update the x and y coordinates based on the input direction
    // If NORTH: increment y by 1
    // If SOUTH: decrement y by 1
    // If EAST: increment x by 1
    // If WEST: decrement x by 1
    switch (direction) {
      case NORTH:
        newY = newY + 1;
        break;
      case SOUTH:
        newY = newY - 1;
        break;
      case EAST:
        newX = newX + 1;
        break;
      case WEST:
        newX = newX - 1;
        break;
      default:
        throw new IllegalArgumentException(
            "Invalid direction selected. Choose either NORTH, SOUTH, EAST, or WEST");
    }

    // Return a new Position object with the new x and y coordinates
    Position newPosition = new PositionImpl(newX, newY);

    return newPosition;
  }

  /**
   * A method that returns a string representation of the Position object.
   *
   * @return a string representation of the Position object
   */
  @Override
  public String toString() {
    // String representation of the Position object: (x, y)
    String stringRepresentation = "(" + this.x + ", " + this.y + ")";
    return stringRepresentation;
  }

  /**
   * A method that checks if the Position object is equal to another object.
   *
   * @param other the object to compare to
   * @return true if the Position object is equal to the other object, false otherwise
   */
  @Override
  public boolean equals(Object other) {
    boolean isEqual = false;

    // Check if the other object is null - if so, they are not equal
    if (other == null) {
      return false;
    }

    // Check if the other object is exactly the same object as the current one
    // If so, they are equal
    if (this == other) {
      return true;
    }

    // Check if the other object is an instance of Position
    // If so, compare the x and y coordinates
    // They are the same if their x and y coordinates are equal
    if (other instanceof Position) {
      PositionImpl otherPosition = (PositionImpl) other;
      boolean isEqualX = this.x == otherPosition.getX();
      boolean isEqualY = this.y == otherPosition.getY();
      isEqual = isEqualX && isEqualY;
      return isEqual;
    }

    return isEqual;
  }
}
