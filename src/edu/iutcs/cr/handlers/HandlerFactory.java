package edu.iutcs.cr.handlers;
import edu.iutcs.cr.system.*;

public class HandlerFactory {


    // Handlers
    public static PersonHandler createPersonHandler(SystemDatabase database) {
        return new PersonHandler(database);
    }

    public static VehicleHandler createVehicleHandler(SystemDatabase database) {
        return new VehicleHandler(database);
    }

    public static DisplayHandler createDisplayHandler(SystemDatabase database) {
        return new DisplayHandler(database);
    }

    public static OrderHandler createOrderHandler(SystemDatabase database) {
        return new OrderHandler(database);
    }
}
