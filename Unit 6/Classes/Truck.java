package Classes;
import Interfaces.TruckVehicle;
import MenuUtilities.*;
import java.util.ArrayList;

/**
 * Represents a truck, extending the Vehicle class and implementing TruckVehicle interface.
 */
public class Truck extends Vehicle implements TruckVehicle{
  final private static ArrayList<Truck> ALL_TRUCKS = new ArrayList<Truck>();
  private int cargoCapacity;
  private String transmissionType;

  /**
   * Constructs a new Truck object.
   * @throws PromptException If there's an error during user input.
   */
  public Truck() throws PromptException {
    buildVehicle();
    super.addToAllVehicles();
  }

  /**
   * Builds a truck by setting its properties.
   * @throws PromptException If there's an error during user input.
   */
  @Override
  public void buildVehicle() throws PromptException {
    super.buildVehicle();
    setCargoCapacity();
    setTransmissionType();
    addToAllTrucks();
  }

  /**
   * Displays the details of the truck.
   */
  @Override
  public void showVehicleDetails() {
    final String[] TRUCK_PROPERTIES = {"Transmission", "Cargo Capacity"};
    final String[] TRUCK_PROPERTY_VALUES = {this.getTransmissionType(), "" + this.getCargoCapacity()};
    
    super.showVehicleDetails();
    
    for (int i = 0; i < TRUCK_PROPERTIES.length; i++) {
      System.out.printf("\n - %s: %s", TRUCK_PROPERTIES[i], TRUCK_PROPERTY_VALUES[i]);
    }
  }

  /**
   * Gets all trucks created in the system.
   * @return An ArrayList of all trucks.
   */
  public static ArrayList<? extends Vehicle> getAllVehicles() {
    return ALL_TRUCKS;
  }

  /**
   * Gets the cargo capacity of the truck.
   * @return The cargo capacity.
   */
  public int getCargoCapacity() {
    return cargoCapacity;
  }

  /**
   * Gets the transmission type of the truck.
   * @return The transmission type.
   */
  public String getTransmissionType() {
    return transmissionType;
  }

  /**
   * Sets the cargo capacity of the truck based on user input.
   * @throws PromptException If there's an error during user input.
   */
  public void setCargoCapacity() throws PromptException {
    while (true) {
      try {
        final int INPUT = Prompt.getValidInt("Enter the cargo capacity (tons)");
        if (INPUT < 0) {
          System.out.println("Must have a capacity of 0 or greater");
          continue;
        } else {
          this.cargoCapacity = INPUT;
          return;
        }
      } catch (PromptException e) {
        Prompt.printPromptException(e);
      }
    }
  }

  /**
   * Sets the transmission type of the truck based on user input.
   * @throws PromptException If there's an error during user input.
   */
  public void setTransmissionType() throws PromptException {
    this.transmissionType = selectTransmissionTypeMenu();
  }

  /**
   * Adds the current truck to the list of all trucks.
   */
  private void addToAllTrucks(){
    ALL_TRUCKS.add(this);
  }

  /**
   * Displays a menu for selecting the transmission type.
   * @return The selected transmission type.
   * @throws PromptException If there's an error during user input.
   */
  private String selectTransmissionTypeMenu() throws PromptException {
    final String[] TRANSMISSION_TYPES = {"Manual", "Automatic"};
    final MenuInterface TRANSMISSION_TYPE_MENU = new MenuInterface(TRANSMISSION_TYPES);
    System.out.println();

    while (true) {
      final int SELECTION = TRANSMISSION_TYPE_MENU.promptMenuSelection(false);
      return TRANSMISSION_TYPES[SELECTION - 1];
    }
  }
}
