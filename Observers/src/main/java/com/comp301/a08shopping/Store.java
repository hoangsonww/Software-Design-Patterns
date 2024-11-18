package com.comp301.a08shopping;

import java.util.List;

/** This interface represents a store that sells products */
public interface Store {
  /**
   * Gets the name of the store
   *
   * @return The name of the store
   */
  String getName();

  /**
   * Adds a new observer to the store
   *
   * @param observer The observer to add
   */
  void addObserver(StoreObserver observer);

  /**
   * Removes an observer from the store
   *
   * @param observer The observer to remove
   */
  void removeObserver(StoreObserver observer);

  /**
   * Gets a list of the products that the store sells
   *
   * @return A list of the products that the store sells
   */
  List<Product> getProducts();

  /**
   * Creates a new product in the store. Throws an IllegalArgumentException for invalid values of
   * name, basePrice, and inventory
   *
   * @param name The name of the product
   * @param basePrice The base price of the product
   * @param inventory The number of copies of the product in stock
   * @return The product that was created
   */
  Product createProduct(String name, double basePrice, int inventory);

  /**
   * Updates a product's inventory to reflect that one copy of the product was purchased (i.e.
   * decrements the product's inventory integer value). Emits the appropriate StoreEvent or
   * StoreEvents that describe the action. Throws a ProductNotFoundException if the specified
   * product is not sold by the store, an IllegalArgumentException if the product is null, or an
   * OutOfStockException if the product is out of stock. Returns a ReceiptItem object representing
   * the sale
   *
   * @param product The product to purchase
   * @return The receipt item representing the sale
   */
  ReceiptItem purchaseProduct(Product product);

  /**
   * Adds the specified number to the store's inventory for a particular product. Emits the
   * appropriate StoreEvent if the product was previously out of stock. Throws a
   * ProductNotFoundException if the specified product is not sold by the store, an
   * IllegalArgumentException if the product is null, or an IllegalArgumentException if numItems is
   * negative
   *
   * @param product The product to restock
   * @param numItems The number of items to restock
   */
  void restockProduct(Product product, int numItems);

  /**
   * Starts a sale for a particular product by updating or setting the product's percentOff value
   * and emitting the appropriate StoreEvent. Throws a ProductNotFoundException if the specified
   * product is not sold by the store, an IllegalArgumentException if the product is null, or a
   * IllegalArgumentException if percentOff is not between 0.0 and 1.0
   *
   * @param product The product to put on sale
   * @param percentOff The percentage to take off the product's base price
   */
  void startSale(Product product, double percentOff);

  /**
   * Ends a sale for a particular product by removing or resetting the product's percentOff value.
   * Emits the appropriate StoreEvent. Throws a ProductNotFoundException if the specified product is
   * not sold by the store, or an IllegalArgumentException if the product is null
   *
   * @param product The product to take off sale
   */
  void endSale(Product product);

  /**
   * Gets the number of copies in stock in the store's inventory for a particular product. Throws a
   * ProductNotFoundException if the product is not sold by the store, or an
   * IllegalArgumentException if the product is null
   *
   * @param product The product to get the inventory for
   * @return The number of copies in stock
   */
  int getProductInventory(Product product);

  /**
   * Determines whether a particular product is in stock in the store. Returns true if the product
   * is in stock, or false if it is not. Throws a ProductNotFoundException if the product is not
   * sold by the store, or an IllegalArgumentException if the product is null
   *
   * @param product The product to check if in stock
   * @return True if the product is in stock, false if it is not
   */
  boolean getIsInStock(Product product);

  /**
   * Gets the store's sale price for a particular product in dollars, rounded to the nearest cent.
   * The sale price for a product is equal to the product's base price x (1.0 - percentOff), where
   * percentOff is the sale amount specified by startSale() for the product. Make sure to round the
   * resulting value to the nearest cent. Throws a ProductNotFoundException if the product is not
   * sold by the store, or an IllegalArgumentException if the product is null
   *
   * @param product The product to get the sale price for
   * @return The sale price of the product
   */
  double getSalePrice(Product product);

  /**
   * Determines whether a particular product is on sale at the store. Returns true if the product is
   * on sale, or false if it is not. A product is on sale if its sale price is less than its base
   * price. Throws a ProductNotFoundException if the product is not sold by the store, or an
   * IllegalArgumentException if the product is null
   *
   * @param product The product to check if on sale
   * @return True if the product is on sale, false if it is not
   */
  boolean getIsOnSale(Product product);
}
