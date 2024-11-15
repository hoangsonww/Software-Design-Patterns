package com.comp301.a06image;

import java.awt.Color;

/**
 * This class implements the Image interface and represents an image with a border around it. The
 * border is a specified thickness and color. The border is drawn around the entire image, so the
 * width and height of the image are increased by twice the thickness of the border.
 */
public class BorderDecorator implements Image {
  // Instance variables
  private Image baseImage;
  private int thiccness;
  private Color borderColor;

  /**
   * Constructor for the BorderDecorator class. Initializes the BorderDecorator with the specified
   * image, thickness of the border, and color of the border.
   *
   * @param image The image to be decorated with a border
   * @param thiccness The thickness of the border
   * @param borderColor The color of the border
   * @throws IllegalArgumentException If the image is null or the thickness is negative
   */
  public BorderDecorator(Image image, int thiccness, Color borderColor) {
    // Check for invalid arguments (null image or negative thiccness)
    if (image == null || thiccness < 0) {
      throw new IllegalArgumentException("Invalid arguments for BorderDecorator.");
    }

    // Initialize the BorderDecorator
    this.baseImage = image;
    this.thiccness = thiccness;
    this.borderColor = borderColor;
  }

  /**
   * Returns the color of the pixel at the specified coordinates. If the pixel is within the border,
   * the border's color is returned. Otherwise, the color of the pixel in the base image is
   * returned.
   *
   * @param x The x coordinate of the pixel
   * @param y The y coordinate of the pixel
   * @return The color of the pixel at the specified coordinates
   */
  @Override
  public Color getPixelColor(int x, int y) {
    // Get the width and height of the image
    int width = this.getWidth();
    int height = this.getHeight();

    // Early check for out-of-bounds coordinates to throw an exception for invalid coordinates
    if (x < 0 || y < 0 || x >= width || y >= height) {
      throw new IllegalArgumentException(
          "Pixel coordinates (" + x + ", " + y + ") are out of image bounds.");
    }

    // Check if the pixel is within the border
    // Explanation: x < thiccness: Checks if the x coordinate is less than the thickness of the
    // border on the left side. If true, it means the pixel is within the left border.
    // y < thiccness: Checks if the y coordinate is less than the thickness of the border on the top
    // side. If true, it means the pixel is within the top border.
    // x >= width - thiccness: Checks if the x coordinate is greater than or equal to the width of
    // the image minus the thickness of the border on the right side. If true, it means the pixel is
    // within the right border.
    // y >= height - thiccness: Checks if the y coordinate is greater than or equal to the height of
    // the image minus the thickness of the border on the bottom side. If true, it means the pixel
    // is
    // within the bottom border.
    if (x < thiccness || y < thiccness || x >= width - thiccness || y >= height - thiccness) {
      return borderColor;
    }

    // Calculate coordinates within the base image
    int xBase = x - thiccness;
    int yBase = y - thiccness;

    // Return the color from the base image
    return baseImage.getPixelColor(xBase, yBase);
  }

  /**
   * Returns the width of the image. The width of the image is the width of the base image plus the
   * thickness of the border on both sides.
   *
   * @return The width of the image
   */
  @Override
  public int getWidth() {
    return this.baseImage.getWidth() + 2 * this.thiccness;
  }

  /**
   * Returns the height of the image. The height of the image is the height of the base image plus
   * the thickness of the border on both sides.
   *
   * @return The height of the image
   */
  @Override
  public int getHeight() {
    // Return the height of the base image plus the thickness of the border on both sides
    return this.baseImage.getHeight() + 2 * this.thiccness;
  }

  /**
   * Returns the number of layers of decorators. The number of layers in the image is the number of
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
