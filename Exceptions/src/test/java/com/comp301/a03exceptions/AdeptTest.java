package com.comp301.a03exceptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;

/** Unit test for the Adept class. */
public class AdeptTest {

  /** Test for section4 method */
  @Test
  public void testSection4() {
    // Create a mock Printer object to collect print statements
    TestPrinter printer = new TestPrinter();

    // Test case where no exception occurs (e.g., n = 6 which is not a multiple of 5)
    Adept.section4(6, printer);
    assertEquals(
        "If we get here, that means no exception occurred\n"
            + "If we get here, the try/catch block is done, but an exception may not have been caught\n"
            + "If we get here, we made it through the try/catch block and caught any exceptions that may have occurred\n",
        printer.getPrintedOutput());

    // Clear the printer output
    printer.clear();

    // Test case where an exception occurs (e.g., n = 5 which should cause a NullPointerException)
    Adept.section4(5, printer);
    assertEquals(
        "If we get here, that means an exception was caught\n"
            + "If we get here, the try/catch block is done, but an exception may not have been caught\n"
            + "If we get here, we made it through the try/catch block and caught any exceptions that may have occurred\n",
        printer.getPrintedOutput());
  }

  /** Test for section5 method */
  @Test
  public void testSection5() {
    // Test case with a valid URL
    try {
      BufferedReader reader = Adept.section5("https://google.com");
      // Just ensure that the reader is not null for this test
      assertTrue(reader != null);
      reader.close();
    } catch (MalformedURLException e) {
      fail("A valid URL should not throw MalformedURLException.");
    } catch (IOException e) {
      fail("A valid URL should not throw IOException.");
    }

    // Test case with an invalid URL that throws MalformedURLException
    try {
      Adept.section5("invalid-url");
      fail("Expected MalformedURLException was not thrown");
    } catch (MalformedURLException e) {
      // Expected outcome
    } catch (IOException e) {
      fail("Expected MalformedURLException but got IOException.");
    }
  }

  /** Test for section6 method */
  @Test
  public void testSection6() {
    // Test with a valid URL
    String result = Adept.section6("https://google.com");
    // Check if content was returned, it should not be the error message.
    assertTrue(!result.equals("An error occurred and the page could not be downloaded"));

    // Test with an invalid URL, expecting an error message
    result = Adept.section6("invalid-url");
    assertEquals("An error occurred and the page could not be downloaded", result);
  }

  /** A simple mock Printer implementation for testing purposes */
  private static class TestPrinter implements Printer {

    /** The printed output */
    private StringBuilder output = new StringBuilder();

    /**
     * Print a message
     *
     * @param message The message to print
     */
    @Override
    public void print(String message) {
      output.append(message).append("\n");
    }

    /**
     * Get the printed output
     *
     * @return The printed output
     */
    public String getPrintedOutput() {
      return output.toString();
    }

    /** Clear the printed output */
    public void clear() {
      output.setLength(0);
    }
  }
}
