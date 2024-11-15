package com.comp301.a01sushi;

/**
 * This class represents an ingredient portion. An ingredient portion is a specific amount of an
 * ingredient. Ingredient portions are used to represent the ingredients in a sushi roll.
 */
public abstract class IngredientPortionGeneral implements IngredientPortion {
  private Ingredient ingredient;
  private double amount;

  /**
   * This constructor initializes the ingredient portion with its ingredient and amount.
   *
   * @param ingredient The ingredient of the portion
   * @param amount The amount of the ingredient in ounces
   */
  public IngredientPortionGeneral(Ingredient ingredient, double amount) {
    if (ingredient == null) {
      throw new IllegalArgumentException("Ingredient cannot be null");
    }

    if (amount < 0) {
      throw new IllegalArgumentException("Amount cannot be negative");
    }

    this.ingredient = ingredient;
    this.amount = amount;
  }

  /**
   * This method returns the ingredient of the portion.
   *
   * @return The ingredient of the portion
   */
  @Override
  public Ingredient getIngredient() {
    return this.ingredient;
  }

  /**
   * This method returns the amount of the ingredient portion.
   *
   * @return The amount of the ingredient in the portion
   */
  @Override
  public double getAmount() {
    return this.amount;
  }

  /**
   * This method returns the name of the ingredient portion.
   *
   * @return The name of the ingredient portion
   */
  @Override
  public String getName() {
    return this.ingredient.getName();
  }

  /**
   * This method returns whether the ingredient portion is vegetarian.
   *
   * @return Whether the ingredient portion is vegetarian
   */
  @Override
  public boolean getIsVegetarian() {
    return this.ingredient.getIsVegetarian();
  }

  /**
   * This method returns whether the ingredient portion is rice.
   *
   * @return Whether the ingredient portion is rice
   */
  @Override
  public boolean getIsRice() {
    return this.ingredient.getIsRice();
  }

  /**
   * This method returns whether the ingredient portion is shellfish.
   *
   * @return Whether the ingredient portion is shellfish
   */
  @Override
  public boolean getIsShellfish() {
    return this.ingredient.getIsShellfish();
  }

  /**
   * This method returns the number of calories in the ingredient portion.
   *
   * @return The number of calories in the ingredient portion
   */
  @Override
  public double getCalories() {
    return this.ingredient.getCaloriesPerOunce() * amount;
  }

  /**
   * This method returns the cost of the ingredient portion.
   *
   * @return The cost of the ingredient portion
   */
  @Override
  public double getCost() {
    return this.ingredient.getPricePerOunce() * amount;
  }
}
