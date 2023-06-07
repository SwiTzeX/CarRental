package com.carrental;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    @FXML
    private HBox dashboardBtn;

    @FXML
    private HBox fleetManageBtn;

    @FXML
    private HBox reservationsBtn;

    @FXML
    private HBox userManageBtn;

    @FXML
    private HBox mainBox;

    @FXML
    private VBox navBar;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadDashboard();
        dashboardBtn.setOnMouseClicked(event ->{
            loadDashboard();
        });
        fleetManageBtn.setOnMouseClicked(event ->{
            loadFleetManagement();
        });
        userManageBtn.setOnMouseClicked(event ->{
            loadUserManagement();
        });
        reservationsBtn.setOnMouseClicked(event ->{
            loadReservationsManagement();
        });

    }

    public void loadDashboard(){
        try {
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("dashboard-view.fxml"));
            VBox dashboardPage = loader.load();
            //Stage stage =(Stage)mainBox.getScene().getWindow();
            mainBox.getChildren().clear();
            mainBox.getChildren().addAll(navBar,dashboardPage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadUserManagement(){
        try {
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("users-view.fxml"));
            AnchorPane usersPage = loader.load();
            //Stage stage =(Stage)mainBox.getScene().getWindow();
            mainBox.getChildren().clear();
            mainBox.getChildren().addAll(navBar,usersPage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadFleetManagement(){
        try {
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("fleet-view.fxml"));
            AnchorPane fleetPage = loader.load();
            //Stage stage =(Stage)mainBox.getScene().getWindow();
            mainBox.getChildren().clear();
            mainBox.getChildren().addAll(navBar,fleetPage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadReservationsManagement(){
        try {
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("reservation-view.fxml"));
            AnchorPane reservationsPage = loader.load();
            //Stage stage =(Stage)mainBox.getScene().getWindow();
            mainBox.getChildren().clear();
            mainBox.getChildren().addAll(navBar,reservationsPage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
