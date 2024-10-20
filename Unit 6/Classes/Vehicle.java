package Classes;
import Interfaces.VehicleInterface;
import java.util.ArrayList;
import MenuUtilities.Prompt;
import MenuUtilities.PromptException;

/**
 * Represents a generic vehicle with basic properties.
 */
public class Vehicle implements VehicleInterface{
  final static private ArrayList<Vehicle> ALL_VEHICLES = new ArrayList<Vehicle>();
  private String make;
  private String model;
  private int yearOfManufacture;

  /**
   * Gets the make of the vehicle.
   * @return The make of the vehicle.
   */
  public String getMake() {
    return make;
  }

  /**
   * Gets the model of the vehicle.
   * @return The model of the vehicle.
   */
  public String getModel() {
    return model;
  }

  /**
   * Gets the year of manufacture of the vehicle.
   * @return The year of manufacture.
   */
  public int getYearOfManufacture() {
    return yearOfManufacture;
  }

  /**
   * Sets the make of the vehicle based on user input.
   * @throws PromptException If there's an error during user input.
   */
  public void setMake() throws PromptException {
    while (true) {
      try {
        this.make = Prompt.getValidString("Enter the vehicle make");
        return;
      } catch (PromptException e) {
        Prompt.printPromptException(e);
      }
    }
  }

  /**
   * Sets the model of the vehicle based on user input.
   * @throws PromptException If there's an error during user input.
   */
  public void setModel() throws PromptException{
    while (true) {
      try {
        this.model = Prompt.getValidString("Enter the vehicle model");
        return;
      } catch (PromptException e) {
        Prompt.printPromptException(e);
      }
    }
  }

  /**
   * Sets the year of manufacture of the vehicle based on user input.
   * @throws PromptException If there's an error during user input.
   */
  public void setYearOfManufacture() throws PromptException {
    while (true) {
      try {
        this.yearOfManufacture = Prompt.getValidInt("Enter the year of manufacture");
        return;
      } catch (PromptException e) {
        Prompt.printPromptException(e);
      }
    }
  }

  /**
   * Gets all vehicles created in the system.
   * @return An ArrayList of all vehicles.
   */
  public static ArrayList<? extends Vehicle> getAllVehicles(){
    return ALL_VEHICLES;
  }

  /**
   * Adds the current vehicle to the list of all vehicles.
   */
  protected void addToAllVehicles(){
    ALL_VEHICLES.add(this);
  }

  /**
   * Builds a vehicle by setting its basic properties.
   * @throws PromptException If there's an error during user input.
   */
  public void buildVehicle() throws PromptException {
    setMake();
    setModel();
    setYearOfManufacture();
  }

  /**
   * Displays the details of the vehicle.
   */
  public void showVehicleDetails() {
    System.out.printf("\n%d %s %s", getYearOfManufacture(), getMake(), getModel());
  }
  
}
