package Interfaces;

public interface MoterVehicle extends VehicleInterface {
  int getNumberOfWheels();
  String getTypeOfMotorcycle();
  void setNumberOfWheels(int numberOfWheels);
  void setTypeOfMotorcycle(String typeOfMotorcycle);
}
