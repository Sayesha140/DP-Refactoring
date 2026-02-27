package edu.iutcs.cr;

import edu.iutcs.cr.handlers.*;
import edu.iutcs.cr.system.SystemDatabase;


/**
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class SystemFlowRunner {
    private final SystemDatabase database;
    private final MainMenu mainMenu;

    private final PersonHandler personHandler;
    private final VehicleHandler vehicleHandler;
    private final DisplayHandler displayHandler;
    private final OrderHandler orderHandler;

    public SystemFlowRunner() {
        this.database = SystemDatabase.getInstance();
        this.mainMenu = new MainMenu();

        this.personHandler = HandlerFactory.createPersonHandler(database);
        this.vehicleHandler = HandlerFactory.createVehicleHandler(database);
        this.displayHandler = HandlerFactory.createDisplayHandler(database);
        this.orderHandler = HandlerFactory.createOrderHandler(database);
    }

    public static void run() {
        new SystemFlowRunner().start();
    }

    private void start() {
        System.out.println("Welcome to Car Hut");
        System.out.println("Loading existing system");
        System.out.println("Existing system loaded");

        try {
            while (true) {
                System.out.println("\n\n\n");
                int selectedOperation = mainMenu.showAndSelectOperation();

                switch (selectedOperation) {
                    case 1 -> {
                        personHandler.addSeller();
                        promptToViewMainMenu();
                    }
                    case 2 -> {
                        personHandler.addBuyer();
                        promptToViewMainMenu();
                    }
                    case 3 -> {
                        vehicleHandler.addVehicle();
                        promptToViewMainMenu();
                    }
                    case 4 -> {
                        displayHandler.showInventory();
                        promptToViewMainMenu();
                    }
                    case 5 -> {
                        displayHandler.showSellers();
                        promptToViewMainMenu();
                    }
                    case 6 -> {
                        displayHandler.showBuyers();
                        promptToViewMainMenu();
                    }
                    case 7 -> {
                        orderHandler.createOrder();
                    }
                    case 8 -> {
                        displayHandler.showInvoices();
                        promptToViewMainMenu();
                    }
                    case 9 -> {
                        database.saveSystem();
                        ConsoleReader.close();
                        System.out.println("Goodbye!");
                        return;
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            ConsoleReader.close();
        }
    }

    private void promptToViewMainMenu() {
        ConsoleReader.waitForInput("\n\nEnter 0 to view main menu: ");
    }
}