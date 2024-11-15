package com.comp301.a05driver;

/*
 * Driver
 * Represents a driver associated with a vehicle.
 *
 * getFirstName()
 *    Retrieves first name of driver.
 *
 * getLastName()
 *    Retrieves last name of driver.
 *
 * getFullName()
 *    Retrieves full name of driver. This should be the first name followed
 *    a single space followed by the last name.
 *
 * getID()
 *    Retrieves the ID number of the driver.
 *
 * getVehicle()
 *    Retrieves the Vehicle object associated with the driver.
 *
 * setVehicle(Vehicle v)
 *    Setter for the vehicle associated with the driver.
 */

/** Represents a driver associated with a vehicle. */
public interface Driver {

  /**
   * Retrieves first name of driver.
   *
   * @return first name of driver
   */
  String getFirstName();

  /**
   * Retrieves last name of driver.
   *
   * @return last name of driver
   */
  String getLastName();

  /**
   * Retrieves full name of driver. This should be the first name followed by a single space
   * followed by the last name.
   *
   * @return full name of driver
   */
  default String getFullName() {
    return getFirstName() + " " + getLastName();
  }

  /**
   * Retrieves the ID number of the driver.
   *
   * @return ID number of the driver
   */
  int getID();

  /**
   * Retrieves the Vehicle object associated with the driver.
   *
   * @return Vehicle object associated with the driver
   */
  Vehicle getVehicle();

  /**
   * Setter for the vehicle associated with the driver.
   *
   * @param v Vehicle object to associate with the driver
   */
  void setVehicle(Vehicle v);
}
