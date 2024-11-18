package com.comp301.a08shopping;

/** This interface represents an item on a receipt */
public interface ReceiptItem {
  /**
   * Gets the name of the product
   *
   * @return The name of the product
   */
  String getProductName();

  /**
   * Gets the price paid for the product
   *
   * @return The price paid for the product
   */
  double getPricePaid();

  /**
   * Gets the store name where the product was purchased
   *
   * @return The store name where the product was purchased
   */
  String getStoreName();
}
