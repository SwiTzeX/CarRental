package com.carrental.models;

import com.carrental.SingletonConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

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
        this.brandImage = "brands/"+brandName+".png";
        this.image = "vehicles/"+brandName+"/"+modelName+"/"+color+".png";
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Vehicles SET color = '" + color + "' WHERE idV = " + this.getId();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Vehicles SET type = '" + type + "' WHERE idV = " + this.getId();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.type = type;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Vehicles SET gearType = '" + gearType + "' WHERE idV = " + this.getId();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.gearType = gearType;
    }

    public Integer getPassengers() {
        return passengers;
    }

    public void setPassengers(Integer passengers) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Vehicles SET passengers = " + passengers + " WHERE idV = " + this.getId();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.passengers = passengers;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Vehicles SET fuelType = '" + fuelType + "' WHERE idV = " + this.getId();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fuelType = fuelType;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Vehicles SET deposit = " + deposit + " WHERE idV = " + this.getId();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.deposit = deposit;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Vehicles SET maxSpeed = " + maxSpeed + " WHERE idV = " + this.getId();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.maxSpeed = maxSpeed;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Vehicles SET horsePower = " + horsePower + " WHERE idV = " + this.getId();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.horsePower = horsePower;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Vehicles SET price = " + price + " WHERE idV = " + this.getId();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Vehicles SET brandName = '" + brandName + "' WHERE idV = " + this.getId();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Vehicles SET modelName = '" + modelName + "' WHERE idV = " + this.getId();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.modelName = modelName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Vehicles SET idV = " + id + " WHERE idV = " + this.getId();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.id = id;
    }

    public Boolean getDisponibility() {
        return disponibility;
    }

    public void setDisponibility(Boolean disponibility) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Vehicles SET disponibility = " + disponibility + " WHERE idV = " + this.getId();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.disponibility = disponibility;
    }

    public Boolean getVehicleState() {
        return vehicleState;
    }

    public void setVehicleState(Boolean vehicleState) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Vehicles SET vehicleState = " + vehicleState + " WHERE idV = " + this.getId();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.vehicleState = vehicleState;
    }

    public Integer getTrunkCapacity() {
        return trunkCapacity;
    }

    public void setTrunkCapacity(Integer trunkCapacity) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Vehicles SET trunkCapacity = " + trunkCapacity + " WHERE idV = " + this.getId();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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

    public static Vehicle create(String brandName, String modelName, String color, Boolean disponibility, Boolean vehicleState, float price, String type, Integer passengers, String fuelType, String gearType, float deposit, Integer trunkCapacity, Integer maxSpeed, Integer horsePower){
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "INSERT INTO Vehicles VALUES(null,'" + modelName + "','" + color
                    + "'," + disponibility + ",'" + brandName + "'," + vehicleState + "," + price
                    + ",'" + type + "'," + passengers + ",'" + fuelType + "','" +gearType
                    + "'," + deposit + "," + trunkCapacity + "," + maxSpeed + "," + horsePower + ")";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req,Statement.RETURN_GENERATED_KEYS);
            int id=-1;
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()) {
                id = rs.getInt(1);
            }
            stmt.close();
            return new Vehicle(id,brandName,modelName,color,disponibility,vehicleState,price,type,passengers,fuelType,gearType,deposit,trunkCapacity,maxSpeed,horsePower);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//(family, null, tonobil, red, null)
    public static ArrayList<Vehicle> filterVehicles(ArrayList<String> filterSettings) {
        try{
            boolean and = false;
            ArrayList<Vehicle> vehicles = new ArrayList<>();
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT * FROM Vehicles WHERE ";
            if(filterSettings.get(0) != null){
                req += "gearType = '" + filterSettings.get(0) + "' ";
                and = true;
            }
            if(filterSettings.get(1) != null){
                if(and){
                    req += "AND ";
                }else{
                    and = true;
                }
                req += "fuelType = '" + filterSettings.get(1) + "' ";
            }
            if(filterSettings.get(2) != null){
                if(and){
                    req += "AND ";
                }else{
                    and = true;
                }
                req += "brandName = '" + filterSettings.get(2) + "' ";
            }
            if(filterSettings.get(3) != null){
                if(and){
                    req += "AND ";
                }else{
                    and = true;
                }
                req += "color = '" + filterSettings.get(3) + "' ";
            }
            if(filterSettings.get(4) != null) {
                if (and) {
                    req += "AND ";
                }
                req += "type = '" + filterSettings.get(4) + "' ";
            }
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
            return vehicles;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Reservation> getAllReservations(){
        ArrayList<Reservation> reservations = new ArrayList<>();
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT * FROM Reservations WHERE idV = " + this.getId();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            while(rs.next()){
                int idU = rs.getInt(1);
                int idV = rs.getInt(2);
                Date startDate = rs.getDate(3);
                Date endDate = rs.getDate(4);
                boolean stat = rs.getBoolean(5);
                reservations.add(new Reservation(User.getUserById(idU), Vehicle.getVehiclesById(idV), startDate, endDate, stat));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reservations;
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
