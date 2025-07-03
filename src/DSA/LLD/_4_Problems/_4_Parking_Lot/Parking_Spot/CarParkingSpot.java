package DSA.LLD._4_Problems._4_Parking_Lot.Parking_Spot;

import DSA.LLD._4_Problems._4_Parking_Lot.Vehicle.Vehicle;

public class CarParkingSpot extends ParkingSpot {
    public CarParkingSpot(int spotNumber, String spotType) {
        super(spotNumber, spotType);
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return "Car".equalsIgnoreCase(vehicle.getVehicleType());
    }
}
