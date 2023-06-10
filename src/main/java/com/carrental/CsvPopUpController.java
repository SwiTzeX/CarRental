package com.carrental;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CsvPopUpController implements Initializable{
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private Button CsvOkButton;
    @FXML
    public void onClickCsvOk(ActionEvent event) {
        Stage stage = DashboardController.getCsvpopupStage();
        stage.close();
        //DashboardController.dashvbox.setEffect(null);
    }
}
