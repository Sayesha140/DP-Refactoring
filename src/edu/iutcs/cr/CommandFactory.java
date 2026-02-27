package edu.iutcs.cr;

import edu.iutcs.cr.handlers.*;
import edu.iutcs.cr.Command;
import edu.iutcs.cr.ConsoleReader;
import edu.iutcs.cr.system.SystemDatabase;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private final Map<Integer, Command> commands = new HashMap<>();

    public CommandFactory(SystemDatabase database,
                          PersonHandler personHandler,
                          VehicleHandler vehicleHandler,
                          DisplayHandler displayHandler,
                          OrderHandler orderHandler) {

        commands.put(1, () -> {
            personHandler.addSeller();
            ConsoleReader.waitForInput("\n\nEnter 0 to view main menu: ");
        });

        commands.put(2, () -> {
            personHandler.addBuyer();
            ConsoleReader.waitForInput("\n\nEnter 0 to view main menu: ");
        });

        commands.put(3, () -> {
            vehicleHandler.addVehicle();
            ConsoleReader.waitForInput("\n\nEnter 0 to view main menu: ");
        });

        commands.put(4, () -> {
            displayHandler.showInventory();
            ConsoleReader.waitForInput("\n\nEnter 0 to view main menu: ");
        });

        commands.put(5, () -> {
            displayHandler.showSellers();
            ConsoleReader.waitForInput("\n\nEnter 0 to view main menu: ");
        });

        commands.put(6, () -> {
            displayHandler.showBuyers();
            ConsoleReader.waitForInput("\n\nEnter 0 to view main menu: ");
        });

        commands.put(7, orderHandler::createOrder);

        commands.put(8, () -> {
            displayHandler.showInvoices();
            ConsoleReader.waitForInput("\n\nEnter 0 to view main menu: ");
        });

        commands.put(9, () -> {
            database.saveSystem();
            ConsoleReader.close();
            System.out.println("Goodbye!");
            System.exit(0);
        });
    }

    public Command getCommand(int choice) {
        Command cmd = commands.get(choice);
        if (cmd == null) {
            return () -> System.out.println("Invalid option!");
        }
        return cmd;
    }
}
