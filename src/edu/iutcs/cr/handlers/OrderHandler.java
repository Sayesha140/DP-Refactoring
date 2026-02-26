package edu.iutcs.cr.handlers;

import edu.iutcs.cr.*;
import edu.iutcs.cr.persons.Buyer;
import edu.iutcs.cr.persons.Seller;
import edu.iutcs.cr.system.SystemDatabase;
import edu.iutcs.cr.utils.ConsoleReader;
import edu.iutcs.cr.vehicles.Vehicle;

public class OrderHandler {
    private final SystemDatabase database;
    private final ConsoleReader reader;

    public OrderHandler(SystemDatabase database, ConsoleReader reader) {
        this.database = database;
        this.reader = reader;
    }

    public void createOrder() {
        System.out.println("\n\n\nCreate order");
        ShoppingCart cart = new ShoppingCart();

        while (true) {
            System.out.println("Please enter the type of operation: [1-5]");
            System.out.println("1. Add new vehicle to cart");
            System.out.println("2. Remove vehicle from cart");
            System.out.println("3. View cart");
            System.out.println("4. Confirm purchase");
            System.out.println();
            System.out.println("5. Return to main menu");

            int operation = reader.readIntInRange("Enter your choice: ", 1, 5);

            switch (operation) {
                case 1 -> addItemToCart(cart);
                case 2 -> removeItemFromCart(cart);
                case 3 -> cart.viewCart();
                case 4 -> {
                    createInvoice(cart);
                    return;
                }
                case 5 -> {
                    return;
                }
            }
        }
    }

    private void addItemToCart(ShoppingCart cart) {
        String regNumber = reader.readMandatoryString("Enter registration number of vehicle: ");
        Vehicle vehicle = database.getSearchService().findVehicleByRegistrationNumber(regNumber);

        if (vehicle == null) {
            System.out.println("Vehicle not found!");
            return;
        }

        if (!vehicle.isAvailable()) {
            System.out.println("Vehicle is not available!");
            return;
        }

        cart.addItem(vehicle);
        System.out.println("Vehicle added to cart!");
    }

    private void removeItemFromCart(ShoppingCart cart) {
        String regNumber = reader.readMandatoryString("Enter registration number of vehicle: ");
        cart.removeItem(regNumber);
        System.out.println("Vehicle removed from cart!");
    }

    private void createInvoice(ShoppingCart cart) {
        Buyer buyer = findBuyer();
        Seller seller = findSeller();

        boolean isPaid = reader.readBoolean("Is payment done?");
        PaymentStatus paymentStatus = PaymentStatus.fromBoolean(isPaid);

        Invoice invoice = new Invoice(buyer, seller, cart, paymentStatus);

        if (isPaid) {
            cart.markAllItemsUnavailable();
        }

        invoice.printInvoice();
        database.addInvoice(invoice);
        System.out.println("Invoice created successfully!");
    }

    private Buyer findBuyer() {
        while (true) {
            String buyerId = reader.readMandatoryString("Enter buyer id: ");
            Buyer buyer = database.getSearchService().findBuyerById(buyerId);
            if (buyer != null) {
                return buyer;
            }
            System.out.println("Buyer not found. Try again!");
        }
    }

    private Seller findSeller() {
        while (true) {
            String sellerId = reader.readMandatoryString("Enter seller id: ");
            Seller seller = database.getSearchService().findSellerById(sellerId);
            if (seller != null) {
                return seller;
            }
            System.out.println("Seller not found. Try again!");
        }
    }
}