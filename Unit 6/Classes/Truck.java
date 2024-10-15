package Classes;
import Interfaces.TruckVehicle;

public class Truck extends Vehicle implements TruckVehicle{
  private int cargoCapacity;
  private String transmissionType;

  public int getCargoCapacity() {
    return cargoCapacity;
  }

  public String getTransmissionType() {
    return transmissionType;
  }

  public void setCargoCapacity(int cargoCapacity) {
    this.cargoCapacity = cargoCapacity;
  }

  public void setTransmissionType(String transmissionType) {
    this.transmissionType = transmissionType;
  }
}
