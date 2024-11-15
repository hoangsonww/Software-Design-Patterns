package com.comp301.a01sushi;

/**
 * This class represents an Eel ingredient portion. Eel is a type of IngredientPortionGeneral with a
 * name, cost, calories, and whether it is vegetarian, rice, or shellfish, etc.
 */
public class EelPortion extends IngredientPortionGeneral {

  /**
   * This constructor initializes the Eel ingredient portion with its amount.
   *
   * @param amount The amount of Eel in ounces
   */
  public EelPortion(double amount) {
    super(new Eel(), amount);
  }

  /**
   * This method combines two Eel ingredient portions into one.
   *
   * @param other The other Eel ingredient portion to be combined
   * @return The combined Eel ingredient portion
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

    return new EelPortion(newAmount);
  }
}
