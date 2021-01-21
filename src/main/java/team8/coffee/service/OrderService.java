package team8.coffee.service;

import org.springframework.stereotype.Service;
import team8.coffee.data.AppResponse;
import team8.coffee.data.Command;
import team8.coffee.data.ControllerResponse;
import team8.coffee.data.OrderInput;
import team8.coffee.util.JSONParser;

@Service
public class OrderService {
    public OrderService() {

    }

    public void processOrder(OrderInput order) {
        System.out.println("Received Order: ");
        System.out.println(order);

        Command command = new Command(-1, -1, order.getOrderID(), order.getDrink(), "Automated", order.getOptions());
        System.out.println("Sent Command to the Machine: ");
        System.out.println(JSONParser.createCommandJSON(command));
        System.out.println("Received From Controller: ");
        String controllerResponseString = MockController.sendResponse(command);
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

        System.out.println(JSONParser.createAppResponseJSON(appResponse));
    }
}
