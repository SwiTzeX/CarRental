package com.carrental.models;

public class Comments {
    public Integer idCom;
    public Integer userId;
    public String descriptionCom;

    public Comments(Integer idCom, Integer userId, String descriptionCom) {
        this.idCom = idCom;
        this.userId = userId;
        this.descriptionCom = descriptionCom;
    }

    public Integer getIdCom() {
        return this.idCom;
    }

    public void setIdCom(Integer idCom) {
        this.idCom = idCom;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDescriptionCom() {
        return this.descriptionCom;
    }

    public void setDescriptionCom(String descriptionCom) {
        this.descriptionCom = descriptionCom;
    }

    @Override
    public String toString() {
        return "CommentsDTO{" +
                "idCom=" + idCom +
                ", descriptionCom='" + descriptionCom + '\'' +
                '}';
    }
}
