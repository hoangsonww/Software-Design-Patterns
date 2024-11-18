package com.comp301.a08shopping.events;

import com.comp301.a08shopping.Product;
import com.comp301.a08shopping.Store;

/**
 * This event is fired when a product that was previously out of stock is back in stock at a store.
 */
public class BackInStockEvent implements StoreEvent {
  /** The product that is back in stock */
  private final Product product;

  /** The store where the product is back in stock */
  private final Store store;

  /**
   * Constructor for the BackInStockEvent
   *
   * @param product The product that is back in stock
   * @param store The store where the product is back in stock
   */
  public BackInStockEvent(Product product, Store store) {
    if (product == null || store == null) {
      throw new IllegalArgumentException("Product and Store cannot be null");
    }

    this.product = product;
    this.store = store;
  }

  /**
   * Get the product that is back in stock
   *
   * @return The product that is back in stock
   */
  public Product getProduct() {
    return product;
  }

  /**
   * Get the store where the product is back in stock
   *
   * @return The store where the product is back in stock
   */
  public Store getStore() {
    return store;
  }
}
