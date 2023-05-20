package com.carrental;

import javafx.fxml.Initializable;
import javafx.event.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;

public class PaymentController implements Initializable{

        @FXML
        private ImageView BrandLogo;

        @FXML
        private Label Brandname;

        @FXML
        private ImageView CarImage;

        @FXML
        private Label CarModel;

        @FXML
        private Label ColorVar;

        @FXML
        private Label FuelTypeVar;

        @FXML
        private Label GearTypeVar;

        @FXML
        private Label HpVar;

        @FXML
        private Label NumPVar;

        @FXML
        private Label PricePerDay;

        @FXML
        private RadioButton RadioOnSite;

        @FXML
        private RadioButton RadioPaypal;

        @FXML
        private Label TotalPrice;

        @FXML
        private Label TrunkCapVar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
