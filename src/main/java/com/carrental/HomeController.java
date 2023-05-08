package com.carrental;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import com.carrental.models.Vehicle;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private HBox cardLayout;

    @FXML
    private Label totalVeh;
    public ArrayList<Vehicle> vehicleCards =  new ArrayList<Vehicle>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vehicleCards.add(new Vehicle("Family","Petrol","Manual",5,1000,140,120,220,"vehicles/volkswagen-touareg.png","brands/volkswagen.png"));
        vehicleCards.add(new Vehicle("Family","Petrol","Manual",5,1000,140,120,220,"vehicles/volkswagen-touareg.png","brands/volkswagen.png"));
        vehicleCards.add(new Vehicle("Family","Petrol","Manual",5,1000,140,120,220,"vehicles/volkswagen-touareg.png","brands/volkswagen.png"));
        totalVeh.setText(String.valueOf(vehicleCards.size())+" Vehicle found");
        try {
            for (int i = 0; i < vehicleCards.size(); i++) {
                Vehicle vehicle = vehicleCards.get(i);
                FXMLLoader fmxlLoader = new FXMLLoader();
                fmxlLoader.setLocation(getClass().getResource("vehicle-card-view.fxml"));
                VBox vehicleCard = fmxlLoader.load();
                VehicleCardController vehicleCardController = fmxlLoader.getController();
                vehicleCardController.setData(vehicle);
                cardLayout.getChildren().add(vehicleCard);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
