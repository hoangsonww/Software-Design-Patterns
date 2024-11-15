package com.comp301.a01sushi;

/**
 * This class represents a Shrimp ingredient portion. Shrimp is a type of IngredientPortionGeneral
 * with a name, cost, calories, and whether it is vegetarian, rice, or shellfish.
 */
public class ShrimpPortion extends IngredientPortionGeneral {

  /**
   * This constructor initializes the Shrimp ingredient portion with its amount.
   *
   * @param amount The amount of Shrimp in the portion
   */
  public ShrimpPortion(double amount) {
    super(new Shrimp(), amount);
  }

  /**
   * This method combines two Shrimp ingredient portions into one portion.
   *
   * @param other The other Shrimp ingredient portion to be combined
   * @return The combined Shrimp ingredient portion
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

    return new ShrimpPortion(newAmount);
  }
}
