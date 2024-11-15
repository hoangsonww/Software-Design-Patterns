package com.comp301.a02adventure;

/**
 * An Item object represents an item that can be collected by a player in the game. An Item object
 * has a name that can be used to identify the item.
 */
public class ItemImpl implements Item {

  // Field to store the name of the item
  private final String name;

  /**
   * Constructs a new Item object with the specified name.
   *
   * @param name the name of the item
   */
  public ItemImpl(String name) {
    if (name == null) {
      throw new IllegalArgumentException("Item's name cannot be null");
    }

    this.name = name;
  }

  /**
   * A method that returns the name of the item.
   *
   * @return the name of the item
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * A method that returns a string representation of the Item object.
   *
   * @return a string representation of the Item object
   */
  @Override
  public String toString() {
    return this.name;
  }

  /**
   * A method that returns true if the item is equal to another item, false otherwise. Two items are
   * considered equal if their names are equal.
   *
   * @param other the other item to compare
   * @return true if the item is equal to the other item, false otherwise
   */
  @Override
  public boolean equals(Object other) {
    boolean isEqual = false;

    // Check if the other object is null - if so, they are not equal
    if (other == null) {
      return false;
    }

    // Check if the other object is exactly the same object as the current one - if so, they are
    // equal
    if (this == other) {
      return true;
    }

    // Check if the other object is an instance of Item - if so, compare the names
    if (other instanceof Item) {
      Item otherItem = (Item) other;
      // If the names are equal, the items are equal
      isEqual = this.name.equals(otherItem.getName());
      return isEqual;
    }

    return isEqual;
  }
}
