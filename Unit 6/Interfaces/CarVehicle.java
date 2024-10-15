package Interfaces;

public interface CarVehicle extends VehicleInterface{
  String getFuelType();
  int getNumberOfDoors();
  void setFuelType(String fuelType);
  void setNumberOfDoors(int numberOfDoors);
}
