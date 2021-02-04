package team8.coffee.service;

import team8.coffee.data.Recipe;
import team8.coffee.data.command.Command;
import team8.coffee.data.OrderInput;
import team8.coffee.util.ControllerType;

import java.util.List;

public interface OrderStrategy {
    Command initialOrderHandler(OrderInput input, int coffeeMachineId, int controllerId, List<Recipe> recipeList);

    ControllerType getControllerType();
}
