package team8.coffee.service;

import team8.coffee.data.Command;
import team8.coffee.data.OrderInput;

public class SimpleOrderStrategy implements OrderStrategy {
    @Override
    public Command initialOrderHandler(OrderInput order, int coffeeMachineId, int controllerId) {
        System.out.println("Received Simple Order: ");
        System.out.println(order);
        return new Command(controllerId, coffeeMachineId, order.getOrderID(), order.getDrink(), "Automated", null);
    }

    @Override
    public boolean isSimple() {
        return true;
    }


}
