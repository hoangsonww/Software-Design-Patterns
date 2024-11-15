package com.comp301.a06image;

import java.awt.Color;

/**
 * The SolidColorImage class is an Image implementation that represents an image with a solid color.
 * The image is defined by a width, a height, and a color. The color of a pixel can be retrieved by
 * calling the getPixelColor method.
 */
public class SolidColorImage implements Image {
  private int width;
  private int height;
  private Color color;

  /**
   * Constructor for the SolidColorImage class. Initializes the SolidColorImage with the specified
   * width, height, and color.
   *
   * @param width The width of the image
   * @param height The height of the image
   * @param color The color of the image
   * @throws IllegalArgumentException If the width or height is negative
   */
  public SolidColorImage(int width, int height, Color color) {
    // Check for invalid arguments (negative width or height)
    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("Width and height must be positive values.");
    }

    // Initialize the SolidColorImage
    this.width = width;
    this.height = height;
    this.color = color;
  }

  /**
   * Returns the color of the pixel at the specified coordinates.
   *
   * @param x The x coordinate of the pixel
   * @param y The y coordinate of the pixel
   * @return The color of the pixel at the specified coordinates
   */
  @Override
  public Color getPixelColor(int x, int y) {
    // Check for invalid arguments (negative x or y, or out-of-bounds x or y)
    if (x < 0) {
      throw new IllegalArgumentException("Pixel x-coordinate must be non-negative.");
    }

    if (y < 0) {
      throw new IllegalArgumentException("Pixel y-coordinate must be non-negative.");
    }

    if (x >= this.width) {
      throw new IllegalArgumentException("Pixel x-coordinate must be less than the image width.");
    }

    if (y >= this.height) {
      throw new IllegalArgumentException("Pixel y-coordinate must be less than the image height.");
    }

    // Return the solid color of the image
    return this.color;
  }

  /**
   * Returns the width of the image.
   *
   * @return The width of the image
   */
  @Override
  public int getWidth() {
    return this.width;
  }

  /**
   * Returns the height of the image.
   *
   * @return The height of the image
   */
  @Override
  public int getHeight() {
    return this.height;
  }

  /**
   * Returns the number of layers in the image. A SolidColorImage is a base image that has no
   * layers, so the number of layers is 1.
   *
   * @return The number of layers in the image
   */
  @Override
  public int getNumLayers() {
    // A SolidColorImage is a base image that has no layers, so return 1
    return 1;
  }
}
