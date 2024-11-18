package com.comp301.a08shopping;

import com.comp301.a08shopping.events.*;
import com.comp301.a08shopping.exceptions.OutOfStockException;
import com.comp301.a08shopping.exceptions.ProductNotFoundException;

import java.util.*;

/** This class represents a store that sells products */
public class StoreImpl implements Store {
  /** The name of the store */
  private final String name;

  /** The list of observers that are subscribed to the store */
  private final List<StoreObserver> observers;

  /** The inventory of products in the store */
  private final Map<Product, Integer> inventory;

  /** The discounts on products in the store */
  private final Map<Product, Double> discounts;

  /**
   * Constructor for the StoreImpl
   *
   * @param name The name of the store
   */
  public StoreImpl(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("Store name cannot be null or empty");
    }

    this.name = name;
    this.observers = new ArrayList<>();
    this.inventory = new HashMap<>();
    this.discounts = new HashMap<>();
  }

  /**
   * Gets the store's name
   *
   * @return The store's name
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * Adds an observer to the store
   *
   * @param observer The observer to add
   */
  @Override
  public void addObserver(StoreObserver observer) {
    if (observer != null) {
      observers.add(observer);
    }
  }

  /**
   * Removes an observer from the store
   *
   * @param observer The observer to remove
   */
  @Override
  public void removeObserver(StoreObserver observer) {
    observers.remove(observer);
  }

  /**
   * Gets a list of the products that the store sells
   *
   * @return A list of the products that the store sells
   */
  @Override
  public List<Product> getProducts() {
    return new ArrayList<>(inventory.keySet());
  }

  /**
   * Creates a new product in the store
   *
   * @param name The name of the product
   * @param basePrice The base price of the product
   * @param inventoryCount The number of copies of the product in stock
   * @return The product that was created
   */
  @Override
  public Product createProduct(String name, double basePrice, int inventoryCount) {
    if (inventoryCount < 0) {
      throw new IllegalArgumentException("Inventory count cannot be negative");
    }

    // Create the product and add it to the inventory
    Product product = new ProductImpl(name, basePrice);
    inventory.put(product, inventoryCount);

    return product;
  }

  /**
   * Purchases a particular product from the store
   *
   * @param product The product to purchase
   * @return The receipt item representing the sale
   */
  @Override
  public ReceiptItem purchaseProduct(Product product) {
    // Validate the product
    validateProduct(product);

    // Check if the product is in stock
    int stock = inventory.getOrDefault(product, 0);
    if (stock <= 0) {
      throw new OutOfStockException("Product is out of stock");
    }

    // Purchase the product
    double salePrice = getSalePrice(product);
    inventory.put(product, stock - 1);

    // Notify observers
    if (stock == 1) {
      notifyObservers(new OutOfStockEvent(product, this));
    }
    notifyObservers(new PurchaseEvent(product, this));

    // Return the receipt item representing the sale
    return new ReceiptItemImpl(product.getName(), salePrice, name);
  }

  /**
   * Restocks a product in the store
   *
   * @param product The product to restock
   * @param numItems The number of items to restock
   */
  @Override
  public void restockProduct(Product product, int numItems) {
    // Check if the number of items is negative
    if (numItems < 0) {
      throw new IllegalArgumentException("Number of items to restock cannot be negative");
    }

    // Validate the product
    validateProduct(product);

    // Restock the product
    int currentStock = inventory.getOrDefault(product, 0);
    inventory.put(product, currentStock + numItems);

    // Notify observers
    if (currentStock == 0) {
      notifyObservers(new BackInStockEvent(product, this));
    }
  }

  /**
   * Starts a sale for a particular product
   *
   * @param product The product to put on sale
   * @param percentOff The percentage to take off the product's base price
   */
  @Override
  public void startSale(Product product, double percentOff) {
    // Check if the discount is between 0 and 1
    if (percentOff < 0 || percentOff > 1) {
      throw new IllegalArgumentException("Discount must be between 0 and 1");
    }

    // Validate the product
    validateProduct(product);

    // Start the sale
    discounts.put(product, percentOff);
    notifyObservers(new SaleStartEvent(product, this));
  }

  /**
   * Ends a sale for a particular product
   *
   * @param product The product to take off sale
   */
  @Override
  public void endSale(Product product) {
    // Validate the product
    validateProduct(product);

    // End the sale
    if (discounts.remove(product) != null) {
      notifyObservers(new SaleEndEvent(product, this));
    }
  }

  /**
   * Gets the number of copies in stock in the store's inventory for a particular product
   *
   * @param product The product to get the inventory for
   * @return The number of copies in stock
   */
  @Override
  public int getProductInventory(Product product) {
    // Validate the product
    validateProduct(product);

    // Return the inventory count for the product
    return inventory.getOrDefault(product, 0);
  }

  /**
   * Determines whether a particular product is in stock in the store
   *
   * @param product The product to check if in stock
   * @return True if the product is in stock, false if it is not
   */
  @Override
  public boolean getIsInStock(Product product) {
    return getProductInventory(product) > 0;
  }

  /**
   * Gets the store's sale price for a particular product
   *
   * @param product The product to get the sale price for
   * @return The sale price of the product
   */
  @Override
  public double getSalePrice(Product product) {
    // Validate the product
    validateProduct(product);

    // Calculate the sale price
    double basePrice = product.getBasePrice();
    double discount = discounts.getOrDefault(product, 0.0);
    double salePrice = basePrice * (1 - discount);

    // Return the sale price rounded to 2 decimal places
    return Math.round(salePrice * 100.0) / 100.0;
  }

  /**
   * Determines whether a particular product is on sale at the store
   *
   * @param product The product to check if on sale
   * @return True if the product is on sale, false if it is not
   */
  @Override
  public boolean getIsOnSale(Product product) {
    // Validate the product
    validateProduct(product);

    // Check if the product is on sale
    return discounts.containsKey(product);
  }

  /**
   * Notifies all observers of a store event
   *
   * @param event The event to notify observers of
   */
  private void notifyObservers(StoreEvent event) {
    // Notify all observers of the event
    for (StoreObserver observer : observers) {
      observer.update(event);
    }
  }

  /**
   * Helper method to validate a product. Checks if the product is null or not in the store
   *
   * @param product The product to validate
   */
  private void validateProduct(Product product) {
    if (product == null) {
      throw new IllegalArgumentException("Product cannot be null");
    }

    if (!inventory.containsKey(product)) {
      throw new ProductNotFoundException("Product not found in the store");
    }
  }
}
