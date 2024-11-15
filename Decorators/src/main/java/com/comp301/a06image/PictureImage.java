package com.comp301.a06image;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The PictureImage class is an Image implementation that represents an image loaded from a file on
 * disk. The image is represented as a BufferedImage object, and the color of a pixel can be
 * retrieved by calling the getPixelColor method.
 */
public class PictureImage implements Image {
  // Instance variable
  private BufferedImage image;

  /**
   * Constructor for the PictureImage class. Initializes the PictureImage with the image loaded from
   * the file at the specified pathname.
   *
   * @param pathname The pathname of the image file
   * @throws IOException If the image file cannot be loaded
   */
  public PictureImage(String pathname) throws IOException {
    // Check for invalid arguments (null pathname)
    if (pathname == null) {
      throw new IllegalArgumentException("Pathname cannot be null.");
    }

    // Load the image from the file at the specified pathname
    // Initialize the PictureImage
    File file = new File(pathname);
    this.image = ImageIO.read(file);
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

    if (x >= this.getWidth()) {
      throw new IllegalArgumentException("Pixel x-coordinate must be less than the image width.");
    }

    if (y >= this.getHeight()) {
      throw new IllegalArgumentException("Pixel y-coordinate must be less than the image height.");
    }

    // Retrieve the color of the pixel at position (x, y)
    int rgb = this.image.getRGB(x, y);
    return new Color(rgb, true);
  }

  /**
   * Returns the width of the image.
   *
   * @return The width of the image
   */
  @Override
  public int getWidth() {
    return this.image.getWidth();
  }

  /**
   * Returns the height of the image.
   *
   * @return The height of the image
   */
  @Override
  public int getHeight() {
    return this.image.getHeight();
  }

  /**
   * Returns the number of layers in the image. A PictureImage is a base image that has no layers,
   * so the number of layers is 1.
   *
   * @return The number of layers in the image
   */
  @Override
  public int getNumLayers() {
    // A PictureImage is a base image that has no layers, so return 1
    return 1;
  }
}
