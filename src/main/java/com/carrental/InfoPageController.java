package com.carrental;

import com.carrental.models.Vehicle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class InfoPageController {

    @FXML
    private Button btnBookNow;

    @FXML
    private ImageView carpic;

    @FXML
    private Label comment;

    @FXML
    private Label infoBrand;

    @FXML
    private Label infoColor;

    @FXML
    private Label infoDuration;

    @FXML
    private Label infoEndDate;

    @FXML
    private Label infoFuel;

    @FXML
    private Label infoGear;

    @FXML
    private Label infoHp;

    @FXML
    private Label infoModel;

    @FXML
    private Label infoPpd;

    @FXML
    private Label infoPsngr;

    @FXML
    private Label infoStartDate;

    @FXML
    private Label infoTotP;

    @FXML
    private Label infoTrunk;

    @FXML
    private Label username;

    public void setData(Vehicle vehicle){

        Image image = new Image(getClass().getResourceAsStream(vehicle.getImage()));
        carpic.setImage(image);
        infoBrand.setText(vehicle.getBrandName());
        infoModel.setText(vehicle.getModelName());
        infoColor.setText(vehicle.getColor());
        infoHp.setText(vehicle.getHorsePower().toString());
        infoFuel.setText(vehicle.fuelType);
        infoGear.setText(vehicle.gearType);
        infoTrunk.setText(vehicle.getTrunkCapacity().toString());


        /*
        vehBrandModel.setText(vehicle.getBrandName() + " " + vehicle.getModelName());
        vehType.setText(vehicle.getType());
        vehPrice.setText(String.valueOf(vehicle.getPrice())+" DH");
        vehPassengers.setText(String.valueOf(vehicle.getPassengers()));
        vehMaxSpeed.setText(String.valueOf(vehicle.getMaxSpeed())+"km");
        vehDeposit.setText(String.valueOf(vehicle.getDeposit())+"DH");
        vehFuelType.setText(vehicle.getFuelType());
        vehGearType.setText(vehicle.getGearType());
        vehHorsePower.setText(String.valueOf(vehicle.getHorsePower()));
        Image image = new Image(getClass().getResourceAsStream(vehicle.getImage()));
        vehImage.setImage(image);
        Image brandImage = new Image(getClass().getResourceAsStream(vehicle.getBrandImage()));
        vehBrandImage.setImage(brandImage);
        vehTrunkCapacityLabel.setText(String.valueOf(vehicle.getTrunkCapacity()));

         */
    }

}
