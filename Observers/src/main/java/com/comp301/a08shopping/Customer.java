package com.comp301.a08shopping;

import java.util.List;

/**
 * This interface represents a customer that can purchase products from a store. The customer has a
 * name, a budget, and a purchase history. The customer can purchase products from a store and
 * receive a receipt item for each purchase. The customer is also a StoreObserver and will be
 * notified when a product is out of stock or when a product is purchased.
 */
public interface Customer extends StoreObserver {
  /**
   * Gets the customer's name
   *
   * @return The customer's name
   */
  String getName();

  /**
   * Gets the amount of money that the customer currently has (in dollars)
   *
   * @return The amount of money that the customer currently has
   */
  double getBudget();

  /**
   * Purchases a particular product from a store by performing the following actions, in order:
   *
   * <p>1. If the sale price of the product costs more money then the customer has, throw an
   * IllegalStateException exception
   *
   * <p>2. Decrease the customer's money by the sale price of the product
   *
   * <p>3. Purchase the object from the store by calling store.purchaseProduct()
   *
   * <p>4. Add the returned ReceiptItem from the store to the customer's purchase history
   *
   * @param product The product to purchase
   * @param store The store from which to purchase the product
   */
  void purchaseProduct(Product product, Store store);

  /**
   * Gets a list of the products that the customer has purchased (Note: The returned value should be
   * a copy of the encapsulated field)
   *
   * @return A list of the products that the customer has purchased
   */
  List<ReceiptItem> getPurchaseHistory();
}
