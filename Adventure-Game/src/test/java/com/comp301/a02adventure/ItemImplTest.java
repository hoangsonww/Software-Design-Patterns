package com.comp301.a02adventure;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class contains a set of test cases that can be used to test the implementation of the Item
 * interface - the ItemImpl class.
 */
public class ItemImplTest {

  /**
   * Default constructor for the ItemImplTest class.
   * This constructor is intentionally left empty since no specific initialization is needed for the tests.
   */
  public ItemImplTest() {
    // No initialization required for this test class.
  }

  /** This test case tests the constructor and getName method of the Item interface. */
  @Test
  public void testItemConstructorAndGetName() {
    Item item = new ItemImpl("Sword");
    assertEquals("Sword", item.getName());
  }

  /** This test case tests the constructor of the Item interface with a null name. */
  @Test(expected = IllegalArgumentException.class)
  public void testItemConstructorNullName() {
    new ItemImpl(null);
  }

  /** This test case tests the equals method of the Item interface. */
  @Test
  public void testItemEquals() {
    Item item1 = new ItemImpl("Shield");
    Item item2 = new ItemImpl("Shield");
    Item item3 = new ItemImpl("Potion");

    // Case 1: Two items with the same name are the same
    assertTrue(item1.equals(item2));
    // Case 2: Two items with different names are not the same
    assertFalse(item1.equals(item3));
    // Case 3: An item is not the same as null or a non-item object
    assertFalse(item1.equals(null));
    // Case 4: An item is not the same as an object with a different type
    assertFalse(item1.equals("Not an item"));
  }

  /** This test case tests the toString method of the Item interface. */
  @Test
  public void testItemToString() {
    Item item = new ItemImpl("Bow");
    assertEquals("Bow", item.toString());
  }
}
