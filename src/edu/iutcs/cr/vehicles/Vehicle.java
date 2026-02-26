//package edu.iutcs.cr.vehicles;
//
//import java.io.Serializable;
//import java.util.Objects;
//import java.util.Scanner;
//
///**
// * @author Raian Rahman
// * @since 4/18/2024
// */
//public class Vehicle implements Serializable {
//
//    private String make;
//    private String model;
//    private String year;
//    private double price;
//    private boolean available;
//    private String registrationNumber;
//
//    public Vehicle() {
//        setRegistrationNumber();
//        setMake();
//        setModel();
//        setYear();
//        setPrice();
//        this.available = true;
//    }
//
//    public Vehicle(String registrationNumber) {
//        this.registrationNumber = registrationNumber;
//    }
//
//    public String getRegistrationNumber() {
//        return this.registrationNumber;
//    }
//
//    public void setRegistrationNumber() {
//        Scanner scanner = new Scanner(System.in);
//        while (this.registrationNumber == null || registrationNumber.isBlank()) {
//            System.out.print("Enter registration number: ");
//            this.registrationNumber = scanner.nextLine();
//
//            if (registrationNumber == null || registrationNumber.isBlank()) {
//                System.out.println("Registration number is mandatory!");
//            }
//        }
//    }
//
//    public String getMake() {
//        return make;
//    }
//
//    public void setMake() {
//        Scanner scanner = new Scanner(System.in);
//
//        while (this.make == null || this.make.isBlank()) {
//            System.out.print("Enter make: ");
//            this.make = scanner.nextLine();
//
//            if (make == null || make.isBlank()) {
//                System.out.println("Make is mandatory!");
//            }
//        }
//    }
//
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel() {
//        Scanner scanner = new Scanner(System.in);
//
//        while (this.model == null || this.model.isBlank()) {
//            System.out.print("Enter model: ");
//            this.model = scanner.nextLine();
//
//            if (model == null || model.isBlank()) {
//                System.out.println("Model is mandatory!");
//            }
//        }
//    }
//
//    public String getYear() {
//        return year;
//    }
//
//    public void setYear() {
//        Scanner scanner = new Scanner(System.in);
//
//        while (this.year == null || this.year.isBlank()) {
//            System.out.print("Enter year: ");
//            this.year = scanner.nextLine();
//
//            if (year == null || year.isBlank()) {
//                System.out.println("Year is mandatory!");
//            }
//        }
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter price: ");
//        this.price = scanner.nextDouble();
//    }
//
//    public boolean isAvailable() {
//        return available;
//    }
//
//    public void setUnavailable() {
//        this.available = false;
//    }
//
//    @Override
//    public String toString() {
//        return "make='" + make + '\'' +
//                ", model='" + model + '\'' +
//                ", year='" + year + '\'' +
//                ", price=" + price +
//                ", available=" + available +
//                ", registrationNumber='" + registrationNumber + '\'';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Vehicle vehicle)) return false;
//        return Objects.equals(this.registrationNumber, vehicle.registrationNumber);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(registrationNumber);
//    }
//}


package edu.iutcs.cr.vehicles;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Raian Rahman
 * @since 4/18/2024
 */
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;

    private String make;
    private String model;
    private int year;
    private double price;
    private boolean available;
    private String registrationNumber;

    public Vehicle(String registrationNumber, String make, String model, int year, double price) {
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.available = true;
    }

    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setUnavailable() {
        this.available = false;
    }

    @Override
    public String toString() {
        return "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", available=" + available +
                ", registrationNumber='" + registrationNumber + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle vehicle)) return false;
        return Objects.equals(this.registrationNumber, vehicle.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber);
    }
}