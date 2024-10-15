package Classes;
import Interfaces.CarVehicle;

public class Car extends Vehicle implements CarVehicle{
  private int numberOfDoors;
  private String fuelType;

  public String getFuelType() {
    return fuelType;
  }

  public int getNumberOfDoors() {
    return numberOfDoors;
  }

  public void setFuelType(String fuelType) {
    this.fuelType = fuelType;
  }

  public void setNumberOfDoors(int numberOfDoors) {
    this.numberOfDoors = numberOfDoors;
  }
}
