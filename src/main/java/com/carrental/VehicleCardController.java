package com.carrental;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import com.carrental.models.Vehicle;
public class VehicleCardController {

    @FXML
    private Button rentButton;

    @FXML
    private ImageView vehBrandImage;

    @FXML
    private Label vehDeposit;

    @FXML
    private Label vehFuelType;

    @FXML
    private Label vehGearType;

    @FXML
    private Label vehHorsePower;

    @FXML
    private ImageView vehImage;

    @FXML
    private Label vehMaxSpeed;

    @FXML
    private Label vehPassengers;

    @FXML
    private Label vehPrice;

    @FXML
    private Label vehType;

    public void setData(Vehicle vehicle){
        vehType.setText(vehicle.getType());
        vehPrice.setText(String.valueOf(vehicle.getPrice())+".00 DH");
        vehPassengers.setText(String.valueOf(vehicle.getPassengers()));
        vehMaxSpeed.setText(String.valueOf(vehicle.getMaxSpeed())+"km");
        vehDeposit.setText(String.valueOf(vehicle.getMaxSpeed())+"kg");
        vehFuelType.setText(vehicle.getFuelType());
        vehGearType.setText(vehicle.getGearType());
        vehHorsePower.setText(String.valueOf(vehicle.getHorsePower()));
        Image image = new Image(getClass().getResourceAsStream(vehicle.getImage()));
        vehImage.setImage(image);
        Image brandImage = new Image(getClass().getResourceAsStream(vehicle.getBrandImage()));
        vehBrandImage.setImage(brandImage);
    }
}
