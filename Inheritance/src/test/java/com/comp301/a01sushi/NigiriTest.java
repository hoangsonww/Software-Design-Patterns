package com.comp301.a01sushi;

import static org.junit.Assert.*;
import org.junit.Test;

/** This class tests the Nigiri class and its subclasses: Tuna, Yellowtail, Crab, and Shrimp. */
public class NigiriTest {

  /** This test method tests the creation of Nigiri objects and their respective methods. */
  @Test
  public void testNigiriCreation() {
    // Case 1: Tuna
    Nigiri tunaNigiri = new Nigiri(Nigiri.NigiriType.TUNA);
    assertEquals("tuna nigiri", tunaNigiri.getName());
    assertEquals(2, tunaNigiri.getIngredients().length);
    assertEquals("tuna", tunaNigiri.getIngredients()[0].getName());
    assertEquals("rice", tunaNigiri.getIngredients()[1].getName());
    assertEquals(49, tunaNigiri.getCalories());
    assertEquals(1.3175, tunaNigiri.getCost(), 0.001);

    // Case 2: Yellowtail
    Nigiri yellowtailNigiri = new Nigiri(Nigiri.NigiriType.YELLOWTAIL);
    assertEquals("yellowtail nigiri", yellowtailNigiri.getName());
    assertEquals(2, yellowtailNigiri.getIngredients().length);
    assertEquals("yellowtail", yellowtailNigiri.getIngredients()[0].getName());
    assertEquals("rice", yellowtailNigiri.getIngredients()[1].getName());
    assertEquals(60, yellowtailNigiri.getCalories());
    assertEquals(0.62, yellowtailNigiri.getCost(), 0.001);
  }

  /** This test method tests the getIsVegetarian method in the Nigiri class. */
  @Test
  public void testVegetarianCheck() {
    // Test case 1: shrimp
    Nigiri shrimpNigiri = new Nigiri(Nigiri.NigiriType.SHRIMP);
    assertFalse(shrimpNigiri.getIsVegetarian());

    // Test case 2: yellowtail
    Nigiri yellowtailNigiri = new Nigiri(Nigiri.NigiriType.YELLOWTAIL);
    assertFalse(yellowtailNigiri.getIsVegetarian());
  }

  /** This test method tests the getHasRice method in the Nigiri class. */
  @Test
  public void testHasRice() {
    Nigiri yellowtailNigiri = new Nigiri(Nigiri.NigiriType.YELLOWTAIL);
    assertTrue(yellowtailNigiri.getHasRice());
  }

  /** This test method tests the getHasShellfish method in the Nigiri class. */
  @Test
  public void testHasShellfish() {
    // Test case 1: crab
    Nigiri crabNigiri = new Nigiri(Nigiri.NigiriType.CRAB);
    assertTrue(crabNigiri.getHasShellfish());

    // Test case 2: eel
    Nigiri eelNigiri = new Nigiri(Nigiri.NigiriType.EEL);
    assertFalse(eelNigiri.getHasShellfish());
  }
}
