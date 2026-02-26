//package edu.iutcs.cr.vehicles;
//
//import java.io.Serializable;
//import java.util.Scanner;
//
///**
// * @author Raian Rahman
// * @since 4/18/2024
// */
//public class Car extends Vehicle implements Serializable {
//
//    int seatingCapacity;
//
//    public Car() {
//        super();
//        setSeatingCapacity();
//    }
//
//    public int getSeatingCapacity() {
//        return seatingCapacity;
//    }
//
//    public void setSeatingCapacity() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter new seating capacity: ");
//        this.seatingCapacity = scanner.nextInt();
//    }
//
//    @Override
//    public String toString() {
//        return "Car{" + super.toString() + ", " +
//                "seatingCapacity=" + getSeatingCapacity() +
//                "}";
//    }
//}


package edu.iutcs.cr.vehicles;

/**
 * @author Raian Rahman
 * @since 4/18/2024
 */
public class Car extends Vehicle {

    private static final long serialVersionUID = 1L;

    private int seatingCapacity;

    public Car(String registrationNumber, String make, String model, int year, double price, int seatingCapacity) {
        super(registrationNumber, make, model, year, price);
        this.seatingCapacity = seatingCapacity;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public String toString() {
        return "Car{" + super.toString() + ", " +
                "seatingCapacity=" + seatingCapacity +
                "}";
    }
}