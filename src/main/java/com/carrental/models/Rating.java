package com.carrental.models;

public class Rating {
    public Integer idRating;
    public Integer userId;
    public Integer starNumber;

    public Rating(Integer idRating, Integer userId, Integer starNumber) {
        this.idRating = idRating;
        this.userId = userId;
        this.starNumber = starNumber;
    }

    public Integer getIdRating() {
        return this.idRating;
    }

    public void setIdRating(Integer idRating) {
        this.idRating = idRating;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStarNumber() {
        return this.starNumber;
    }

    public void setStarNumber(Integer starNumber) {
        this.starNumber = starNumber;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "idRating=" + idRating +
                ", userId=" + userId +
                ", starNumber=" + starNumber +
                '}';
    }
}
