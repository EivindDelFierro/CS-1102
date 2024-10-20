package Interfaces;
import MenuUtilities.PromptException;

/**
 * Represents the specific properties and behaviors of a car.
 */
public interface CarVehicle extends VehicleInterface{
  /**
   * Gets the fuel type of the car.
   * @return The fuel type as a String.
   */
  String getFuelType();

  /**
   * Gets the number of doors of the car.
   * @return The number of doors as an int.
   */
  int getNumberOfDoors();

  /**
   * Sets the fuel type of the car.
   * @throws PromptException If there's an error during user input.
   */
  void setFuelType() throws PromptException;
  
  /**
   * Sets the number of doors of the car.
   * @throws PromptException If there's an error during user input.
   */
  void setNumberOfDoors() throws PromptException;
}
