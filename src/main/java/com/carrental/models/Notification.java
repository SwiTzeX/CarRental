package com.carrental.models;
import com.carrental.SingletonConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Notifications SET title = '" + title + "' WHERE idN = " + this.getIdN();
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Notifications SET content = '" + content + "' WHERE idN = " + this.getIdN();
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.content = content;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "UPDATE Notifications SET `read` = " + read + " WHERE idN = " + this.getIdN();
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
    public boolean delete() {
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "DELETE FROM Notifications WHERE idN=" + this.getIdN();
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(req);
            return rs > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<Notification> getAllNotificationsForUser(User user){
        ArrayList<Notification> notifications = new ArrayList<>();
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT * FROM Notifications WHERE idU = " + user.getId()+" ORDER BY date desc" ;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            while(rs.next()){
                int id = rs.getInt(1);
                String title = rs.getString(3);
                String content = rs.getString(4);
                boolean read = rs.getBoolean(5);
                Date date = rs.getTimestamp(6);
                notifications.add(new Notification(id, user.getId(), title,content,read,date));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return notifications;
    }
    public static ArrayList<Notification> getAllUnreadNotificationsForUser(User user){
        ArrayList<Notification> notifications = new ArrayList<>();
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT * FROM Notifications WHERE idU = " + user.getId()+" AND `read`=0" ;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            while(rs.next()){
                int id = rs.getInt(1);
                String title = rs.getString(3);
                String content = rs.getString(4);
                boolean read = rs.getBoolean(5);
                Date date = rs.getTimestamp(6);
                notifications.add(new Notification(id, user.getId(), title,content,read,date));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return notifications;
    }

    public String getTime() {
        long inputTimeMillis = this.getDate().getTime();
        long currentTimeMillis = System.currentTimeMillis();
        long timeDifferenceMillis = currentTimeMillis - inputTimeMillis;

        boolean isFuture = inputTimeMillis > currentTimeMillis;

        long seconds = TimeUnit.MILLISECONDS.toSeconds(timeDifferenceMillis);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(timeDifferenceMillis);
        long hours = TimeUnit.MILLISECONDS.toHours(timeDifferenceMillis);
        long days = TimeUnit.MILLISECONDS.toDays(timeDifferenceMillis);
        long weeks = days / 7L;

        String result = "";

        if (weeks > 0) {
            result += weeks + ("w");
        } else if (days > 0) {
            result += days + ("d");
        } else if (hours > 0) {
            result += hours + ("h");
        } else if (minutes > 0) {
            result += minutes + ("m");
        } else {
            result += seconds + ("s");
        }

        result += isFuture ? " left" : " ago";

        return result;
    }

}
