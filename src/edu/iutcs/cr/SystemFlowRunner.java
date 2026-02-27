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
    private final CommandFactory commandFactory;

    public SystemFlowRunner() {
        this.database = SystemDatabase.getInstance();
        this.mainMenu = new MainMenu();

        // Create handlers using factory
        PersonHandler personHandler = HandlerFactory.createPersonHandler(database);
        VehicleHandler vehicleHandler = HandlerFactory.createVehicleHandler(database);
        DisplayHandler displayHandler = HandlerFactory.createDisplayHandler(database);
        OrderHandler orderHandler = HandlerFactory.createOrderHandler(database);

        // Create command factory with all handlers
        this.commandFactory = new CommandFactory(database, personHandler, vehicleHandler,
                displayHandler, orderHandler);
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

                Command command = commandFactory.getCommand(selectedOperation);
                command.execute();
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            ConsoleReader.close();
        }
    }
}