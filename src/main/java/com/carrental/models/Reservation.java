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
    public int status;

    public Reservation(User user, Vehicle vehicle, Date startDate, Date endDate, int status) {
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
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
            String startDate = format.format(this.startDate);
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Reservations SET idU = " + user.getId() + " WHERE idU = " + this.user.getId()
                    + " AND idV = " + this.vehicle.getId() + " AND startDate = '" + startDate + "'";
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
            if(rs == 1){
                this.user = user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
            String startDate = format.format(this.startDate);
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Reservations SET idV = " + vehicle.getId() + " WHERE idU = " + this.user.getId()
                    + " AND idV = " + this.vehicle.getId() + " AND startDate = '" + startDate + "'";
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
            if (rs==1){
                this.vehicle = vehicle;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
            String dateStart = format.format(startDate);
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Reservations SET startDate = '" + dateStart + "' WHERE idU = " + this.user.getId()
                    + " AND idV = " + this.vehicle.getId() + " AND startDate = '" + format.format(this.startDate) + "'";
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
            if (rs==1){
                this.startDate = startDate;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
            String dateEnd = format.format(endDate);
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Reservations SET endDate = '" + dateEnd + "' WHERE idU = " + this.user.getId()
                    + " AND idV = " + this.vehicle.getId() + " AND startDate = '" + format.format(this.startDate) + "'";
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
            if (rs==1){
                this.endDate = endDate;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
            String startDate = format.format(this.startDate);
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Reservations SET status = " + status + " WHERE idU = " + this.user.getId()
                    + " AND idV = " + this.vehicle.getId() + " AND startDate = '" + startDate + "'";
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
            if (rs==1){
                this.status = status;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Reservation create(User user, Vehicle vehicle, Date startDate, Date endDate, int status){
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
                    + " AND startDate = '" + this.startDate + "'";
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
            stmt.close();
            return rs > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Reservation getReservationById(int idU, int idV, Date startDate){
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT * FROM Reservations WHERE idU="+idU+" AND idV="+idV+" AND startDate="+startDate;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            if(rs.next()){
                Date startDate1 = rs.getTimestamp(3);
                Date endDate = rs.getTimestamp(4);
                int status = rs.getInt(5);
                return new Reservation(User.getUserById(idU), Vehicle.getVehiclesById(idV), startDate1, endDate, status);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

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
                Date startDate = rs.getTimestamp(3);
                Date endDate = rs.getTimestamp(4);
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
                Date startDate = rs.getTimestamp(3);
                Date endDate = rs.getTimestamp(4);
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
                Date startDate = rs.getTimestamp(3);
                Date endDate = rs.getTimestamp(4);
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
    public static ArrayList<Reservation> getAllReservationsByYear(int year){
        ArrayList<Reservation> reservations = new ArrayList<>();
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT * FROM Reservations WHERE Year(startDate) = " + year ;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            while(rs.next()){
                int idU = rs.getInt(1);
                int idV = rs.getInt(2);
                Date startDate = rs.getTimestamp(3);
                Date endDate = rs.getTimestamp(4);
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

    public static ArrayList<Reservation> getUserReservations(User user){
        ArrayList<Reservation> reservations = new ArrayList<>();
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT * FROM Reservations WHERE idU = " + user.getId();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            while(rs.next()){
                int idU = rs.getInt(1);
                int idV = rs.getInt(2);
                Date startDate = rs.getTimestamp(3);
                Date endDate = rs.getTimestamp(4);
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

    public static ArrayList<Reservation> getVehicleReservations(Vehicle vehicle){
        ArrayList<Reservation> reservations = new ArrayList<>();
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT * FROM Reservations WHERE idV = " + vehicle.getId();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            while(rs.next()){
                int idU = rs.getInt(1);
                int idV = rs.getInt(2);
                Date startDate = rs.getTimestamp(3);
                Date endDate = rs.getTimestamp(4);
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
    public static ArrayList<Reservation> getAllEndedReservations(){
        ArrayList<Reservation> reservations = new ArrayList<>();
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT * FROM Reservations WHERE status = 2";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            while(rs.next()){
                int idU = rs.getInt(1);
                int idV = rs.getInt(2);
                Date startDate = rs.getTimestamp(3);
                Date endDate = rs.getTimestamp(4);
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
    public static float totalSaleInYear(int year){
        ArrayList<Reservation> list = getAllReservationsByYear(year);
        float total = 0;
        for(Reservation res : list){
            total += res.totalPrice();
        }
        return total;
    }
    public static float getGrowth(){
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT CASE WHEN prev_count = 0 THEN current_count * 100 ELSE (current_count - prev_count) / prev_count * 100 END AS growth_percentage FROM (SELECT COUNT(*) AS current_count FROM Reservations WHERE status > 0 AND MONTH(startDate) = MONTH(CURRENT_DATE())) AS current CROSS JOIN (SELECT COUNT(*) AS prev_count FROM Reservations WHERE status = 2 AND MONTH(startDate) >= MONTH(DATE_SUB(CURRENT_DATE(), INTERVAL 2 MONTH)) AND MONTH(startDate) < MONTH(CURRENT_DATE())) AS prev;\n";
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


    public String getTimeLeft() {
        long currentTimeMillis = System.currentTimeMillis();
        long inputTimeMillis = this.getEndDate().getTime();
        long timeDifferenceMillis = Math.abs(currentTimeMillis - inputTimeMillis);

        boolean isFuture = inputTimeMillis > currentTimeMillis;

        long seconds = TimeUnit.MILLISECONDS.toSeconds(timeDifferenceMillis);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(timeDifferenceMillis);
        long hours = TimeUnit.MILLISECONDS.toHours(timeDifferenceMillis);
        long days = TimeUnit.MILLISECONDS.toDays(timeDifferenceMillis);
        long months = days / 30L;
        long years = months / 12L;

        String result = "";

        if (years > 0) {
            result += years + (years == 1 ? " year" : " years");
        } else if (months > 0) {
            result += months + (months == 1 ? " month" : " months");
        } else if (days > 0) {
            result += days + (days == 1 ? " day" : " days");
        } else if (hours > 0) {
            result += hours + (hours == 1 ? " hour" : " hours");
        } else if (minutes > 0) {
            result += minutes + (minutes == 1 ? " minute" : " minutes");
        } else {
            result += seconds + (seconds == 1 ? " second" : " seconds");
        }

        result += isFuture ? "" : " ago";
        return result;
    }

    public double getPercentageOfTimeLeft(){
        long currentTimeMillis = System.currentTimeMillis();
        long endTimeMillis = this.getEndDate().getTime();
        long startTimeMillis = this.getStartDate().getTime();
        long timeDifferenceMillis = Math.abs(currentTimeMillis - endTimeMillis);
        double totalTimeMillis = endTimeMillis - startTimeMillis;
        double percentage = (double) timeDifferenceMillis / totalTimeMillis;
        return (double) percentage*100;
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
