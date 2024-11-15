package com.comp301.a01sushi;

/**
 * This class represents a Crab ingredient portion. Crab is a type of IngredientPortionGeneral with
 * a name, cost, calories, and whether it is vegetarian, rice, or shellfish, etc.
 */
public class CrabPortion extends IngredientPortionGeneral {

  /**
   * This constructor initializes the Crab ingredient portion with its amount.
   *
   * @param amount The amount of Crab in ounces
   */
  public CrabPortion(double amount) {
    super(new Crab(), amount);
  }

  /**
   * This method combines two Crab ingredient portions into one.
   *
   * @param other The other Crab ingredient portion to be combined
   * @return The combined Crab ingredient portion
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

    return new CrabPortion(newAmount);
  }
}
