package edu.iutcs.cr.vehicles;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Factory for creating Vehicle instances.
 * Replaces the if-else chain in SystemFlowRunner.addCar() with a
 * registry-based approach (Factory Method pattern), fixing the
 * Open/Closed Principle violation and Switch Statements smell.
 */
public class VehicleFactory {

    private static final Map<Integer, VehicleType> VEHICLE_TYPES = new LinkedHashMap<>();

    static {
        VEHICLE_TYPES.put(1, new VehicleType("Bus",
                (regNum, make, model, year, price) -> new Bus(regNum, make, model, year, price, 0)));
        VEHICLE_TYPES.put(2, new VehicleType("Car",
                (regNum, make, model, year, price) -> new Car(regNum, make, model, year, price, 0)));
        VEHICLE_TYPES.put(3, new VehicleType("Hatchback",
                (regNum, make, model, year, price) -> new Hatchback(regNum, make, model, year, price, false)));
        VEHICLE_TYPES.put(4, new VehicleType("Sedan",
                (regNum, make, model, year, price) -> new Sedan(regNum, make, model, year, price, false)));
        VEHICLE_TYPES.put(5, new VehicleType("SUV",
                (regNum, make, model, year, price) -> new SUV(regNum, make, model, year, price, false)));
    }

    public static void showVehicleTypes() {
        System.out.println("Please enter the type of vehicle [1-" + VEHICLE_TYPES.size() + "]: ");
        VEHICLE_TYPES.forEach((key, type) -> System.out.println(key + ". " + type.name()));
    }

    public static int getTypeCount() {
        return VEHICLE_TYPES.size();
    }

    public static Vehicle create(int typeCode, String regNum, String make, String model, int year, double price) {
        VehicleType type = VEHICLE_TYPES.get(typeCode);
        if (type == null) {
            throw new IllegalArgumentException("Invalid vehicle type: " + typeCode);
        }
        System.out.println("\n\nCreate new " + type.name().toLowerCase());
        return type.creator().create(regNum, make, model, year, price);
    }

    private record VehicleType(String name, VehicleCreator creator) {}

    @FunctionalInterface
    public interface VehicleCreator {
        Vehicle create(String regNum, String make, String model, int year, double price);
    }
}