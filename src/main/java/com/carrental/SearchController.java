package com.carrental;

import com.carrental.customnodes.MyDatePicker;
import com.carrental.customnodes.MyTextField;
import com.carrental.customnodes.MyTimePicker;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class SearchController implements Initializable {

    public AnchorPane mainBox;
    @FXML
    private MyTextField locationId;

    @FXML
    private MyDatePicker pickupDateId;

    @FXML
    private MyTimePicker pickupTimeId;

    @FXML
    private MyDatePicker returnDateId;

    @FXML
    private MyTimePicker returnTimeId;

    @FXML
    private Button searchButton;

    @FXML
    void rentEvent(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> mainBox.requestFocus());

        locationId.myFocusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(!locationId.getText().trim().isEmpty() && locationId.isError()) {
                    locationId.hideError();
                }
            }
        });
        pickupDateId.myFocusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(!pickupDateId.getText().trim().isEmpty() && pickupDateId.isError()) {
                    pickupDateId.hideError();
                }
            }
        });
        pickupTimeId.myFocusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(!pickupTimeId.getText().trim().isEmpty() && pickupTimeId.isError()) {
                    pickupTimeId.hideError();
                }
            }
        });
        returnDateId.myFocusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(!returnDateId.getText().trim().isEmpty() && returnDateId.isError()) {
                    returnDateId.hideError();
                }
            }
        });
        returnTimeId.myFocusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(!returnTimeId.getText().trim().isEmpty() && returnTimeId.isError()) {
                    returnTimeId.hideError();
                }
            }
        });
        searchButton.setOnAction(event ->{
            String locationIdText = locationId.getText();
            boolean isLocationEmpty = locationIdText.trim().isEmpty();
            if (isLocationEmpty) {
                locationId.showError("Location Field is empty");
            }else{
                locationId.hideError();
            }

            String pickUpDateText = pickupDateId.getText();
            boolean isPickUpDateEmpty = pickUpDateText.trim().isEmpty();
            if (isPickUpDateEmpty) {
                pickupDateId.showError("Pick-up Date is empty");
            }else{
                pickupDateId.hideError();
            }

            String pickUpTimeText = pickupTimeId.getText();
            boolean isPickUpTimeEmpty = pickUpTimeText.trim().isEmpty();
            if (isPickUpTimeEmpty) {
                pickupTimeId.showError("Pick-up Time is empty");
            }else{
                pickupTimeId.hideError();
            }

            String returnDateText = returnDateId.getText();
            boolean isReturnDateEmpty = returnDateText.trim().isEmpty();
            if (isReturnDateEmpty) {
                returnDateId.showError("Return Date is empty");
            }else{
                returnDateId.hideError();
            }

            String returnTimeText = returnTimeId.getText();
            boolean isReturnTimeEmpty = returnTimeText.trim().isEmpty();
            if (isReturnTimeEmpty) {
                returnTimeId.showError("Return Time is empty");
            }else{
                returnTimeId.hideError();
            }
        });
    }
}
