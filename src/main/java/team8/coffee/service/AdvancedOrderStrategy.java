package team8.coffee.service;

import team8.coffee.data.command.OldCommand;
import team8.coffee.data.OrderInput;
import team8.coffee.util.ControllerType;

public class AdvancedOrderStrategy implements OrderStrategy {
    @Override
    public OldCommand initialOrderHandler(OrderInput order, int coffeeMachineId, int controllerId) {
        System.out.println("Received Advanced Order: ");
        System.out.println(order);
        return new OldCommand(controllerId, coffeeMachineId, order.getOrderID(), order.getDrink(), "Automated", order.getOptions());
    }

    @Override
    public ControllerType getControllerType() {
        return ControllerType.ADVANCED;
    }
}
