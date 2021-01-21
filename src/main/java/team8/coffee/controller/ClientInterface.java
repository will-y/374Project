package team8.coffee.controller;

import org.springframework.stereotype.Component;

@Component
public class ClientInterface {
    public void sendToClient(String json) {
        System.out.println("-----------------TO_CLIENT-----------------");
        System.out.println(json);
    }
}
