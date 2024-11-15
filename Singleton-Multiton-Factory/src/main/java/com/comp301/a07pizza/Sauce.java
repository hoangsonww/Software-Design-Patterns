package com.comp301.a07pizza;

/**
 * This class represents a sauce ingredient that can be used in a pizza. It is a subclass of
 * IngredientImpl.
 */
public class Sauce extends IngredientImpl {
  /** Tomato sauce ingredient */
  public static final Sauce TOMATO = new Sauce("tomato", true, true);

  /** Barbecue sauce ingredient */
  public static final Sauce BARBECUE = new Sauce("barbecue", true, true);

  /** Pesto sauce ingredient */
  public static final Sauce PESTO = new Sauce("pesto", true, true);

  /** Alfredo sauce ingredient */
  public static final Sauce ALFREDO = new Sauce("alfredo", true, false);

  /** Ranch sauce ingredient */
  public static final Sauce RANCH = new Sauce("ranch", true, false);

  /**
   * Constructor for Sauce class
   *
   * @param name The name of the sauce
   * @param isVegetarian Whether the sauce is vegetarian
   * @param isVegan Whether the sauce is vegan
   */
  private Sauce(String name, boolean isVegetarian, boolean isVegan) {
    super(name, isVegetarian, isVegan);
  }
}
