package team8.coffee.service;

import team8.coffee.data.Command;
import team8.coffee.data.OrderInput;

public class AdvancedOrderStrategy implements OrderStrategy {
    @Override
    public Command initialOrderHandler(OrderInput order, int coffeeMachineId, int controllerId) {
        System.out.println("Received Advanced Order: ");
        System.out.println(order);
        return new Command(controllerId, coffeeMachineId, order.getOrderID(), order.getDrink(), "Automated", order.getOptions());
    }

    @Override
    public boolean isSimple() {
        return false;
    }
}
