package team8.coffee.data;

import com.google.gson.annotations.SerializedName;

public class ControllerResponse {
    int orderID;
    int status;
    @SerializedName("errordesc")
    String errorDescription;
    @SerializedName("errorcode")
    int errorCode;

    public int getOrderID() {
        return orderID;
    }

    public int getStatus() {
        return status;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
