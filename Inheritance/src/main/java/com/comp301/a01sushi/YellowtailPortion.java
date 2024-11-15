package com.comp301.a01sushi;

/**
 * This class represents a Yellowtail ingredient portion. Yellowtail is a type of
 * IngredientPortionGeneral with a name, cost, calories, and whether it is vegetarian, rice, or
 * shellfish, etc.
 */
public class YellowtailPortion extends IngredientPortionGeneral {

  /** This constructor initializes the Yellowtail ingredient portion with its amount. */
  public YellowtailPortion(double amount) {
    super(new Yellowtail(), amount);
  }

  /**
   * This method combines two Yellowtail ingredient portions into one portion.
   *
   * @param other The other Yellowtail ingredient portion to be combined
   * @return The combined Yellowtail ingredient portion
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

    return new YellowtailPortion(newAmount);
  }
}
