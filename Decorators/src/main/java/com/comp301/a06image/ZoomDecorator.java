package com.comp301.a06image;

import java.awt.Color;

/**
 * The ZoomDecorator class is an Image decorator that zooms in on a base image. The zoom factor is
 * defined by a multiplier. The width and height of the image are increased by the multiplier, and
 * the color of a pixel can be retrieved by calling the getPixelColor method.
 */
public class ZoomDecorator implements Image {
  // Instance variables
  private Image baseImage;
  private int multiplier;

  /**
   * Constructor for the ZoomDecorator class. Initializes the ZoomDecorator with the specified image
   * and multiplier.
   *
   * @param image The image to be decorated with a zoom effect
   * @param multiplier The zoom factor
   * @throws IllegalArgumentException If the image is null or the multiplier is less than 1
   */
  public ZoomDecorator(Image image, int multiplier) {
    // Check for invalid arguments (null image or multiplier less than 1)
    if (image == null || multiplier < 1) {
      throw new IllegalArgumentException("Invalid arguments for ZoomDecorator.");
    }

    // Initialize the ZoomDecorator
    this.baseImage = image;
    this.multiplier = multiplier;
  }

  /**
   * Constructor for the ZoomDecorator class. Initializes the ZoomDecorator with the specified image
   * and a default multiplier of 2.
   *
   * @param image The image to be decorated with a zoom effect
   * @throws IllegalArgumentException If the image is null
   */
  public ZoomDecorator(Image image) {
    // Call the other constructor with a default multiplier of 2
    this(image, 2);
  }

  /**
   * Returns the color of the pixel at the specified coordinates. The color of the pixel in the base
   * image at the original x, y coordinates is returned.
   *
   * @param x The x coordinate of the pixel
   * @param y The y coordinate of the pixel
   * @return The color of the pixel at the specified coordinates
   */
  @Override
  public Color getPixelColor(int x, int y) {
    // Check for invalid arguments (out-of-bounds coordinates)
    // Throw an exception for invalid coordinates
    if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
      throw new IllegalArgumentException(
          "Pixel coordinates (" + x + ", " + y + ") are out of bounds.");
    }

    int originalX = x / this.multiplier;
    int originalY = y / this.multiplier;

    return this.baseImage.getPixelColor(originalX, originalY);
  }

  /**
   * Returns the width of the image.
   *
   * @return The width of the image
   */
  @Override
  public int getWidth() {
    return this.baseImage.getWidth() * this.multiplier;
  }

  /**
   * Returns the height of the image.
   *
   * @return The height of the image
   */
  @Override
  public int getHeight() {
    return this.baseImage.getHeight() * this.multiplier;
  }

  /**
   * Returns the number of layers in the image. The number of layers is equal to the number of
   * layers in the base image plus 1 due to this decorator.
   *
   * @return The number of layers in the image
   */
  @Override
  public int getNumLayers() {
    // Return the number of layers in the base image plus 1 due to this decorator
    return this.baseImage.getNumLayers() + 1;
  }
}
