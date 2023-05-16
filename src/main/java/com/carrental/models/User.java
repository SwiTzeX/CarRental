package com.carrental.models;

import com.carrental.SingletonConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User {
    public Integer id;
    public String email;
    public String phoneNumber;
    public boolean status;
    public Integer age;
    public String fullName;
    public String password;
    public boolean isAdmin;

    public User(Integer id, String email, String phoneNumber, boolean status, Integer age, String fullName, String password, boolean isAdmin) {
        this.id = id;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.age = age;
        this.fullName = fullName;
        this.password = password;
        this.isAdmin = isAdmin;
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
            String req = "UPDATE User SET idU = " + id + " WHERE idU = " + this.getId();
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
            String req = "UPDATE User SET email = " + email + " WHERE idU = " + this.getId();
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
        this.phoneNumber = phoneNumber;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
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
                String email = rs.getString(2);
                String phoneNumber = rs.getString(3);
                boolean status = rs.getBoolean(4);
                int age = rs.getInt(5);
                String fullName = rs.getString(6);
                String password = rs.getString(7);
                boolean isAdmin = rs.getBoolean(8);
                users.add(new User(id,email,phoneNumber,status,age,fullName,password,isAdmin));
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
                String email = rs.getString(2);
                String phoneNumber = rs.getString(3);
                boolean status = rs.getBoolean(4);
                int age = rs.getInt(5);
                String fullName = rs.getString(6);
                String password = rs.getString(7);
                boolean isAdmin = rs.getBoolean(8);
                return new User(id,email,phoneNumber,status,age,fullName,password,isAdmin);
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
            String req = "SELECT * FROM Users WHERE email="+email;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            if(rs.next()){
                int id = rs.getInt(1);
                String phoneNumber = rs.getString(3);
                boolean status = rs.getBoolean(4);
                int age = rs.getInt(5);
                String fullName = rs.getString(6);
                String password = rs.getString(7);
                boolean isAdmin = rs.getBoolean(8);
                return new User(id,email,phoneNumber,status,age,fullName,password,isAdmin);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public static boolean create(String email, String phoneNumber, boolean status, Integer age, String fullName, String password, boolean isAdmin){
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "INSERT INTO Users VALUES(null," + email + "," + phoneNumber + "," + status + "," +age + "," + fullName+ "," + password + "," + isAdmin + ")";
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
            stmt.close();
            return rs > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delete(){
        try {
            Connection conn = SingletonConnection.getConnection();
            System.out.println(this.getId());
            String req = "DELETE FROM Users WHERE idU="+this.getId()+" OR email="+this.getEmail();
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
            return rs > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
}
