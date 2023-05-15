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
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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
            String req = "SELECT * FROM Users WHERE idUser="+id;
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
    public static boolean addToDatabase(User u){
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "INSERT INTO Users VALUES(null," + u.getEmail() + "," + u.getPhoneNumber() + "," + u.getStatus() + "," +u.getAge() + "," + u.getFullName() + "," + u.getPassword() + "," + u.getIsAdmin() + ")";
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
            stmt.close();
            return rs > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean updateInDatabase(User u){
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE INTO Users VALUES("+u.getId()+"," + u.getEmail() + "," + u.getPhoneNumber() + "," + u.getStatus() + "," +u.getAge() + "," + u.getFullName() + "," + u.getPassword() + "," + u.getIsAdmin() + ")";
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean deleteFromDatabase(User u){
        if( u == null){
            return false;
        }
        try {
            Connection conn = SingletonConnection.getConnection();
            System.out.println(u.getId());
            String req = "DELETE FROM Users WHERE idUser="+u.getId()+" OR email="+u.getEmail();
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean checkUserPassword(User user,String password){
        assert user != null;
        if (!user.getPassword().equals(password)){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + id + '\'' +
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
