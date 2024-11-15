package com.comp301.a01sushi;

/**
 * This interface represents an ingredient in a sushi restaurant. Ingredients have a name, cost,
 * calories, and whether they are vegetarian, rice, or shellfish.
 */
public interface Ingredient {
  /**
   * Getter method for the name of the ingredient
   *
   * @return the name of the ingredient as a String
   */
  String getName();

  /**
   * Getter method for the number of calories in one dollar's worth of the ingredient
   *
   * @return the number of calories per dollar's worth of the ingredient
   */
  double getCaloriesPerDollar();

  /**
   * Getter method for the number of calories in one ounce of the ingredient
   *
   * @return the number of calories per ounce of the ingredient
   */
  int getCaloriesPerOunce();

  /**
   * Getter method for the price of one ounce of the ingredient
   *
   * @return the price per ounce of the ingredient, in dollars
   */
  double getPricePerOunce();

  /**
   * Getter method which returns true if the ingredient is vegetarian
   *
   * @return true if the ingredient is vegetarian; false otherwise
   */
  boolean getIsVegetarian();

  /**
   * Getter method which returns true if the ingredient is rice
   *
   * @return true if the ingredient is rice; false otherwise
   */
  boolean getIsRice();

  /**
   * Getter method which returns true if the ingredient is shellfish
   *
   * @return true if the ingredient is shellfish; false otherwise
   */
  boolean getIsShellfish();

  /**
   * Determines whether the ingredient is the same as another ingredient
   *
   * @return If other is null, returns false; otherwise, compares the name, calories, price (within
   *     1 cent), vegetarian, rice, and shellfish properties of the two ingredients. If all of them
   *     are the same, returns true. If any are different, returns false.
   */
  boolean equals(Ingredient other);
}
