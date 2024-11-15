package com.comp301.a05driver;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import java.util.*;

/** This class tests the functionality of the ExpandingProximityIterator class. */
public class ExpandingProximityIteratorTest {

  /**
   * Default constructor for the ExpandingProximityIteratorTest class. This constructor is empty
   * because the test environment is set up in the setUp() method.
   */
  public ExpandingProximityIteratorTest() {}

  private Position clientPos;
  private List<Driver> drivers;
  private Vehicle vehicle1, vehicle2, vehicle3, vehicle4;
  private Driver driver1, driver2, driver3, driver4;

  /** Sets up the test environment by initializing the client's position and driver pool. */
  @Before
  public void setUp() {
    // Setting up positions for client and drivers
    clientPos = new PositionImpl(5, 5);
    Position driverPos1 = new PositionImpl(6, 6); // Distance is 2
    Position driverPos2 = new PositionImpl(10, 10); // Distance is 10
    Position driverPos3 = new PositionImpl(8, 8); // Distance is 6
    Position driverPos4 = new PositionImpl(5, 10); // Distance is 5

    // Setting up vehicles
    vehicle1 = new VehicleImpl("Toyota", "Camry", "123ABC", driverPos1);
    vehicle2 = new VehicleImpl("Honda", "Civic", "456DEF", driverPos2);
    vehicle3 = new VehicleImpl("Ford", "Mustang", "789GHI", driverPos3);
    vehicle4 = new VehicleImpl("Chevy", "Malibu", "321XYZ", driverPos4);

    // Setting up drivers
    driver1 = new DriverImpl("John", "Doe", 1, vehicle1);
    driver2 = new DriverImpl("Jane", "Smith", 2, vehicle2);
    driver3 = new DriverImpl("Emily", "Johnson", 3, vehicle3);
    driver4 = new DriverImpl("Michael", "Brown", 4, vehicle4);

    // Adding all 4 drivers to the pool
    drivers = new ArrayList<>();
    drivers.add(driver1);
    drivers.add(driver2);
    drivers.add(driver3);
    drivers.add(driver4);
  }

  /**
   * Tests the basic functionality of the ExpandingProximityIterator class, including next() and
   * hasNext() methods.
   */
  @Test
  public void testBasicFunctionality() {
    ExpandingProximityIterator iterator = new ExpandingProximityIterator(drivers, clientPos, 2);

    assertTrue(iterator.hasNext());
    assertEquals("John Doe", iterator.next().getFullName()); // Distance 2

    assertTrue(iterator.hasNext());
    assertEquals("Michael Brown", iterator.next().getFullName()); // Distance 5

    assertTrue(iterator.hasNext());
    assertEquals("Emily Johnson", iterator.next().getFullName()); // Distance 6

    assertTrue(iterator.hasNext());
    assertEquals("Jane Smith", iterator.next().getFullName()); // Distance 10

    assertFalse(iterator.hasNext()); // No more drivers
  }

  /** Tests the behavior of the ExpandingProximityIterator class when the driver pool is empty. */
  @Test
  public void testEmptyDriverPool() {
    ExpandingProximityIterator iterator =
        new ExpandingProximityIterator(new ArrayList<>(), clientPos, 2);
    assertFalse(iterator.hasNext()); // No drivers in the pool
  }

  /**
   * Tests the behavior of the ExpandingProximityIterator class when there is only one driver in the
   * pool and the driver is within the proximity range.
   */
  @Test
  public void testSingleDriverPoolWithinRange() {
    // Only driver1 is in the pool
    List<Driver> singleDriverPool = Collections.singletonList(driver1);
    ExpandingProximityIterator iterator =
        new ExpandingProximityIterator(singleDriverPool, clientPos, 2);

    // Driver1 is at distance 2 (within the range)
    assertTrue(iterator.hasNext());
    assertEquals(driver1, iterator.next()); // Driver1 should be returned
    assertFalse(iterator.hasNext()); // No more drivers
  }

  /**
   * Tests the behavior of the ExpandingProximityIterator class when there is only one driver in the
   * pool and the driver is out of the proximity range.
   */
  @Test
  public void testSingleDriverPoolOutOfRange() {
    List<Driver> singleDriverPool =
        Collections.singletonList(driver2); // Only driver2 with distance 10
    ExpandingProximityIterator iterator =
        new ExpandingProximityIterator(singleDriverPool, clientPos, 2);

    // Driver2 is at distance 10 (out of range)
    assertTrue(iterator.hasNext());
    assertEquals(
        driver2, iterator.next()); // Driver is at distance 10, caught in the third expansion
    assertFalse(iterator.hasNext()); // No more drivers
  }

  /**
   * Tests the behavior of the ExpandingProximityIterator class when the expansion step is set to a
   * large value.
   */
  @Test
  public void testLargeExpansionStep() {
    ExpandingProximityIterator iterator =
        new ExpandingProximityIterator(drivers, clientPos, 5); // Large expansion step

    assertTrue(iterator.hasNext());
    assertEquals("John Doe", iterator.next().getFullName()); // Distance 2

    assertTrue(iterator.hasNext());
    assertEquals("Emily Johnson", iterator.next().getFullName()); // Distance 5

    assertTrue(iterator.hasNext());
    assertEquals("Michael Brown", iterator.next().getFullName()); // Distance 6

    assertTrue(iterator.hasNext());
    assertEquals("Jane Smith", iterator.next().getFullName()); // Distance 10

    assertFalse(iterator.hasNext()); // No more drivers
  }

  /**
   * Tests the behavior of the ExpandingProximityIterator class when it's expected to throw a
   * NoSuchElementException.
   */
  @Test(expected = NoSuchElementException.class)
  public void testNoSuchElementException() {
    ExpandingProximityIterator iterator = new ExpandingProximityIterator(drivers, clientPos, 2);

    iterator.next(); // Driver 1
    iterator.next(); // Driver 4
    iterator.next(); // Driver 3
    iterator.next(); // Driver 2

    iterator.next(); // This should throw NoSuchElementException
  }

  /**
   * Tests the behavior of the ExpandingProximityIterator class when the client's position is at the
   * exact boundary of the proximity range.
   */
  @Test
  public void testDriverAtExactBoundary() {
    Position boundaryPos = new PositionImpl(6, 4); // Distance 2, exactly on the boundary
    Vehicle boundaryVehicle = new VehicleImpl("Tesla", "Model 3", "999ZZZ", boundaryPos);
    Driver boundaryDriver = new DriverImpl("Boundary", "Driver", 5, boundaryVehicle);

    drivers.add(boundaryDriver); // Add the boundary driver to the pool

    ExpandingProximityIterator iterator = new ExpandingProximityIterator(drivers, clientPos, 2);
    assertTrue(iterator.hasNext());
    assertEquals(driver1, iterator.next()); // Driver 1 (distance 2)

    assertTrue(iterator.hasNext());
    assertEquals(boundaryDriver, iterator.next()); // Boundary driver (distance 2, on boundary)

    assertTrue(iterator.hasNext());
    assertEquals(driver4, iterator.next()); // Driver 4 (distance 5)

    assertTrue(iterator.hasNext());
    assertEquals(driver3, iterator.next()); // Driver 3 (distance 6)

    assertTrue(iterator.hasNext());
    assertEquals(driver2, iterator.next()); // Driver 2 (distance 10)

    assertFalse(iterator.hasNext()); // No more drivers
  }
}
