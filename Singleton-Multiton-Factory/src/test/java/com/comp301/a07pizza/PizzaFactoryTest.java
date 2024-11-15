package com.comp301.a07pizza;

import com.comp301.a07pizza.*;
import com.comp301.a07pizza.Pizza.Size;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/** This class tests the PizzaFactory class and the PizzaImpl class */
public class PizzaFactoryTest {

  /** Constructor for PizzaFactoryTest class */
  public PizzaFactoryTest() {}

  // Create instances of each pizza type and size
  private Pizza cheesePizzaSmall, cheesePizzaMedium, cheesePizzaLarge;
  private Pizza hawaiianPizzaSmall, hawaiianPizzaMedium, hawaiianPizzaLarge;
  private Pizza meatLoversPizzaSmall, meatLoversPizzaMedium, meatLoversPizzaLarge;
  private Pizza veggieSupremePizzaSmall, veggieSupremePizzaMedium, veggieSupremePizzaLarge;
  private Pizza dailySpecial;

  /** This method sets up the test environment by creating instances of each pizza type and size */
  @Before
  public void setUp() {
    cheesePizzaSmall = PizzaFactory.makeCheesePizza(Size.SMALL);
    cheesePizzaMedium = PizzaFactory.makeCheesePizza(Size.MEDIUM);
    cheesePizzaLarge = PizzaFactory.makeCheesePizza(Size.LARGE);

    hawaiianPizzaSmall = PizzaFactory.makeHawaiianPizza(Size.SMALL);
    hawaiianPizzaMedium = PizzaFactory.makeHawaiianPizza(Size.MEDIUM);
    hawaiianPizzaLarge = PizzaFactory.makeHawaiianPizza(Size.LARGE);

    meatLoversPizzaSmall = PizzaFactory.makeMeatLoversPizza(Size.SMALL);
    meatLoversPizzaMedium = PizzaFactory.makeMeatLoversPizza(Size.MEDIUM);
    meatLoversPizzaLarge = PizzaFactory.makeMeatLoversPizza(Size.LARGE);

    veggieSupremePizzaSmall = PizzaFactory.makeVeggieSupremePizza(Size.SMALL);
    veggieSupremePizzaMedium = PizzaFactory.makeVeggieSupremePizza(Size.MEDIUM);
    veggieSupremePizzaLarge = PizzaFactory.makeVeggieSupremePizza(Size.LARGE);

    dailySpecial = PizzaFactory.makeDailySpecialPizza();
  }

  /** This method tests the properties of each ingredient */
  @Test
  public void testIngredientProperties() {
    assertTrue(Crust.HAND_TOSSED.isVegetarian());
    assertTrue(Crust.HAND_TOSSED.isVegan());

    assertEquals("tomato", Sauce.TOMATO.getName());
    assertTrue(Sauce.TOMATO.isVegan());

    assertEquals("mozzarella", Cheese.MOZZARELLA.getName());
    assertFalse(Cheese.MOZZARELLA.isVegan());

    assertEquals("pepperoni", Topping.PEPPERONI.getName());
    assertFalse(Topping.PEPPERONI.isVegan());
  }

  /** This method tests the singleton instances of each ingredient */
  @Test
  public void testSingletonInstances() {
    assertSame(Crust.HAND_TOSSED, Crust.HAND_TOSSED);
    assertSame(Sauce.TOMATO, Sauce.TOMATO);
    assertSame(Cheese.MOZZARELLA, Cheese.MOZZARELLA);
    assertSame(Topping.PEPPERONI, Topping.PEPPERONI);
  }

  /** This method tests the size of each pizza type */
  @Test
  public void testPizzaSizes() {
    assertEquals(Size.SMALL, cheesePizzaSmall.getSize());
    assertEquals(Size.MEDIUM, cheesePizzaMedium.getSize());
    assertEquals(Size.LARGE, cheesePizzaLarge.getSize());
  }

  /** This method tests the base price of each pizza type */
  @Test
  public void testPizzaBasePrice() {
    Pizza smallPlainPizza =
        new PizzaImpl(Size.SMALL, Crust.THIN, Sauce.TOMATO, Cheese.BLEND, new Topping[] {});
    assertEquals(7.0, smallPlainPizza.getPrice(), 0.01);

    Pizza mediumPlainPizza =
        new PizzaImpl(Size.MEDIUM, Crust.THIN, Sauce.TOMATO, Cheese.BLEND, new Topping[] {});
    assertEquals(9.0, mediumPlainPizza.getPrice(), 0.01);

    Pizza largePlainPizza =
        new PizzaImpl(Size.LARGE, Crust.THIN, Sauce.TOMATO, Cheese.BLEND, new Topping[] {});
    assertEquals(11.0, largePlainPizza.getPrice(), 0.01);
  }

  /** This method tests the decorated price of each pizza type */
  @Test
  public void testPizzaPriceWithToppings() {
    Pizza smallWithTwoToppings =
        new PizzaImpl(
            Size.SMALL,
            Crust.HAND_TOSSED,
            Sauce.BARBECUE,
            Cheese.MOZZARELLA,
            new Topping[] {Topping.OLIVES, Topping.ONION});
    assertEquals(7.5, smallWithTwoToppings.getPrice(), 0.01);

    Pizza mediumWithThreeToppings =
        new PizzaImpl(
            Size.MEDIUM,
            Crust.DEEP_DISH,
            Sauce.PESTO,
            Cheese.BLEND,
            new Topping[] {Topping.MUSHROOMS, Topping.OLIVES, Topping.SPINACH});
    assertEquals(10.5, mediumWithThreeToppings.getPrice(), 0.01);

    Pizza largeWithFiveToppings =
        new PizzaImpl(
            Size.LARGE,
            Crust.THIN,
            Sauce.ALFREDO,
            Cheese.VEGAN,
            new Topping[] {
              Topping.GARLIC, Topping.SPINACH, Topping.OLIVES, Topping.JALAPENO, Topping.TOMATO
            });
    assertEquals(14.75, largeWithFiveToppings.getPrice(), 0.01);
  }

  /** This method tests the vegetarian and vegan properties of each pizza type */
  @Test
  public void testVegetarianAndVeganCombinations() {
    Pizza vegetarianPizza =
        new PizzaImpl(
            Size.MEDIUM,
            Crust.HAND_TOSSED,
            Sauce.TOMATO,
            Cheese.BLEND,
            new Topping[] {Topping.ONION, Topping.OLIVES});
    assertTrue(vegetarianPizza.isVegetarian());
    assertFalse(vegetarianPizza.isVegan()); // Cheese blend is not vegan

    Pizza veganPizza =
        new PizzaImpl(
            Size.LARGE,
            Crust.THIN,
            Sauce.PESTO,
            Cheese.VEGAN,
            new Topping[] {Topping.ONION, Topping.SPINACH, Topping.GARLIC});
    assertTrue(veganPizza.isVegan());
    assertTrue(veganPizza.isVegetarian());
  }

  /** This method tests the cheese pizza factory */
  @Test
  public void testCheesePizzaFactory() {
    assertEquals(Crust.HAND_TOSSED, cheesePizzaSmall.getCrust());
    assertEquals(Sauce.TOMATO, cheesePizzaSmall.getSauce());
    assertEquals(Cheese.BLEND, cheesePizzaSmall.getCheese());
    assertEquals(0, cheesePizzaSmall.getToppings().length);
    assertEquals(7.0, cheesePizzaSmall.getPrice(), 0.01);
  }

  /** This method tests the hawaiian pizza factory */
  @Test
  public void testHawaiianPizzaFactory() {
    assertEquals(Size.MEDIUM, hawaiianPizzaMedium.getSize());
    assertEquals(Crust.HAND_TOSSED, hawaiianPizzaMedium.getCrust());
    assertEquals(Sauce.TOMATO, hawaiianPizzaMedium.getSauce());
    assertEquals(2, hawaiianPizzaMedium.getToppings().length);
    assertEquals(Topping.HAM, hawaiianPizzaMedium.getToppings()[0]);
    assertEquals(Topping.PINEAPPLE, hawaiianPizzaMedium.getToppings()[1]);
  }

  /** This method tests the meat lovers pizza factory */
  @Test
  public void testMeatLoversPizzaFactory() {
    assertEquals(Size.LARGE, meatLoversPizzaLarge.getSize());
    assertEquals(Crust.DEEP_DISH, meatLoversPizzaLarge.getCrust());
    assertEquals(Sauce.TOMATO, meatLoversPizzaLarge.getSauce());
    assertEquals(4, meatLoversPizzaLarge.getToppings().length);
    assertFalse(meatLoversPizzaLarge.isVegetarian());
  }

  /** This method tests the supreme pizza factory */
  @Test
  public void testVeggieSupremePizzaFactory() {
    assertEquals(Size.SMALL, veggieSupremePizzaSmall.getSize());
    assertEquals(Crust.THIN, veggieSupremePizzaSmall.getCrust());
    assertEquals(Sauce.TOMATO, veggieSupremePizzaSmall.getSauce());
    assertTrue(veggieSupremePizzaSmall.isVegetarian());
  }

  /** This method tests the daily special pizza factory */
  @Test
  public void testDailySpecialPizzaFactory() {
    assertNotNull(dailySpecial);
    assertTrue(dailySpecial.isVegetarian());
    assertEquals(Size.LARGE, dailySpecial.getSize());
  }

  /** This method tests the edge case of an empty topping array */
  @Test
  public void testEmptyToppingArray() {
    Pizza pizzaWithEmptyTopping =
        new PizzaImpl(Size.SMALL, Crust.THIN, Sauce.RANCH, Cheese.VEGAN, new Topping[] {});
    assertEquals(7.0, pizzaWithEmptyTopping.getPrice(), 0.01);
    assertEquals(0, pizzaWithEmptyTopping.getToppings().length);
  }

  /** This method tests the edge case of a null topping array */
  @Test
  public void testNullToppingArray() {
    Topping[] toppings = null;
    Pizza pizzaWithNullTopping =
        new PizzaImpl(Size.MEDIUM, Crust.DEEP_DISH, Sauce.BARBECUE, Cheese.BLEND, toppings);
    assertEquals(9.0, pizzaWithNullTopping.getPrice(), 0.01);
  }

  /** This method tests the edge case of a null topping array */
  @Test
  public void testVariousCombinationsOfPizzaProperties() {
    Pizza allVegToppingsPizza =
        new PizzaImpl(
            Size.LARGE,
            Crust.THIN,
            Sauce.PESTO,
            Cheese.VEGAN,
            new Topping[] {Topping.GARLIC, Topping.MUSHROOMS, Topping.OLIVES});
    assertTrue(allVegToppingsPizza.isVegetarian());
    assertTrue(allVegToppingsPizza.isVegan());

    Pizza nonVegWithMixToppings =
        new PizzaImpl(
            Size.LARGE,
            Crust.HAND_TOSSED,
            Sauce.TOMATO,
            Cheese.MOZZARELLA,
            new Topping[] {Topping.PEPPERONI, Topping.MUSHROOMS});
    assertFalse(nonVegWithMixToppings.isVegan());
    assertFalse(nonVegWithMixToppings.isVegetarian());
  }
}
