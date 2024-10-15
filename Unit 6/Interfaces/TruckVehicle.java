package Interfaces;

public interface TruckVehicle extends VehicleInterface {
  int getCargoCapacity();
  String getTransmissionType();
  void setCargoCapacity(int cargoCapacity);
  void setTransmissionType(String transmissionType);
}
