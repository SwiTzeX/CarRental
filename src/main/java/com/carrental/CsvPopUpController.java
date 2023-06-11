package com.carrental;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class CsvPopUpController implements Initializable{
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private Button CsvOkButton;

    public void setH(HBox h) {
        this.h = h;
    }
    HBox h;

    @FXML
    public void onClickCsvOk(ActionEvent event) {
        Stage stage = (Stage) CsvOkButton.getScene().getWindow();
        stage.close();
        h.setEffect(null);
    }
}
