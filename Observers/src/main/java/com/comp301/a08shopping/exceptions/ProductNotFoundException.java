package com.comp301.a08shopping.exceptions;

/** This exception is thrown when a product is not found */
public class ProductNotFoundException extends RuntimeException {
  /** Constructs a new ProductNotFoundException with a default message */
  public ProductNotFoundException() {}

  /**
   * Constructs a new ProductNotFoundException with a custom message
   *
   * @param message The custom message to include in the exception
   */
  public ProductNotFoundException(String message) {
    super(message);
  }
}
