package com.comp301.a08shopping.exceptions;

/** This exception is thrown when a product is out of stock */
public class OutOfStockException extends RuntimeException {
  /** Constructs a new OutOfStockException with a default message */
  public OutOfStockException() {}

  /**
   * Constructs a new OutOfStockException with a custom message
   *
   * @param message The custom message to include in the exception
   */
  public OutOfStockException(String message) {
    super(message);
  }
}
