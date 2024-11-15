package com.comp301.a05driver;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This class implements an Iterator that iterates over a list of driver pools in a snake order
 * across the pools. The snake order starts from the first pool and goes to the last pool, then
 * reverses direction and goes back to the first pool, and so on.
 */
public class SnakeOrderAcrossPoolsIterator implements Iterator<Driver> {

  // Stores the list of iterators for each pool
  private final List<Iterator<Driver>> poolIterators;

  // Tracks the direction: true for first-to-last, false for last-to-first
  private boolean isForward;

  // Tracks the index of the current pool being processed
  private int currentPoolIndex;

  // Tracks the number of pools that still have drivers left
  private int remainingPools;

  /**
   * Constructor for SnakeOrderAcrossPoolsIterator.
   *
   * @param driverPools A list of driver pools, where each pool is an Iterable of Driver objects.
   */
  public SnakeOrderAcrossPoolsIterator(List<Iterable<Driver>> driverPools) {
    // Initialize pool iterators
    this.poolIterators = new ArrayList<>();

    // Add an iterator from each pool to the list of iterators
    for (Iterable<Driver> pool : driverPools) {
      Iterator<Driver> iterator = pool.iterator();

      // Only add the iterator of the pool that is not empty to skip initally empty pools
      if (iterator.hasNext() == true) {
        this.poolIterators.add(iterator);
      }
    }

    // Initialize instance fields
    this.isForward = true; // Start by going from first-to-last
    this.currentPoolIndex = 0; // Start at the first pool
    this.remainingPools = poolIterators.size(); // Initially, all non-empty pools are remaining
  }

  /**
   * Checks if there are more drivers to return.
   *
   * @return True if there are more drivers, false otherwise.
   */
  @Override
  public boolean hasNext() {
    // If no pools have drivers left, we're done
    if (this.remainingPools == 0) {
      return false;
    }

    // Otherwise, keep checking for the next available driver in the next pool
    return findNextAvailablePool();
  }

  /**
   * Returns the next driver in snake order across the pools, i.e. getting the first driver from
   * pool 0, then the first driver from pool 1, and so on until the last driver from the last pool,
   * then reversing the order and going back to the first driver from the last pool, and so on.
   *
   * @return The next valid Driver object.
   */
  @Override
  public Driver next() {
    // If there are no more drivers, throw an exception
    if (!hasNext()) {
      throw new NoSuchElementException("There are no more drivers left.");
    }

    // Get the iterator for the current pool and return the next driver
    Iterator<Driver> currentIterator = this.poolIterators.get(this.currentPoolIndex);
    Driver nextDriver = currentIterator.next();

    // If the current pool is now exhausted, mark it as null
    if (currentIterator.hasNext() == false) {
      // Mark the current pool as exhausted (null) and decrement the remaining pools count
      // to preserve the snake order traversal
      this.poolIterators.set(currentPoolIndex, null);
      this.remainingPools--;
    }

    // Move to the next pool in snake order
    moveToNextPool();

    // Return the next driver
    return nextDriver;
  }

  /**
   * Helper method to find the next available pool with drivers.
   *
   * @return True if an available pool was found, false if otherwise.
   */
  private boolean findNextAvailablePool() {
    // Track the number of pools we've checked
    int iterations = 0;

    // Loop through the pools to find the next available driver
    while (iterations < this.poolIterators.size()) {
      // Get the iterator for the current pool
      Iterator<Driver> currentIterator = this.poolIterators.get(this.currentPoolIndex);

      // If the current pool is valid and still has drivers, return true
      if (currentIterator != null && currentIterator.hasNext()) {
        return true;
      }

      // Move to the next pool
      moveToNextPool();

      // Increment the number of pools we've checked
      iterations++;
    }

    // If we exit the loop without finding any available drivers, return false
    return false;
  }

  /**
   * Moves to the next pool in the snake order according to the current direction (forward or
   * backward).
   */
  private void moveToNextPool() {
    // Loops until we find a valid pool or run out of pools to check
    // Using a do-while loop here because we need to check the current pool first before moving on
    // to the next one
    do {
      // If we're going forward, increment the index of the current pool
      if (this.isForward) {
        this.currentPoolIndex++;
        // If we reach the end, reverse direction and adjust the index
        if (this.currentPoolIndex >= this.poolIterators.size()) {
          this.isForward = false;
          this.currentPoolIndex = this.poolIterators.size() - 1;
        }
      } else {
        // If we're going backward, decrement the index of the current pool
        this.currentPoolIndex--;
        // If we reach the start, reverse direction and adjust the index again
        if (this.currentPoolIndex < 0) {
          this.isForward = true;
          this.currentPoolIndex = 0;
        }
      }
      // Repeat until we find a valid pool (not null) or when we have run out of pools
    } while (poolIterators.get(currentPoolIndex) == null && remainingPools > 0);
  }
}
