package com.carrental.models;

import com.carrental.SingletonConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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
    public String plate;
    public Vehicle(Integer id, String brandName, String modelName, String color, Boolean disponibility, Boolean vehicleState, float price, String type, Integer passengers, String fuelType, String gearType, float deposit, Integer trunkCapacity, Integer maxSpeed, Integer horsePower,String plate) {
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
        this.plate = plate;
    }

    public Vehicle(String modelName, String color, Boolean disponibility, String brandName, Boolean vehicleState, float price, String type, Integer passengers, String fuelType, String gearType, float deposit, Integer trunkCapacity, Integer maxSpeed, Integer horsePower, String image, String brandImage, String plate) {
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
        this.image = image;
        this.brandImage = brandImage;
        this.plate = plate;
    }

    public Vehicle(Integer id, String modelName, Boolean disponibility, String brandName, float price, String plate) {
        this.id = id;
        this.modelName = modelName;
        this.disponibility = disponibility;
        this.brandName = brandName;
        this.price = price;
        this.plate = plate;
    }

    public Vehicle(){}


    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Vehicles SET plate = '" + plate + "' WHERE idV = " + this.getId();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.plate = plate;
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

    public static ArrayList<String> getAllBrandsAvailable(ArrayList<Vehicle> vehicles) {
        ArrayList<String> brands =new ArrayList<String>();
        for(Vehicle vehicle:vehicles){
            if (!brands.contains(vehicle.getBrandName())) {
                brands.add(vehicle.getBrandName());
            }
        }
        return brands;
    }
    public static ArrayList<String> getAllColorsAvailable(ArrayList<Vehicle> vehicles) {
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
                String plate = rs.getString(16);
                vehicles.add(new Vehicle(idV, brandName, modelName,color,disponibility, vehicleState,price,type,passengers,fuelType,gearType,deposit,trunkCapacity,maxSpeed,horsePower,plate));
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
                String plate = rs.getString(16);
                return new Vehicle(id, brandName, modelName,color,disponibility, vehicleState,price,type,passengers,fuelType,gearType,deposit,trunkCapacity,maxSpeed,horsePower,plate);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public static Vehicle create(String brandName, String modelName, String color, Boolean disponibility, Boolean vehicleState, float price, String type, Integer passengers, String fuelType, String gearType, float deposit, Integer trunkCapacity, Integer maxSpeed, Integer horsePower,String plate){
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
            return new Vehicle(id,brandName,modelName,color,disponibility,vehicleState,price,type,passengers,fuelType,gearType,deposit,trunkCapacity,maxSpeed,horsePower,plate);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//(family, null, tonobil, red, null)
    public static ArrayList<Vehicle> filterVehicles(ArrayList<String> filterSettings,Date pickupDate,Date returnDate) {
        try{
            boolean and = false;
            ArrayList<Vehicle> vehicles = new ArrayList<>();
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT * FROM Vehicles ";
            if(filterSettings.get(0) != null){
                req += "WHERE gearType = '" + filterSettings.get(0) + "' ";
                and = true;
            }
            if(filterSettings.get(1) != null){
                if(and){
                    req += "AND ";
                }else{
                    req += "WHERE ";
                    and = true;
                }
                req += "fuelType = '" + filterSettings.get(1) + "' ";
            }
            if(filterSettings.get(2) != null){
                if(and){
                    req += "AND ";
                }else{
                    req += "WHERE ";
                    and = true;
                }
                req += "brandName = '" + filterSettings.get(2) + "' ";
            }
            if(filterSettings.get(3) != null){
                if(and){
                    req += "AND ";
                }else{
                    req += "WHERE ";
                    and = true;
                }
                req += "color = '" + filterSettings.get(3) + "' ";
            }
            if(filterSettings.get(4) != null) {
                if (and) {
                    req += "AND ";
                }else{
                    req += "WHERE ";
                    and = true;
                }
                req += "type = '" + filterSettings.get(4) + "' ";
            }
            if(filterSettings.get(5) != null){
                if (and) {
                    req += "AND ";
                }else{
                    req += "WHERE ";
                    and = true;
                }
                req += "modelName = '" + filterSettings.get(5) + "' ";
            }
            if(filterSettings.get(6) != null){
                if (and) {
                    req += "AND ";
                }else{
                    req += "WHERE ";
                    and = true;
                }
                req += "disponibility = '" + filterSettings.get(6) + "' ";
            }
            if(pickupDate != null || returnDate!= null) {
                if (and) {
                    req += "AND ";
                } else {
                    req += "WHERE ";
                }
                and = false;
                req += "idV NOT IN ( SELECT idV FROM Reservations WHERE ";
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                if (returnDate != null) {
                    String rDate = format.format(returnDate);
                    req += "startDate <= '" + rDate + "' ";
                    and = true;
                }
                if (pickupDate != null) {
                    if (and) {
                        req += "AND ";
                    }
                    String pDate = format.format(pickupDate);
                    req +="endDate >= '" + pDate + "' ";
                }
                req +=")";
            }
            System.out.println(req);
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
                String plate = rs.getString(16);
                vehicles.add(new Vehicle(idV, brandName, modelName,color,disponibility, vehicleState,price,type,passengers,fuelType,gearType,deposit,trunkCapacity,maxSpeed,horsePower,plate));
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
                int stat = rs.getInt(5);
                reservations.add(new Reservation(User.getUserById(idU), Vehicle.getVehiclesById(idV), startDate, endDate, stat));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reservations;
    }
    public static ArrayList<Integer> getAllVehicleId(){
        ArrayList<Integer> listIdVehicle = new ArrayList<>();
        try{
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT idV FROM Vehicles";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            while(rs.next()){
                int id = rs.getInt(1);
                listIdVehicle.add(id);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return listIdVehicle;
    }
    public static float getRevenueOfBrand(String brand){
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT SUM(price*DATEDIFF(endDate,startDate)) FROM Reservations NATURAL JOIN Vehicles WHERE brandName = '" + brand+"'" ;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            if(rs.next()){
                return rs.getFloat(1);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
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
