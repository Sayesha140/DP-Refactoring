package edu.iutcs.cr.system;


import java.util.Set;

/**
 * Factory class that provides generic load/save methods
 */
public class DataStoreFactory {
    private static DataStoreFactory instance;
    private final DataStore dataStore;

    // Constants for file names
    public static final String INVOICES_FILE = "invoices.txt";
    public static final String BUYERS_FILE = "buyers.txt";
    public static final String SELLERS_FILE = "sellers.txt";
    public static final String VEHICLES_FILE = "cars.txt";

    private DataStoreFactory() {
        this.dataStore = new DataStore();
    }

    public static synchronized DataStoreFactory getInstance() {
        if (instance == null) {
            instance = new DataStoreFactory();
        }
        return instance;
    }

    // Generic load method
    @SuppressWarnings("unchecked")
    public <T> Set<T> load(String filename) {
        return dataStore.loadFromFile(filename);
    }

    // Generic save method
    public <T> void save(String filename, Set<T> data) {
        dataStore.saveToFile(data, filename);
    }
}