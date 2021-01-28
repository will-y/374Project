package team8.coffee;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import team8.coffee.data.*;
import team8.coffee.util.JSONParser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JSONParserTests {
    @Test
    public void createAppResponseTest() {
        AppResponse response = new AppResponse(1, 1, 0, "Status Message", "No Error");
        String actual = JSONParser.createAppResponseJSON(response);
        String expected = "{\"orderID\":1,\"coffee_machine_id\":1,\"status\":0,\"status-message\":\"Status Message\",\"error-message\":\"No Error\"}";
        assertEquals(expected, actual);
    }

    @Test
    public void createCommandTest() {
        Command command = new Command(1, 1, 2, "Large Coffee", "automated", new Option[] {new Option("sugar", 4)});
        String actual = JSONParser.createCommandJSON(command);
        String expected = "{\"controllerId\":1,\"coffeeMachineId\":1,\"orderId\":2,\"drinkName\":\"Large Coffee\",\"requestType\":\"automated\",\"options\":[{\"name\":\"sugar\",\"qty\":4}]}";
        assertEquals(expected, actual);
    }

    @Test
    public void testControllerResponse() {
        String json = "{\n" +
                "  \"drinkresponse\": {\n" +
                "    \"orderID\": 2,\n" +
                "    \"status\": 1,\n" +
                "    \"errordesc\": \"Out of milk, drink cancelled\",\n" +
                "    \"errorcode\": 2\n" +
                "  }\n" +
                "}";
        ControllerResponse expected = new ControllerResponse(2, 1, "Out of milk, drink cancelled", 2);

        assertEquals(expected.toString(), JSONParser.getControllerResponse(json).toString());
    }

    @Test
    public void testGetOrderInput() {
        String json = "{\n" +
                "  \"order\": { \"orderID\": 1,\n" +
                "            \"address\": {\n" +
                "                  \"street\": \"200 N Main\",\n" +
                "                  \"ZIP\": 47803\n" +
                "            },\n" +
                "            \"drink\": \"Americano\",\n" +
                "            \"condiments\": [\n" +
                "                {\"name\": \"Sugar\", \"qty\": 1},\n" +
                "                {\"name\": \"Cream\", \"qty\": 2}\n" +
                "            ]\n" +
                "            }\n" +
                "}";
        OrderInput expected = new OrderInput(1, new Address("200 N Main", 47803), "Americano", new Option[] {new Option("Sugar", 1), new Option("Cream", 2)});

        assertEquals(expected.toString(), JSONParser.getOrderInput(json).toString());
    }

    @Test
    public void testGetCommand() {
        String json = JSONParser.createCommandJSON(new Command(2, 1, 1, "Americano", "Automated", new Option[] {new Option("Cream", 2), new Option("Sugar", 1)}));

        Command expected = new Command(2, 1, 1, "Americano", "Automated", new Option[] {new Option("Cream", 2), new Option("Sugar", 1)});

        assertEquals(expected.toString(), JSONParser.getCommand(json).toString());
    }
}
