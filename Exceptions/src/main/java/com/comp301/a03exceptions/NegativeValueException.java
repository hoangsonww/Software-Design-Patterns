package com.comp301.a03exceptions;

/** This exception indicates that a negative value was encountered. */
public class NegativeValueException extends RuntimeException {

  /** Constructor with a default message */
  public NegativeValueException() {
    super("A negative value was encountered");
  }

  /**
   * Constructor with a custom message
   *
   * @param message The message to display
   */
  public NegativeValueException(String message) {
    super(message);
  }
}
