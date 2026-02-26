package edu.iutcs.cr.system;

import edu.iutcs.cr.persons.Buyer;
import edu.iutcs.cr.persons.Seller;
import edu.iutcs.cr.vehicles.Vehicle;

import java.util.Collection;

/**
 * Handles all search operations for SystemDatabase
 */
public class DatabaseSearchService {
    private final SystemDatabase database;

    public DatabaseSearchService(SystemDatabase database) {
        this.database = database;
    }

    public Vehicle findVehicleByRegistrationNumber(String registrationNumber) {
        for (Vehicle vehicle : database.getVehicles()) {
            if (registrationNumber.equals(vehicle.getRegistrationNumber())) {
                return vehicle;
            }
        }
        return null;
    }

    public Buyer findBuyerById(String id) {
        for (Buyer buyer : database.getBuyers()) {
            if (id.equals(buyer.getId())) {
                return buyer;
            }
        }
        return null;
    }

    public Seller findSellerById(String id) {
        for (Seller seller : database.getSellers()) {
            if (id.equals(seller.getId())) {
                return seller;
            }
        }
        return null;
    }
}