package team8.coffee.data;

public class Command {
    int controllerId;
    int coffeeMachineId;
    int orderId;
    String drinkName;
    String requestType;
    Option[] options;

    public Command(int controllerId, int coffeeMachineId, int orderId, String drinkName, String requestType, Option[] options) {
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
}
