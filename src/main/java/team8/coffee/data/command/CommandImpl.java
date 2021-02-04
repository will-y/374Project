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

    @Override
    public String toString() {
        return "Command{" +
                "controllerId=" + controllerId +
                ", coffeeMachineId=" + coffeeMachineId +
                ", orderId=" + orderId +
                ", drinkName='" + drinkName + '\'' +
                ", requestType='" + requestType + '\'' +
                ", options=" + Arrays.toString(options) +
                '}';
    }

    @Override
    public String recipe() {
        return "Recipe: [";
    }
}