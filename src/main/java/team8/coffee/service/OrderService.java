package team8.coffee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team8.coffee.controller.ClientInterface;
import team8.coffee.controller.ControllerInterface;
import team8.coffee.data.AppResponse;
import team8.coffee.data.Recipe;
import team8.coffee.data.command.Command;
import team8.coffee.data.ControllerResponse;
import team8.coffee.data.OrderInput;
import team8.coffee.util.CompanyName;
import team8.coffee.util.ControllerType;
import team8.coffee.util.JSONParser;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    DatabaseControllerFactory databaseFactoryController;
    @Autowired
    ControllerInterface controllerInterface;
    @Autowired
    ClientInterface clientInterface;

    OrderStrategy orderStrategy;

    public void processOrder(OrderInput order) {
        DatabaseController databaseController = databaseFactoryController.createDatabaseController(CompanyName.CM2W);
        ArrayList<Integer[]> machines = databaseController.capableMachines(order);
        ArrayList<Recipe> recipes = databaseController.recipe(order);
        int controllerId;
        int coffeeMachineId;
        if (machines.size() == 0) {
            AppResponse appResponse = new AppResponse(order.getOrderID(), -1, 1, "Failed", "No Machine Available");
            clientInterface.sendToClient(JSONParser.createAppResponseJSON(appResponse));
            return;
        } else if (order.getOptions() != null && orderStrategy.getControllerType() == ControllerType.SIMPLE) {
            AppResponse appResponse = new AppResponse(order.getOrderID(), -1, 1, "Failed", "Not a Simple Order Request");
            clientInterface.sendToClient(JSONParser.createAppResponseJSON(appResponse));
            return;
        } else {
            coffeeMachineId = machines.get(0)[0];
            controllerId = machines.get(0)[1];
        }

        Command command = getCommand(order, coffeeMachineId, controllerId, recipes);

        System.out.println("Sent Command to the Controller: ");
        String commandString = JSONParser.createCommandJSON(command);
        System.out.println(commandString);

        String controllerResponseString = controllerInterface.sendToController(1, 1, commandString);
        System.out.println("Received From Controller: ");
        System.out.println(controllerResponseString);

        AppResponse appResponse = handleControllerResponse(controllerResponseString, coffeeMachineId);

        clientInterface.sendToClient(JSONParser.createAppResponseJSON(appResponse));
    }

    public Command getCommand(OrderInput orderInput, int coffeeMachineId, int controllerId, List<Recipe> recipeList) {

        return orderStrategy.initialOrderHandler(orderInput, coffeeMachineId, controllerId, recipeList);
    }

    public AppResponse handleControllerResponse(String controllerResponseString, int coffeeMachineId) {
        ControllerResponse response = JSONParser.getControllerResponse(controllerResponseString);
        System.out.println("Sent to Application:");
        String statusMessage;
        if (response.getStatus() == 0) {
            statusMessage = "Your coffee has been prepared with your desired options.";
        } else {
            statusMessage = "Your coffee order has been cancelled.";
        }

        return new AppResponse(response.getOrderID(), coffeeMachineId, response.getStatus(), statusMessage, response.getErrorDescription());
    }

    public void applyStrategy(OrderStrategy strategy) {
        this.orderStrategy = strategy;
    }
}