package edu.iutcs.cr.handlers;

import edu.iutcs.cr.system.SystemDatabase;
import edu.iutcs.cr.ConsoleReader;
import edu.iutcs.cr.vehicles.*;
import edu.iutcs.cr.vehicles.VehicleFactory;

public class VehicleHandler {
    private final SystemDatabase database;

    public VehicleHandler(SystemDatabase database) {
        this.database = database;
    }

    public void addVehicle() {
        System.out.println("\n\n\nAdd new vehicle");

        System.out.println("Please enter the type of vehicle [1-5]: ");
        System.out.println("1. Bus");
        System.out.println("2. Car");
        System.out.println("3. Hatchback");
        System.out.println("4. Sedan");
        System.out.println("5. SUV");

        int vehicleType = ConsoleReader.readIntInRange("Enter your choice: ", 1, 5);

        String regNum = ConsoleReader.readMandatoryString("Enter registration number: ");
        String make = ConsoleReader.readMandatoryString("Enter make: ");
        String model = ConsoleReader.readMandatoryString("Enter model: ");
        int year = ConsoleReader.readInt("Enter year: ");
        double price = ConsoleReader.readDouble("Enter price: ");

        Vehicle vehicle = VehicleFactory.create(vehicleType, regNum, make, model, year, price);
        addVehicleSpecificDetails(vehicle);

        database.addVehicle(vehicle);
        System.out.println("Vehicle added successfully!");
    }

    private void addVehicleSpecificDetails(Vehicle vehicle) {
        if (vehicle instanceof Bus bus) {
            int capacity = ConsoleReader.readInt("Enter passenger capacity: ");
            bus.setPassengerCapacity(capacity);
        } else if (vehicle instanceof Car car) {
            int capacity = ConsoleReader.readInt("Enter seating capacity: ");
            car.setSeatingCapacity(capacity);
        } else if (vehicle instanceof Hatchback hatchback) {
            boolean isCompact = ConsoleReader.readBoolean("Is the hatchback compact?");
            hatchback.setCompact(isCompact);
        } else if (vehicle instanceof Sedan sedan) {
            boolean hasSunroof = ConsoleReader.readBoolean("Does the sedan have a sunroof?");
            sedan.setHasSunroof(hasSunroof);
        } else if (vehicle instanceof SUV suv) {
            boolean isOffRoad = ConsoleReader.readBoolean("Is the SUV for off-road use?");
            suv.setOffRoad(isOffRoad);
        }
    }
}