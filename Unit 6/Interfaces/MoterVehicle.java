package Interfaces;
import MenuUtilities.PromptException;

/**
 * Represents the specific properties and behaviors of a motorcycle.
 */
public interface MoterVehicle extends VehicleInterface {
  /**
   * Gets the number of wheels of the motorcycle.
   * @return The number of wheels as an int.
   */
  int getNumberOfWheels();
  
  /**
   * Gets the type of the motorcycle.
   * @return The type of motorcycle as a String.
   */
  String getTypeOfMotorcycle();

  /**
   * Sets the number of wheels of the motorcycle.
   * @throws PromptException If there's an error during user input.
   */
  void setNumberOfWheels() throws PromptException;

  /**
   * Sets the type of the motorcycle.
   * @throws PromptException If there's an error during user input.
   */
  void setTypeOfMotorcycle() throws PromptException;
}
