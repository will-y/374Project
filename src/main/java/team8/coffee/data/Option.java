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
}
