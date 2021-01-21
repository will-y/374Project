package team8.coffee.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface OrderController {
    @PostMapping("/order")
    void receiveOrder(@RequestBody String order);
}
