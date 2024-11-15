package com.comp301.a01sushi;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

/** This class tests the Roll class. */
public class RollTest {

  /**
   * This test method tests the case where a roll is created with a valid (unique) set of
   * ingredients.
   */
  @Test
  public void testRollCreation() {
    IngredientPortion[] ingredients = {
      new TunaPortion(0.5), new RicePortion(0.5), new SeaweedPortion(0.05)
    };
    Roll roll = new Roll("Tuna Roll", ingredients);

    assertEquals("Tuna Roll", roll.getName());
    assertEquals(3, roll.getIngredients().length); // Tuna, Rice, Seaweed (0.1 oz total)
    assertEquals(0.5, roll.getIngredients()[0].getAmount(), 0.001); // Amount of Tuna
    assertEquals(0.5, roll.getIngredients()[1].getAmount(), 0.001); // Amount of Rice
    assertEquals(0.1, roll.getIngredients()[2].getAmount(), 0.001); // Amount of Seaweed
    assertEquals(49, roll.getCalories());
    assertEquals(1.19, roll.getCost(), 0.001);
  }

  /** This test method tests the case where a roll is created with duplicated ingredients. */
  @Test
  public void testRollWithRepeatedIngredients() {
    // 2 portions of tuna will be combined into a single portion
    IngredientPortion[] ingredients = {
      new TunaPortion(0.5), new TunaPortion(0.25), new RicePortion(0.5), new SeaweedPortion(0.05)
    };
    Roll roll = new Roll("Double Tuna Roll", ingredients);

    assertEquals(3, roll.getIngredients().length);
    assertEquals(0.75, roll.getIngredients()[0].getAmount(), 0.001); // Amount of Tuna
    assertEquals(0.5, roll.getIngredients()[1].getAmount(), 0.001); // Amount of Rice
    assertEquals(0.1, roll.getIngredients()[2].getAmount(), 0.001); // Amount of Seaweed
    assertEquals(59, roll.getCalories());
    assertEquals(1.60, roll.getCost(), 0.001);
  }

  /**
   * This test method tests the case where a roll is created with a set of ingredients that does not
   * contain enough seaweed.
   */
  @Test
  public void testRollWithoutEnoughSeaweed() {
    IngredientPortion[] ingredients = {new TunaPortion(0.5), new RicePortion(0.5)};
    Roll roll = new Roll("Tuna Roll without Seaweed", ingredients);

    assertEquals(3, roll.getIngredients().length); // Tuna, Rice, Added Seaweed
    assertEquals("tuna", roll.getIngredients()[0].getName());
    assertEquals(0.5, roll.getIngredients()[0].getAmount(), 0.001); // 0.5 oz of Tuna
    assertEquals("rice", roll.getIngredients()[1].getName());
    assertEquals(0.5, roll.getIngredients()[1].getAmount(), 0.001); // 0.5 oz of Rice
    assertEquals("seaweed", roll.getIngredients()[2].getName()); // Added Seaweed
    assertEquals(0.1, roll.getIngredients()[2].getAmount(), 0.001); // 0.1 oz of Seaweed
  }

  /**
   * This test method tests the case where a roll is created with a set of ingredients that contains
   * exactly enough seaweed.
   */
  @Test
  public void testRollWithJustEnoughSeaweed() {
    IngredientPortion[] ingredients = {
      new TunaPortion(0.5), new RicePortion(0.5), new SeaweedPortion(0.1)
    };
    Roll roll = new Roll("Tuna Roll with Seaweed", ingredients);

    assertEquals(3, roll.getIngredients().length); // Tuna, Rice, Seaweed
    assertEquals("seaweed", roll.getIngredients()[2].getName());
    assertEquals(0.1, roll.getIngredients()[2].getAmount(), 0.001); // Exactly 0.1 oz of Seaweed
  }

  /** This test method tests the getIsVegetarian method in the Roll class. */
  @Test
  public void testVegetarianRoll() {
    // Vegetarian roll with avocado, rice, and seaweed
    IngredientPortion[] ingredients = {
      new AvocadoPortion(0.5), new RicePortion(0.5), new SeaweedPortion(0.1)
    };
    Roll roll = new Roll("Vegetarian Roll", ingredients);

    assertTrue(roll.getIsVegetarian());

    // Non-vegetarian roll with tuna, rice, and seaweed
    IngredientPortion[] ingredients2 = {
      new TunaPortion(0.5), new RicePortion(0.5), new SeaweedPortion(0.1)
    };
    Roll roll2 = new Roll("Non-Vegetarian Roll", ingredients2);
    assertFalse(roll2.getIsVegetarian());

    // Non-vegetarian roll with avocado, crab, and seaweed
    IngredientPortion[] ingredients3 = {new AvocadoPortion(0.5), new CrabPortion(0.5)};
    Roll roll3 = new Roll("Vegetarian Roll", ingredients3);
    assertFalse(roll3.getIsVegetarian());
  }

  /** This test method tests the getHasShellfish method in the Roll class. */
  @Test
  public void testRollWithShellfish() {
    // Shellfish roll with crab, rice, and seaweed
    IngredientPortion[] ingredients = {
      new CrabPortion(0.5), new RicePortion(0.5), new SeaweedPortion(0.1)
    };
    Roll roll = new Roll("Crab Roll", ingredients);

    assertTrue(roll.getHasShellfish());

    // Non-shellfish roll with tuna, rice, and seaweed
    IngredientPortion[] ingredients2 = {
      new TunaPortion(0.5), new RicePortion(0.5), new SeaweedPortion(0.1)
    };
    Roll roll2 = new Roll("Non-Shellfish Roll", ingredients2);

    assertFalse(roll2.getHasShellfish());
  }

  /**
   * This test method tests the case where a roll is created with a set of ingredients that contains
   * a null ingredient.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullIngredientInRoll() {
    IngredientPortion[] ingredients = {new TunaPortion(0.5), null, new RicePortion(0.5)};
    new Roll("Invalid Roll", ingredients);
  }

  /** This test method tests the case where a roll is created with a null name. */
  @Test(expected = IllegalArgumentException.class)
  public void testNullNameInRoll() {
    IngredientPortion[] ingredients = {new TunaPortion(0.5), new RicePortion(0.5)};
    new Roll(null, ingredients);
  }

  /** This test method tests the case where a roll is created with an empty set of ingredients. */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyIngredientsInRoll() {
    new Roll("Empty Roll", new IngredientPortion[0]);
  }

  /**
   * This test method tests if getIngredients returns a copy of the internal ingredients array
   * rather than a reference to the actual internal array.
   */
  @Test
  public void testGetIngredientsReturnsCopy() {
    IngredientPortion[] ingredients = {
      new TunaPortion(0.5), new RicePortion(0.5), new SeaweedPortion(0.1)
    };
    Roll roll = new Roll("Tuna Roll", ingredients);
    IngredientPortion[] rollIngredients = roll.getIngredients();

    // Modify the returned array and check if it affects the original roll
    rollIngredients[0] = new CrabPortion(0.5);
    assertNotEquals("crab", roll.getIngredients()[0].getName()); // Original should remain tuna
  }
}
