package team8.coffee.data;

import com.google.gson.annotations.SerializedName;

public class AppResponse {

    int orderID;
    @SerializedName("coffee_machine_id")
    int coffeeMachineId;
    int status;
    @SerializedName("status-message")
    String statusMessage;
    @SerializedName("error-message")
    String errorMessage;
}
