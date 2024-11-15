package com.comp301.a07pizza;

import com.comp301.a07pizza.Pizza.Size;

/** This class is a factory class that can be used to create different types of pizzas */
public class PizzaFactory {

  /** Default constructor for PizzaFactory class */
  public PizzaFactory() {}

  /**
   * This method creates a cheese pizza with the specified size
   *
   * @param size The size of the pizza
   * @return The cheese pizza
   */
  public static Pizza makeCheesePizza(Size size) {
    // Example choice: Medium pizza with hand-tossed crust, tomato sauce, a blend of cheeses, and no
    // toppings for now
    return new PizzaImpl(size, Crust.HAND_TOSSED, Sauce.TOMATO, Cheese.BLEND, new Topping[] {});
  }

  /**
   * This method creates a Hawaiian pizza with the specified size
   *
   * @param size The size of the pizza
   * @return The Hawaiian pizza
   */
  public static Pizza makeHawaiianPizza(Size size) {
    // Example choice: Small pizza with hand-tossed crust, tomato sauce, a blend of cheeses, ham,
    // and pineapple
    return new PizzaImpl(
        size,
        Crust.HAND_TOSSED,
        Sauce.TOMATO,
        Cheese.BLEND,
        new Topping[] {Topping.HAM, Topping.PINEAPPLE});
  }

  /**
   * This method creates a meat lovers pizza with the specified size
   *
   * @param size The size of the pizza
   * @return The meat lovers pizza
   */
  public static Pizza makeMeatLoversPizza(Size size) {
    // Example choice: Large pizza with deep dish crust, tomato sauce, a blend of cheeses, and a
    // variety of meats
    return new PizzaImpl(
        size,
        Crust.DEEP_DISH,
        Sauce.TOMATO,
        Cheese.BLEND,
        new Topping[] {Topping.PEPPERONI, Topping.SAUSAGE, Topping.BACON, Topping.GROUND_BEEF});
  }

  /**
   * This method creates a veggie supreme pizza with the specified size
   *
   * @param size The size of the pizza
   * @return The veggie supreme pizza
   */
  public static Pizza makeVeggieSupremePizza(Size size) {
    // Example choice: Medium pizza with thin crust, tomato sauce, a blend of cheeses, and a variety
    // of vegetarian toppings
    return new PizzaImpl(
        size,
        Crust.THIN,
        Sauce.TOMATO,
        Cheese.BLEND,
        new Topping[] {
          Topping.SUN_DRIED_TOMATO, Topping.GREEN_PEPPER, Topping.MUSHROOMS, Topping.OLIVES
        });
  }

  /**
   * This method creates a daily special pizza
   *
   * @return The daily special pizza
   */
  public static Pizza makeDailySpecialPizza() {
    // Example choice: Large pizza with thin crust, pesto sauce, vegan cheese, and a variety of
    // vegetarian toppings
    return new PizzaImpl(
        Size.LARGE,
        Crust.THIN,
        Sauce.PESTO,
        Cheese.VEGAN,
        new Topping[] {
          Topping.TOMATO, Topping.GARLIC, Topping.SPINACH, Topping.ONION, Topping.JALAPENO
        });
  }
}
