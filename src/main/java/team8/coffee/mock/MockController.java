package team8.coffee.mock;

import team8.coffee.data.command.Command;
import team8.coffee.util.JSONParser;

import java.util.List;
import java.util.Random;

public class MockController {

    public MockController(int controllerId, List<Integer> machinesIDs) {
    }

    public String createResponse(int machineId, String commandJSON) {
        Command command = JSONParser.getCommand(commandJSON);
        int status = getStatus();

        if (status == 0) {
            return String.format("{\n  \"drinkresponse\": {\n    \"orderID\": %d,\n    \"status\": 0\n  }\n}", command.getOrderId());
        } else {
            int errorCode = getError();
            String errorMessage = getErrorMessage(errorCode);
            return String.format("{\n  \"drinkresponse\": {\n    \"orderID\": %d,\n    \"status\": %d,\n    \"errordesc\": \"%s\",\n    \"errorcode\": %d\n  }\n}", command.getOrderId(), status, errorMessage, errorCode);
        }
    }

    private int getStatus() {
        Random rand = new Random();
        if (rand.nextFloat() > 0.8) {
            return 1;
        } else {
            return 0;
        }
    }

    private int getError() {
        Random rand = new Random();
        return rand.nextInt(5);
    }

    private String getErrorMessage(int errorCode) {
        switch (errorCode) {
            case 1:
                return "Machine Offline";
            case 2:
                return "Out of Milk";
            case 3:
                return "Machine Jammed";
            default:
                return "Unknown Error";
        }
    }
}
