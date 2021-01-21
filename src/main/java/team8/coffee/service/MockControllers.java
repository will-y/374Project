package team8.coffee.service;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class MockControllers implements Observer {

    private HashMap<Integer, MockController> controllers;

    public MockControllers() {
        controllers = new HashMap<>();
        //TODO pull from database to do this
        controllers.put(1, new MockController(1, List.of(1, 2)));
        controllers.put(2, new MockController(2, List.of(3)));
    }

    public String getResponseFromController(int controllerId, int machineId, String json) {
        return controllers.get(controllerId).createResponse(machineId, json);
    }

    @Override
    public String update(String json) {
        return null;
    }
}
