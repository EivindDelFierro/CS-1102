package MenuSystem;
import MenuUtilities.*;
import lib.MenuFunctions;
import Classes.*;
import lib.VehicleFactory;
import lib.VehicleType;

/**
 * Manages the main application menu and user interactions.
 */
public class ApplicationMenuInterface {
  static private MenuInterface mainMenu;

  /**
   * Launches the main menu of the application.
   */
  public static void LaunchMainMenu() {
    if (mainMenu == null) {
      final String[] MAIN_MENU_OPTIONS = {"Add a Vehicle", "List Vehicle data by Type", "List all Vehicle data"};
      mainMenu = new MenuInterface(MAIN_MENU_OPTIONS);
    }

    while (true) {
      try {
        
        System.out.println("\n\nMain Menu");

        final int SELECTION = mainMenu.promptMenuSelection(true);

        if (SELECTION == mainMenu.getExitOptionInteger()) break;

        switch (SELECTION) {
          case 1: 
            VehicleFactory.createVehicle(selectVehicleTypeMenu());
            break;
          case 2: 
            MenuFunctions.listVehiclesByType(selectVehicleTypeMenu());
            break;
          case 3: // display all vehicle details
            MenuFunctions.listVehicles(Vehicle.getAllVehicles());
            break;
        }
      } catch (Exception e) {
        System.out.println(e.getClass().getSimpleName()+ ": " + e.getMessage());
      }
    }
  }

  /**
   * Displays a menu for selecting a vehicle type.
   * @return The selected VehicleType.
   * @throws PromptException If there's an error during user input.
   */
  public static VehicleType selectVehicleTypeMenu() throws PromptException {
    final VehicleType[] VEHICLE_OPTIONS = VehicleType.values();

    final String[] STRING_ARRAY_OF_VEHICLE_OPTIONS = new String[VEHICLE_OPTIONS.length];

    for (int i = 0; i < VEHICLE_OPTIONS.length; i++) {
      STRING_ARRAY_OF_VEHICLE_OPTIONS[i] = VEHICLE_OPTIONS[i].name();
    }
    
    final MenuInterface VEHICLE_SELECTION_MENU = new MenuInterface(STRING_ARRAY_OF_VEHICLE_OPTIONS);

    System.out.print("Select a vehicle type");
    return VEHICLE_OPTIONS[VEHICLE_SELECTION_MENU.promptMenuSelection(false)-1];
  }
}
