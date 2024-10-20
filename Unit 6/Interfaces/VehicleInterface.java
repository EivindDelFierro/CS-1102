package Interfaces;
import MenuUtilities.PromptException;

/**
 * Represents the basic properties and behaviors of a vehicle.
 */
public interface VehicleInterface {
  /**
   * Gets the make of the vehicle.
   * @return The make of the vehicle as a String.
   */
  String getMake();
  /**
   * Gets the model of the vehicle.
   * @return The model of the vehicle as a String.
   */
  String getModel();
  /**
   * Gets the year of manufacture of the vehicle.
   * @return The year of manufacture as an int.
   */
  int getYearOfManufacture();
  /**
   * Sets the make of the vehicle.
   * @throws PromptException If there's an error during user input.
   */
  void setMake() throws PromptException;
  /**
   * Sets the model of the vehicle.
   * @throws PromptException If there's an error during user input.
   */
  void setModel() throws PromptException;
  /**
   * Sets the year of manufacture of the vehicle.
   * @throws PromptException If there's an error during user input.
   */
  void setYearOfManufacture() throws PromptException;
}
