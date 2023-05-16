package com.carrental.models;

import com.carrental.SingletonConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

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
                    + " AND idV = " + this.vehicle.getId() + "AND startDate = " + this.startDate;
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
                    + " AND idV = " + this.vehicle.getId() + "AND startDate = " + this.startDate;
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
                    + " AND idV = " + this.vehicle.getId() + "AND startDate = " + this.startDate;
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
                    + " AND idV = " + this.vehicle.getId() + "AND startDate = " + this.startDate;
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
                    + " AND idV = " + this.vehicle.getId() + "AND startDate = " + this.startDate;
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
            String req = "DELETE FROM Reservations WHERE idU = " + this.user.getId() + "AND idV = " + this.vehicle.getId()
                    + "AND startDate = " + startDate;
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
            stmt.close();
            return rs > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
