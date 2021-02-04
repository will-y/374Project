package team8.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import team8.coffee.service.*;
import team8.coffee.util.JSONParser;

@RestController
public class OrderController {

    @Autowired
    DataBaseController dataBaseController;
    @Autowired
    OrderService orderService;

    @PostMapping("/simple-order")
    public void receiveSimpleOrder(@RequestBody String order) {
        orderService.applyStrategy(new SimpleOrderStrategy());
        orderService.processOrder(JSONParser.getOrderInput(order));
    }

    @PostMapping("/advanced-order")
    public void receiveAdvancedOrder(@RequestBody String order) {
        orderService.applyStrategy(new AdvancedOrderStrategy());
        orderService.processOrder(JSONParser.getOrderInput(order));
    }
}
