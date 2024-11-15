package com.comp301.a07pizza;

/**
 * This class represents a crust ingredient that can be used in a pizza. It is a subclass of
 * IngredientImpl.
 */
public class Crust extends IngredientImpl {
  /** Hand-tossed crust ingredient */
  public static final Crust HAND_TOSSED = new Crust("hand-tossed", true, true);

  /** Thin crust ingredient */
  public static final Crust THIN = new Crust("thin", true, true);

  /** Deep dish crust ingredient */
  public static final Crust DEEP_DISH = new Crust("deep dish", true, true);

  /**
   * Constructor for Crust class
   *
   * @param name The name of the crust
   * @param isVegetarian Whether the crust is vegetarian
   * @param isVegan Whether the crust is vegan
   */
  private Crust(String name, boolean isVegetarian, boolean isVegan) {
    super(name, isVegetarian, isVegan);
  }
}
