package com.comp301.a02adventure;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class contains a set of test cases that can be used to test the implementation of the Map
 * interface - the MapImpl class.
 */
public class MapImplTest {

  /**
   * Default constructor for the MapImplTest class.
   * This constructor is intentionally left empty since no specific initialization is needed for the tests.
   */
  public MapImplTest() {
    // No initialization required for this test class.
  }

  /** This test case tests the constructor and getter methods of the Map interface. */
  @Test
  public void testConstructorAndGetters() {
    Map map = new MapImpl(5, 5, 3);
    assertEquals(5, map.getWidth());
    assertEquals(5, map.getHeight());
    assertEquals(3, map.getNumItems());
  }

  /** This test case tests the constructor of the Map interface with invalid width values. */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithInvalidWidth() {
    new MapImpl(0, 5, 3);
  }

  /** This test case tests the constructor of the Map interface with invalid height values. */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithInvalidHeight() {
    new MapImpl(5, -1, 3);
  }

  /** This test case tests the getCell method of the Map interface. */
  @Test
  public void testGetCell() {
    Map map = new MapImpl(3, 3, 1);
    map.initCell(1, 1);
    assertNotNull(map.getCell(1, 1));
    assertEquals(new PositionImpl(1, 1), map.getCell(1, 1).getPosition());
  }

  /**
   * This test case tests the getCell method of the Map interface with out-of-bounds index values.
   */
  @Test(expected = IndexOutOfBoundsException.class)
  public void testGetCellOutOfBounds() {
    Map map = new MapImpl(2, 2, 1);
    map.getCell(3, 3);
  }

  /** This test case tests the getCellByPosition method of the Map interface. */
  @Test
  public void testGetCellByPosition() {
    Map map = new MapImpl(3, 3, 1);
    map.initCell(1, 2);
    Position position = new PositionImpl(1, 2);
    assertNotNull(map.getCell(position));
    assertEquals(position, map.getCell(position).getPosition());
  }

  /**
   * This test case tests the getCellByPosition method of the Map interface with out-of-bounds
   * position values.
   */
  @Test(expected = IndexOutOfBoundsException.class)
  public void testGetCellByPositionOutOfBounds() {
    Map map = new MapImpl(2, 2, 1);
    Position position = new PositionImpl(3, 3);
    map.getCell(position);
  }

  /** This test case tests the initCell method of the Map interface. */
  @Test
  public void testInitCell() {
    Map map = new MapImpl(3, 3, 2);
    map.initCell(0, 0);
    assertNotNull(map.getCell(0, 0));
    assertEquals(new PositionImpl(0, 0), map.getCell(0, 0).getPosition());
  }

  /**
   * This test case tests the initCell method of the Map interface with out-of-bounds index values.
   */
  @Test(expected = IndexOutOfBoundsException.class)
  public void testInitCellOutOfBounds() {
    Map map = new MapImpl(2, 2, 1);
    map.initCell(2, 2);
  }
}
