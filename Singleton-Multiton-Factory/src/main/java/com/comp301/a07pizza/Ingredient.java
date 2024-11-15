package com.comp301.a07pizza;

/** This interface represents an ingredient that can be used in a pizza */
public interface Ingredient {
  /**
   * Getter method to retrieve the name of the ingredient
   *
   * @return The name of the ingredient
   */
  String getName();

  /**
   * Returns true only if the ingredient is a vegetarian option
   *
   * @return Whether the ingredient is vegetarian
   */
  boolean isVegetarian();

  /**
   * Returns true only if the ingredient is a vegan option
   *
   * @return Whether the ingredient is vegan
   */
  boolean isVegan();
}
