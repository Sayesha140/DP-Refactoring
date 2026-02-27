package edu.iutcs.cr.handlers;

import edu.iutcs.cr.persons.*;
import edu.iutcs.cr.system.SystemDatabase;
import edu.iutcs.cr.ConsoleReader;

public class PersonHandler {
    private final SystemDatabase database;

    public PersonHandler(SystemDatabase database) {
        this.database = database;
    }

    public void addSeller() {
        System.out.println("\n\n\nAdd new seller");
        String name = ConsoleReader.readMandatoryString("Enter name: ");
        String id = ConsoleReader.readMandatoryString("Enter id: ");
        String email = ConsoleReader.readMandatoryString("Enter email: ");

        Seller seller = PersonFactory.createSeller(name, id, email);
        database.addSeller(seller);
        System.out.println("Seller added successfully!");
    }

    public void addBuyer() {
        System.out.println("\n\n\nAdd new customer");
        String name = ConsoleReader.readMandatoryString("Enter name: ");
        String id = ConsoleReader.readMandatoryString("Enter id: ");
        String email = ConsoleReader.readMandatoryString("Enter email: ");
        PaymentMethod paymentMethod = readPaymentMethod();

        Buyer buyer = PersonFactory.createBuyer(name, id, email, paymentMethod);
        database.addBuyer(buyer);
        System.out.println("Buyer added successfully!");
    }

    private PaymentMethod readPaymentMethod() {
        System.out.println("Select payment method:");
        System.out.println("1. Cash");
        System.out.println("2. Card");
        System.out.println("3. Bank Transfer");
        int choice = ConsoleReader.readIntInRange("Enter your choice: ", 1, 3);

        return switch (choice) {
            case 1 -> PaymentMethod.CASH;
            case 2 -> PaymentMethod.CARD;
            case 3 -> PaymentMethod.BANK_TRANSFER;
            default -> throw new IllegalArgumentException("Invalid choice");
        };
    }
}