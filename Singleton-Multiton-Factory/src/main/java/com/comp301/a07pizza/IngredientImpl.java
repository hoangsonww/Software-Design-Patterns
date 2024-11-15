package com.comp301.a07pizza;

/**
 * This class represents an ingredient that can be used in a pizza. It is a superclass of Crust,
 * Sauce, and Cheese.
 */
public class IngredientImpl implements Ingredient {
  /** The name of the ingredient */
  private final String name;

  /** Whether the ingredient is vegetarian */
  private final boolean isVegetarian;

  /** Whether the ingredient is vegan */
  private final boolean isVegan;

  /**
   * Constructor for IngredientImpl class
   *
   * @param name The name of the ingredient
   * @param isVegetarian Whether the ingredient is vegetarian
   * @param isVegan Whether the ingredient is vegan
   */
  public IngredientImpl(String name, boolean isVegetarian, boolean isVegan) {
    this.name = name;
    this.isVegetarian = isVegetarian;
    this.isVegan = isVegan;
  }

  /**
   * Getter method to retrieve the name of the ingredient
   *
   * @return The name of the ingredient
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * Returns true only if the ingredient is a vegetarian option
   *
   * @return Whether the ingredient is vegetarian
   */
  @Override
  public boolean isVegetarian() {
    return isVegetarian;
  }

  /**
   * Returns true only if the ingredient is a vegan option
   *
   * @return Whether the ingredient is vegan
   */
  @Override
  public boolean isVegan() {
    return isVegan;
  }
}
