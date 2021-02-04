package team8.coffee.util;

import org.springframework.stereotype.Service;
import team8.coffee.service.AdvancedOrderStrategy;
import team8.coffee.service.OrderService;
import team8.coffee.service.ProgrammableOrderStrategy;
import team8.coffee.service.SimpleOrderStrategy;

@Service
public class OrderServiceFactory {
    public OrderService createOrderService(ControllerType controllerType) {
        OrderService service = new OrderService();
        switch (controllerType) {
            case SIMPLE:
                service.applyStrategy(new SimpleOrderStrategy());
                break;
            case ADVANCED:
                service.applyStrategy(new AdvancedOrderStrategy());
                break;
            case PROGRAMMABLE:
                service.applyStrategy(new ProgrammableOrderStrategy());
                break;
        }

        return service;
    }
}
