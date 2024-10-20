package Interfaces;
import MenuUtilities.PromptException;

/**
 * Represents the specific properties and behaviors of a truck.
 */
public interface TruckVehicle extends VehicleInterface {
  /**
   * Gets the cargo capacity of the truck.
   * @return The cargo capacity as an int.
   */
  int getCargoCapacity();

  /**
   * Gets the transmission type of the truck.
   * @return The transmission type as a String.
   */
  String getTransmissionType();

  /**
   * Sets the cargo capacity of the truck.
   * @throws PromptException If there's an error during user input.
   */
  void setCargoCapacity() throws PromptException;

  /**
   * Sets the transmission type of the truck.
   * @throws PromptException If there's an error during user input.
   */
  void setTransmissionType() throws PromptException;
}
