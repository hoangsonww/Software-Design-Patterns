package com.comp301.a08shopping.events;

import com.comp301.a08shopping.Product;
import com.comp301.a08shopping.Store;

/**
 * This event is fired when a product is out of stock at a store. The event contains the product
 * that is out of stock and the store where the product is out of stock.
 */
public class OutOfStockEvent implements StoreEvent {
  /** The product that is out of stock */
  private final Product product;

  /** The store where the product is out of stock */
  private final Store store;

  /**
   * Constructor for the OutOfStockEvent
   *
   * @param product The product that is out of stock
   * @param store The store where the product is out of stock
   */
  public OutOfStockEvent(Product product, Store store) {
    if (product == null || store == null) {
      throw new IllegalArgumentException("Product and Store cannot be null");
    }

    this.product = product;
    this.store = store;
  }

  /**
   * Get the product that is out of stock
   *
   * @return The product that is out of stock
   */
  public Product getProduct() {
    return product;
  }

  /**
   * Get the store where the product is out of stock
   *
   * @return The store where the product is out of stock
   */
  public Store getStore() {
    return store;
  }
}
