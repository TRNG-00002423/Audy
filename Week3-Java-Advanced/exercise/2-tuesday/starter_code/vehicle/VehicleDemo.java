package vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleDemo {
    public static void main(String[] args) {
        List<Vehicle> fleet = new ArrayList<>();
        // TODO: add GasCar, ElectricCar, optionally one that implements AutonomousCapable
        fleet.add(new GasCar("Toyota",2020,7.5, 1.10));
        fleet.add(new ElectricCar("Tesla",2022, 16.0, 0.10, true));
        fleet.add(new ElectricCar("Nissan",2018, 18.5, 0.10, false));
        // TODO: polymorphic loop + instanceof demo
        for (Vehicle vehicle : fleet) {
            System.out.printf("%s -> cost/100km: %.2f%n", vehicle, vehicle.fuelCostPer100Km());

            if (vehicle instanceof AutonomousCapable auto){
                System.out.println(" self-driving capable: " + auto.supportsSelfDrive());
            }
        }
    }
}
