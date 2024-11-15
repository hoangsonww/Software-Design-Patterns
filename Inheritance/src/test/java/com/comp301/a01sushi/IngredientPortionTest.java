package com.comp301.a01sushi;

import static org.junit.Assert.*;
import org.junit.Test;

/** This class tests the IngredientPortion class and its subclasses. */
public class IngredientPortionTest {

  /**
   * This test method tests the creation of IngredientPortion objects and their respective methods.
   */
  @Test
  public void testIngredientPortionCreation() {
    // Test case 1: Avocado
    IngredientPortion avocadoPortion = new AvocadoPortion(0.5);
    assertEquals(0.5, avocadoPortion.getAmount(), 0.001);
    assertEquals("avocado", avocadoPortion.getName());
    assertEquals(21.0, avocadoPortion.getCalories(), 0.001);
    assertEquals(0.12, avocadoPortion.getCost(), 0.001);
    assertTrue(avocadoPortion.getIsVegetarian());
    assertFalse(avocadoPortion.getIsRice());
    assertFalse(avocadoPortion.getIsShellfish());

    // Test case 2: Crab
    IngredientPortion crabPortion = new CrabPortion(0.75);
    assertEquals(0.75, crabPortion.getAmount(), 0.001);
    assertEquals("crab", crabPortion.getName());
    assertEquals(27.75, crabPortion.getCalories(), 0.001);
    assertEquals(0.54, crabPortion.getCost(), 0.001);
    assertFalse(crabPortion.getIsVegetarian());
    assertFalse(crabPortion.getIsRice());
    assertTrue(crabPortion.getIsShellfish());

    // Test case 3: Seaweed
    IngredientPortion seaweedPortion = new SeaweedPortion(0.25);
    assertEquals(0.25, seaweedPortion.getAmount(), 0.001);
    assertEquals("seaweed", seaweedPortion.getName());
    assertEquals(26.25, seaweedPortion.getCalories(), 0.001);
    assertEquals(0.7125, seaweedPortion.getCost(), 0.001);
    assertTrue(seaweedPortion.getIsVegetarian());
    assertFalse(seaweedPortion.getIsRice());
    assertFalse(seaweedPortion.getIsShellfish());
  }

  @Test
  public void testCombineIngredientPortions() {
    // Test case 1: Avocado
    IngredientPortion avocadoPortion1 = new AvocadoPortion(0.5);
    IngredientPortion avocadoPortion2 = new AvocadoPortion(0.25);
    IngredientPortion combined = avocadoPortion1.combine(avocadoPortion2);

    assertEquals(0.75, combined.getAmount(), 0.001);
    assertEquals(31.5, combined.getCalories(), 0.001);
    assertEquals(0.18, combined.getCost(), 0.001);

    // Test case 2: Crab
    IngredientPortion crabPortion1 = new CrabPortion(0.75);
    IngredientPortion crabPortion2 = new CrabPortion(0.5);
    combined = crabPortion1.combine(crabPortion2);

    assertEquals(1.25, combined.getAmount(), 0.001);
    assertEquals(46.25, combined.getCalories(), 0.001);
    assertEquals(0.90, combined.getCost(), 0.001);

    // Test case 3: Seaweed
    IngredientPortion seaweedPortion1 = new SeaweedPortion(0.25);
    IngredientPortion seaweedPortion2 = new SeaweedPortion(0.5);
    combined = seaweedPortion1.combine(seaweedPortion2);

    assertEquals(0.75, combined.getAmount(), 0.001);
    assertEquals(78.75, combined.getCalories(), 0.001);
    assertEquals(2.1375, combined.getCost(), 0.001);
  }

  /** This test method tests the combine method when the other ingredient portion is null. */
  @Test(expected = IllegalArgumentException.class)
  public void testCombineDifferentIngredientPortions() {
    IngredientPortion avocadoPortion = new AvocadoPortion(0.5);
    IngredientPortion tunaPortion = new TunaPortion(0.5);
    avocadoPortion.combine(tunaPortion);
  }
}
