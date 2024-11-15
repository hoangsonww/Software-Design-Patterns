package com.comp301.a01sushi;

/**
 * This class represents a Tuna ingredient portion. Tuna is a type of IngredientPortionGeneral with
 * a name, cost, calories, and whether it is vegetarian, rice, or shellfish, etc.
 */
public class TunaPortion extends IngredientPortionGeneral {

  /**
   * This constructor initializes the Tuna ingredient portion with its amount.
   *
   * @param amount The amount of Tuna in ounces
   */
  public TunaPortion(double amount) {
    super(new Tuna(), amount);
  }

  /**
   * This method combines two Tuna ingredient portions into one.
   *
   * @param other The other Tuna ingredient portion to be combined
   * @return The combined Tuna ingredient portion
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

    return new TunaPortion(newAmount);
  }
}
