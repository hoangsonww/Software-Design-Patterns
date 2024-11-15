package com.comp301.a03exceptions;

/**
 * You do not need to implement this interface for the assignment. This interface is used by the
 * autograder to interact with your code. Some of the problems in this assignment will ask you to
 * "print" information at specific parts in your code. Use the print() method below to accomplish
 * this.
 */
public interface Printer {

  /**
   * Call this method to "print" a String. Unlike System.out.println, this method doesn't actually
   * print the string to the console. Instead, it just sends the string value straight to the
   * autograder.
   */
  void print(String value);
}
