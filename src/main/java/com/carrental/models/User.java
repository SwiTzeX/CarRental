package com.carrental.models;


import com.carrental.SingletonConnection;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class User {
    public Integer id;
    public String nId;
    public String email;
    public String phoneNumber;
    public boolean status;
    public Integer age;
    public String fullName;
    public String password;
    public Date creationDate;
    public boolean isAdmin;
    private SingletonConnection DatabaseManager;


    public User(Integer id,String nId, String email, String phoneNumber, boolean status, Integer age, String fullName, String password, boolean isAdmin,Date creationDate) {
        this.id = id;
        this.nId = nId;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.age = age;
        this.fullName = fullName;
        this.password = password;
        this.isAdmin = isAdmin;
        this.creationDate = creationDate;
    }


    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Users SET creationDate = " + new java.sql.Date(creationDate.getTime()) + " WHERE idU = " + this.getId();
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.creationDate = creationDate;
    }

    public String getNId() {
        return nId;
    }

    public void setNId(String nId) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Users SET nid = '" + nId + "' WHERE idU = " + this.getId();
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.nId = nId;
    }

    public String getEmail(int i) {
        return this.email;
    }

    public String getPhoneNumber(int i) {
        return this.phoneNumber;
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Users SET idU = " + id + " WHERE idU = " + this.getId();
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Users SET email = '" + email + "' WHERE idU = " + this.getId();
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Users SET phoneNumber = " + phoneNumber + " WHERE idU = " + this.getId();
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.phoneNumber = phoneNumber;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Users SET status = " + status + " WHERE idU = " + this.getId();
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.status = status;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Users SET age = " + age + " WHERE idU = " + this.getId();
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.age = age;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Users SET fullName = '" + fullName + "' WHERE idU = " + this.getId();
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fullName = fullName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Users SET password = '" + password + "' WHERE idU = " + this.getId();
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.password = password;
    }

    public boolean getIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Users SET isAdmin = " + isAdmin + " WHERE idU = " + this.getId();
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.isAdmin = isAdmin;
    }


    //Database
    public static ArrayList<User> getAllUsers(){
        ArrayList<User> users = new ArrayList<>();
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT * FROM Users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            while(rs.next()){
                int id = rs.getInt(1);
                String nid = rs.getString(2);
                String email = rs.getString(3);
                String phoneNumber = rs.getString(4);
                boolean status = rs.getBoolean(5);
                int age = rs.getInt(6);
                String fullName = rs.getString(7);
                String password = rs.getString(8);
                Date creationDate = rs.getTimestamp(9);
                boolean isAdmin = rs.getBoolean(10);
                users.add(new User(id,nid,email,phoneNumber,status,age,fullName,password,isAdmin,creationDate));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
    public static User getUserById(int id){
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT * FROM Users WHERE idU="+id;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            if(rs.next()){
                String nid = rs.getString(2);
                String email = rs.getString(3);
                String phoneNumber = rs.getString(4);
                boolean status = rs.getBoolean(5);
                int age = rs.getInt(6);
                String fullName = rs.getString(7);
                String password = rs.getString(8);
                Date creationDate = rs.getTimestamp(9);
                boolean isAdmin = rs.getBoolean(10);
                return new User(id,nid,email,phoneNumber,status,age,fullName,password,isAdmin,creationDate);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public static User getUserByEmail(String email){
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT * FROM Users WHERE email='"+email+"'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            if(rs.next()){
                int id = rs.getInt(1);
                String nid = rs.getString(2);
                String phoneNumber = rs.getString(4);
                boolean status = rs.getBoolean(5);
                int age = rs.getInt(6);
                String fullName = rs.getString(7);
                String password = rs.getString(8);
                Date creationDate = rs.getTimestamp(9);
                boolean isAdmin = rs.getBoolean(10);
                return new User(id,nid,email,phoneNumber,status,age,fullName,password,isAdmin,creationDate);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public static User create(String nid,String email, String phoneNumber, Integer age, String fullName, String password){
        boolean status = true;
        boolean isAdmin = false;
        try {
            Connection conn = SingletonConnection.getConnection();
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
            String currentDateTime = format.format(date);
            String req = "INSERT INTO Users VALUES(null,'" + nid + "', '" + email + "', '" + phoneNumber + "', " + status + "," +age + ", '" + fullName+ "', '" + password + "', '" +currentDateTime + "', " + isAdmin + ")";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req,Statement.RETURN_GENERATED_KEYS);
            int id=-1;
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()) {
                id = rs.getInt(1);
            }
            stmt.close();
            return new User(id,nid,email,phoneNumber,status,age,fullName,password,isAdmin,date);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delete() {
        try {
            Connection conn = SingletonConnection.getConnection();
            conn.setAutoCommit(false);

            // Supprimer les réservations associées à l'utilisateur
            String deleteReservationsQuery = "DELETE FROM Reservations WHERE idU=" + this.getId();
            Statement deleteReservationsStmt = conn.createStatement();
            deleteReservationsStmt.executeUpdate(deleteReservationsQuery);

            // Supprimer les notifications associées à l'utilisateur
            String deleteNotificationsQuery = "DELETE FROM Notifications WHERE idU=" + this.getId();
            Statement deleteNotificationsStmt = conn.createStatement();
            deleteNotificationsStmt.executeUpdate(deleteNotificationsQuery);

            // Supprimer l'utilisateur de la table Users
            String deleteUserQuery = "DELETE FROM Users WHERE idU=" + this.getId() + " OR email='" + this.getEmail() + "'";
            Statement deleteUserStmt = conn.createStatement();
            int affectedRows = deleteUserStmt.executeUpdate(deleteUserQuery);

            conn.commit();
            conn.setAutoCommit(true);

            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public ArrayList<Notification> getAllNotifications(){
        return Notification.getAllNotificationsForUser(this);
    }
    public ArrayList<Notification> getAllUnreadNotifications(){
        return Notification.getAllUnreadNotificationsForUser(this);
    }
    public ArrayList<Reservation> getReservations(){
        return Reservation.getUserReservations(this);
    }
    public void sendNotification(String title,String content){
         Notification.create(this,title,content);
    }


    public boolean checkPassword(String password){
        return this.getPassword().equals(password);
    }

    @Override
    public String toString() {
        return "User{" +
                "idU='" + id + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", status=" + status +
                ", age=" + age +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
    public static User createUser(String nId, String email, String phoneNumber, boolean status, Integer age, String fullName, String password, boolean isAdmin, Date creationDate) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "INSERT INTO Users (nId, email, phoneNumber, status, age, fullName, password, isAdmin, creationDate) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, nId);
            stmt.setString(2, email);
            stmt.setString(3, phoneNumber);
            stmt.setBoolean(4, status);
            stmt.setInt(5, age);
            stmt.setString(6, fullName);
            stmt.setString(7, password);
            stmt.setBoolean(8, isAdmin);
            stmt.setDate(9, new java.sql.Date(creationDate.getTime()));
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                return new User(id, nId, email, phoneNumber, status, age, fullName, password, isAdmin, creationDate);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static ArrayList<Integer> getAllUsersId(){
        ArrayList<Integer> listIdUser = new ArrayList<>();
        try{
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT idU FROM Users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            while(rs.next()){
                int id = rs.getInt(1);
                listIdUser.add(id);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return listIdUser;
    }

}
