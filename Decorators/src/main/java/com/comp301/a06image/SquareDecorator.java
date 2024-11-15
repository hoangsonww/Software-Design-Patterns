package com.comp301.a06image;

import java.awt.Color;

/**
 * The SquareDecorator class is an Image decorator that draws a square on top of a base image. The
 * square is defined by a top-left corner point, a side length, and a color. If a point is within
 * the square, the square's color is returned. Otherwise, the base image's color is returned.
 */
public class SquareDecorator implements Image {
  // Instance variables
  private Image baseImage;
  private int squareX;
  private int squareY;
  private int squareSize;
  private Color color;

  /**
   * Constructor for the SquareDecorator class. Initializes the SquareDecorator with the specified
   * image, top-left corner point, side length, and color of the square.
   *
   * @param image The image to be decorated with a square
   * @param squareX The x coordinate of the top-left corner of the square
   * @param squareY The y coordinate of the top-left corner of the square
   * @param squareSize The side length of the square
   * @param color The color of the square
   * @throws IllegalArgumentException If the image is null or the square size is negative
   */
  public SquareDecorator(Image image, int squareX, int squareY, int squareSize, Color color) {
    // Check for invalid arguments (null image or negative square size)
    if (image == null || squareSize < 0) {
      throw new IllegalArgumentException("Invalid arguments for SquareDecorator.");
    }

    // Initialize the SquareDecorator
    this.baseImage = image;
    this.squareX = squareX;
    this.squareY = squareY;
    this.squareSize = squareSize;
    this.color = color;
  }

  /**
   * Returns the color of the pixel at the specified coordinates. If the pixel is within the square,
   * the square's color is returned. Otherwise, the base image's color is returned.
   *
   * @param x The x coordinate of the pixel
   * @param y The y coordinate of the pixel
   * @return The color of the pixel at the specified coordinates
   */
  @Override
  public Color getPixelColor(int x, int y) {
    // Get the dimensions of the square
    int squareXDimension = this.squareX + this.squareSize;
    int squareYDimension = this.squareY + this.squareSize;

    // If the point is within the square, return the square's color
    if (x >= this.squareX && x < squareXDimension && y >= this.squareY && y < squareYDimension) {
      return this.color;
    }

    // Otherwise, return the base image's color
    return this.baseImage.getPixelColor(x, y);
  }

  /**
   * Returns the width of the image.
   *
   * @return The width of the image
   */
  @Override
  public int getWidth() {
    return this.baseImage.getWidth();
  }

  /**
   * Returns the height of the image.
   *
   * @return The height of the image
   */
  @Override
  public int getHeight() {
    return this.baseImage.getHeight();
  }

  /**
   * Returns the number of layers of decorators. A SquareDecorator is a decorator that adds an
   * additional layer to the base image, so the number of layers is the number of layers in the base
   * image plus 1.
   *
   * @return The number of layers in the image
   */
  @Override
  public int getNumLayers() {
    // Return the number of layers in the base image plus 1 due to this decorator
    return this.baseImage.getNumLayers() + 1;
  }
}
