package edu.iutcs.cr.vehicles;
public class VehicleFactory {
    public static Vehicle create(int type, String regNum, String make, String model, int year, double price) {
        switch (type) {
            case 1: return new Bus(regNum, make, model, year, price, 0);
            case 2: return new Car(regNum, make, model, year, price, 0);
            case 3: return new Hatchback(regNum, make, model, year, price, false);
            case 4: return new Sedan(regNum, make, model, year, price, false);
            case 5: return new SUV(regNum, make, model, year, price, false);
            default: throw new IllegalArgumentException("Invalid type");
        }
    }
}