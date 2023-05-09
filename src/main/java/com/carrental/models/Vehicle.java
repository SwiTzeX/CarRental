package com.carrental.models;

import java.util.ArrayList;

public class Vehicle {
    public String type;
    public String color;
    public Integer passengers;
    public String fuelType;
    public String gearType;
    public Integer deposit;
    public Integer maxSpeed;
    public Integer horsePower;
    public Integer price;
    public String image;
    public String brandImage;
    public String brandName;
    public String modelName;

    public Vehicle(String brandName,String modelName,String type,String color, String fuelType, String gearType, Integer passengers, Integer deposit, Integer maxSpeed, Integer horsePower, Integer price, String image, String brand) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.color = color;
        this.type = type;
        this.passengers = passengers;
        this.fuelType = fuelType;
        this.gearType = gearType;
        this.deposit = deposit;
        this.maxSpeed = maxSpeed;
        this.horsePower = horsePower;
        this.price = price;
        this.image = image;
        this.brandImage = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    public Integer getPassengers() {
        return passengers;
    }

    public void setPassengers(Integer passengers) {
        this.passengers = passengers;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getDeposit() {
        return deposit;
    }

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBrandImage() {
        return brandImage;
    }

    public void setBrandImage(String brandImage) {
        this.brandImage = brandImage;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public static ArrayList<String> getAllBrandsFromAvailableVehicles(ArrayList<Vehicle> vehicles) {
        ArrayList<String> brands =new ArrayList<String>();
        for(Vehicle vehicle:vehicles){
            if (!brands.contains(vehicle.getBrandName())) {
                brands.add(vehicle.getBrandName());
            }
        }
        return brands;
    }

}
