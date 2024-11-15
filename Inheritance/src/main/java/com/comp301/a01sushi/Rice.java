package com.comp301.a01sushi;

/**
 * This class represents a Rice ingredient. Rice is a type of IngredientGeneral with a name, cost,
 * calories, and whether it is vegetarian, rice, or shellfish.
 */
public class Rice extends IngredientGeneral {

  /**
   * This constructor initializes the Rice ingredient with its name, cost, calories, and whether it
   * is vegetarian, rice, or shellfish.
   */
  public Rice() {
    super("rice", 0.13, 34, true, true, false);
  }
}
