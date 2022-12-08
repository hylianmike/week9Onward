package com.example.week9onward;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class Dealership {

    @SerializedName("Dealership")
    private String name;
    @SerializedName("Inventory")
    private Car[] cars;

    @Override
    public String toString() {
        return "Dealership{" +
                "name='" + name + '\'' +
                ", cars=" + Arrays.toString(cars) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getCars() {
        return Arrays.asList(cars);
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }
}
