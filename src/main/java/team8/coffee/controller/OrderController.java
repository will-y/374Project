package team8.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import team8.coffee.service.OrderService;
import team8.coffee.util.JSONParser;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public String test() {
        return "test message and commit check message";
    }

    @PostMapping("/order")
    public void receiveOrder(@RequestBody String order) {
        orderService.receiveOrder(JSONParser.getOrderInput(order));

    }


}
