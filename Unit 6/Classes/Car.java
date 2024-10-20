package Classes;
import Interfaces.CarVehicle;
import java.util.ArrayList;
import MenuUtilities.*;

/**
 * Represents a car, extending the Vehicle class and implementing CarVehicle interface.
 */
public class Car extends Vehicle implements CarVehicle{
  final private static ArrayList<Car> ALL_CARS = new ArrayList<Car>();
  private int numberOfDoors;
  private String fuelType;

  /**
   * Constructs a new Car object.
   * @throws PromptException If there's an error during user input.
   */
  public Car() throws PromptException {
    buildVehicle();
    super.addToAllVehicles();
  }

  /**
   * Builds a car by setting its properties.
   * @throws PromptException If there's an error during user input.
   */
  @Override
  public void buildVehicle() throws PromptException {
    super.buildVehicle();
    setFuelType();
    setNumberOfDoors();
    addToAllCars();
  }

  /**
   * Displays the details of the car.
   */
  @Override
  public void showVehicleDetails() {
    final String[] CAR_PROPERTIES = {"Fuel Type", "Number of Doors"};
    final String[] CAR_PROPERTY_VALUES = {this.getFuelType(), "" + this.getNumberOfDoors()};
    
    super.showVehicleDetails();

    for (int i = 0; i < CAR_PROPERTIES.length; i++) {
      System.out.printf("\n - %s: %s", CAR_PROPERTIES[i], CAR_PROPERTY_VALUES[i]);
    }
  }

  /**
   * Gets all cars created in the system.
   * @return An ArrayList of all cars.
   */
  public static ArrayList<? extends Vehicle> getAllVehicles() {
    return ALL_CARS;
  }

  /**
   * Gets the fuel type of the car.
   * @return The fuel type.
   */
  public String getFuelType() {
    return fuelType;
  }

  /**
   * Gets the number of doors of the car.
   * @return The number of doors.
   */
  public int getNumberOfDoors() {
    return numberOfDoors;
  }

  /**
   * Sets the fuel type of the car based on user input.
   * @throws PromptException If there's an error during user input.
   */
  public void setFuelType() throws PromptException {
     this.fuelType = selectFuelTypeMenu();
  }

  /**
   * Sets the number of doors of the car based on user input.
   * @throws PromptException If there's an error during user input.
   */
  public void setNumberOfDoors() throws PromptException {
    while (true) {
      try {
        final int INPUT = Prompt.getValidInt("Enter the number of doors");
        if (INPUT < 0) {
          System.out.println("Enter a value of 0 or greater");
        } else {
          this.numberOfDoors = INPUT;
          break;
        }
      } catch (PromptException e) {
        Prompt.printPromptException(e);
      }
    }

  }

  /**
   * Gets all cars created in the system.
   * @return An ArrayList of all cars.
   */
  public static ArrayList<Car> getAllCars(){
    return ALL_CARS;
  }

  /**
   * Adds the current car to the list of all cars.
   */
  private void addToAllCars(){
    ALL_CARS.add(this);
  }

  /**
   * Displays a menu for selecting the fuel type.
   * @return The selected fuel type.
   * @throws PromptException If there's an error during user input.
   */
  private String selectFuelTypeMenu() throws PromptException {
    final String[] FUEL_TYPES = {"Petrol", "Diesel", "Electric"};
    final MenuInterface FUEL_TYPE_MENU = new MenuInterface(FUEL_TYPES);
    System.out.println();
    while (true) {
      try {
        final int SELECTION = FUEL_TYPE_MENU.promptMenuSelection(false);
        return FUEL_TYPES[SELECTION - 1];
      } catch (PromptException e) {
        Prompt.printPromptException(e);
      }
    }
  }
}
