package team8.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team8.coffee.service.MockControllers;

@Component
public class ControllerInterface extends Subject {
    @Autowired
    private MockControllers controllers;

    public String sendToController(int controllerId, int machineId, String request) {
        return controllers.getResponseFromController(controllerId, machineId, request);
    }
}
