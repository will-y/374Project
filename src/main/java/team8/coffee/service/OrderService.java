package team8.coffee.service;

import org.springframework.stereotype.Service;
import team8.coffee.data.OrderInput;

@Service
public class OrderService {
    public OrderService() {

    }

    public void receiveOrder(OrderInput order) {
        System.out.println(order);
    }
}
