package com.comp301.a01sushi;

import static org.junit.Assert.*;
import org.junit.Test;

/** This class tests the Sashimi class's methods and constructors. */
public class SashimiTest {

  /** This test method tests the creation of Sashimi objects and their respective methods. */
  @Test
  public void testSashimiCreation() {
    // Case 1: Tuna
    Sashimi tunaSashimi = new Sashimi(Sashimi.SashimiType.TUNA);
    assertEquals("tuna sashimi", tunaSashimi.getName());
    assertEquals(1, tunaSashimi.getIngredients().length);
    assertEquals("tuna", tunaSashimi.getIngredients()[0].getName());
    assertEquals(32, tunaSashimi.getCalories());
    assertEquals(1.2525, tunaSashimi.getCost(), 0.001);

    // Case 2: Eel
    Sashimi eelSashimi = new Sashimi(Sashimi.SashimiType.EEL);
    assertEquals("eel sashimi", eelSashimi.getName());
    assertEquals(1, eelSashimi.getIngredients().length);
    assertEquals("eel", eelSashimi.getIngredients()[0].getName());
    assertEquals(62, eelSashimi.getCalories());
    assertEquals(1.6125, eelSashimi.getCost(), 0.001);
  }

  /** This test method tests the getIsVegetarian method in the Sashimi class. */
  @Test
  public void testVegetarianCheck() {
    // Test case 1: shrimp
    Sashimi shrimpSashimi = new Sashimi(Sashimi.SashimiType.SHRIMP);
    assertFalse(shrimpSashimi.getIsVegetarian());

    // Test case 2: crab
    Sashimi crabSashimi = new Sashimi(Sashimi.SashimiType.CRAB);
    assertFalse(crabSashimi.getIsVegetarian());
  }

  /** This test method tests the getHasRice method in the Sashimi class. */
  @Test
  public void testHasRice() {
    Sashimi eelSashimi = new Sashimi(Sashimi.SashimiType.EEL);
    assertFalse(eelSashimi.getHasRice());
  }

  /** This test method tests the getHasShellfish method in the Sashimi class. */
  @Test
  public void testHasShellfish() {
    // Case 1: Crab
    Sashimi crabSashimi = new Sashimi(Sashimi.SashimiType.CRAB);
    assertTrue(crabSashimi.getHasShellfish());

    // Case 2: Tuna
    Sashimi tunaSashimi = new Sashimi(Sashimi.SashimiType.TUNA);
    assertFalse(tunaSashimi.getHasShellfish());
  }
}
