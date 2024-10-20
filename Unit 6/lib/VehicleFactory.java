package lib;
import Classes.*;
import MenuUtilities.PromptException;

/**
 * Factory class for creating different types of vehicles.
 */
public class VehicleFactory {
  /**
     * Creates a new vehicle of the specified type.
     * @param type The type of vehicle to create.
     * @return A new Vehicle object of the specified type.
     * @throws PromptException If there's an error during user input.
     * @throws IllegalArgumentException If an unknown vehicle type is provided.
     */
  public static Vehicle createVehicle(VehicleType type) throws PromptException {
    switch (type) {
      case CAR: 
        return new Car();
      case MOTORCYCLE: 
        return new Motorcycle();
      case TRUCK: 
        return new Truck();
      default: 
        throw new IllegalArgumentException("Unknown vehicle type");
    }
  }
}