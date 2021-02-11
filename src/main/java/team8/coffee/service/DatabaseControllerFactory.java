package team8.coffee.service;

import org.springframework.stereotype.Service;
import team8.coffee.util.CompanyName;

@Service
public class DatabaseControllerFactory {

    public DatabaseController createDatabaseController(CompanyName companyName) {
        DatabaseController databaseController;
        
        switch (companyName) {
            case CM2W:
                databaseController = new CM2WDatabaseController();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + companyName);
        }
        return databaseController;
    }
}