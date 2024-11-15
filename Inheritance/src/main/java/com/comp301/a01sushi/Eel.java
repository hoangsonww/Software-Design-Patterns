package com.comp301.a01sushi;

/**
 * This class represents an Eel ingredient. Eel is a type of IngredientGeneral with a name, cost,
 * calories, and whether it is vegetarian, rice, or shellfish.
 */
public class Eel extends IngredientGeneral {

  /**
   * This constructor initializes the Eel ingredient with its name, cost, calories, and whether it
   * is vegetarian, rice, or shellfish.
   */
  public Eel() {
    super("eel", 2.15, 82, false, false, false);
  }
}
