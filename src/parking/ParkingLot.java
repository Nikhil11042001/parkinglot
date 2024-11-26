package parking;

import java.util.ArrayList;
import java.util.List;


/*
     Class which handles the levels of parking place.
 */
public class ParkingLot {
    private static ParkingLot parkingLotInstance;
    private final List<Level> levels;
    public static synchronized ParkingLot getInstance() {
        if (parkingLotInstance == null) {
            parkingLotInstance = new ParkingLot();
        }
        return parkingLotInstance;
    }

    public ParkingLot (){
        levels = new ArrayList<>();
    }
    public void addLevel(Level level) {
        levels.add(level);
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.parkVehicle(vehicle)) {
                System.out.println("Vehicle parked successfully.");
                return true;
            }
        }
        System.out.println("Could not park vehicle.");
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.unparkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        for (Level level : levels) {
            level.displayAvailability();
        }
    }




}
