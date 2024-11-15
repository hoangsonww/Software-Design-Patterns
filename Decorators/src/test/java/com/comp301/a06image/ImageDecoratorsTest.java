package com.comp301.a06image;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.awt.Color;
import java.io.IOException;

/**
 * This test suite checks the functionality of the ImageDecorator classes. It tests the
 * SolidColorImage, PictureImage, SquareDecorator, CircleDecorator, BorderDecorator, and
 * ZoomDecorator classes.
 */
public class ImageDecoratorsTest {

  /**
   * Default constructor for the ImageDecoratorsTest class. This constructor is empty because no
   * setup is needed for the tests.
   */
  public ImageDecoratorsTest() {
    // Default constructor
  }

  /**
   * Tests the SolidColorImage class by creating an image with a solid color and checking its
   * dimensions and pixel colors.
   */
  @Test
  public void testSolidColorImageDimensions() {
    Image img = new SolidColorImage(100, 100, new Color(0, 255, 52));
    assertEquals(100, img.getWidth());
    assertEquals(100, img.getHeight());
  }

  /**
   * Tests the SolidColorImage class by creating an image with a solid color and checking the color
   * of each pixel.
   */
  @Test
  public void testSolidColorImagePixelColor() {
    Image img = new SolidColorImage(100, 100, new Color(0, 255, 52));
    for (int x = 0; x < img.getWidth(); x++) {
      for (int y = 0; y < img.getHeight(); y++) {
        assertEquals(new Color(0, 255, 52), img.getPixelColor(x, y));
      }
    }
  }

  /**
   * Tests if the SolidColorImage class throws an IllegalArgumentException when the width or height
   * is negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSolidColorImageInvalidDimensions() {
    new SolidColorImage(-100, 100, new Color(0, 255, 52));
  }

  /**
   * Tests if the SolidColorImage class throws an IllegalArgumentException when the pixel
   * coordinates are out of bounds.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSolidColorImageOutOfBounds() {
    Image img = new SolidColorImage(100, 100, new Color(0, 255, 52));
    img.getPixelColor(100, 50);
  }

  /**
   * Tests the PictureImage class by loading an image from a file and checking its dimensions.
   *
   * @throws IOException If the image file cannot be loaded
   */
  @Test
  public void testPictureImageLoadAndDimensions() throws IOException {
    Image img = new PictureImage("img/kmp.jpg");
    assertTrue(img.getWidth() > 0 && img.getHeight() > 0);
  }

  /**
   * Tests the PictureImage class by loading a non-existent image file and checking if an
   * IOException is thrown.
   *
   * @throws IOException If the image file cannot be loaded
   */
  @Test(expected = IOException.class)
  public void testPictureImageLoadFailure() throws IOException {
    new PictureImage("nonexistent.jpg");
  }

  /**
   * Tests the PictureImage class by loading an image from a file and checking the color of a pixel.
   *
   * @throws IOException If the image file cannot be loaded
   */
  @Test(expected = IllegalArgumentException.class)
  public void testPictureImagePixelOutOfBounds() throws IOException {
    Image img = new PictureImage("img/kmp.jpg");
    img.getPixelColor(img.getWidth(), img.getHeight());
  }

  /**
   * Tests the SquareDecorator class by creating an image with a square and checking the color of
   * some pixel.
   */
  @Test
  public void testSquareDecoratorWithinBounds() {
    Image baseImage = new SolidColorImage(100, 100, Color.WHITE);
    Image squareImage = new SquareDecorator(baseImage, 10, 10, 20, Color.RED);
    assertEquals(Color.RED, squareImage.getPixelColor(10, 10));
    assertEquals(Color.RED, squareImage.getPixelColor(29, 29));
    assertEquals(Color.WHITE, squareImage.getPixelColor(9, 10));
    assertEquals(Color.WHITE, squareImage.getPixelColor(30, 10));
  }

  /**
   * Tests if the SquareDecorator class throws an IllegalArgumentException when the square size is
   * negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSquareDecoratorInvalidArguments() {
    Image baseImage = new SolidColorImage(100, 100, Color.WHITE);
    new SquareDecorator(baseImage, 10, 10, -20, Color.RED);
  }

  /**
   * Tests the CircleDecorator class by creating an image with a circle and checking the color of
   * some pixel.
   */
  @Test
  public void testCircleDecoratorInsideAndOutside() {
    Image baseImage = new SolidColorImage(100, 100, Color.WHITE);
    Image circleImage = new CircleDecorator(baseImage, 50, 50, 30, Color.BLUE);
    assertEquals(Color.BLUE, circleImage.getPixelColor(50, 50));
    assertEquals(Color.BLUE, circleImage.getPixelColor(70, 50));
    assertEquals(Color.WHITE, circleImage.getPixelColor(81, 50));
  }

  /**
   * Tests if the CircleDecorator class throws an IllegalArgumentException when the radius is
   * negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCircleDecoratorInvalidRadius() {
    Image baseImage = new SolidColorImage(100, 100, Color.WHITE);
    new CircleDecorator(baseImage, 50, 50, -1, Color.BLUE);
  }

  /**
   * Tests the BorderDecorator class by creating an image with a border and checking the color of
   * some pixel.
   */
  @Test
  public void testBorderDecoratorBorderAndInside() {
    Image baseImage = new SolidColorImage(100, 100, Color.WHITE);
    Image borderedImage = new BorderDecorator(baseImage, 10, Color.GREEN);

    // Check pixels on the border
    assertEquals("Border color at top-left corner", Color.GREEN, borderedImage.getPixelColor(0, 0));
    assertEquals(
        "Border color at bottom-right corner", Color.GREEN, borderedImage.getPixelColor(119, 119));

    // Check pixels just inside the border
    assertEquals(
        "Image color just inside top-left", Color.WHITE, borderedImage.getPixelColor(10, 10));
    assertEquals(
        "Image color just inside bottom-right", Color.WHITE, borderedImage.getPixelColor(109, 109));
  }

  /**
   * Tests if the BorderDecorator class throws an IllegalArgumentException when the thickness is
   * negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBorderDecoratorInvalidThickness() {
    Image baseImage = new SolidColorImage(100, 100, Color.WHITE);
    new BorderDecorator(baseImage, -1, Color.GREEN);
  }

  /**
   * Tests the ZoomDecorator class by creating an image with a zoomed-in version of a base image and
   * checking the color of some pixel.
   */
  @Test
  public void testZoomDecoratorScalingAndPixelRepetition() {
    Image baseImage = new SolidColorImage(2, 2, Color.RED);
    Image zoomedImage = new ZoomDecorator(baseImage, 2);
    assertEquals(Color.RED, zoomedImage.getPixelColor(0, 0));
    assertEquals(Color.RED, zoomedImage.getPixelColor(1, 1));
    assertEquals(Color.RED, zoomedImage.getPixelColor(2, 2));
    assertEquals(Color.RED, zoomedImage.getPixelColor(3, 3));
  }

  /**
   * Tests if the ZoomDecorator class throws an IllegalArgumentException when the multiplier is less
   * than 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testZoomDecoratorInvalidMultiplier() {
    Image baseImage = new SolidColorImage(100, 100, Color.WHITE);
    new ZoomDecorator(baseImage, 0);
  }

  /**
   * Tests the sequential application of multiple decorators to understand how they cumulatively
   * affect the image's dimensions, particularly the width.
   */
  @Test
  public void testComplexDecoratorSequence() {
    // Increase the base size significantly
    Image baseImage = new SolidColorImage(500, 500, Color.WHITE);

    // Apply a thicker border to see a more substantial increase in dimensions
    Image borderImage1 = new BorderDecorator(baseImage, 50, Color.BLACK); // 50 pixels border
    System.out.println("Width after first border: " + borderImage1.getWidth());

    // Apply a larger zoom factor
    Image zoomedImage = new ZoomDecorator(borderImage1, 2); // Doubling the size
    System.out.println("Width after zoom: " + zoomedImage.getWidth());

    // Apply another thick border after zooming
    Image borderImage2 =
        new BorderDecorator(zoomedImage, 50, Color.BLACK); // Another 50 pixels border
    System.out.println("Width after second border: " + borderImage2.getWidth());

    // The expected width calculation: (500 + 100) * 2 + 100 = 1300
    int expectedWidth = (baseImage.getWidth() + 100) * 2 + 100;
    System.out.println("Expected final width calculated dynamically: " + expectedWidth);

    // Final check against the dynamically calculated expected width
    assertEquals("Expected final width is not met", expectedWidth, borderImage2.getWidth());
  }

  /**
   * Tests the chaining of multiple decorators to understand how they cumulatively affect the
   * image's dimensions, particularly the width.
   */
  @Test
  public void testDecoratorChaining() {
    // Start with a basic image of reasonable size
    Image baseImage = new SolidColorImage(300, 300, Color.WHITE);

    // First, apply a border with a thickness of 20, color does not matter here
    Image borderImage1 = new BorderDecorator(baseImage, 20, Color.BLACK);
    int widthAfterFirstBorder = borderImage1.getWidth();
    System.out.println("Width after first border: " + widthAfterFirstBorder);

    // Apply a zoom of 3x to the image with the first border
    Image zoomedImage = new ZoomDecorator(borderImage1, 3);
    int widthAfterZoom = zoomedImage.getWidth();
    System.out.println("Width after zoom: " + widthAfterZoom);

    // Apply another border of 20 pixels on the zoomed image
    Image borderImage2 = new BorderDecorator(zoomedImage, 20, Color.BLACK);
    int widthAfterSecondBorder = borderImage2.getWidth();
    System.out.println("Width after second border: " + widthAfterSecondBorder);

    // Verify that each width measurement is as expected
    assertEquals("Width after first border should be 340", 340, widthAfterFirstBorder);
    assertEquals("Width after zoom should be 1020", 1020, widthAfterZoom);
    assertEquals("Width after second border should be 1060", 1060, widthAfterSecondBorder);

    // Optionally, check the final image dimensions against an expected value
    int expectedFinalWidth = 1060; // This should match the calculated width after second border
    assertEquals("Expected final width is not met", expectedFinalWidth, widthAfterSecondBorder);
  }

  /**
   * Tests the chaining of multiple decorators to understand how they cumulatively affect the
   * image's dimensions, particularly the width.
   */
  @Test
  public void testDecoratorChaining2() {
    // Assume initial width of the base image is 341 for testing consistency
    Image baseImage = new SolidColorImage(341, 341, Color.WHITE);

    // Apply first border with a thickness of 5 (should increase total width to 351)
    Image firstBorder = new BorderDecorator(baseImage, 5, new Color(255, 0, 0));
    assertEquals(351, firstBorder.getWidth());

    // Apply second border with a thickness of 50 (should increase total width to 451)
    Image secondBorder = new BorderDecorator(firstBorder, 50, new Color(0, 0, 255));
    assertEquals(451, secondBorder.getWidth());

    // Apply a yellow circle (width should remain 451 if CircleDecorator doesn't change width)
    Image yellowCircle = new CircleDecorator(secondBorder, 50, 50, 40, new Color(255, 255, 0));
    assertEquals(451, yellowCircle.getWidth());

    // Apply an orange square (width should remain 451 if SquareDecorator doesn't change width)
    Image orangeSquare = new SquareDecorator(yellowCircle, 100, 100, 40, new Color(200, 80, 10));
    assertEquals(451, orangeSquare.getWidth());

    // Apply a zoom with a factor of 2 (should double the width to 902)
    Image zoomed = new ZoomDecorator(orangeSquare, 2);
    assertEquals(902, zoomed.getWidth());

    // Verify the final expected width against the failed test case scenario
    assertEquals(
        "Final expected width does not match the expected result from the test case scenario.",
        902,
        zoomed.getWidth());
  }

  /**
   * Tests the chaining of multiple decorators to understand how they cumulatively affect the
   * image's dimensions, particularly the width.
   */
  @Test
  public void testComplexDecoratorChaining() {
    // Initial base image with width 341
    Image baseImage = new SolidColorImage(341, 341, Color.WHITE);

    // Apply a series of borders to increase width significantly
    Image bordered1 = new BorderDecorator(baseImage, 5, new Color(255, 0, 0)); // +10 width
    Image bordered2 = new BorderDecorator(bordered1, 50, new Color(0, 0, 255)); // +100 width

    // After the above steps, width = 341 + 10 + 100 = 451
    assertEquals(451, bordered2.getWidth());

    // Apply a zoom decorator to multiply the width
    Image zoomed = new ZoomDecorator(bordered2, 3);

    // Expected width = 451 * 3 = 1353 (closest we can get with integer zoom under typical
    // constraints)
    assertEquals(1353, zoomed.getWidth());

    // Check if additional border can be added to get closer or match the target width 1420.
    Image finalImage = new BorderDecorator(zoomed, 33, new Color(200, 100, 50)); // +66 width
    assertEquals(1353 + 66, finalImage.getWidth()); // Expected 1419
  }
}
