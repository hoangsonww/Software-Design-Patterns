package com.comp301.a05driver;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

/** This class tests the functionality of the SnakeOrderAcrossPoolsIterator class. */
public class SnakeOrderAcrossPoolsIteratorTest {

  /**
   * Default constructor for the SnakeOrderAcrossPoolsIteratorTest class. This constructor is empty
   * because the test environment is set up in the setUp() method.
   */
  public SnakeOrderAcrossPoolsIteratorTest() {}

  private Driver driver1 =
      new DriverImpl(
          "John", "Doe", 1, new VehicleImpl("Toyota", "Camry", "123ABC", new PositionImpl(5, 5)));
  private Driver driver2 =
      new DriverImpl(
          "Jane", "Smith", 2, new VehicleImpl("Honda", "Civic", "456DEF", new PositionImpl(6, 5)));
  private Driver driver3 =
      new DriverImpl(
          "Emily",
          "Johnson",
          3,
          new VehicleImpl("Ford", "Mustang", "789GHI", new PositionImpl(7, 5)));
  private Driver driver4 =
      new DriverImpl(
          "Michael",
          "Brown",
          4,
          new VehicleImpl("Chevy", "Malibu", "321XYZ", new PositionImpl(8, 5)));
  private Driver driver5 =
      new DriverImpl(
          "Sarah",
          "Connor",
          5,
          new VehicleImpl("Nissan", "Altima", "654JKL", new PositionImpl(9, 5)));

  /**
   * Tests the basic functionality of the SnakeOrderAcrossPoolsIterator class, including next() and
   * hasNext() methods.
   */
  @Test
  public void testBasicSnakeOrderTraversal() {
    List<Driver> pool1 = Arrays.asList(driver1, driver2); // 2 drivers
    List<Driver> pool2 = Arrays.asList(driver3); // 1 driver
    List<Driver> pool3 = Arrays.asList(driver4, driver5); // 2 drivers

    List<Iterable<Driver>> driverPools = Arrays.asList(pool1, pool2, pool3);
    SnakeOrderAcrossPoolsIterator iterator = new SnakeOrderAcrossPoolsIterator(driverPools);

    // First-to-last order
    assertTrue(iterator.hasNext());
    assertEquals(driver1, iterator.next()); // Pool 1, driver 1
    assertTrue(iterator.hasNext());
    assertEquals(driver3, iterator.next()); // Pool 2, driver 3
    assertTrue(iterator.hasNext());
    assertEquals(driver4, iterator.next()); // Pool 3, driver 4

    // Last-to-first order
    assertTrue(iterator.hasNext());
    assertEquals(driver5, iterator.next()); // Pool 3, driver 5
    assertTrue(iterator.hasNext());
    assertEquals(driver2, iterator.next()); // Pool 1, driver 2

    assertFalse(iterator.hasNext()); // No more drivers left
  }

  /**
   * Tests the SnakeOrderAcrossPoolsIterator class with uneven pools (i.e. pools with different
   * numbers of drivers).
   */
  @Test
  public void testUnevenPools() {
    List<Driver> pool1 = Arrays.asList(driver1); // 1 driver
    List<Driver> pool2 = Arrays.asList(driver2, driver3); // 2 drivers
    List<Driver> pool3 = Arrays.asList(driver4); // 1 driver

    List<Iterable<Driver>> driverPools = Arrays.asList(pool1, pool2, pool3);
    SnakeOrderAcrossPoolsIterator iterator = new SnakeOrderAcrossPoolsIterator(driverPools);

    // First-to-last order
    assertTrue(iterator.hasNext());
    assertEquals(driver1, iterator.next()); // Pool 1, driver 1
    assertTrue(iterator.hasNext());
    assertEquals(driver2, iterator.next()); // Pool 2, driver 2
    assertTrue(iterator.hasNext());
    assertEquals(driver4, iterator.next()); // Pool 3, driver 4

    // Last-to-first order
    assertTrue(iterator.hasNext());
    assertEquals(driver3, iterator.next()); // Pool 2, driver 3

    assertFalse(iterator.hasNext()); // No more drivers left
  }

  /**
   * Tests the SnakeOrderAcrossPoolsIterator class with empty pools (i.e. pools with no drivers).
   */
  @Test
  public void testEmptyPools() {
    List<Driver> pool1 = Arrays.asList(driver1, driver2); // 2 drivers
    List<Driver> pool2 = Collections.emptyList(); // Empty pool
    List<Driver> pool3 = Arrays.asList(driver3, driver4); // 2 drivers

    List<Iterable<Driver>> driverPools = Arrays.asList(pool1, pool2, pool3);
    SnakeOrderAcrossPoolsIterator iterator = new SnakeOrderAcrossPoolsIterator(driverPools);

    // First-to-last order (skip empty pool)
    assertTrue(iterator.hasNext());
    assertEquals(driver1, iterator.next()); // Pool 1, driver 1
    assertTrue(iterator.hasNext());
    assertEquals(driver3, iterator.next()); // Pool 3, driver 3

    // Last-to-first order (skip empty pool)
    assertTrue(iterator.hasNext());
    assertEquals(driver4, iterator.next()); // Pool 3, driver 4
    assertTrue(iterator.hasNext());
    assertEquals(driver2, iterator.next()); // Pool 1, driver 2

    assertFalse(iterator.hasNext()); // No more drivers left
  }

  /**
   * Tests the SnakeOrderAcrossPoolsIterator class with all empty pools (i.e. no drivers in any
   * pool).
   */
  @Test
  public void testAllEmptyPools() {
    List<Driver> pool1 = Collections.emptyList(); // Empty pool
    List<Driver> pool2 = Collections.emptyList(); // Empty pool
    List<Driver> pool3 = Collections.emptyList(); // Empty pool

    List<Iterable<Driver>> driverPools = Arrays.asList(pool1, pool2, pool3);
    SnakeOrderAcrossPoolsIterator iterator = new SnakeOrderAcrossPoolsIterator(driverPools);

    // No drivers should be available
    assertFalse(iterator.hasNext());
  }

  /**
   * Tests the SnakeOrderAcrossPoolsIterator class with a single pool (i.e. only one pool of
   * drivers).
   */
  @Test
  public void testSinglePool() {
    List<Driver> pool1 = Arrays.asList(driver1, driver2, driver3); // 3 drivers

    List<Iterable<Driver>> driverPools = Arrays.asList(pool1);
    SnakeOrderAcrossPoolsIterator iterator = new SnakeOrderAcrossPoolsIterator(driverPools);

    // All drivers should be returned in order since there's only one pool
    assertTrue(iterator.hasNext());
    assertEquals(driver1, iterator.next()); // Pool 1, driver 1
    assertTrue(iterator.hasNext());
    assertEquals(driver2, iterator.next()); // Pool 1, driver 2
    assertTrue(iterator.hasNext());
    assertEquals(driver3, iterator.next()); // Pool 1, driver 3

    assertFalse(iterator.hasNext()); // No more drivers left
  }

  /**
   * Tests the SnakeOrderAcrossPoolsIterator class with single-driver pools (i.e. each pool has only
   * one driver).
   */
  @Test
  public void testSingleDriverPools() {
    List<Driver> pool1 = Arrays.asList(driver1); // 1 driver
    List<Driver> pool2 = Arrays.asList(driver2); // 1 driver
    List<Driver> pool3 = Arrays.asList(driver3); // 1 driver

    List<Iterable<Driver>> driverPools = Arrays.asList(pool1, pool2, pool3);
    SnakeOrderAcrossPoolsIterator iterator = new SnakeOrderAcrossPoolsIterator(driverPools);

    // First-to-last order
    assertTrue(iterator.hasNext());
    assertEquals(driver1, iterator.next()); // Pool 1, driver 1
    assertTrue(iterator.hasNext());
    assertEquals(driver2, iterator.next()); // Pool 2, driver 2
    assertTrue(iterator.hasNext());
    assertEquals(driver3, iterator.next()); // Pool 3, driver 3

    // Last-to-first order
    assertFalse(iterator.hasNext()); // No more drivers left
  }

  /**
   * Tests the SnakeOrderAcrossPoolsIterator class with exhausted pools (i.e. all drivers have been
   * returned from each pool) in the middle of the traversal.
   */
  @Test
  public void testExhaustedPoolsMidTraversal() {
    List<Driver> pool1 = Arrays.asList(driver1); // 1 driver
    List<Driver> pool2 = Arrays.asList(driver2, driver3); // 2 drivers
    List<Driver> pool3 = Arrays.asList(driver4, driver5); // 2 drivers

    List<Iterable<Driver>> driverPools = Arrays.asList(pool1, pool2, pool3);
    SnakeOrderAcrossPoolsIterator iterator = new SnakeOrderAcrossPoolsIterator(driverPools);

    // First-to-last order
    assertTrue(iterator.hasNext());
    assertEquals(driver1, iterator.next()); // Pool 1, driver 1
    assertTrue(iterator.hasNext());
    assertEquals(driver2, iterator.next()); // Pool 2, driver 2
    assertTrue(iterator.hasNext());
    assertEquals(driver4, iterator.next()); // Pool 3, driver 4

    // Last-to-first order
    assertTrue(iterator.hasNext());
    assertEquals(driver5, iterator.next()); // Pool 3, driver 5
    assertTrue(iterator.hasNext());
    assertEquals(driver3, iterator.next()); // Pool 2, driver 3

    assertFalse(iterator.hasNext()); // No more drivers left
  }
}
