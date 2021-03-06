package team8.coffee.service;

import team8.coffee.data.Recipe;
import team8.coffee.data.command.Command;
import team8.coffee.data.command.CommandImpl;
import team8.coffee.data.OrderInput;
import team8.coffee.util.ControllerType;

import java.util.List;

public class SimpleOrderStrategy implements OrderStrategy {
    @Override
    public Command initialOrderHandler(OrderInput order, int coffeeMachineId, int controllerId, List<Recipe> recipeList) {
        System.out.println("Received Simple Order: ");
        System.out.println(order);
        return new CommandImpl(controllerId, coffeeMachineId, order.getOrderID(), order.getDrink(), "Automated", null);
    }

    @Override
    public ControllerType getControllerType() {
        return ControllerType.SIMPLE;
    }
}
