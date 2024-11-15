package com.comp301.a06image;

import java.awt.Color;

/**
 * The CircleDecorator class is an Image decorator that draws a circle on top of a base image. The
 * circle is defined by a center point, a radius, and a color. If a point is within the circle, the
 * circle's color is returned. Otherwise, the base image's color is returned.
 */
public class CircleDecorator implements Image {
  // Instance variables
  private Image baseImage;
  private int centerX;
  private int centerY;
  private int radius;
  private Color color;

  /**
   * Constructor for the CircleDecorator class. Initializes the CircleDecorator with the specified
   * image, center point, radius, and color of the circle.
   *
   * @param image The image to be decorated with a circle
   * @param centerX The x coordinate of the center of the circle
   * @param centerY The y coordinate of the center of the circle
   * @param radius The radius of the circle
   * @param color The color of the circle
   * @throws IllegalArgumentException If the image is null or the radius is negative
   */
  public CircleDecorator(Image image, int centerX, int centerY, int radius, Color color) {
    // Check for invalid arguments (null image or negative radius)
    if (image == null || radius < 0) {
      throw new IllegalArgumentException("Invalid arguments for CircleDecorator.");
    }

    // Initialize the CircleDecorator
    this.baseImage = image;
    this.centerX = centerX;
    this.centerY = centerY;
    this.radius = radius;
    this.color = color;
  }

  /**
   * Returns the color of the pixel at the specified coordinates. If the pixel is within the circle,
   * the circle's color is returned. Otherwise, the base image's color is returned.
   *
   * @param x The x coordinate of the pixel
   * @param y The y coordinate of the pixel
   * @return The color of the pixel at the specified coordinates
   */
  @Override
  public Color getPixelColor(int x, int y) {
    // If the point is within the circle, return the circle's color
    if (isWithinCircle(x, y) == true) {
      return this.color;
    }

    // Otherwise, return the base image's color
    return this.baseImage.getPixelColor(x, y);
  }

  /**
   * Helper method that determines if a point is within the circle.
   *
   * @param x The x coordinate of the point
   * @param y The y coordinate of the point
   * @return True if the point is within the circle, false otherwise
   */
  private boolean isWithinCircle(int x, int y) {
    // Using the distance formula to determine if a point is within the circle
    // Formula: Distance = sqrt((x - centerX)^2 + (y - centerY)^2)
    double distance = Math.sqrt(Math.pow(x - this.centerX, 2) + Math.pow(y - this.centerY, 2));

    // If the distance is less than the radius, the point is within the circle
    if (distance < radius) {
      return true;
    } else {
      // Otherwise, the point is outside the circle
      return false;
    }
  }

  /**
   * Returns the width of the image. The width of the image is the width of the base image.
   *
   * @return The width of the image
   */
  @Override
  public int getWidth() {
    return this.baseImage.getWidth();
  }

  /**
   * Returns the height of the image. The height of the image is the height of the base image.
   *
   * @return The height of the image
   */
  @Override
  public int getHeight() {
    return this.baseImage.getHeight();
  }

  /**
   * Returns the number of layers of the decorators. The number of layers is the number of layers in
   * the base image plus 1 due to this decorator.
   *
   * @return The number of layers in the image
   */
  @Override
  public int getNumLayers() {
    // Return the number of layers in the base image plus 1 due to this decorator
    return this.baseImage.getNumLayers() + 1;
  }
}
