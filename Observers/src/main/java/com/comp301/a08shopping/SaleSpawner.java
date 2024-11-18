/*
 * No need to make changes to this file for a08-shopping. This file handles randomly starting and
 * ending sales in the different stores
 */

package com.comp301.a08shopping;

import java.util.List;

/** This class randomly toggles sales and purchases products in the stores */
public class SaleSpawner implements Runnable {
  /** The list of stores to randomly toggle sales and purchase products from */
  private final List<Store> stores;

  /**
   * Constructor for the SaleSpawner
   *
   * @param stores The list of stores to randomly toggle sales and purchase products from
   */
  public SaleSpawner(List<Store> stores) {
    this.stores = stores;
  }

  /**
   * A helper method that waits for a random amount of time between 5 and 20 seconds
   *
   * @throws InterruptedException if the thread is interrupted
   */
  private static void waitRandomAmountOfTime() throws InterruptedException {
    int ms = 5000 + (int) (Math.random() * 15000); // waits for 5-to-20 seconds
    Thread.sleep(ms);
  }

  /**
   * The main method that runs the SaleSpawner. This method will randomly pick a store, a product in
   * the store, and an action (purchase/restock or toggle sale) to perform
   */
  @Override
  public void run() {
    while (true) {
      // Wait a random amount of time
      try {
        waitRandomAmountOfTime();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        return;
      }

      // Pick a random store
      Store store = pickRandomStore();

      // Pick a random product in the store
      Product product = pickRandomProduct(store);

      // Pick an action at random (toggle sale state or purchase a product)
      String randomAction = pickRandomAction();
      switch (randomAction) {
        case "PURCHASE/RESTOCK":
          if (store.getIsInStock(product)) {
            store.purchaseProduct(product);
          } else {
            store.restockProduct(product, (int) Math.round(Math.random() * 5));
          }
          break;
        case "TOGGLE SALE":
          if (store.getIsOnSale(product)) {
            store.endSale(product);
          } else {
            store.startSale(product, Math.random());
          }
          break;
      }
    }
  }

  /**
   * Picks a random store from the list of stores
   *
   * @return The randomly picked store
   */
  private Store pickRandomStore() {
    int randomStoreIndex = (int) (Math.random() * stores.size());
    return stores.get(randomStoreIndex);
  }

  /**
   * Picks a random product from the store
   *
   * @param store The store to pick a random product from
   * @return The randomly picked product
   */
  private Product pickRandomProduct(Store store) {
    List<Product> products = store.getProducts();
    int randomProductIndex = (int) (Math.random() * products.size());
    return products.get(randomProductIndex);
  }

  /**
   * Picks an action at random (50% probability between purchase/restock or toggle sale)
   *
   * @return The randomly picked action
   */
  private String pickRandomAction() {
    double action = Math.random();
    if (action > 0.5) {
      return "PURCHASE/RESTOCK";
    } else {
      return "TOGGLE SALE";
    }
  }
}
