package Classes;
import Interfaces.MoterVehicle;
import java.util.ArrayList;
import MenuUtilities.*;

/**
 * Represents a motorcycle, extending the Vehicle class and implementing MoterVehicle interface.
 */
public class Motorcycle extends Vehicle implements MoterVehicle{
  final private static ArrayList<Motorcycle> ALL_MOTORCYCLES = new ArrayList<Motorcycle>();
  private int numberOfWheels;
  private String typeOfMotorcycle;

  /**
   * Constructs a new Motorcycle object.
   * @throws PromptException If there's an error during user input.
   */
  public Motorcycle() throws PromptException {
    buildVehicle();
    super.addToAllVehicles();
  }

  /**
   * Builds a motorcycle by setting its properties.
   * @throws PromptException If there's an error during user input.
   */
  @Override
  public void buildVehicle() throws PromptException {
    super.buildVehicle();
    setNumberOfWheels();
    setTypeOfMotorcycle();
    addToAllMotorcycles();
  }

  /**
   * Displays the details of the motorcycle.
   */
  @Override
  public void showVehicleDetails() {
    final String[] MOTORCYCLE_PROPERTIES = {"Motorcycle Type", "Number of Wheels"};
    final String[] MOTORCYCLE_PROPERTY_VALUES = {this.getTypeOfMotorcycle(), "" + this.getNumberOfWheels()};
    
    super.showVehicleDetails();

    for (int i = 0; i < MOTORCYCLE_PROPERTIES.length; i++) {
      System.out.printf("\n - %s: %s", MOTORCYCLE_PROPERTIES[i], MOTORCYCLE_PROPERTY_VALUES[i]);
    }
  }

  /**
   * Gets all motorcycles created in the system.
   * @return An ArrayList of all motorcycles.
   */
  public static ArrayList<? extends Vehicle> getAllVehicles() {
    return ALL_MOTORCYCLES;
  }

  /**
   * Gets the number of wheels of the motorcycle.
   * @return The number of wheels.
   */
  public int getNumberOfWheels() {
    return numberOfWheels;
  }

  /**
   * Gets the type of the motorcycle.
   * @return The type of motorcycle.
   */
  public String getTypeOfMotorcycle() {
    return typeOfMotorcycle;
  }

  /**
   * Sets the number of wheels of the motorcycle based on user input.
   * @throws PromptException If there's an error during user input.
   */
  public void setNumberOfWheels() throws PromptException {
    while (true) {
      try {
        final int INPUT = Prompt.getValidInt("Enter the number of wheels");
        if (INPUT < 0) {
          System.out.println("Must have a capacity of 0 or greater");
          continue;
        } else {
          this.numberOfWheels = INPUT;
          return;
        }
      } catch (PromptException e) {
        Prompt.printPromptException(e);
      }
    }
  }

  /**
   * Sets the type of the motorcycle based on user input.
   * @throws PromptException If there's an error during user input.
   */
  public void setTypeOfMotorcycle() throws PromptException {
    this.typeOfMotorcycle = selectTypeOfMotorcycleMenu();
  }

  /**
   * Gets all motorcycles created in the system.
   * @return An ArrayList of all motorcycles.
   */
  public static ArrayList<Motorcycle> getAllMotorcycles(){
    return ALL_MOTORCYCLES;
  }

  /**
   * Adds the current motorcycle to the list of all motorcycles.
   */
  private void addToAllMotorcycles(){
    ALL_MOTORCYCLES.add(this);
  }

  /**
   * Displays a menu for selecting the type of motorcycle.
   * @return The selected type of motorcycle.
   * @throws PromptException If there's an error during user input.
   */
  private String selectTypeOfMotorcycleMenu() throws PromptException {
    final String[] MOTORCYCLE_TYPES = {"Sport", "Cruiser", "Off-Road"};
    final MenuInterface MOTORCYCLE_TYPE_MENU = new MenuInterface(MOTORCYCLE_TYPES);
    System.out.println();

    while (true) {
      final int SELECTION = MOTORCYCLE_TYPE_MENU.promptMenuSelection(false);
      return MOTORCYCLE_TYPES[SELECTION - 1];
    }
  }
}
