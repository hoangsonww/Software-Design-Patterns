package com.comp301.a05driver;

/** Represents a driver associated with a vehicle. */
public class DriverImpl implements Driver {

  private String _first;
  private String _last;
  private int _id;
  private Vehicle _vehicle;

  /**
   * Constructor for the DriverImpl class.
   *
   * @param first The first name of the driver
   * @param last The last name of the driver
   * @param id The ID number of the driver
   * @param vehicle The Vehicle object associated with the driver
   */
  public DriverImpl(String first, String last, int id, Vehicle vehicle) {
    if (first == null) {
      throw new RuntimeException("Null first name");
    }
    if (last == null) {
      throw new RuntimeException("Null last name");
    }
    if (vehicle == null) {
      throw new RuntimeException("Null vehicle");
    }

    _first = first;
    _last = last;
    _id = id;
    _vehicle = vehicle;
  }

  /**
   * Retrieves first name of driver.
   *
   * @return first name of driver
   */
  @Override
  public String getFirstName() {
    return _first;
  }

  /**
   * Retrieves last name of driver.
   *
   * @return last name of driver
   */
  @Override
  public String getLastName() {
    return _last;
  }

  /**
   * Retrieves the ID number of the driver.
   *
   * @return ID number of the driver
   */
  @Override
  public int getID() {
    return _id;
  }

  /**
   * Retrieves the Vehicle object associated with the driver.
   *
   * @return Vehicle object associated with the driver
   */
  @Override
  public Vehicle getVehicle() {
    return _vehicle;
  }

  /**
   * Setter for the vehicle associated with the driver.
   *
   * @param v Vehicle object to associate with the driver
   */
  @Override
  public void setVehicle(Vehicle v) {
    if (v == null) {
      throw new RuntimeException("Null vehicle");
    }
    _vehicle = v;
  }
}
