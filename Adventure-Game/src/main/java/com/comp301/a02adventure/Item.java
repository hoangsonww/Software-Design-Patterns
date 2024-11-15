package com.comp301.a02adventure;

/**
 * The Item interface represents an item that can be picked up and stored in a player's inventory.
 */
public interface Item {
  /**
   * Getter method to retrieve the name of the Item
   *
   * @return the name of the Item
   */
  String getName();

  /**
   * Every class in Java is a descendant of a built-in superclass, called "Object". The Object
   * superclass defines a few useful methods for every Java object, like equals() and toString().
   * Since Object is the superclass to every class, that means every Java object has these methods.
   * Programmers can override them, if necessary, to supply a subclass-specific version of the
   * method. Every Item class should override both equals() and toString().
   *
   * <p>The equals() method tests to see if the "this" object is the same as the "other" object,
   * returning true if they are the same, or false if they are not. For this method, assume two
   * Items are the same if they have the same "name" String.
   *
   * @param other the other item to compare
   * @return true if the item is equal to the other item, false otherwise
   */
  @Override
  boolean equals(Object other);

  /**
   * Every class in Java is a descendant of a built-in superclass, called "Object". The Object
   * superclass defines a few useful methods for every Java object, like equals() and toString().
   * Since Object is the superclass to every class, that means every Java object has these methods.
   * Programmers can override them, if necessary, to supply a subclass-specific version of the
   * method. Every Item class should override both equals() and toString().
   *
   * <p>The toString() method generates a human-readable, String representation of the object,
   * suitable for printing to the console either for debugging or for the eventual user to read. For
   * this method, assume the "string representation" of an Item is simply the item's name String.
   *
   * @return a string representation of the Item object
   */
  @Override
  String toString();
}
