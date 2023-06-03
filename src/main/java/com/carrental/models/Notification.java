package com.carrental.models;
import com.carrental.SingletonConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class Notification {
    public int idN;
    public int idU;
    public String title;
    public String content;
    public boolean read;
    public Date date;

    public Notification(int idN, int idU, String title, String content, boolean read, Date date) {
        this.idN = idN;
        this.idU = idU;
        this.title = title;
        this.content = content;
        this.read = read;
        this.date = date;
    }

    public int getIdN() {
        return idN;
    }

    public void setIdN(int idN) {
        this.idN = idN;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static Notification create(User user,String title,String content){
        boolean read = false;
        try {
            Connection conn = SingletonConnection.getConnection();
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
            String currentDateTime = format.format(date);
            String req = "INSERT INTO Notifications VALUES(null," + user.getId() + ", '" + title + "', '" + content + "', " + read + ",'" +currentDateTime + "')";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(req,Statement.RETURN_GENERATED_KEYS);
            int id=-1;
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()) {
                id = rs.getInt(1);
            }
            stmt.close();
            return new Notification(id, user.getId(), title,content,read,date);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<Notification> getNotificationsForUser(User user){
        ArrayList<Notification> notifications = new ArrayList<>();
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT * FROM Notifications WHERE idU = " + user.getId() ;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            while(rs.next()){
                int id = rs.getInt(1);
                String title = rs.getString(3);
                String content = rs.getString(4);
                boolean read = rs.getBoolean(5);
                Date date = rs.getDate(6);
                notifications.add(new Notification(id, user.getId(), title,content,read,date));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return notifications;
    }
}
