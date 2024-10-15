package Classes;
import Interfaces.VehicleInterface;

public class Vehicle implements VehicleInterface{
  private String make;
  private String model;
  private int yearOfManufacture;

  public String getMake() {
    return make;
  }

  public String getModel() {
    return model;
  }

  public int getYearOfManufacture() {
    return yearOfManufacture;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setYearOfManufacture(int yearOfManufacture) {
    this.yearOfManufacture = yearOfManufacture;
  }
}
