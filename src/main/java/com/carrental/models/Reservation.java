package com.carrental.models;

import java.time.LocalDateTime;

public class Reservation {
    public Integer userId;
    public Integer idVehicle;
    public LocalDateTime startDate;
    public LocalDateTime endDate;
    public Boolean status;

    public Reservation(Integer userId, Integer idVehicle, LocalDateTime startDate, LocalDateTime endDate, Boolean status) {
        this.userId = userId;
        this.idVehicle = idVehicle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIdVehicle() {
        return this.idVehicle;
    }

    public void setIdVehicle(Integer idVehicle) {
        this.idVehicle = idVehicle;
    }

    public LocalDateTime getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "userId=" + userId +
                ", idV=" + idVehicle +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                '}';
    }
}
