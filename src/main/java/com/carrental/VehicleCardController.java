package com.carrental;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import com.carrental.models.Vehicle;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class VehicleCardController {

    @FXML
    private VBox card;

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

    @FXML
    private Label vehBrandModel;
    @FXML
    private Label vehTrunkCapacityLabel;

    boolean shadowAnimation = false;
    Timeline timeline = null;

    public void setData(Vehicle vehicle){
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
    }
    @FXML
    void mouseInAnimation(MouseEvent event) {
        if (!shadowAnimation){
            return;
        }
        DropShadow shadow = new DropShadow(0, Color.web("#6279FF"));
        card.setEffect(null);
        card.setEffect(shadow);
        if (timeline != null) {
            timeline.stop();
        }
        timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(shadow.radiusProperty(), 0)),
                new KeyFrame(Duration.seconds(0.5), new KeyValue(shadow.radiusProperty(), 20))
        );
        timeline.setCycleCount(1);
        timeline.play();
        // Add the rectangle to a stack pane and show the stage

    }
    @FXML
    void mouseOutAnimation(MouseEvent event) {
        if (!shadowAnimation){
            return;
        }
        DropShadow shadow = new DropShadow(20, Color.web("#6279FF"));
        card.setEffect(shadow);
        timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(shadow.radiusProperty(), 20)),
                new KeyFrame(Duration.seconds(0.5), new KeyValue(shadow.radiusProperty(), 0)),
                new KeyFrame(Duration.seconds(0.5), new KeyValue(card.effectProperty(), null))
        );
        timeline.setCycleCount(1);
        timeline.play();
    }

    void loadIn(){
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1),card);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        fadeTransition.setOnFinished(event -> {
            shadowAnimation = true;
        });
    }

}
