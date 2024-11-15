package com.comp301.a05driver;

/** Represents a vehicle that can be driven by a driver. */
public class VehicleImpl implements Vehicle {

  private String _make;
  private String _model;
  private String _plate;
  private int _mileage;
  private Position _position;

  /**
   * Constructor for the VehicleImpl class.
   *
   * @param make The make of the vehicle
   * @param model The model of the vehicle
   * @param plate The license plate of the vehicle
   * @param position The current position of the vehicle
   */
  public VehicleImpl(String make, String model, String plate, Position position) {
    if (make == null) {
      throw new RuntimeException("make is null");
    }
    if (model == null) {
      throw new RuntimeException("model is null");
    }
    if (plate == null) {
      throw new RuntimeException("plate is null");
    }
    if (position == null) {
      throw new RuntimeException("position is null");
    }

    _make = make;
    _model = model;
    _plate = plate;
    _position = position;

    _mileage = 0;
  }

  /**
   * Retrieves the make of the vehicle.
   *
   * @return The make of the vehicle
   */
  @Override
  public String getMake() {
    return _make;
  }

  /**
   * Retrieves the model of the vehicle.
   *
   * @return The model of the vehicle
   */
  @Override
  public String getModel() {
    return _model;
  }

  /**
   * Retrieves the license plate of the vehicle.
   *
   * @return The license plate of the vehicle
   */
  @Override
  public String getPlate() {
    return _plate;
  }

  /**
   * Retrieves the total distance the vehicle has traveled up to now. Think of this like its
   * "odometer".
   *
   * @return The total distance the vehicle has traveled
   */
  @Override
  public int getMileage() {
    return _mileage;
  }

  /**
   * Retrieves the current position of the vehicle.
   *
   * @return The current position of the vehicle
   */
  @Override
  public Position getPosition() {
    return _position;
  }

  /**
   * Updates the mileage of the vehicle by adding the Manhattan distance between the vehicle's
   * current position and the position p passed in as a parameter. Then updates the vehicle's
   * current position to be p.
   *
   * @param p The new position of the vehicle
   */
  @Override
  public void moveToPosition(Position p) {
    if (p == null) {
      throw new RuntimeException("New vehicle position is null");
    }

    _mileage += _position.getManhattanDistanceTo(p);
    _position = p;
  }
}
