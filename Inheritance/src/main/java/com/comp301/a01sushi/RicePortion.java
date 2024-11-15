package com.comp301.a01sushi;

/**
 * This class represents a Rice ingredient portion. Rice is a type of IngredientPortionGeneral with
 * a name, cost, calories, and whether it is vegetarian, rice, or shellfish, etc.
 */
public class RicePortion extends IngredientPortionGeneral {

  /**
   * This constructor initializes the Rice ingredient portion with its amount.
   *
   * @param amount The amount of Rice in ounces
   */
  public RicePortion(double amount) {
    super(new Rice(), amount);
  }

  /**
   * This method combines two Rice ingredient portions into one.
   *
   * @param other The other Rice ingredient portion to be combined
   * @return The combined Rice ingredient portion
   */
  @Override
  public IngredientPortion combine(IngredientPortion other) {
    if (other == null) {
      return this;
    }

    boolean isSameIngredient = this.getIngredient().equals(other.getIngredient());

    if (!isSameIngredient) {
      throw new IllegalArgumentException("Cannot combine ingredients of different types");
    }

    double newAmount = this.getAmount() + other.getAmount();

    return new RicePortion(newAmount);
  }
}
