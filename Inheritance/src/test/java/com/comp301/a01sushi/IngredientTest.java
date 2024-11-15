package com.comp301.a01sushi;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class tests the Ingredient class and its subclasses: Avocado, Crab, Eel, Rice, Seaweed,
 * Shrimp, Tuna, and Yellowtail.
 */
public class IngredientTest {

  /** This test method tests the creation of Ingredient objects and their respective methods. */
  @Test
  public void testIngredientCreation() {
    // Test case 1: Avocado
    Ingredient avocado = new Avocado();
    assertEquals("avocado", avocado.getName());
    assertEquals(0.24, avocado.getPricePerOunce(), 0.001);
    assertEquals(42, avocado.getCaloriesPerOunce());
    assertTrue(avocado.getIsVegetarian());
    assertFalse(avocado.getIsRice());
    assertFalse(avocado.getIsShellfish());

    // Test case 2: Crab
    Ingredient crab = new Crab();
    assertEquals("crab", crab.getName());
    assertEquals(0.72, crab.getPricePerOunce(), 0.001);
    assertEquals(37, crab.getCaloriesPerOunce());
    assertFalse(crab.getIsVegetarian());
    assertFalse(crab.getIsRice());
    assertTrue(crab.getIsShellfish());

    // Test case 3: Eel
    Ingredient eel = new Eel();
    assertEquals("eel", eel.getName());
    assertEquals(2.15, eel.getPricePerOunce(), 0.001);
    assertEquals(82, eel.getCaloriesPerOunce());
    assertFalse(eel.getIsVegetarian());
    assertFalse(eel.getIsRice());
    assertFalse(eel.getIsShellfish());

    // Test case 4: Rice
    Ingredient rice = new Rice();
    assertEquals("rice", rice.getName());
    assertEquals(0.13, rice.getPricePerOunce(), 0.001);
    assertEquals(34, rice.getCaloriesPerOunce());
    assertTrue(rice.getIsVegetarian());
    assertTrue(rice.getIsRice());
    assertFalse(rice.getIsShellfish());

    // Test case 5: Seaweed
    Ingredient seaweed = new Seaweed();
    assertEquals("seaweed", seaweed.getName());
    assertEquals(2.85, seaweed.getPricePerOunce(), 0.001);
    assertEquals(105, seaweed.getCaloriesPerOunce());
    assertTrue(seaweed.getIsVegetarian());
    assertFalse(seaweed.getIsRice());
    assertFalse(seaweed.getIsShellfish());

    // Test case 6: Shrimp
    Ingredient shrimp = new Shrimp();
    assertEquals("shrimp", shrimp.getName());
    assertEquals(0.65, shrimp.getPricePerOunce(), 0.001);
    assertEquals(32, shrimp.getCaloriesPerOunce());
    assertFalse(shrimp.getIsVegetarian());
    assertFalse(shrimp.getIsRice());
    assertTrue(shrimp.getIsShellfish());

    // Test case 7: Tuna
    Ingredient tuna = new Tuna();
    assertEquals("tuna", tuna.getName());
    assertEquals(1.67, tuna.getPricePerOunce(), 0.001);
    assertEquals(42, tuna.getCaloriesPerOunce());
    assertFalse(tuna.getIsVegetarian());
    assertFalse(tuna.getIsRice());
    assertFalse(tuna.getIsShellfish());

    // Test case 8: Yellowtail
    Ingredient yellowtail = new Yellowtail();
    assertEquals("yellowtail", yellowtail.getName());
    assertEquals(0.74, yellowtail.getPricePerOunce(), 0.001);
    assertEquals(57, yellowtail.getCaloriesPerOunce());
    assertFalse(yellowtail.getIsVegetarian());
    assertFalse(yellowtail.getIsRice());
    assertFalse(yellowtail.getIsShellfish());
  }

  /** This test method tests the equals method in the Ingredient class. */
  @Test
  public void testIngredientEquals() {
    Ingredient avocado1 = new Avocado();
    Ingredient avocado2 = new Avocado();
    assertTrue(avocado1.equals(avocado2));

    Ingredient tuna = new Tuna();
    assertFalse(avocado1.equals(tuna));
  }
}
