package com.comp301.a07pizza;

/**
 * This class represents a cheese ingredient that can be used in a pizza. It is a subclass of
 * IngredientImpl.
 */
public class Cheese extends IngredientImpl {
  /** Mozzarella cheese ingredient */
  public static final Cheese MOZZARELLA = new Cheese("mozzarella", true, false);

  /** Cheddar cheese ingredient */
  public static final Cheese BLEND = new Cheese("blend", true, false);

  /** Vegan cheese ingredient */
  public static final Cheese VEGAN = new Cheese("vegan", true, true);

  /**
   * Constructor for Cheese class
   *
   * @param name The name of the cheese
   * @param isVegetarian Whether the cheese is vegetarian
   * @param isVegan Whether the cheese is vegan
   */
  private Cheese(String name, boolean isVegetarian, boolean isVegan) {
    super(name, isVegetarian, isVegan);
  }
}
