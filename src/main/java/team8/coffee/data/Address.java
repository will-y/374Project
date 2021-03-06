package team8.coffee.data;

import com.google.gson.annotations.SerializedName;

public class Address {
    String street;
    @SerializedName("ZIP")
    int zip;

    public Address(String street, int zip) {
        this.street = street;
        this.zip = zip;
    }

    public String getStreet() {
        return this.street;
    }

    public int getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return "{street: " + street + ", ZIP: " + zip + "}";
    }
}
