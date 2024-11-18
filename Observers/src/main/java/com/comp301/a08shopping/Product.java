package com.comp301.a08shopping;

/** This interface represents a product that can be purchased */
public interface Product {
  /**
   * Gets the product's name
   *
   * @return The product's name
   */
  String getName();

  /**
   * Gets the product's price
   *
   * @return The product's price
   */
  double getBasePrice();
}
