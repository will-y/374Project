package team8.coffee.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import team8.coffee.data.AppResponse;
import team8.coffee.data.command.Command;
import team8.coffee.data.command.OldCommand;
import team8.coffee.data.ControllerResponse;
import team8.coffee.data.OrderInput;

public class JSONParser {

    public static String createAppResponseJSON(AppResponse response) {
        Gson gson = new Gson();
        return gson.toJson(response);
    }

    public static String createCommandJSON(Command command) {
        return command.toString();
    }

    public static ControllerResponse getControllerResponse(String json) {
        Gson gson = new Gson();
        JsonElement element = JsonParser.parseString(json);
        element = element.getAsJsonObject().get("drinkresponse");
        return gson.fromJson(element, ControllerResponse.class);
    }

    public static OrderInput getOrderInput(String json) {
        Gson gson = new Gson();
        JsonElement element = JsonParser.parseString(json);
        element = element.getAsJsonObject().get("order");
        return gson.fromJson(element, OrderInput.class);
    }

    public static OldCommand getCommand(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, OldCommand.class);
    }
}
