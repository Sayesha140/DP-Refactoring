package edu.iutcs.cr.system;

public class SearchServiceFactory {
    public static DatabaseSearchService createSearchService(SystemDatabase database) {
        return new DatabaseSearchService(database);
    }
}
