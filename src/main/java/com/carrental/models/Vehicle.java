package com.carrental.models;

import com.carrental.SingletonConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Vehicle {
    public Integer id;
    public String modelName;
    public String color;
    public Boolean disponibility;
    public String brandName;
    public Boolean vehicleState;
    public float price;
    public String type;
    public Integer passengers;
    public String fuelType;
    public String gearType;
    public float deposit;
    public Integer trunkCapacity;
    public Integer maxSpeed;
    public Integer horsePower;
    public String image;
    public String brandImage;

    public Vehicle(Integer id, String brandName, String modelName, String color, Boolean disponibility, Boolean vehicleState, float price, String type, Integer passengers, String fuelType, String gearType, float deposit, Integer trunkCapacity, Integer maxSpeed, Integer horsePower) {
        this.id = id;
        this.modelName = modelName;
        this.color = color;
        this.disponibility = disponibility;
        this.brandName = brandName;
        this.vehicleState = vehicleState;
        this.price = price;
        this.type = type;
        this.passengers = passengers;
        this.fuelType = fuelType;
        this.gearType = gearType;
        this.deposit = deposit;
        this.trunkCapacity = trunkCapacity;
        this.maxSpeed = maxSpeed;
        this.horsePower = horsePower;
        this.brandImage = "brands/volkswagen.png";
        this.image = "vehicles/volkswagen-touareg.png";
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

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getDisponibility() {
        return disponibility;
    }

    public void setDisponibility(Boolean disponibility) {
        this.disponibility = disponibility;
    }

    public Boolean getVehicleState() {
        return vehicleState;
    }

    public void setVehicleState(Boolean vehicleState) {
        this.vehicleState = vehicleState;
    }

    public Integer getTrunkCapacity() {
        return trunkCapacity;
    }

    public void setTrunkCapacity(Integer trunkCapacity) {
        this.trunkCapacity = trunkCapacity;
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
    public static ArrayList<String> getAllColorsFromAvailableVehicles(ArrayList<Vehicle> vehicles) {
        ArrayList<String> colors =new ArrayList<String>();
        for(Vehicle vehicle:vehicles){
            if (!colors.contains(vehicle.getColor())) {
                colors.add(vehicle.getColor());
            }
        }
        return colors;
    }

    public static ArrayList<Vehicle> getAllVehicles(){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT * FROM Vehicles";
            Statement stmt = (Statement) conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            while(rs.next()){
                Integer idV = rs.getInt(1);
                String modelName = rs.getString(2);
                String color = rs.getString(3);
                Boolean disponibility = rs.getBoolean(4);
                String brandName = rs.getString(5);
                Boolean vehicleState = rs.getBoolean(6);
                float price = rs.getFloat(7);
                String type = rs.getString(8);
                Integer passengers = rs.getInt(9);
                String fuelType = rs.getString(10);
                String gearType = rs.getString(11);
                float deposit = rs.getFloat(12);
                Integer trunkCapacity = rs.getInt(13);
                Integer maxSpeed = rs.getInt(14);
                Integer horsePower = rs.getInt(15);
                vehicles.add(new Vehicle(idV, brandName, modelName,color,disponibility, vehicleState,price,type,passengers,fuelType,gearType,deposit,trunkCapacity,maxSpeed,horsePower));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }

    public static Vehicle getVehiclesById(int id){
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT * FROM Vehicles  WHERE idV ="+id;
            Statement stmt = (Statement) conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            if (rs.next()){
                String modelName = rs.getString(2);
                String color = rs.getString(3);
                Boolean disponibility = rs.getBoolean(4);
                String brandName = rs.getString(5);
                Boolean vehicleState = rs.getBoolean(6);
                float price = rs.getFloat(7);
                String type = rs.getString(8);
                Integer passengers = rs.getInt(9);
                String fuelType = rs.getString(10);
                String gearType = rs.getString(11);
                float deposit = rs.getFloat(12);
                Integer trunkCapacity = rs.getInt(13);
                Integer maxSpeed = rs.getInt(14);
                Integer horsePower = rs.getInt(15);
                return new Vehicle(id, brandName, modelName,color,disponibility, vehicleState,price,type,passengers,fuelType,gearType,deposit,trunkCapacity,maxSpeed,horsePower);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static boolean addToDatabase(Vehicle v){
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "INSERT INTO Users VALUES(null," + v.getId() + "," + v.getModelName() + "," + v.getColor()
                    + "," + v.getDisponibility() + "," + v.getBrandName() + "," + v.getVehicleState() + "," + v.getPrice()
                    + "," + v.getType() + "," + v.getPassengers() + "," + v.getFuelType() + "," + v.getGearType()
                    + "," + v.getDeposit() + "," + v.getTrunkCapacity() + "," + v.getMaxSpeed() + "," + v.getHorsePower() + ")";
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
            stmt.close();
            return rs > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public static ArrayList<Vehicle> filterVehicles(ArrayList<Object> filterSettings) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        return vehicles;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", passengers=" + passengers +
                ", fuelType='" + fuelType + '\'' +
                ", gearType='" + gearType + '\'' +
                ", deposit=" + deposit +
                ", maxSpeed=" + maxSpeed +
                ", horsePower=" + horsePower +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", brandImage='" + brandImage + '\'' +
                ", brandName='" + brandName + '\'' +
                ", modelName='" + modelName + '\'' +
                '}';
    }
}
