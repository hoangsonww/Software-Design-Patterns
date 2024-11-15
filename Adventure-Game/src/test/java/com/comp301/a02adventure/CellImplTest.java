package com.comp301.a02adventure;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class contains a set of test cases that can be used to test the implementation of the Cell
 * interface - the CellImpl class.
 */
public class CellImplTest {

  /**
   * Default constructor for the CellImplTest class.
   * This constructor is intentionally left empty since no specific initialization is needed for the tests.
   */
  public CellImplTest() {
    // No initialization required for this test class.
  }

  /** This test case tests the constructor and getter methods of the Cell interface. */
  @Test
  public void testConstructorAndGetters() {
    Position position = new PositionImpl(1, 2);
    Cell cell = new CellImpl(1, 2, "Cave", "A dark and mysterious cave");

    assertEquals("Cave", cell.getName());
    assertEquals("A dark and mysterious cave", cell.getDescription());
    assertEquals(position, cell.getPosition());
    assertFalse(cell.getIsVisited());
    assertFalse(cell.hasChest());
  }

  /** This test case tests the constructor with default values of the Cell interface. */
  @Test
  public void testConstructorWithDefaultValues() {
    Cell cell = new CellImpl(3, 4);

    assertEquals("", cell.getName());
    assertEquals("", cell.getDescription());
    assertEquals(new PositionImpl(3, 4), cell.getPosition());
    assertFalse(cell.getIsVisited());
    assertFalse(cell.hasChest());
  }

  /** This test case tests the constructor with a null name of the Cell interface. */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithNullName() {
    new CellImpl(1, 2, null, "Description");
  }

  /** This test case tests the constructor with a null description of the Cell interface. */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithNullDescription() {
    new CellImpl(1, 2, "Name", null);
  }

  /** This test case tests the setName method of the Cell interface. */
  @Test
  public void testSetName() {
    Cell cell = new CellImpl(0, 0, "Old Name", "Description");
    cell.setName("New Name");
    assertEquals("New Name", cell.getName());
  }

  /** This test case tests the setName method of the Cell interface with a null name. */
  @Test(expected = IllegalArgumentException.class)
  public void testSetNameNull() {
    Cell cell = new CellImpl(0, 0, "Old Name", "Description");
    cell.setName(null);
  }

  /** This test case tests the setDescription method of the Cell interface. */
  @Test
  public void testSetDescription() {
    Cell cell = new CellImpl(0, 0, "Name", "Old Description");
    cell.setDescription("New Description");
    assertEquals("New Description", cell.getDescription());
  }

  /**
   * This test case tests the setDescription method of the Cell interface with a null description.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetDescriptionNull() {
    Cell cell = new CellImpl(0, 0, "Name", "Description");
    cell.setDescription(null);
  }

  /** This test case tests the setChest method of the Cell interface. */
  @Test
  public void testSetChest() {
    Cell cell = new CellImpl(0, 0, "Name", "Description");
    Inventory chest = new InventoryImpl();
    cell.setChest(chest);
    assertEquals(chest, cell.getChest());
    assertTrue(cell.hasChest());
  }

  /** This test case tests the setChest method of the Cell interface with a null chest. */
  @Test(expected = IllegalArgumentException.class)
  public void testSetChestNull() {
    Cell cell = new CellImpl(0, 0, "Name", "Description");
    cell.setChest(null);
  }

  /** This test case tests the visit method of the Cell interface. */
  @Test
  public void testVisit() {
    Cell cell = new CellImpl(0, 0, "Name", "Description");
    assertFalse(cell.getIsVisited());
    cell.visit();
    assertTrue(cell.getIsVisited());
  }
}
