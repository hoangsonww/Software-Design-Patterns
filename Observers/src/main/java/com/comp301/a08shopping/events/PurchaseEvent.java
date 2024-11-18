package com.comp301.a08shopping.events;

import com.comp301.a08shopping.Product;
import com.comp301.a08shopping.Store;

/**
 * This event is fired when a product is purchased from a store. The event contains the product that
 * was purchased and the store where the product was purchased.
 */
public class PurchaseEvent implements StoreEvent {
  /** The product that was purchased */
  private final Product product;

  /** The store where the product was purchased */
  private final Store store;

  /**
   * Constructor for the PurchaseEvent
   *
   * @param product The product that was purchased
   * @param store The store where the product was purchased
   */
  public PurchaseEvent(Product product, Store store) {
    if (product == null || store == null) {
      throw new IllegalArgumentException("Product and Store cannot be null");
    }

    this.product = product;
    this.store = store;
  }

  /**
   * Get the product that was purchased
   *
   * @return The product that was purchased
   */
  public Product getProduct() {
    return product;
  }

  /**
   * Get the store where the product was purchased
   *
   * @return The store where the product was purchased
   */
  public Store getStore() {
    return store;
  }
}
