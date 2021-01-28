package team8.coffee.service;

import team8.coffee.data.Command;
import team8.coffee.data.OrderInput;

public interface OrderStrategy {
    Command initialOrderHandler(OrderInput input, int coffeeMachineId, int controllerId);

    boolean isSimple();

}
