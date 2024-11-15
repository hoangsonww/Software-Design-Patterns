package com.comp301.a07pizza;

/**
 * This class represents a topping ingredient that can be used in a pizza. It is a subclass of
 * IngredientImpl.
 */
public class Topping extends IngredientImpl {
  /** Tomato topping ingredient */
  public static final Topping TOMATO = new Topping("tomato", true, true);

  /** Garlic topping ingredient */
  public static final Topping GARLIC = new Topping("garlic", true, true);

  /** Mushrooms topping ingredient */
  public static final Topping MUSHROOMS = new Topping("mushrooms", true, true);

  /** Pineapple topping ingredient */
  public static final Topping PINEAPPLE = new Topping("pineapple", true, true);

  /** Olives topping ingredient */
  public static final Topping OLIVES = new Topping("olives", true, true);

  /** Green pepper topping ingredient */
  public static final Topping GREEN_PEPPER = new Topping("green pepper", true, true);

  /** Spinach topping ingredient */
  public static final Topping SPINACH = new Topping("spinach", true, true);

  /** Onion topping ingredient */
  public static final Topping ONION = new Topping("onion", true, true);

  /** Jalapeno topping ingredient */
  public static final Topping JALAPENO = new Topping("jalapeno", true, true);

  /** Sun dried tomato topping ingredient */
  public static final Topping SUN_DRIED_TOMATO = new Topping("sun-dried tomato", true, true);

  /** Pepperoni topping ingredient */
  public static final Topping PEPPERONI = new Topping("pepperoni", false, false);

  /** Ground beef topping ingredient */
  public static final Topping GROUND_BEEF = new Topping("ground beef", false, false);

  /** Sausage topping ingredient */
  public static final Topping SAUSAGE = new Topping("sausage", false, false);

  /** Bacon topping ingredient */
  public static final Topping BACON = new Topping("bacon", false, false);

  /** Buffalo chicken topping ingredient */
  public static final Topping BUFFALO_CHICKEN = new Topping("buffalo chicken", false, false);

  /** Ham topping ingredient */
  public static final Topping HAM = new Topping("ham", false, false);

  /** Anchovies topping ingredient */
  public static final Topping ANCHOVIES = new Topping("anchovies", false, false);

  /**
   * Constructor for Topping class
   *
   * @param name The name of the topping
   * @param isVegetarian Whether the topping is vegetarian
   * @param isVegan Whether the topping is vegan
   */
  private Topping(String name, boolean isVegetarian, boolean isVegan) {
    super(name, isVegetarian, isVegan);
  }
}
