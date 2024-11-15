package com.comp301.a01sushi;

/**
 * This class represents a Tuna ingredient. Tuna is a type of IngredientGeneral with a name, cost,
 * calories, and whether it is vegetarian, rice, or shellfish.
 */
public class Tuna extends IngredientGeneral {

  /**
   * This constructor initializes the Tuna ingredient with its name, cost, calories, and whether it
   * is vegetarian, rice, or shellfish.
   */
  public Tuna() {
    super("tuna", 1.67, 42, false, false, false);
  }
}
