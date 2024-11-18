package com.comp301.a08shopping;

/** This class represents a product that can be purchased */
public class ProductImpl implements Product {
  /** The name of the product */
  private final String name;

  /** The base price of the product */
  private final double basePrice;

  /**
   * Constructor for the ProductImpl
   *
   * @param name The name of the product
   * @param basePrice The base price of the product
   */
  public ProductImpl(String name, double basePrice) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("Product name cannot be null or empty");
    }

    if (basePrice <= 0) {
      throw new IllegalArgumentException("Base price must be greater than zero");
    }

    this.name = name;
    this.basePrice = Math.round(basePrice * 100.0) / 100.0;
  }

  /**
   * Gets the product's name
   *
   * @return The product's name
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * Gets the product's price
   *
   * @return The product's price
   */
  @Override
  public double getBasePrice() {
    return basePrice;
  }
}
