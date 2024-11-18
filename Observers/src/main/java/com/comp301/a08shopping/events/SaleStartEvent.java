package com.comp301.a08shopping.events;

import com.comp301.a08shopping.Product;
import com.comp301.a08shopping.Store;

/**
 * This event is fired when a sale starts for a product at a store. The event contains the product
 * that is on sale and the store where the sale is happening.
 */
public class SaleStartEvent implements StoreEvent {
  /** The product that is on sale */
  private final Product product;

  /** The store where the sale is happening */
  private final Store store;

  /**
   * Constructor for the SaleStartEvent
   *
   * @param product The product that is on sale
   * @param store The store where the sale is happening
   */
  public SaleStartEvent(Product product, Store store) {
    if (product == null || store == null) {
      throw new IllegalArgumentException("Product and Store cannot be null");
    }

    this.product = product;
    this.store = store;
  }

  /**
   * Get the product that is on sale
   *
   * @return The product that is on sale
   */
  public Product getProduct() {
    return product;
  }

  /**
   * Get the store where the sale is happening
   *
   * @return The store where the sale is happening
   */
  public Store getStore() {
    return store;
  }
}
