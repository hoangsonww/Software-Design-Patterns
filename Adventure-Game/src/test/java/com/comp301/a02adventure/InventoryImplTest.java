package com.comp301.a02adventure;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

/**
 * This class contains a set of test cases that can be used to test the implementation of the
 * Inventory interface - the InventoryImpl class.
 */
public class InventoryImplTest {

  /**
   * Default constructor for the InventoryImplTest class.
   * This constructor is intentionally left empty since no specific initialization is needed for the tests.
   */
  public InventoryImplTest() {
    // No initialization required for this test class.
  }

  /** This test case tests the constructor and the getNumItems method of the Inventory interface. */
  @Test
  public void testInventoryConstructor() {
    Inventory inventory = new InventoryImpl();
    assertEquals(0, inventory.getNumItems());
  }

  /** This test case tests the constructor and the isEmpty method of the Inventory interface. */
  @Test
  public void testInventoryIsEmpty() {
    Inventory inventory = new InventoryImpl();
    assertTrue(inventory.isEmpty());
  }

  /** This test case tests the addItem method of the Inventory interface. */
  @Test
  public void testAddItem() {
    Inventory inventory = new InventoryImpl();
    Item item = new ItemImpl("Potion");
    inventory.addItem(item);
    assertEquals(1, inventory.getNumItems());
    assertFalse(inventory.isEmpty());
  }

  /** This test case tests the addItem method of the Inventory interface with a null item. */
  @Test(expected = IllegalArgumentException.class)
  public void testAddNullItem() {
    Inventory inventory = new InventoryImpl();
    inventory.addItem(null);
  }

  /** This test case tests the removeItem method of the Inventory interface. */
  @Test
  public void testRemoveItem() {
    Inventory inventory = new InventoryImpl();
    Item item = new ItemImpl("Potion");
    inventory.addItem(item);
    inventory.removeItem(item);
    assertTrue(inventory.isEmpty());
  }

  /** This test case tests the removeItem method of the Inventory interface with a null item. */
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveNullItem() {
    Inventory inventory = new InventoryImpl();
    inventory.removeItem(null);
  }

  /**
   * This test case tests the removeItem method of the Inventory interface with a non-existent item.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveNonExistentItem() {
    Inventory inventory = new InventoryImpl();
    Item item = new ItemImpl("Potion");
    inventory.removeItem(item);
  }

  /** This test case tests the getItems method of the Inventory interface. */
  @Test
  public void testGetItems() {
    Inventory inventory = new InventoryImpl();
    Item item1 = new ItemImpl("Potion");
    Item item2 = new ItemImpl("Shield");
    inventory.addItem(item1);
    inventory.addItem(item2);
    List<Item> items = inventory.getItems();
    assertEquals(2, items.size());
    assertTrue(items.contains(item1));
    assertTrue(items.contains(item2));
  }

  /** This test cast tests the clear method of the Inventory interface. */
  @Test
  public void testClearInventory() {
    Inventory inventory = new InventoryImpl();
    Item item = new ItemImpl("Potion");
    inventory.addItem(item);
    inventory.clear();
    assertTrue(inventory.isEmpty());
  }

  /** This test case tests the transferFrom method of the Inventory interface. */
  @Test
  public void testTransferFrom() {
    Inventory inventory1 = new InventoryImpl();
    Inventory inventory2 = new InventoryImpl();
    Item item = new ItemImpl("Sword");
    inventory2.addItem(item);

    inventory1.transferFrom(inventory2);

    assertEquals(1, inventory1.getNumItems());
    assertTrue(inventory1.getItems().contains(item));
    assertTrue(inventory2.isEmpty());
  }

  /**
   * This test case tests the transferFrom method of the Inventory interface with a null inventory.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testTransferFromNullInventory() {
    Inventory inventory = new InventoryImpl();
    inventory.transferFrom(null);
  }
}
