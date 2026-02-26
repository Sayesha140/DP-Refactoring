//package edu.iutcs.cr.vehicles;
//
//import java.io.Serializable;
//import java.util.Scanner;
//
///**
// * @author Raian Rahman
// * @since 4/18/2024
// */
//public class Bus extends Vehicle implements Serializable {
//
//    int passengerCapacity;
//
//    public Bus() {
//        super();
//        setPassengerCapacity();
//    }
//
//    public int getPassengerCapacity() {
//        return passengerCapacity;
//    }
//
//    public void setPassengerCapacity() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter new passenger capacity: ");
//        this.passengerCapacity = scanner.nextInt();
//    }
//
//    @Override
//    public String toString() {
//        return "Bus{" + super.toString() + ", " +
//                "passengerCapacity=" + getPassengerCapacity() +
//                "}";
//    }
//}


package edu.iutcs.cr.vehicles;

/**
 * @author Raian Rahman
 * @since 4/18/2024
 */
public class Bus extends Vehicle {

    private static final long serialVersionUID = 1L;

    private int passengerCapacity;

    public Bus(String registrationNumber, String make, String model, int year, double price, int passengerCapacity) {
        super(registrationNumber, make, model, year, price);
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public String toString() {
        return "Bus{" + super.toString() + ", " +
                "passengerCapacity=" + passengerCapacity +
                "}";
    }
}