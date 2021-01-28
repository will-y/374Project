package team8.coffee.data;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class OrderInput {
    int orderID;
    Address address;
    String drink;
    @SerializedName("condiments")
    Option[] options;

    public OrderInput(int orderId, Address address, String drink, Option[] options) {
        this.orderID = orderId;
        this.address = address;
        this.drink = drink;
        this.options = options;
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

    public Option[] getOptions() {
        return options;
    }

    public void setOptions(Option[] options) {
        this.options = options;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("orderId: ").append(orderID).append("\naddress: ").append(address).append("\ndrink: ").append(drink).append("\noptions: ").append(Arrays.toString(options));
        return b.toString();
    }
}
