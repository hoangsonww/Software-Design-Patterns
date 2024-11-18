package com.comp301.a08shopping.events;

import com.comp301.a08shopping.Product;
import com.comp301.a08shopping.Store;

/**
 * This interface represents an event that occurs at a store. This interface is implemented by
 * events that are fired when a product is out of stock or when a product is purchased.
 */
public interface StoreEvent {
  /**
   * Get the product that is involved with this event
   *
   * @return The product that is involved with this event
   */
  Product getProduct();

  /**
   * Get the store where this event occurred
   *
   * @return The store where this event occurred
   */
  Store getStore();
}
