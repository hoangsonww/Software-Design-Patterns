package com.comp301.a03exceptions;

/** This class contains methods that throw exceptions and catch exceptions. */
public class Jedi {

  /**
   * Section 7: Custom exception classes
   *
   * <p>Add a class file to your submission called NegativeValueException.java. In this file, define
   * a class called "NegativeValueException" which extends from RuntimeException. This exception
   * indicates that a negative value was encountered.
   *
   * <p>Inside the section7() method, check the value of parameter n. If n is negative, throw a
   * NegativeValueException. Otherwise, do nothing inside this method.
   *
   * @param n The value to check
   */
  public static void section7(int n) {
    // If n is negative, throw a NegativeValueException
    if (n < 0) {
      throw new NegativeValueException();
    }
    // Otherwise, do nothing
  }

  /**
   * Section 8: Subsequent try blocks
   *
   * <p>Inside this method, call method section7(), but catch a potential NegativeValueException. If
   * a NegativeValueException occurs, this method should return "A NegativeValueException occurred".
   *
   * <p>After calling method section7(), in a separate try/catch block, call static method
   * section1() from the Novice class. If a RuntimeException occurs, this method should return "A
   * RuntimeException occurred".
   *
   * <p>After calling section7() and section1(), if no exception occurred, return "No exception
   * occurred".
   *
   * @param n The value to check
   * @return A string indicating the result of the method
   */
  public static String section8(int n) {
    // Call section7() and catch a potential NegativeValueException
    try {
      section7(n);
    } catch (NegativeValueException e) {
      return "A NegativeValueException occurred";
    }

    // Call section1() from the Novice class and catch a potential RuntimeException
    try {
      Novice.section1(n);
    } catch (RuntimeException e) {
      return "A RuntimeException occurred";
    }

    // If no exception occurred, return this message
    return "No exception occurred";
  }

  /**
   * Section 9: Nested try blocks
   *
   * <p>Inside this method, call method section7(), passing in n as the argument, and catch a
   * potential NegativeValueException. If a NegativeValueException occurs (and only if one occurs),
   * this method should then call method section1() in a nested try/catch block, passing in -n
   * (negative n) as the argument. If a RuntimeException occurs due to section1() being called, this
   * method should return the string "Two exceptions were caught". If section1() executes without
   * throwing an exception, this method should return the string "One exception was caught". If
   * section7() executes without throwing an exception, this method should return the string "No
   * exceptions were caught".
   *
   * @param n The value to check
   * @return A string indicating the result of the method
   */
  public static String section9(int n) {
    // Call section7() and catch a potential NegativeValueException
    try {
      section7(n);
    } catch (NegativeValueException e) {
      // If a NegativeValueException occurs, call section1() in a nested try/catch block
      try {
        Novice.section1(-n);
      } catch (RuntimeException e2) {
        // If a RuntimeException occurs, return this message
        return "Two exceptions were caught";
      }

      // If section1() executes without throwing an exception, return this message
      return "One exception was caught";
    }

    // If section7() executes without throwing an exception, return this message
    return "No exceptions were caught";
  }
}
