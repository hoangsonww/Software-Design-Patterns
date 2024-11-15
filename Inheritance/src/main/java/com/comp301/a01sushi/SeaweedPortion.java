package com.comp301.a01sushi;

/**
 * This class represents a Seaweed ingredient portion. Seaweed is a type of IngredientPortionGeneral
 * with a name, cost, calories, and whether it is vegetarian, rice, or shellfish, etc.
 */
public class SeaweedPortion extends IngredientPortionGeneral {

  /**
   * This constructor initializes the Seaweed ingredient portion with its amount.
   *
   * @param amount The amount of Seaweed in ounces
   */
  public SeaweedPortion(double amount) {
    super(new Seaweed(), amount);
  }

  /**
   * This method combines two Seaweed ingredient portions into one.
   *
   * @param other The other Seaweed ingredient portion to be combined
   * @return The combined Seaweed ingredient portion
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

    return new SeaweedPortion(newAmount);
  }
}
