package edu.iutcs.cr.handlers;

import edu.iutcs.cr.system.SystemDatabase;
import edu.iutcs.cr.utils.ConsoleReader;

public class DisplayHandler {
    private final SystemDatabase database;
    private final ConsoleReader reader;

    public DisplayHandler(SystemDatabase database, ConsoleReader reader) {
        this.database = database;
        this.reader = reader;
    }

    public void showInventory() {
        System.out.println("\n\n\nInventory list");
        database.getDisplayService().showInventory();
    }

    public void showSellers() {
        System.out.println("\n\n\nSeller's list");
        database.getDisplayService().showSellerList();
    }

    public void showBuyers() {
        System.out.println("\n\n\nCustomer's list");
        database.getDisplayService().showBuyerList();
    }

    public void showInvoices() {
        System.out.println("\n\n\nInvoice list");
        database.getDisplayService().showInvoices();
    }
}