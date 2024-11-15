package com.comp301.a01sushi;

/**
 * This class represents a Shrimp ingredient. Shrimp is a type of IngredientGeneral with a name,
 * cost, calories, and whether it is vegetarian, rice, or shellfish.
 */
public class Shrimp extends IngredientGeneral {

  /**
   * This constructor initializes the Shrimp ingredient with its name, cost, calories, and whether
   * it is vegetarian, rice, or shellfish.
   */
  public Shrimp() {
    super("shrimp", 0.65, 32, false, false, true);
  }
}
