package com.comp301.a01sushi;

/**
 * This interface represents a plate of sushi. A plate of sushi has a name, a list of ingredients, a
 * number of calories, a cost, and whether it has rice, shellfish, and is vegetarian.
 */
public interface Sushi {
  /**
   * Getter method for the name of the sushi
   *
   * @return the name of the sushi as a String
   */
  String getName();

  /**
   * Getter method for the list of ingredients in the plate of sushi
   *
   * @return the list of ingredients in the plate of sushi
   */
  IngredientPortion[] getIngredients();

  /**
   * Getter method for the overall number of calories in the plate of sushi
   *
   * @return the number of calories in the plate of sushi, rounded to the nearest integer
   */
  int getCalories();

  /**
   * Getter method for the cost of the ingredients in the plate of sushi
   *
   * @return the cost of the ingredients in the plate of sushi, rounded to the nearest cent
   */
  double getCost();

  /**
   * Getter method which returns true if the plate of sushi has rice as an ingredient
   *
   * @return true if the sushi has rice as an ingredient; false otherwise
   */
  boolean getHasRice();

  /**
   * Getter method which returns true if the plate of sushi has shellfish as an ingredient
   *
   * @return true if the sushi has shellfish as an ingredient; false otherwise
   */
  boolean getHasShellfish();

  /**
   * Getter method which returns true if the plate of sushi is vegetarian
   *
   * @return true if all the ingredients in the sushi are vegetarian; false otherwise
   */
  boolean getIsVegetarian();
}
