package com.comp301.a01sushi;

/**
 * This class represents a Crab ingredient. Crab is a type of IngredientGeneral with a name, cost,
 * calories, and whether it is vegetarian, rice, or shellfish.
 */
public class Crab extends IngredientGeneral {

  /**
   * This constructor initializes the Crab ingredient with its name, cost, calories, and whether it
   * is vegetarian, rice, or shellfish.
   */
  public Crab() {
    super("crab", 0.72, 37, false, false, true);
  }
}
