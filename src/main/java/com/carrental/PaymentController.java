package com.carrental;

import javafx.fxml.Initializable;
import javafx.event.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
public class PaymentController implements Initializable{


        @FXML
        private ImageView BrandLogoVar;

        @FXML
        private Label BrandNameVar;

        @FXML
        private ImageView CarImageVar;

        @FXML
        private Label ColorVar;

        @FXML
        private Label FuelTypeVar;

        @FXML
        private Label GearTypeVar;

        @FXML
        private Label HpVar;

        @FXML
        private Label ModelNameVar;

        @FXML
        private Label NumPVar;

        @FXML
        private Label PricePerDay;

        @FXML
        private RadioButton RadioBOnSite;

        @FXML
        private RadioButton RadioBPaypal;

        @FXML
        private Label TotalPrice;

        @FXML
        private Label TrunkCapVar;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
                // NEED TO ADD A BACK BUTTON TO RESERVATION PAGE

    }

}
