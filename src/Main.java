import parking.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
          ParkingLot  p1 = ParkingLot.getInstance();
          p1.addLevel(new Level(1,100));
          p1.addLevel(new Level(2,200));
        Vehicle car = new Car("1XXX5");
        Vehicle bike = new MotorCycle("1CCP6");
        Vehicle truck = new Truck("2PPP4");

        p1.parkVehicle(car);
        p1.parkVehicle(truck);
        p1.parkVehicle(bike);

        // Display availability
        p1.displayAvailability();

        // Unpark vehicle
        p1.unparkVehicle(bike);

        // Display updated availability
        p1.displayAvailability();
    }
}