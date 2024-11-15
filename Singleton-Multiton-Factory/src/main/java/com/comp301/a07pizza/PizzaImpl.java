package com.comp301.a07pizza;

import java.util.ArrayList;
import java.util.List;

/** This class represents a pizza that can be ordered from a pizza restaurant */
public class PizzaImpl implements Pizza {
  /** The size of the pizza */
  private final Size size;

  /** The type of crust in the pizza */
  private final Crust crust;

  /** The type of sauce in the pizza */
  private final Sauce sauce;

  /** The type of cheese in the pizza */
  private final Cheese cheese;

  /** The list of toppings in the pizza */
  private final Topping[] toppings;

  /**
   * Constructor for PizzaImpl class
   *
   * @param size The size of the pizza
   * @param crust The type of crust in the pizza
   * @param sauce The type of sauce in the pizza
   * @param cheese The type of cheese in the pizza
   * @param toppings The list of toppings in the pizza
   */
  public PizzaImpl(Size size, Crust crust, Sauce sauce, Cheese cheese, Topping[] toppings) {
    // Initialize the fields
    this.size = size;
    this.crust = crust;
    this.sauce = sauce;
    this.cheese = cheese;
    // If toppings is null, set to an empty array. Otherwise, clone the provided array
    // to prevent external modification
    this.toppings = (toppings == null) ? new Topping[0] : toppings.clone();
  }

  /**
   * This method returns true if the pizza consists entirely of vegetarian ingredients
   *
   * @return Whether the pizza is vegetarian
   */
  @Override
  public boolean isVegetarian() {
    for (Ingredient ingredient : getIngredients()) {
      if (!ingredient.isVegetarian()) {
        return false;
      }
    }

    return true;
  }

  /**
   * This method returns true if the pizza consists entirely of vegan ingredients
   *
   * @return Whether the pizza is vegan
   */
  @Override
  public boolean isVegan() {
    for (Ingredient ingredient : getIngredients()) {
      if (!ingredient.isVegan()) {
        return false;
      }
    }

    return true;
  }

  /**
   * This method returns the price of the pizza
   *
   * @return The price of the pizza
   */
  @Override
  public double getPrice() {
    double basePrice;

    // Calculate the base price based on the size of the pizza
    switch (size) {
      case SMALL:
        basePrice = 7.0;
        basePrice += toppings.length * 0.25;
        break;
      case MEDIUM:
        basePrice = 9.0;
        basePrice += toppings.length * 0.50;
        break;
      case LARGE:
        basePrice = 11.0;
        basePrice += toppings.length * 0.75;
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + size);
    }

    return basePrice;
  }

  /**
   * This method returns the size of the pizza
   *
   * @return The size of the pizza
   */
  @Override
  public Size getSize() {
    return size;
  }

  /**
   * This method returns the type of sauce in the pizza
   *
   * @return The type of sauce in the pizza
   */
  @Override
  public Ingredient getSauce() {
    return sauce;
  }

  /**
   * This method returns the type of cheese in the pizza
   *
   * @return The type of cheese in the pizza
   */
  @Override
  public Ingredient getCheese() {
    return cheese;
  }

  /**
   * This method returns the type of crust in the pizza
   *
   * @return The type of crust in the pizza
   */
  @Override
  public Ingredient getCrust() {
    return crust;
  }

  /**
   * This method returns the list of toppings in the pizza
   *
   * @return The list of toppings in the pizza
   */
  @Override
  public Ingredient[] getToppings() {
    return toppings.clone();
  }

  /**
   * This method returns all the ingredients in the pizza including toppings, cheese, crust, and
   * sauce
   *
   * @return All the ingredients in the pizza
   */
  @Override
  public Ingredient[] getIngredients() {
    // Create a list to store all the ingredients
    List<Ingredient> ingredients = new ArrayList<>();
    ingredients.add(crust);
    ingredients.add(sauce);
    ingredients.add(cheese);

    // Add all toppings to the list of ingredients
    for (Topping topping : toppings) {
      ingredients.add(topping);
    }

    return ingredients.toArray(new Ingredient[0]);
  }
}
