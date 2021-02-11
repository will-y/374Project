package team8.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import team8.coffee.service.*;
import team8.coffee.util.ControllerType;
import team8.coffee.util.JSONParser;
import team8.coffee.util.OrderServiceFactory;

@RestController
public class OrderController {

    @Autowired
    DatabaseControllerFactory databaseFactoryController;

    @Autowired
    OrderServiceFactory orderServiceFactory;

    @PostMapping("/simple-order")
    public void receiveSimpleOrder(@RequestBody String order) {
        OrderService orderService = orderServiceFactory.createOrderService(ControllerType.SIMPLE);
        orderService.processOrder(JSONParser.getOrderInput(order));
    }

    @PostMapping("/advanced-order")
    public void receiveAdvancedOrder(@RequestBody String order) {
        OrderService orderService = orderServiceFactory.createOrderService(ControllerType.ADVANCED);
        orderService.processOrder(JSONParser.getOrderInput(order));
    }

    @PostMapping("/programmable-order")
    public void receiveProgrammableOrder(@RequestBody String order) {
        OrderService orderService = orderServiceFactory.createOrderService(ControllerType.PROGRAMMABLE);
        orderService.processOrder(JSONParser.getOrderInput(order));
    }
}
