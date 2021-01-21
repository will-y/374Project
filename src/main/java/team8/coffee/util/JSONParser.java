package team8.coffee.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import team8.coffee.data.AppResponse;
import team8.coffee.data.Command;
import team8.coffee.data.ControllerResponse;
import team8.coffee.data.OrderInput;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSONParser {
    public static String createAppResponseJSON(AppResponse response) {
        return "";
    }

    public static String createCommandJSON(Command command) {
        return "";
    }

    public static ControllerResponse getControllerResponse(String filePath) {
        return null;
    }

    public static OrderInput getOrderInput(String json) {

        Gson gson = new Gson();
        JsonElement element = JsonParser.parseString(json);
        element = element.getAsJsonObject().get("order");
        return gson.fromJson(element, OrderInput.class);
    }
}

