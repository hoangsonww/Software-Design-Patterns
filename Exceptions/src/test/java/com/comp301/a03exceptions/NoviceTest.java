package com.comp301.a03exceptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/** Unit tests for the Novice class */
public class NoviceTest {

  /** Test for section1 method */
  @Test
  public void testSection1() {
    // Test for negative n: Should throw UnsupportedOperationException
    try {
      Novice.section1(-1);
      fail("Expected UnsupportedOperationException for n = -1");
    } catch (UnsupportedOperationException e) {
      // Test passed
    }

    // Test for n = 0: Should throw IndexOutOfBoundsException
    try {
      Novice.section1(0);
      fail("Expected IndexOutOfBoundsException for n = 0");
    } catch (IndexOutOfBoundsException e) {
      // Test passed
    }

    // Test for n = 1: Should throw ArrayIndexOutOfBoundsException
    try {
      Novice.section1(1);
      fail("Expected ArrayIndexOutOfBoundsException for n = 1");
    } catch (ArrayIndexOutOfBoundsException e) {
      // Test passed
    }

    // Test for n = 2: Should throw IllegalStateException
    try {
      Novice.section1(2);
      fail("Expected IllegalStateException for n = 2");
    } catch (IllegalStateException e) {
      // Test passed
    }

    // Test for n = 3: Should throw IllegalArgumentException
    try {
      Novice.section1(3);
      fail("Expected IllegalArgumentException for n = 3");
    } catch (IllegalArgumentException e) {
      // Test passed
    }

    // Test for n = 4: Should throw ArithmeticException
    try {
      Novice.section1(4);
      fail("Expected ArithmeticException for n = 4");
    } catch (ArithmeticException e) {
      // Test passed
    }

    // Test for n = 5: Should throw NullPointerException with the correct message
    try {
      Novice.section1(5);
      fail("Expected NullPointerException for n = 5");
    } catch (NullPointerException e) {
      assertEquals("The value of n is 5", e.getMessage());
    }

    // Test for n = 10 (multiple of 5): Should throw NullPointerException with the correct message
    try {
      Novice.section1(10);
      fail("Expected NullPointerException for n = 10");
    } catch (NullPointerException e) {
      assertEquals("The value of n is 10", e.getMessage());
    }

    // Test for n = 7 (should return 7)
    assertEquals(7, Novice.section1(7));
  }

  /** Test for section2 method */
  @Test
  public void testSection2() {
    // Test for n = 3: Should convert IllegalArgumentException to ArithmeticException
    try {
      Novice.section2(3);
      fail("Expected ArithmeticException for n = 3");
    } catch (ArithmeticException e) {
      // Test passed
    }

    // Test for n = 4: Should convert ArithmeticException to NullPointerException
    try {
      Novice.section2(4);
      fail("Expected NullPointerException for n = 4");
    } catch (NullPointerException e) {
      // Test passed
    }

    // Test for n = 5: Should return -1 since NullPointerException should be caught
    assertEquals(-1, Novice.section2(5));

    // Test for other values, such as n = 6, which should simply return 6
    assertEquals(6, Novice.section2(6));
  }

  /** Test for section3 method */
  @Test
  public void testSection3() {
    // Create a mock test Printer object to collect print statements
    TestPrinter printer = new TestPrinter();

    // Test when an exception is caught (e.g., n = 1 should cause an ArrayIndexOutOfBoundsException)
    Novice.section3(1, printer);
    assertEquals(
        "If we get here, that means an exception was caught\nAll done\n",
        printer.getPrintedOutput());

    // Test when no exception occurs (e.g., n = 6 should cause no exception)
    printer.clear(); // Clear the previous output
    Novice.section3(6, printer);
    assertEquals(
        "If we get here, that means no exception occurred\nAll done\n", printer.getPrintedOutput());
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
