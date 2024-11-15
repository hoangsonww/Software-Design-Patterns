package com.comp301.a03exceptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/** Unit test for the Jedi class. */
public class JediTest {

  /** Test for section7 method */
  @Test
  public void testSection7() {
    // Test case when n is negative, expecting a NegativeValueException
    try {
      Jedi.section7(-5);
      fail("Expected NegativeValueException was not thrown");
    } catch (NegativeValueException e) {
      // Expected outcome, test passes
    }

    // Test case when n is non-negative, expecting no exception
    try {
      Jedi.section7(5);
      // If we reach here, it means no exception was thrown, which is expected
    } catch (NegativeValueException e) {
      fail("NegativeValueException should not be thrown for non-negative n");
    }
  }

  /** Test for section8 method */
  @Test
  public void testSection8() {
    // Test case when n is negative, should return "A NegativeValueException occurred"
    assertEquals("A NegativeValueException occurred", Jedi.section8(-1));

    // Test case when n = 3 (which should throw IllegalArgumentException in section1),
    // resulting in "A RuntimeException occurred"
    assertEquals("A RuntimeException occurred", Jedi.section8(3));

    // Test case with n = 5 (which should throw NullPointerException in section1),
    // resulting in "A RuntimeException occurred"
    assertEquals("A RuntimeException occurred", Jedi.section8(5));

    // Test case with n = 6 (no exception should occur), expecting "No exception occurred"
    assertEquals("No exception occurred", Jedi.section8(6));
  }

  /** Test for section9 method */
  @Test
  public void testSection9() {
    // Test case where n = -1, should catch NegativeValueException and section1(-n) should throw a
    // RuntimeException, hence expecting "Two exceptions were caught"
    assertEquals("Two exceptions were caught", Jedi.section9(-1));

    // Test case where n = -7, should catch NegativeValueException but section1(7) will not throw,
    // hence expecting "One exception was caught"
    assertEquals("One exception was caught", Jedi.section9(-7));

    // Test case with n = 5 (section7 does not throw, but section1 throws NullPointerException),
    // expecting "No exceptions were caught"
    assertEquals("No exceptions were caught", Jedi.section9(5));

    // Test case where n = -5, expecting "Two exceptions were caught" because
    // section1(-n) should throw UnsupportedOperationException
    assertEquals("Two exceptions were caught", Jedi.section9(-5));

    // Test case with n = 3 (section7 does not throw, but section1 throws IllegalArgumentException),
    // should expect "No exceptions were caught"
    assertEquals("No exceptions were caught", Jedi.section9(3));

    // Test case with n = 6 (no exception is expected in both section7 and section1),
    // so it should return "No exceptions were caught"
    assertEquals("No exceptions were caught", Jedi.section9(6));
  }
}
