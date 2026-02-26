//package edu.iutcs.cr.vehicles;
//
//import java.io.Serializable;
//import java.util.Scanner;
//
///**
// * @author Raian Rahman
// * @since 4/19/2024
// */
//public class SUV extends Vehicle implements Serializable {
//
//    private boolean isOffRoad;
//
//    // Constructor
//    public SUV() {
//        super();
//        setOffRoad();
//    }
//
//    // Getters and setters
//    public boolean isOffRoad() {
//        return isOffRoad;
//    }
//
//    public void setOffRoad() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Is the SUV for off-road use? (true/false): ");
//        this.isOffRoad = scanner.nextBoolean();
//    }
//
//    @Override
//    public String toString() {
//        return "SUV{" + super.toString() + ", " +
//                "isOffRoad=" + isOffRoad() +
//                "}";
//    }
//}


package edu.iutcs.cr.vehicles;

/**
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class SUV extends Vehicle {

    private static final long serialVersionUID = 1L;

    private boolean isOffRoad;

    public SUV(String registrationNumber, String make, String model, int year, double price, boolean isOffRoad) {
        super(registrationNumber, make, model, year, price);
        this.isOffRoad = isOffRoad;
    }

    public boolean isOffRoad() {
        return isOffRoad;
    }

    public void setOffRoad(boolean isOffRoad) {
        this.isOffRoad = isOffRoad;
    }

    @Override
    public String toString() {
        return "SUV{" + super.toString() + ", " +
                "isOffRoad=" + isOffRoad +
                "}";
    }
}