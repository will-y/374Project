package team8.coffee;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import team8.coffee.data.Address;
import team8.coffee.data.Command;
import team8.coffee.data.Option;
import team8.coffee.data.OrderInput;
import team8.coffee.service.AdvancedOrderStrategy;
import team8.coffee.service.OrderService;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CoffeeApplicationTests {

    @Test
    void orderServiceTest() {
       OrderService os = new OrderService();
       os.applyStrategy(new AdvancedOrderStrategy());
        assertEquals(os.handleControllerResponse("{\n" +
                "  \"drinkresponse\": {\n" +
                "    \"orderID\": 1,\n" +
                "    \"status\": 0\n" +
                "  }\n" +
                "}", 2).getOrderID(), 1);
        assertEquals(os.handleControllerResponse("{\n" +
                "  \"drinkresponse\": {\n" +
                "    \"orderID\": 1,\n" +
                "    \"status\": 0\n" +
                "  }\n" +
                "}", 2).getStatusMessage(), "Your coffee has been prepared with your desired options.");
        assertEquals(os.handleControllerResponse("{\n" +
                "  \"drinkresponse\": {\n" +
                "    \"orderID\": 2,\n" +
                "    \"status\": 1,\n" +
                "    \"errordesc\": \"Out of milk, drink cancelled\",\n" +
                "    \"errorcode\": 2\n" +
                "  }\n" +
                "}", 1).getOrderID(), 2);
        assertEquals(os.handleControllerResponse("{\n" +
                "  \"drinkresponse\": {\n" +
                "    \"orderID\": 2,\n" +
                "    \"status\": 1,\n" +
                "    \"errordesc\": \"Out of milk, drink cancelled\",\n" +
                "    \"errorcode\": 2\n" +
                "  }\n" +
                "}", 1).getStatusMessage(), "Your coffee order has been cancelled.");
        assertEquals(os.getCommand(new OrderInput(2, new Address("asdf",0), "Large Coffee", new Option[] {new Option("sugar", 4)}), 1, 1).toString(),
                new Command(1, 1, 2, "Large Coffee", "Automated", new Option[] {new Option("sugar", 4)}).toString());

    }

}
