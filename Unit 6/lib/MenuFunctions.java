package lib;
import java.util.ArrayList;
import Classes.Car;
import Classes.Motorcycle;
import Classes.Truck;
import Classes.Vehicle;

/**
 * Provides utility functions for menu operations related to vehicles.
 */
public class MenuFunctions {
  /**
   * Lists all vehicles of a specific type.
   * @param VEHICLE_LIST The list of vehicles to display.
   */
  public static void listVehicles(ArrayList<? extends Vehicle> VEHICLE_LIST) {
    if (VEHICLE_LIST.size() == 0) {
      System.out.println("No vehicles of this type found");
    } else {
      for (Vehicle vehicle : VEHICLE_LIST) {
        vehicle.showVehicleDetails();
      }
    }
    System.out.println();
  }

  /** 
   * Lists vehicles by a specific type.
   * @param type The type of vehicle to list.
   */
  public static void listVehiclesByType(VehicleType type) {
      ArrayList<? extends Vehicle> vehicles;
      switch (type) {
        case CAR:
          vehicles = Car.getAllVehicles();
          break;
        case MOTORCYCLE:
          vehicles = Motorcycle.getAllVehicles();
          break;
        case TRUCK:
          vehicles = Truck.getAllVehicles();
          break;
        default:
          return;
      }
      MenuFunctions.listVehicles(vehicles);
      return;
    }
}
