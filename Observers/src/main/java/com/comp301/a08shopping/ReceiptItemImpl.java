/*
 * No need to make changes to this file for a08-shopping. This file represents a receipt from a
 * store after an item is purchased. You'll need to use this class in the
 * StoreImpl.purchaseProduct() method
 */

package com.comp301.a08shopping;

/** This class represents an item on a receipt */
public class ReceiptItemImpl implements ReceiptItem {
  /** The name of the product */
  private final String productName;

  /** The price paid for the product */
  private final double pricePaid;

  /** The store name where the product was purchased */
  private final String storeName;

  /**
   * Constructor for the ReceiptItemImpl
   *
   * @param productName The name of the product
   * @param pricePaid The price paid for the product
   * @param storeName The store name where the product was purchased
   */
  public ReceiptItemImpl(String productName, double pricePaid, String storeName) {
    this.productName = productName;
    this.pricePaid = pricePaid;
    this.storeName = storeName;
  }

  /**
   * Gets the name of the product
   *
   * @return The name of the product
   */
  @Override
  public String getProductName() {
    return productName;
  }

  /**
   * Gets the price paid for the product
   *
   * @return The price paid for the product
   */
  @Override
  public double getPricePaid() {
    return pricePaid;
  }

  /**
   * Gets the store name where the product was purchased
   *
   * @return The store name where the product was purchased
   */
  @Override
  public String getStoreName() {
    return storeName;
  }
}
