package com.comp301.a08shopping.events;

import com.comp301.a08shopping.Product;
import com.comp301.a08shopping.Store;

/**
 * This event is fired when a sale ends for a product at a store. The event contains the product
 * that the sale ended for and the store where the sale ended.
 */
public class SaleEndEvent implements StoreEvent {
  /** The product that the sale ended for */
  private final Product product;

  /** The store where the sale ended */
  private final Store store;

  /**
   * Constructor for the SaleEndEvent
   *
   * @param product The product that the sale ended for
   * @param store The store where the sale ended
   */
  public SaleEndEvent(Product product, Store store) {
    if (product == null || store == null) {
      throw new IllegalArgumentException("Product and Store cannot be null");
    }

    this.product = product;
    this.store = store;
  }

  /**
   * Get the product that the sale ended for
   *
   * @return The product that the sale ended for
   */
  public Product getProduct() {
    return product;
  }

  /**
   * Get the store where the sale ended
   *
   * @return The store where the sale ended
   */
  public Store getStore() {
    return store;
  }
}
