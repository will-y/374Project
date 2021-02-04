package team8.coffee.data.command;

import team8.coffee.data.Option;

import java.util.Arrays;

public class CommandImpl implements Command {
    int controllerId;
    int coffeeMachineId;
    int orderId;
    String drinkName;
    String requestType;
    Option[] options;

    public CommandImpl(int controllerId, int coffeeMachineId, int orderId, String drinkName, String requestType, Option[] options) {
        this.controllerId = controllerId;
        this.coffeeMachineId = coffeeMachineId;
        this.orderId = orderId;
        this.drinkName = drinkName;
        this.requestType = requestType;
        this.options = options;
    }

    public int getControllerId() {
        return controllerId;
    }

    public int getCoffeeMachineId() {
        return coffeeMachineId;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public String getRequestType() {
        return requestType;
    }

    public Option[] getOptions() {
        return options;
    }

    /*
    "command": {
    "controller_id": 2,
    "coffee_machine_id": 1,
    "orderID": 1,
    "DrinkName": "Pumpkin Spice",
    "Requesttype": "Programmable",
    "Options:": [
        {"Name": "sugar", "qty": 2}
    ]
    "Recipe": [
        {"commandstep": "add", "object": "coffee"},
        {"commandstep": "add", "object": "pumpkin spice"},
        {"commandstep": "mix"},
        {"commandstep": "top", "object": "nutmeg"}
    ]
     */

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("{" +
                "\"controller_id\": " + "\"" + controllerId + "\"" +
                ", \"coffee_machine_id\": " + "\"" + coffeeMachineId + "\"" +
                ", \"orderID\": " + "\"" + orderId + "\"" +
                ", \"DrinkName\": " + "\"" + drinkName + "\"" +
                ", \"Requesttype\": " + "\"" + requestType + "\"");

        if (options != null) {
            string.append(", \"Options\": [");
            for (Option o : options) {
                string.append("{\"Name\": ").append("\"").append(o.getName()).append("\", \"qty\": ").append(o.getQuantity()).append("},");
            }

            string = new StringBuilder(string.substring(0, string.length() - 1));
            string.append("]");
        }

        return string.toString();
    }

    @Override
    public String recipe() {
        return ",Recipe: [";
    }
}
