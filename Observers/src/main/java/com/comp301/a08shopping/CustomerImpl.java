package com.comp301.a08shopping;

import com.comp301.a08shopping.events.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a customer that can purchase products from a store. A customer has a name
 * and a budget. A customer can purchase products from a store and receive a receipt item for each
 * purchase. A customer is also a StoreObserver and will be notified when a product is out of stock
 * or when a product is purchased.
 */
public class CustomerImpl implements Customer {
  /** The name of the customer */
  private final String name;

  /** The amount of money that the customer currently has (in dollars) */
  private double budget;

  /** The purchase history of the customer */
  private final List<ReceiptItem> purchaseHistory;

  /**
   * Constructor for the CustomerImpl
   *
   * @param name The name of the customer
   * @param budget The amount of money that the customer currently has (in dollars)
   */
  public CustomerImpl(String name, double budget) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("Customer name cannot be null or empty");
    }

    if (budget <= 0) {
      throw new IllegalArgumentException("Budget must be greater than zero");
    }

    // Initialize the customer fields
    this.name = name;
    // Round to 2 decimal places
    this.budget = Math.round(budget * 100.0) / 100.0;
    this.purchaseHistory = new ArrayList<>();
  }

  /**
   * Gets the customer's name
   *
   * @return The customer's name
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * Gets the amount of money that the customer currently has (in dollars)
   *
   * @return The amount of money that the customer currently has
   */
  @Override
  public double getBudget() {
    return budget;
  }

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
  @Override
  public void purchaseProduct(Product product, Store store) {
    // Check if the product and store are null
    if (product == null || store == null) {
      throw new IllegalArgumentException("Product and Store cannot be null");
    }

    // Check if the product is in stock and get the sale price
    double salePrice = store.getSalePrice(product);

    // Check if the customer has enough budget to purchase the product. If not, throw an exception
    if (salePrice > budget) {
      throw new IllegalStateException("Insufficient budget to purchase product");
    }

    // Deduct the budget and purchase the product
    budget -= salePrice;
    ReceiptItem receipt = store.purchaseProduct(product);

    // Add the receipt to purchase history
    purchaseHistory.add(receipt);
  }

  /**
   * Gets a list of the products that the customer has purchased (Note: The returned value should be
   * a copy of the encapsulated field)
   *
   * @return A list of the products that the customer has purchased
   */
  @Override
  public List<ReceiptItem> getPurchaseHistory() {
    // Return a copy of the purchase history to avoid direct access and modification of the list
    return new ArrayList<>(purchaseHistory);
  }

  /**
   * Updates the customer when a product is out of stock or when a product is purchased
   *
   * @param event The event that occurred
   */
  @Override
  public void update(StoreEvent event) {
    // Check the type of event and print the appropriate message
    if (event instanceof BackInStockEvent) {
      System.out.println(
          event.getProduct().getName() + " is back in stock at " + event.getStore().getName());
    } else if (event instanceof OutOfStockEvent) {
      System.out.println(
          event.getProduct().getName() + " is now out of stock at " + event.getStore().getName());
    } else if (event instanceof PurchaseEvent) {
      System.out.println(
          "Someone purchased "
              + event.getProduct().getName()
              + " at "
              + event.getStore().getName());
    } else if (event instanceof SaleEndEvent) {
      System.out.println(
          "The sale for "
              + event.getProduct().getName()
              + " at "
              + event.getStore().getName()
              + " has ended");
    } else if (event instanceof SaleStartEvent) {
      System.out.println(
          "New sale for "
              + event.getProduct().getName()
              + " at "
              + event.getStore().getName()
              + "!");
    }
  }
}
