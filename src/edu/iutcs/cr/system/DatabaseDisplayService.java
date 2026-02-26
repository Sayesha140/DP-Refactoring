package edu.iutcs.cr.system;

import edu.iutcs.cr.Invoice;
import java.util.Collection;

/**
 * Handles all display operations for SystemDatabase
 */
public class DatabaseDisplayService {
    private final SystemDatabase database;

    public DatabaseDisplayService(SystemDatabase database) {
        this.database = database;
    }

    // Generic showList method
    private <T> void showList(Collection<T> items, String emptyMessage) {
        if (items.isEmpty()) {
            System.out.println(emptyMessage);
            return;
        }

        for (T item : items) {
            System.out.println(item.toString());
        }
    }

    // Public display methods
    public void showInventory() {
        showList(database.getVehicles(), "No vehicles present in system");
    }

    public void showBuyerList() {
        showList(database.getBuyers(), "No buyers present in system");
    }

    public void showSellerList() {
        showList(database.getSellers(), "No sellers present in system");
    }

    public void showInvoices() {
        if (database.getInvoices().isEmpty()) {
            System.out.println("No invoices found in system");
            return;
        }

        for (Invoice invoice : database.getInvoices()) {
            invoice.printInvoice();
            System.out.println("\n\n\n");
        }
    }
}