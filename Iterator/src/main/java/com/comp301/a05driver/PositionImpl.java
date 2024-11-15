package com.comp301.a05driver;

/** Represents an integer (x,y) position on a grid. */
public class PositionImpl implements Position {

  private int _x;
  private int _y;

  /**
   * Constructor for the PositionImpl class.
   *
   * @param x The x coordinate of the position
   * @param y The y coordinate of the position
   */
  public PositionImpl(int x, int y) {
    _x = x;
    _y = y;
  }

  /**
   * Retrieves x coordinate of the position
   *
   * @return x coordinate of the position
   */
  @Override
  public int getX() {
    return _x;
  }

  /**
   * Retrieves y coordinate of the position
   *
   * @return y coordinate of the position
   */
  @Override
  public int getY() {
    return _y;
  }
}
