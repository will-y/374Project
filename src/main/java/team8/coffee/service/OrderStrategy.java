package team8.coffee.service;

import team8.coffee.data.command.OldCommand;
import team8.coffee.data.OrderInput;
import team8.coffee.util.ControllerType;

public interface OrderStrategy {
    OldCommand initialOrderHandler(OrderInput input, int coffeeMachineId, int controllerId);

    ControllerType getControllerType();
}
