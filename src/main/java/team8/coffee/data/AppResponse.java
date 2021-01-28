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

    public AppResponse(int orderID, int coffeeMachineId, int status, String statusMessage, String errorMessage) {
        this.orderID = orderID;
        this.coffeeMachineId = coffeeMachineId;
        this.status = status;
        this.statusMessage = statusMessage;
        this.errorMessage = errorMessage;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getCoffeeMachineId() {
        return coffeeMachineId;
    }

    public int getStatus() {
        return status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
