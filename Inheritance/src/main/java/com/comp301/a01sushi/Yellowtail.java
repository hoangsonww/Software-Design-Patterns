package com.comp301.a01sushi;

/**
 * This class represents a Yellowtail ingredient. Yellowtail is a type of IngredientGeneral with a
 * name, cost, calories, and whether it is vegetarian, rice, or shellfish.
 */
public class Yellowtail extends IngredientGeneral {

  /**
   * This constructor initializes the Yellowtail ingredient with its name, cost, calories, and
   * whether it is vegetarian, rice, or shellfish.
   */
  public Yellowtail() {
    super("yellowtail", 0.74, 57, false, false, false);
  }
}
