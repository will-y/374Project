package team8.coffee.mock;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class MockControllers {

    private HashMap<Integer, MockController> controllers;


    public MockControllers() {
        controllers = new HashMap<>();
        //TODO pull from database to do this
        controllers.put(1, new MockController(1, List.of(2)));
        controllers.put(2, new MockController(2, List.of(1)));
    }

    public String getResponseFromController(int controllerId, int machineId, String json) {
        return controllers.get(controllerId).createResponse(machineId, json);
    }
}
