package DSA.LLD._4_Problems._4_Parking_Lot.Parking_Fee;

public interface ParkingFeeStrategy {

    /**
     * - Calculate parking fee based on vehicle type and duration
     * -
     * - @param vehicleType Type of vehicle being parked
     * - @param duration Duration of parking (in hours or days)
     * - @param durationType Type of duration (HOURS or DAYS)
     * - @return Calculated parking fee
     */
    double calculateFee(String vehicleType, int duration, DurationType durationType);

}
