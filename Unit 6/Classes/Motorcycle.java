package Classes;
import Interfaces.MoterVehicle;

public class Motorcycle extends Vehicle implements MoterVehicle{
  private int numberOfWheels;
  private String typeOfMotorcycle;

  public int getNumberOfWheels() {
    return numberOfWheels;
  }

  public String getTypeOfMotorcycle() {
    return typeOfMotorcycle;
  }

  public void setNumberOfWheels(int numberOfWheels) {
    this.numberOfWheels = numberOfWheels;
  }

  public void setTypeOfMotorcycle(String typeOfMotorcycle) {
    this.typeOfMotorcycle = typeOfMotorcycle;
  }
}
