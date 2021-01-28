package team8.coffee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team8.coffee.controller.ClientInterface;
import team8.coffee.controller.ControllerInterface;
import team8.coffee.data.AppResponse;
import team8.coffee.data.Command;
import team8.coffee.data.ControllerResponse;
import team8.coffee.data.AdvancedOrderInput;
import team8.coffee.util.JSONParser;

import java.util.ArrayList;

@Service
public class OrderService {

    @Autowired
    DataBaseController dataBaseController;
    @Autowired
    ControllerInterface controllerInterface;
    @Autowired
    ClientInterface clientInterface;

    public void processOrder(AdvancedOrderInput order) {
        ArrayList<Integer[]> machines = dataBaseController.capableMachines(order);
        System.out.println("Received Order: ");
        System.out.println(order);
        int controllerId;
        int coffeeMachineId;
        if (machines.size() == 0) {
            AppResponse appResponse = new AppResponse(order.getOrderID(), -1, 1, "Failed", "No Machine Available");
            clientInterface.sendToClient(JSONParser.createAppResponseJSON(appResponse));
            return;
        } else {
            coffeeMachineId = machines.get(0)[0];
            controllerId = machines.get(0)[1];
        }

        Command command = new Command(controllerId, coffeeMachineId, order.getOrderID(), order.getDrink(), "Automated", order.getOptions());
        System.out.println("Sent Command to the Controller: ");
        String commandString = JSONParser.createCommandJSON(command);
        System.out.println(commandString);
        String controllerResponseString = controllerInterface.sendToController(1, 1, commandString);
        System.out.println("Received From Controller: ");
        System.out.println(controllerResponseString);
        ControllerResponse response = JSONParser.getControllerResponse(controllerResponseString);
        System.out.println("Sent to Application:");
        String statusMessage = "";
        if (response.getStatus() == 0) {
            statusMessage = "Your coffee has been prepared with your desired options.";
        } else {
            statusMessage = "Your coffee order has been cancelled.";
        }

        AppResponse appResponse = new AppResponse(response.getOrderID(), command.getCoffeeMachineId(), response.getStatus(), statusMessage, response.getErrorDescription());

        clientInterface.sendToClient(JSONParser.createAppResponseJSON(appResponse));
    }
}
