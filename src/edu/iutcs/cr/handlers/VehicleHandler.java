package edu.iutcs.cr.handlers;

import edu.iutcs.cr.system.SystemDatabase;
import edu.iutcs.cr.utils.ConsoleReader;
import edu.iutcs.cr.vehicles.*;

public class VehicleHandler {
    private final SystemDatabase database;
    private final ConsoleReader reader;

    public VehicleHandler(SystemDatabase database, ConsoleReader reader) {
        this.database = database;
        this.reader = reader;
    }

    public void addVehicle() {
        System.out.println("\n\n\nAdd new vehicle");

        VehicleFactory.showVehicleTypes();
        int vehicleType = reader.readIntInRange("Enter your choice: ", 1, VehicleFactory.getTypeCount());

        String regNum = reader.readMandatoryString("Enter registration number: ");
        String make = reader.readMandatoryString("Enter make: ");
        String model = reader.readMandatoryString("Enter model: ");
        int year = reader.readInt("Enter year: ");
        double price = reader.readDouble("Enter price: ");

        Vehicle vehicle = VehicleFactory.create(vehicleType, regNum, make, model, year, price);
        addVehicleSpecificDetails(vehicle);

        database.addVehicle(vehicle);
        System.out.println("Vehicle added successfully!");
    }

    private void addVehicleSpecificDetails(Vehicle vehicle) {
        if (vehicle instanceof Bus bus) {
            int capacity = reader.readInt("Enter passenger capacity: ");
            bus.setPassengerCapacity(capacity);
        } else if (vehicle instanceof Car car) {
            int capacity = reader.readInt("Enter seating capacity: ");
            car.setSeatingCapacity(capacity);
        } else if (vehicle instanceof Hatchback hatchback) {
            boolean isCompact = reader.readBoolean("Is the hatchback compact?");
            hatchback.setCompact(isCompact);
        } else if (vehicle instanceof Sedan sedan) {
            boolean hasSunroof = reader.readBoolean("Does the sedan have a sunroof?");
            sedan.setHasSunroof(hasSunroof);
        } else if (vehicle instanceof SUV suv) {
            boolean isOffRoad = reader.readBoolean("Is the SUV for off-road use?");
            suv.setOffRoad(isOffRoad);
        }
    }
}