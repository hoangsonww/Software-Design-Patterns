package com.comp301.a01sushi;

/**
 * This class represents a Seaweed ingredient. Seaweed is a type of IngredientGeneral with a name,
 * cost, calories, and whether it is vegetarian, rice, or shellfish.
 */
public class Seaweed extends IngredientGeneral {

  /**
   * This constructor initializes the Seaweed ingredient with its name, cost, calories, and whether
   * it is vegetarian, rice, or shellfish.
   */
  public Seaweed() {
    super("seaweed", 2.85, 105, true, false, false);
  }
}
