package com.comp301.a01sushi;

/**
 * This class represents an Avocado ingredient. Avocado is a type of IngredientGeneral with a name,
 * cost, calories, and whether it is vegetarian, rice, or shellfish.
 */
public class Avocado extends IngredientGeneral {

  /**
   * This constructor initializes the Avocado ingredient with its name, cost, calories, and whether
   * it is vegetarian, rice, or shellfish.
   */
  public Avocado() {
    super("avocado", 0.24, 42, true, false, false);
  }
}
