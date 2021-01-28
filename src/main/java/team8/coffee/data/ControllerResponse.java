package team8.coffee.data;

import com.google.gson.annotations.SerializedName;

public class ControllerResponse {
    int orderID;
    int status;
    @SerializedName("errordesc")
    String errorDescription;
    @SerializedName("errorcode")
    int errorCode;

    public ControllerResponse(int orderID, int status, String errorDescription, int errorCode) {
        this.orderID = orderID;
        this.status = status;
        this.errorDescription = errorDescription;
        this.errorCode = errorCode;
    }

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

    @Override
    public String toString() {
        return "ControllerResponse{" +
                "orderID=" + orderID +
                ", status=" + status +
                ", errorDescription='" + errorDescription + '\'' +
                ", errorCode=" + errorCode +
                '}';
    }
}
