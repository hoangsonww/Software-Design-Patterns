package com.comp301.a06image;

import java.awt.Color;
import java.io.IOException;
import javafx.application.Application;

/**
 * This class is the entry point for the image decorator application. You can use this class to test
 * your image decorator implementations. The makeImage() method below creates an image object and
 * applies a series of decorators to it. You can modify this method to test different decorators.
 * When you run the main() method below, the image you create will be displayed on the screen.
 */
public class Main {
  /**
   * Creates and returns an image object for testing. The image that this method produces will be
   * automatically displayed on the screen when main() is run below. Use this method to test
   * different decorators.
   *
   * @return The image object to be displayed
   * @throws IOException If the image file cannot be loaded
   */
  public static Image makeImage() throws IOException {
    // Load the base image
    Image baseImage = new PictureImage("img/headshot.jpg");

    // Apply a red border
    Image redBorderImage = new BorderDecorator(baseImage, 5, new Color(255, 0, 0));

    // Apply a blue border
    Image blueBorderImage = new BorderDecorator(redBorderImage, 50, new Color(0, 0, 255));

    // Apply a yellow circle
    Image yellowCircleImage =
        new CircleDecorator(blueBorderImage, 50, 50, 40, new Color(255, 255, 0));

    // Apply an orange square
    Image orangeSquareImage =
        new SquareDecorator(yellowCircleImage, 100, 100, 40, new Color(200, 80, 10));

    // Finally, apply a ZoomDecorator with a multiplier of 2
    Image finalImage = new ZoomDecorator(orangeSquareImage, 2);

    // Return the final image
    return finalImage;
  }

  /**
   * Use this method for testing your code. When main() runs, the image you created and decorated in
   * the makeImage() method above will be generated and displayed on the screen. You don't need to
   * make any changes to this main() method.
   *
   * @param args Command-line arguments
   */
  public static void main(String[] args) {
    Application.launch(ImageDisplay.class, args);
  }
}
