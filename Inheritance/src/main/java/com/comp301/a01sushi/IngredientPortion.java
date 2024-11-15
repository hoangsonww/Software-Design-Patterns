package com.comp301.a01sushi;

/**
 * This interface represents an ingredient portion. An ingredient portion has an ingredient, an
 * amount (in ounces), and methods to get the name, amount, calories, cost, and whether the
 * ingredient is vegetarian, rice, or shellfish.
 */
public interface IngredientPortion {
  /**
   * Getter method for the underlying ingredient instance
   *
   * @return the underlying ingredient that this is a portion of
   */
  Ingredient getIngredient();

  /**
   * Getter method for the number of ounces of the underlying ingredient that this IngredientPortion
   * represents
   *
   * @return the weight, in ounces, of the underlying ingredient
   */
  double getAmount();

  /**
   * Getter method for the name of the ingredient
   *
   * @return the name of the underlying ingredient as a String
   */
  String getName();

  /**
   * Getter method for whether the ingredient is vegetarian
   *
   * @return true if the underlying ingredient is vegitarian; false otherwise
   */
  boolean getIsVegetarian();

  /**
   * Getter method which returns true if the ingredient is rice
   *
   * @return true if the underlying ingredient is rice; false otherwise
   */
  boolean getIsRice();

  /**
   * Getter method which returns true if the ingredient is shellfish
   *
   * @return true if the underlying ingredient is shellfish; false otherwise
   */
  boolean getIsShellfish();

  /**
   * Getter method for the number of calories in the portion
   *
   * @return the unrounded number of calories in the portion
   */
  double getCalories();

  /**
   * Getter method for the price of the portion
   *
   * @return the unrounded price of the portion
   */
  double getCost();

  /**
   * Combines the ingredient portion with another portion of the same ingredient, creating a
   * combined portion of the ingredient.
   *
   * @return If other is null, returns this ingredient portion. If the other ingredient portion is
   *     not the same as this ingredient portion, throws an IllegalArgumentException. Otherwise,
   *     returns a new ingredient portion, representing the combined amounts of this ingredient
   *     portion and the other ingredient portion. HINT: Use the equals() method to test equality.
   */
  IngredientPortion combine(IngredientPortion other);
}
