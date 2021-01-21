package team8.coffee.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import team8.coffee.controller.OrderController;
import team8.coffee.service.OrderService;
import team8.coffee.util.JSONParser;

@RestController
public class OrderControllerImpl implements OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public void receiveOrder(@RequestBody String order) {
        orderService.processOrder(JSONParser.getOrderInput(order));

    }


}
