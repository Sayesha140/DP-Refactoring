//package edu.iutcs.cr.vehicles;
//
//import java.util.Scanner;
//
///**
// * @author Raian Rahman
// * @since 4/19/2024
// */
//public class Hatchback extends Vehicle {
//
//    private boolean isCompact;
//
//    public Hatchback() {
//        super();
//        setCompact();
//    }
//
//    public boolean isCompact() {
//        return isCompact;
//    }
//
//    public void setCompact() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Is the hatchback compact? (true/false): ");
//        this.isCompact = scanner.nextBoolean();
//    }
//
//    @Override
//    public String toString() {
//        return "Hatchback{" + super.toString() + ", " +
//                "isCompact=" + isCompact() +
//                "}";
//    }
//}


package edu.iutcs.cr.vehicles;

/**
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class Hatchback extends Vehicle {

    private static final long serialVersionUID = 1L;

    private boolean isCompact;

    public Hatchback(String registrationNumber, String make, String model, int year, double price, boolean isCompact) {
        super(registrationNumber, make, model, year, price);
        this.isCompact = isCompact;
    }

    public boolean isCompact() {
        return isCompact;
    }

    public void setCompact(boolean isCompact) {
        this.isCompact = isCompact;
    }

    @Override
    public String toString() {
        return "Hatchback{" + super.toString() + ", " +
                "isCompact=" + isCompact +
                "}";
    }
}