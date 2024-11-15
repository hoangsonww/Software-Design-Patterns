package com.comp301.a05driver;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements an Iterator that iterates over a pool of drivers within an expanding
 * proximity range. The proximity range expands by a fixed (specified) step size until a driver is
 * found.
 */
public class ExpandingProximityIterator implements Iterator<Driver> {

  // Stores the pool of drivers
  private final Iterable<Driver> driverPool;

  // Stores the client's position
  private final Position clientPosition;

  // Stores the step size for expanding the proximity range
  private final int expansionStep;

  // Iterator for the driver pool
  private Iterator<Driver> driverIterator;

  // Stores the current proximity range (lower bound is exclusive)
  private int currentLowerBound;

  // Stores the current proximity range (upper bound is inclusive)
  private int currentUpperBound;

  // Stores the next driver within the expanding proximity range
  private Driver nextDriver;

  // Stores the number of drivers returned so far
  private int driversReturned;

  // Stores the total number of drivers in the pool
  private final int totalDrivers;

  /**
   * Constructor for ExpandingProximityIterator class.
   *
   * @param driverPool The pool of available Driver objects.
   * @param clientPosition The client's static position.
   * @param expansionStep The step size by which the proximity range expands.
   */
  public ExpandingProximityIterator(
      Iterable<Driver> driverPool, Position clientPosition, int expansionStep) {
    // Check for invalid arguments - driverPool and clientPosition cannot be null, and expansionStep
    // must be positive
    if (driverPool == null || clientPosition == null || expansionStep <= 0) {
      throw new IllegalArgumentException("Invalid arguments.");
    }

    // Initialize the instance fields
    this.driverPool = driverPool;
    this.clientPosition = clientPosition;
    this.expansionStep = expansionStep;

    // Ensures we start with the lower bound at 0 (exclusive), meaning the range starts at 1
    this.currentLowerBound = 0;
    // Initial upper bound is 1, meaning the range is initially (0, 1]
    this.currentUpperBound = 1;

    // Initialize the iterator and other instance fields
    this.driverIterator = driverPool.iterator();
    this.nextDriver = null;
    this.driversReturned = 0;

    // Get & count the total number of drivers in the pool
    this.totalDrivers = getDriverPoolSize(driverPool);
  }

  /**
   * Checks if there is a next driver within the expanding proximity range.
   *
   * @return True if there is a next driver, false otherwise.
   */
  @Override
  public boolean hasNext() {
    // If there's already a valid next driver, return true
    if (this.nextDriver != null) {
      return true;
    }

    // Look for the next driver within the current proximity range
    findNextDriver();

    // Return true if a driver is found, false otherwise
    if (this.nextDriver == null) {
      // If no drivers found, return false
      return false;
    } else {
      // If a driver is found, return true
      return true;
    }
  }

  /**
   * Returns the next valid driver within the expanding proximity range.
   *
   * @return The next valid Driver object.
   */
  @Override
  public Driver next() {
    // Check if there is a next driver available - if not, throw NoSuchElementException.
    if (hasNext() == false) {
      throw new NoSuchElementException("No more drivers available.");
    }

    // Return the next driver
    Driver toReturn = this.nextDriver;

    // Reset the nextDriver to null so that hasNext() can continue to search for the next driver
    this.nextDriver = null;

    return toReturn;
  }

  /** Helper method to find the next driver within the expanding proximity range. */
  private void findNextDriver() {
    // Loop until a driver is found or when all drivers are returned
    while (this.nextDriver == null && this.driversReturned < this.totalDrivers) {
      // Loop through the drivers using the encapsulated iterator
      while (this.driverIterator.hasNext() == true) {
        // Get the current driver
        Driver currentDriver = this.driverIterator.next();

        // Get the current position of the current driver
        Position currentPosition = currentDriver.getVehicle().getPosition();

        // Calculate the Manhattan distance between the vehicle and the client
        int distance = currentPosition.getManhattanDistanceTo(this.clientPosition);

        // Check if the driver is within the current range: (currentLowerBound, currentUpperBound]
        if (distance > this.currentLowerBound && distance <= this.currentUpperBound) {
          // Store the driver and increment the number of drivers returned
          this.nextDriver = currentDriver;
          this.driversReturned++;

          // Exit the loop since we found a valid driver
          return;
        }
      }

      // If no drivers found in the current range, expand the range and reset the iterator
      expandSearchRange();
    }
  }

  /**
   * Helper method to expand the proximity range by the expansion step size and reset the iterator
   * to loop over the drivers again. The steps are expanded as follows - The lower bound is updated
   * to the current upper bound - The upper bound is updated by adding the expansion step to it, so
   * that the new range is (currentUpperBound, currentUpperBound + expansionStep].
   */
  private void expandSearchRange() {
    // Update the new lower bound to the current upper bound
    this.currentLowerBound = this.currentUpperBound;
    // The upper bound is exclusive, so we add the expansion step to it
    this.currentUpperBound += this.expansionStep;

    // Reset the iterator to loop over the drivers again
    this.driverIterator = this.driverPool.iterator();
  }

  /**
   * Helper method to count the total number of drivers in the pool.
   *
   * @param driverPool The iterable driver pool.
   * @return The number of drivers in the pool.
   */
  private int getDriverPoolSize(Iterable<Driver> driverPool) {
    // Store the size of the driver pool
    int size = 0;

    // Loop through the driver pool to count the number of drivers in it
    for (Driver driver : driverPool) {
      size++;
    }

    // Return the total number of drivers in the pool
    return size;
  }
}
