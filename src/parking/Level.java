package parking;

import java.util.ArrayList;
import java.util.List;

/*
     This class will handle the parking spots at each level.
 */
public class Level {
    private final int floor;
    private final List<ParkingSpot> parkingSpots;

    public Level(int floor, int numSpots) {
        this.floor = floor;
        parkingSpots = new ArrayList<>(numSpots);

        double spotsForBike = 0.50;
        double spotsForCar = 0.40;

        int mxBike =(int)(spotsForBike*numSpots);
        int mxCar  =(int)(spotsForCar*numSpots);

        for (int i = 1; i <= mxBike; i++) {
            parkingSpots.add(new ParkingSpot(i,VehicleType.MOTORCYCLE));
        }
        for (int i = mxBike + 1; i <= mxBike + mxCar; i++) {
            parkingSpots.add(new ParkingSpot(i,VehicleType.CAR));
        }
        for (int i = mxBike + mxCar + 1; i <= numSpots; i++) {
            parkingSpots.add(new ParkingSpot(i,VehicleType.TRUCK));
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isAvailable() && spot.getVehicleType() == vehicle.getType()) {
                spot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unparkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpots) {
            if (!spot.isAvailable() && spot.getParkedVehicle().equals(vehicle)) {
                spot.unparkVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        System.out.println("Level " + floor + " Availability:");
        for (ParkingSpot spot : parkingSpots) {
            System.out.println("Spot " + spot.getSpotNumber() + ": " + (spot.isAvailable() ? "Available For"  : "Occupied By ")+" "+spot.getVehicleType());
        }
    }

}
