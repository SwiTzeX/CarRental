package com.carrental.tables;

import com.carrental.SingletonConnection;
import com.carrental.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataReservation {
    public int idU;
    public int idV;
    public String fullName;
    public String phoneNumber;
    public String brandName;
    public String modelName;
    public float price;
    public Date startDate;
    public Date endDate;
    public String status;

    public DataReservation(int idU, int idV, String fullName, String phoneNumber, String brandName, String modelName, float price, Date startDate, Date endDate, String status) {
        this.idU = idU;
        this.idV = idV;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.brandName = brandName;
        this.modelName = modelName;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        if(status.equals("0")){
            this.status = "Pending";
        }else if(status.equals("1")){
            this.status = "Approved";
        }else if(status.equals("2")){
            this.status = "Ended";
        }else if(status.equals("-2")){
            this.status = "Ended";
        }else{
            this.status = "Denied";
        }
    }

    public DataReservation(String fullName, String phoneNumber, String brandName, String modelName, float price, Date startDate, Date endDate, String status) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.brandName = brandName;
        this.modelName = modelName;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public int getIdV() {
        return idV;
    }

    public void setIdV(int idV) {
        this.idV = idV;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "DataReservation{" +
                "fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", brandName='" + brandName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", price=" + price +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                '}';
    }
}
