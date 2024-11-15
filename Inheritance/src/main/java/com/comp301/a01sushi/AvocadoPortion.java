package com.comp301.a01sushi;

/**
 * This class represents an Avocado ingredient portion. Avocado is a type of
 * IngredientPortionGeneral with a name, cost, calories, and whether it is vegetarian, rice, or
 * shellfish, etc.
 */
public class AvocadoPortion extends IngredientPortionGeneral {

  /**
   * This constructor initializes the Avocado ingredient portion with its amount.
   *
   * @param amount The amount of Avocado in ounces
   */
  public AvocadoPortion(double amount) {
    super(new Avocado(), amount);
  }

  /**
   * This method combines two Avocado ingredient portions into one.
   *
   * @param other The other Avocado ingredient portion to be combined
   * @return The combined Avocado ingredient portion
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

    return new AvocadoPortion(newAmount);
  }
}
