package edu.iutcs.cr.system;

import edu.iutcs.cr.Invoice;
import edu.iutcs.cr.persons.Buyer;
import edu.iutcs.cr.persons.Seller;
import edu.iutcs.cr.vehicles.Vehicle;

import java.io.Serializable;
import java.util.Set;

import static java.util.Objects.isNull;

/**
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class SystemDatabase implements Serializable {
    private static SystemDatabase instance;

    private final Set<Buyer> buyers;
    private final Set<Seller> sellers;
    private final Set<Vehicle> vehicles;
    private final Set<Invoice> invoices;

    private final DataStoreFactory factory;


    private transient DatabaseDisplayService displayService; //dont save this field-non serializable
    private transient DatabaseSearchService searchService;

    private SystemDatabase() {
        this.factory = DataStoreFactory.getInstance();

        this.buyers = factory.load(DataStoreFactory.BUYERS_FILE);
        this.sellers = factory.load(DataStoreFactory.SELLERS_FILE);
        this.vehicles = factory.load(DataStoreFactory.VEHICLES_FILE);
        this.invoices = factory.load(DataStoreFactory.INVOICES_FILE);

        // Initialize services
        this.displayService = DisplayServiceFactory.createDisplayService(this);
        this.searchService = SearchServiceFactory.createSearchService(this);
    }

    public static SystemDatabase getInstance() {
        if (isNull(instance)) {
            instance = new SystemDatabase();
        }
        return instance;
    }

    public void saveSystem() {
        System.out.println("Saving system data...");
        factory.save(DataStoreFactory.BUYERS_FILE, buyers);
        factory.save(DataStoreFactory.SELLERS_FILE, sellers);
        factory.save(DataStoreFactory.VEHICLES_FILE, vehicles);
        factory.save(DataStoreFactory.INVOICES_FILE, invoices);
        System.out.println("System saved successfully!");
    }

    public Set<Buyer> getBuyers() {
        return buyers;
    }

    public Set<Seller> getSellers() {
        return sellers;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    //  for accessing services
    public DatabaseDisplayService getDisplayService() {
        return displayService;
    }

    public DatabaseSearchService getSearchService() {
        return searchService;
    }

    // Add these convenience methods
    public void addBuyer(Buyer buyer) {
        buyers.add(buyer);
    }

    public void addSeller(Seller seller) {
        sellers.add(seller);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }
}