package com.carrental.models;

import com.carrental.SingletonConnection;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class Reservation {
    public User user;
    public Vehicle vehicle;
    public Date startDate;
    public Date endDate;
    public Boolean status;

    public Reservation(User user, Vehicle vehicle, Date startDate, Date endDate, Boolean status) {
        this.user = user;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Reservations SET idU = " + user.getId() + " WHERE idU = " + this.user.getId()
                    + " AND idV = " + this.vehicle.getId() + " AND startDate = " + this.startDate;
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Reservations SET idV = " + vehicle.getId() + " WHERE idU = " + this.user.getId()
                    + " AND idV = " + this.vehicle.getId() + " AND startDate = " + this.startDate;
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.vehicle = vehicle;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Reservations SET startDate = " + this.startDate + " WHERE idU = " + this.user.getId()
                    + " AND idV = " + this.vehicle.getId() + " AND startDate = " + this.startDate;
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Reservations SET endDate = " + this.endDate + " WHERE idU = " + this.user.getId()
                    + " AND idV = " + this.vehicle.getId() + " AND startDate = " + this.startDate;
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.endDate = endDate;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Reservations SET status = " + this.status + " WHERE idU = " + this.user.getId()
                    + " AND idV = " + this.vehicle.getId() + " AND startDate = " + this.startDate;
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.status = status;
    }

    public static Reservation create(User user, Vehicle vehicle, Date startDate, Date endDate, Boolean status){
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "INSERT INTO Reservations VALUES (" + user.getId() + ","
                    + vehicle.getId() + ", ? , ?," + status + ")";
            PreparedStatement pstmt = conn.prepareStatement(req);
            pstmt.setDate(1, new java.sql.Date(startDate.getTime()));
            pstmt.setDate(2, new java.sql.Date(endDate.getTime()));
            int rs = pstmt.executeUpdate();
            if(rs < 0) {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new Reservation(user, vehicle, startDate, endDate, status);
    }

    public boolean delete(){
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "DELETE FROM Reservations WHERE idU = " + this.user.getId() + " AND idV = " + this.vehicle.getId()
                    + " AND startDate = " + startDate;
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
            stmt.close();
            return rs > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*public static Reservation getReservationById(int idU, int idV, Date startDate){
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT * FROM Reservations WHERE idU="+idU+" AND idV="+idV+" AND startDate="+startDate;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            if(rs.next()){
                Date startDate1 = rs.getDate(3);
                Date endDate = rs.getDate(4);
                Boolean status = rs.getBoolean(5);
                return new Reservation(User.getUserById(idU), Vehicle.getVehiclesById(idV), startDate1, endDate, status);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }*/

    public static ArrayList<Reservation> getAllReservationsByStatus(Boolean status){
        ArrayList<Reservation> reservations = new ArrayList<>();
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT * FROM Reservations WHERE status = " + status;
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

    public static ArrayList<Reservation> getAllReservations(){
        ArrayList<Reservation> reservations = new ArrayList<>();
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT * FROM Reservations";
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

    public static ArrayList<Reservation> getAllReservationsByMonth(int month){
        ArrayList<Reservation> reservations = new ArrayList<>();
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT * FROM Reservations WHERE MONTH(startDate) = " + month ;
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

    public float totalPrice(){
        long durationInMillis = this.endDate.getTime() - this.startDate.getTime();
        long daysBetween = TimeUnit.MILLISECONDS.toDays(durationInMillis);
        return this.vehicle.getPrice() * daysBetween;
    }
    public static float totalSales(){
        ArrayList<Reservation> list = getAllReservationsByStatus(true);
        float total = 0;
        for(Reservation res : list){
            total += res.totalPrice();
        }
        return total;
    }
    public static float totalSaleInMonth(int month){
        ArrayList<Reservation> list = getAllReservationsByMonth(month);
        float total = 0;
        for(Reservation res : list){
            total += res.totalPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "user=" + user +
                ", vehicle=" + vehicle +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                '}';
    }
}
