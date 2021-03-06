package team8.coffee.data;

import com.google.gson.annotations.SerializedName;

public class Option {
    String name;
    @SerializedName("qty")
    int quantity;

    public Option(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "{name: " + name + ", quantity: " + quantity + "}";
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
