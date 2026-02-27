package edu.iutcs.cr.system;

public class DisplayServiceFactory {
    public static DatabaseDisplayService createDisplayService(SystemDatabase database) {
        return new DatabaseDisplayService(database);
    }
}
