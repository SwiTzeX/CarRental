package com.carrental.models;

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
