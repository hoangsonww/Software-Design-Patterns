package com.comp301.a07pizza;

/** This interface represents a pizza that can be ordered from a pizza restaurant */
public interface Pizza {

  /**
   * Returns true if the pizza consists entirely of vegetarian ingredients
   *
   * @return Whether the pizza is vegetarian
   */
  boolean isVegetarian();

  /**
   * Returns true if the pizza consists entirely of vegan ingredients
   *
   * @return Whether the pizza is vegan
   */
  boolean isVegan();

  /**
   * Getter method to get the price of the pizza
   *
   * @return The price of the pizza
   */
  double getPrice();

  /**
   * Getter method to get the size of the pizza
   *
   * @return The size of the pizza
   */
  Size getSize();

  /**
   * Getter method to get the type of sauce in the pizza
   *
   * @return The type of sauce in the pizza
   */
  Ingredient getSauce();

  /**
   * Getter method to get the type of cheese in the pizza
   *
   * @return The type of cheese in the pizza
   */
  Ingredient getCheese();

  /**
   * Getter method to get the type of crust in the pizza
   *
   * @return The type of crust in the pizza
   */
  Ingredient getCrust();

  /**
   * Getter method to get the toppings in the pizza
   *
   * @return The toppings in the pizza
   */
  Ingredient[] getToppings();

  /**
   * Getter method for all the ingredients in the pizza including toppings, cheese, crust, and sauce
   *
   * @return All the ingredients in the pizza
   */
  Ingredient[] getIngredients();

  /** This enum represents the size of the pizza */
  enum Size {
    /** Small size pizza */
    SMALL,
    /** Medium size pizza */
    MEDIUM,
    /** Large size pizza */
    LARGE
  }
}
