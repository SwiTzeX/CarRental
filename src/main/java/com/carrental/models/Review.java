package com.carrental.models;

import com.carrental.SingletonConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class Review {
    public Integer idR;
    public Integer idU;
    public Integer stars;
    public String comment;

    public Review(Integer idR, Integer idU, Integer stars, String comment) {
        this.idR = idR;
        this.idU = idU;
        this.stars = stars;
        this.comment = comment;
    }

    public Integer getIdR() {
        return this.idR;
    }

    public void setIdR(Integer idR) {
        this.idR = idR;
    }

    public Integer getIdU() {
        return this.idU;
    }

    public void setIdU(Integer idU) {
        this.idU = idU;
    }



    public Integer getStars() {
        return this.stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
//select top 100 * from myTable

    public ArrayList<Review> getComments(){
        ArrayList<Review> reviews = new ArrayList<>();
        try {
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT * FROM Reviews ORDER BY ? ASC LIMIT 25";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            while(rs.next()){
                int idR = rs.getInt(2);
                int idU = rs.getInt(3);
                int stars = rs.getInt(4);
                String comment = rs.getString(5);
                reviews.add(new Review(idR, idU, stars, comment));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reviews;

    }

    @Override
    public String toString() {
        return "Review{" +
                "idR=" + idR +
                ", idU=" + idU +
                ", stars=" + stars +
                ", comment='" + comment + '\'' +
                '}';
    }
}
