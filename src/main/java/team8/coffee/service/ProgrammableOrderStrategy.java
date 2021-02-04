package team8.coffee.service;

import team8.coffee.data.Recipe;
import team8.coffee.data.command.AdvancedRecipeDecorator;
import team8.coffee.data.command.Command;
import team8.coffee.data.OrderInput;
import team8.coffee.data.command.CommandImpl;
import team8.coffee.data.command.SimpleRecipeDecorator;
import team8.coffee.util.ControllerType;

import java.util.List;

public class ProgrammableOrderStrategy implements OrderStrategy {
    @Override
    public Command initialOrderHandler(OrderInput order, int coffeeMachineId, int controllerId, List<Recipe> recipeList) {
        System.out.println("Received Programmable Order: ");
        System.out.println(order);
        Command command = new CommandImpl(controllerId, coffeeMachineId, order.getOrderID(), order.getDrink(), "Automated", order.getOptions());
        if (recipeList != null) {
            for (Recipe recipe : recipeList) {
                if (recipe.getObject() == null) {
                    command = new SimpleRecipeDecorator(command, recipe.getCommandStep());
                } else {
                    command = new AdvancedRecipeDecorator(command, recipe.getCommandStep(), recipe.getObject());
                }
            }
        }

        return command;
    }

    @Override
    public ControllerType getControllerType() {
        return ControllerType.PROGRAMMABLE;
    }
}
