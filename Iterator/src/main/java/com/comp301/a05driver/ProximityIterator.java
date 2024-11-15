package com.comp301.a05driver;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements an Iterator that iterates over a pool of drivers within a proximity range.
 */
public class ProximityIterator implements Iterator<Driver> {

  // Iterator for the driver pool
  private Iterator<Driver> driverIterator;

  // Stores the client's position
  private Position clientPosition;

  // Stores the proximity range
  private int proximityRange;

  // Keeps track of the next driver within the proximity range
  private Driver nextDriver;

  /**
   * Constructor for the ProximityIterator class.
   *
   * @param driverPool The pool of available Driver objects
   * @param clientPosition The client's static position
   * @param proximityRange The proximity range to search for drivers - used when deciding whether to
   *     include a Driver object in the iterator
   */
  public ProximityIterator(
      Iterable<Driver> driverPool, Position clientPosition, int proximityRange) {
    // Check for invalid arguments - driverPool and clientPosition cannot be null
    if (driverPool == null || clientPosition == null) {
      throw new IllegalArgumentException("driverPool and clientPosition cannot be null");
    }

    // Initialize the instance fields
    this.driverIterator = driverPool.iterator();
    this.clientPosition = clientPosition;
    this.proximityRange = proximityRange;
    this.nextDriver = null;
  }

  /**
   * Checks if there is a valid driver within the proximity range.
   *
   * @return True if there is a valid driver within the proximity range, false if otherwise
   */
  @Override
  public boolean hasNext() {
    // If there's already a valid next driver, return true
    if (this.nextDriver != null) {
      return true;
    }

    // Loop to search for the next valid driver within proximity
    while (this.driverIterator.hasNext() == true) {
      // Get the next driver
      Driver currentDriver = this.driverIterator.next();

      // Get the vehicle position of the current driver
      Position vehiclePosition = currentDriver.getVehicle().getPosition();

      // Calculate the Manhattan distance between the vehicle and the client
      int distance = vehiclePosition.getManhattanDistanceTo(this.clientPosition);

      // Check if this driver is within the proximity range (less than or equal to the range)
      if (distance <= this.proximityRange) {
        // Store the driver and return true since we have found a valid driver
        this.nextDriver = currentDriver;
        return true;
      }
    }

    // If no more valid drivers are found (after the loop finishes), return false
    return false;
  }

  /**
   * Returns the next valid driver within the proximity range.
   *
   * @return The next valid driver within the proximity range
   * @throws NoSuchElementException If there are no more drivers in the proximity range
   */
  @Override
  public Driver next() {
    // Ensure that there is a next valid driver. If not, throw an exception
    if (hasNext() == false) {
      throw new NoSuchElementException(
          "There are no more drivers in the specified proximity range.");
    }

    // Return the next valid driver
    Driver driverToReturn = this.nextDriver;

    // Reset the nextDriver field to null so that hasNext() can continue to search for the next
    // valid driver
    this.nextDriver = null;

    return driverToReturn;
  }
}
