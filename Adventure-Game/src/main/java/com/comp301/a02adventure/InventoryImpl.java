package com.comp301.a02adventure;

import java.util.List;
import java.util.ArrayList;

/**
 * An Inventory object represents a collection of items. An Inventory object can be used to store
 * items and transfer items between inventories.
 */
public class InventoryImpl implements Inventory {

  // Field to store the items in the inventory
  private List<Item> items;

  /** Constructs a new Inventory object with an empty list of items. */
  public InventoryImpl() {
    // Using ArrayList because it is a common implementation of the List interface
    // and allows for dynamic resizing of the list
    this.items = new ArrayList<>();
  }

  /**
   * A method that returns true if the inventory is empty, false otherwise.
   *
   * @return true if the inventory is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    return this.items.isEmpty();
  }

  /**
   * A method that returns the number of items in the inventory.
   *
   * @return the number of items in the inventory
   */
  @Override
  public int getNumItems() {
    return this.items.size();
  }

  /**
   * A method that returns a list of items in the inventory. The list returned is a copy of the list
   * of items in the inventory.
   *
   * @return a list of items in the inventory
   */
  @Override
  public List<Item> getItems() {
    // Cloning the list of items to prevent direct modification of the inventory
    List<Item> clonedItems = new ArrayList<>();

    // Loop to clone each item in the inventory to the new list
    for (int i = 0; i < this.items.size(); i++) {
      Item currentItem = this.items.get(i);
      clonedItems.add(currentItem);
    }

    return clonedItems;
  }

  /**
   * A method that adds an item to the inventory.
   *
   * @param item the item to be added to the inventory
   */
  @Override
  public void addItem(Item item) {
    if (item == null) {
      throw new IllegalArgumentException("Item to be added must not be null");
    }

    this.items.add(item);
  }

  /**
   * A method that removes an item from the inventory.
   *
   * @param item the item to be removed from the inventory
   */
  @Override
  public void removeItem(Item item) {
    // Check if the item to be removed is null - only remove if it is not
    if (item == null) {
      throw new IllegalArgumentException("Item to be removed must not be null");
    }

    // Check if the item to be removed is in the inventory - only remove if it is
    if (!this.items.contains(item)) {
      throw new IllegalArgumentException("Item to be removed is not in the inventory");
    }

    this.items.remove(item);
  }

  /** A method that clears the inventory of all items. */
  @Override
  public void clear() {
    this.items.clear();
  }

  /**
   * A method that transfers all items from another inventory to this inventory.
   *
   * @param other the inventory to transfer items from
   */
  @Override
  public void transferFrom(Inventory other) {
    if (other == null) {
      throw new IllegalArgumentException("Inventory to transfer from must not be null");
    }

    List<Item> otherItems = other.getItems();

    // Loop to transfer each item from the other inventory to this inventory
    for (int i = 0; i < otherItems.size(); i++) {
      Item currentItem = otherItems.get(i);
      this.items.add(currentItem);
    }

    other.clear();
  }
}
