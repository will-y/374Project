package team8.coffee.data;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class SimpleOrderInput {
    int orderID;
    Address address;
    String drink;

    public SimpleOrderInput(int orderId, Address address, String drink) {
        this.orderID = orderId;
        this.address = address;
        this.drink = drink;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    @Override
    public String toString() {
        return "orderId: " + orderID + "\naddress: " + address + "\ndrink: " + drink + "\noptions: ";
    }
}
