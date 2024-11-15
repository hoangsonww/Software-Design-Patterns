package com.comp301.a05driver;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

/** This class tests the functionality of the ProximityIterator class. */
public class ProximityIteratorTest {

  /**
   * Default constructor for the ProximityIteratorTest class. This constructor is empty because the
   * test environment is set up in the setUp() method.
   */
  public ProximityIteratorTest() {}

  private Driver driver1 =
      new DriverImpl(
          "John", "Doe", 1, new VehicleImpl("Toyota", "Camry", "123ABC", new PositionImpl(2, 2)));
  private Driver driver2 =
      new DriverImpl(
          "Jane", "Smith", 2, new VehicleImpl("Honda", "Civic", "456DEF", new PositionImpl(4, 5)));
  private Driver driver3 =
      new DriverImpl(
          "Emily",
          "Johnson",
          3,
          new VehicleImpl("Ford", "Mustang", "789GHI", new PositionImpl(6, 6)));
  private Driver driver4 =
      new DriverImpl(
          "Michael",
          "Brown",
          4,
          new VehicleImpl("Chevy", "Malibu", "321XYZ", new PositionImpl(10, 10)));
  private Driver driver5 =
      new DriverImpl(
          "Sarah",
          "Connor",
          5,
          new VehicleImpl("Nissan", "Altima", "654JKL", new PositionImpl(15, 15)));

  /**
   * Tests the basic functionality of the ProximityIterator class, including next() and hasNext()
   */
  @Test
  public void testMultipleDriversAtExactProximityBoundary() {
    Position clientPosition = new PositionImpl(5, 5);
    int proximityRange = 5; // Test with drivers within range 5

    List<Driver> drivers = Arrays.asList(driver1, driver2, driver3, driver4, driver5);
    ProximityIterator iterator = new ProximityIterator(drivers, clientPosition, proximityRange);

    // Correct order based on Manhattan distance:
    // Driver 1 (John Doe) - Distance: 6 (OUT OF RANGE)
    // Driver 2 (Jane Smith) - Distance: 1
    // Driver 3 (Emily Johnson) - Distance: 2
    // Driver 4 (Michael Brown) - Distance: 10 (OUT OF RANGE)
    // Driver 5 (Sarah Connor) - Distance: 20 (OUT OF RANGE)

    // Correct expected results:
    assertTrue(iterator.hasNext());
    assertEquals("Jane Smith", iterator.next().getFullName()); // Distance to client: 1
    assertTrue(iterator.hasNext());
    assertEquals("Emily Johnson", iterator.next().getFullName()); // Distance to client: 2

    // Drivers 1, 4, and 5 are out of the 5-unit range, so no more drivers
    assertFalse(iterator.hasNext());
  }

  /**
   * Tests the basic functionality of the ProximityIterator class, including next() and hasNext(),
   * when some drivers are out of the proximity range.
   */
  @Test
  public void testDriversWithinProximity() {
    Position clientPosition = new PositionImpl(5, 5);
    int proximityRange = 5; // Only drivers within 5 units of Manhattan distance should be returned

    List<Driver> drivers = Arrays.asList(driver1, driver2, driver3, driver4, driver5);
    ProximityIterator iterator = new ProximityIterator(drivers, clientPosition, proximityRange);

    // Correct order based on Manhattan distance:
    // Driver 1 (John Doe) - Distance: 6 (OUT OF RANGE)
    // Driver 2 (Jane Smith) - Distance: 1
    // Driver 3 (Emily Johnson) - Distance: 2
    // Driver 4 (Michael Brown) - Distance: 10 (OUT OF RANGE)
    // Driver 5 (Sarah Connor) - Distance: 20 (OUT OF RANGE)

    // Correct expected results:
    assertTrue(iterator.hasNext());
    assertEquals("Jane Smith", iterator.next().getFullName()); // Distance to client: 1
    assertTrue(iterator.hasNext());
    assertEquals("Emily Johnson", iterator.next().getFullName()); // Distance to client: 2

    // Drivers 1, 4, and 5 are out of the 5-unit range
    assertFalse(iterator.hasNext());
  }

  /**
   * Tests the basic functionality of the ProximityIterator class, including next() and hasNext(),
   * when all drivers are out of the proximity range.
   */
  @Test
  public void testNoDriversWithinProximity() {
    Position clientPosition = new PositionImpl(0, 0);
    int proximityRange = 2; // Only drivers within 2 units of Manhattan distance

    List<Driver> drivers = Arrays.asList(driver1, driver2, driver3, driver4, driver5);
    ProximityIterator iterator = new ProximityIterator(drivers, clientPosition, proximityRange);

    // No drivers should be within the range of 2 units from (0, 0)
    assertFalse(iterator.hasNext());
  }

  /**
   * Tests the basic functionality of the ProximityIterator class, including next() and hasNext(),
   * when all drivers are within the proximity range.
   */
  @Test
  public void testAllDriversWithinProximity() {
    Position clientPosition = new PositionImpl(0, 0);
    int proximityRange = 50; // All drivers should be within this large range

    List<Driver> drivers = Arrays.asList(driver1, driver2, driver3, driver4, driver5);
    ProximityIterator iterator = new ProximityIterator(drivers, clientPosition, proximityRange);

    // All drivers are within the range, so they should be returned
    assertTrue(iterator.hasNext());
    assertEquals("John Doe", iterator.next().getFullName());
    assertTrue(iterator.hasNext());
    assertEquals("Jane Smith", iterator.next().getFullName());
    assertTrue(iterator.hasNext());
    assertEquals("Emily Johnson", iterator.next().getFullName());
    assertTrue(iterator.hasNext());
    assertEquals("Michael Brown", iterator.next().getFullName());
    assertTrue(iterator.hasNext());
    assertEquals("Sarah Connor", iterator.next().getFullName());

    assertFalse(iterator.hasNext()); // No more drivers left
  }

  /** Tests the behavior of the ProximityIterator class when the driver pool is empty. */
  @Test
  public void testEmptyDriverPool() {
    Position clientPosition = new PositionImpl(5, 5);
    int proximityRange = 5;

    List<Driver> drivers = Collections.emptyList(); // No drivers in the pool
    ProximityIterator iterator = new ProximityIterator(drivers, clientPosition, proximityRange);

    // Since the pool is empty, hasNext should return false
    assertFalse(iterator.hasNext());
  }

  /**
   * Tests the behavior of the ProximityIterator class when there are no drivers in the pool and
   * whether the method throws a NoSuchElementException when next() is called.
   */
  @Test(expected = NoSuchElementException.class)
  public void testNextThrowsExceptionWhenNoDriversAvailable() {
    Position clientPosition = new PositionImpl(5, 5);
    int proximityRange = 5;

    List<Driver> drivers = Collections.emptyList(); // No drivers in the pool
    ProximityIterator iterator = new ProximityIterator(drivers, clientPosition, proximityRange);

    // Call next() when there are no drivers should throw NoSuchElementException
    iterator.next();
  }

  /**
   * Tests the behavior of the ProximityIterator class when there is only one driver in the pool and
   * the driver is within the proximity range.
   */
  @Test
  public void testOneDriverWithinProximity() {
    Position clientPosition = new PositionImpl(10, 10);
    int proximityRange = 0; // Only drivers exactly at the client's position should be returned

    List<Driver> drivers = Arrays.asList(driver4); // Driver 4 is exactly at (10, 10)
    ProximityIterator iterator = new ProximityIterator(drivers, clientPosition, proximityRange);

    // Only driver4 should be returned
    assertTrue(iterator.hasNext());
    assertEquals("Michael Brown", iterator.next().getFullName());
    assertFalse(iterator.hasNext());
  }
}
