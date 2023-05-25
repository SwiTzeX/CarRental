package com.carrental;

import com.carrental.models.Reservation;
import com.carrental.models.Vehicle;
import javafx.fxml.FXMLLoader;
import java.awt.event.MouseEvent;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.event.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PVpopupController implements Initializable{

    @FXML
    private Button PopUp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void onClickBackPV(ActionEvent event) {
               Stage stage = PaymentController.getPopupStage();
               stage.close();
}}
