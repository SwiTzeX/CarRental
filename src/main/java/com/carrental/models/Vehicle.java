package com.carrental.models;

public class Vehicle {
    public String type;
    public Integer passengers;
    public String fuelType;
    public String gearType;
    public Integer deposit;
    public Integer maxSpeed;
    public Integer horsePower;

    public Integer price;

    public Vehicle(String type, Integer passengers, String fuelType,String gearType, Integer deposit, Integer maxSpeed, Integer horsePower, Integer price) {
        this.type = type;
        this.passengers = passengers;
        this.fuelType = fuelType;
        this.gearType = gearType;
        this.deposit = deposit;
        this.maxSpeed = maxSpeed;
        this.horsePower = horsePower;
        this.price = price;
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
}
