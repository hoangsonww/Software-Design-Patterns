package com.comp301.a02adventure;

import java.util.List;

/**
 * An Inventory object represents a collection of items. An Inventory object can be used to store
 * items and transfer items between inventories.
 */
public interface Inventory {
  /**
   * Returns true if the Inventory is empty
   *
   * @return true if the Inventory is empty, false otherwise
   */
  boolean isEmpty();

  /**
   * Getter method for the number of Items currently stored in the inventory
   *
   * @return the number of Items currently stored in the inventory
   */
  int getNumItems();

  /**
   * Getter method which returns a cloned list of the Items in the Inventory
   *
   * @return a cloned list of the Items in the Inventory
   */
  List<Item> getItems();

  /**
   * Adds an Item to the Inventory
   *
   * @param item the Item to be added to the Inventory
   */
  void addItem(Item item);

  /**
   * Removes an Item from the Inventory
   *
   * @param item the Item to be removed from the Inventory
   */
  void removeItem(Item item);

  /** Clears the Inventory */
  void clear();

  /**
   * Removes the Items from an "other" Inventory, and adds them into "this" Inventory
   *
   * @param other the Inventory to transfer Items from
   */
  void transferFrom(Inventory other);
}
