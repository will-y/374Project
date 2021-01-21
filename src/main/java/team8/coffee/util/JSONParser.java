package team8.coffee.util;

import com.google.gson.Gson;
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

    public static OrderInput getOrderInput(String filePath) {

        try {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(filePath));
            
            return gson.fromJson(reader, OrderInput.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

