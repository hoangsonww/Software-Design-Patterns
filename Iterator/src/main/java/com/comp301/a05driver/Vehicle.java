package com.comp301.a05driver;

/*
 * Vehicle
 * Represents a vehicle in our system.
 *
 * getMake()
 *    Retrieves the make of the vehicle.
 *
 * getModel()
 *    Retrieves the model of the vehicle.
 *
 * getPlate()
 *    Retrieves the license plate of the vehicle.
 *
 * getMileage()
 *    Retrieves the total distance the vehicle has traveled
 *    up to now. Think of this like its "odometer".
 *
 * getPosition()
 *    Retrieves the current position of the vehicle.
 *
 * moveTo(Position p)
 *    Updates the mileage of the vehicle by adding the Manhattan
 *    distance between the vehicle's current position and the
 *    position p passed in as a parameter. Then updates the
 *    vehicle's current position to be p.
 */

/** Represents a vehicle in our system. */
public interface Vehicle {

  /**
   * Retrieves the make of the vehicle.
   *
   * @return The make of the vehicle
   */
  String getMake();

  /**
   * Retrieves the model of the vehicle.
   *
   * @return The model of the vehicle
   */
  String getModel();

  /**
   * Retrieves the license plate of the vehicle.
   *
   * @return The license plate of the vehicle
   */
  String getPlate();

  /**
   * Retrieves the total distance the vehicle has traveled up to now. Think of this like its
   * "odometer".
   *
   * @return The total distance the vehicle has traveled
   */
  int getMileage();

  /**
   * Retrieves the current position of the vehicle.
   *
   * @return The current position of the vehicle
   */
  Position getPosition();

  /**
   * Updates the mileage of the vehicle by adding the Manhattan distance between the vehicle's
   * current position and the position p passed in as a parameter. Then updates the vehicle's
   * current position to be p.
   *
   * @param p The position to move the vehicle to
   */
  void moveToPosition(Position p);
}
