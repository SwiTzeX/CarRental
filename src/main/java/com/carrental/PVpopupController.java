package com.carrental;


import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.event.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;


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
               PaymentController.mainvbox.setEffect(null);
}}
