package lib;
import Classes.*;


/**
 * Enum representing different types of vehicles.
 */
public enum VehicleType {
  CAR(Car.class),
  MOTORCYCLE(Motorcycle.class),
  TRUCK(Truck.class);

  private final Class<? extends Vehicle> vehicleClass;

  /**
   * Constructs a VehicleType with the associated vehicle class.
   * @param vehicleClass The class associated with this vehicle type.
   */
  VehicleType(Class<? extends Vehicle> vehicleClass) {
    this.vehicleClass = vehicleClass;
  }

  /**
   * Gets the class associated with this vehicle type.
   * @return The Class object for this vehicle type.
   */
  public Class<? extends Vehicle> getVehicleClass() {
    return vehicleClass;
  }
}