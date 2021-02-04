package team8.coffee.service;

import team8.coffee.data.command.OldCommand;
import team8.coffee.data.OrderInput;
import team8.coffee.util.ControllerType;

public class ProgrammableOrderStrategy implements OrderStrategy {
    @Override
    public OldCommand initialOrderHandler(OrderInput input, int coffeeMachineId, int controllerId) {
        return null;
    }

    @Override
    public ControllerType getControllerType() {
        return ControllerType.PROGRAMMABLE;
    }
}
