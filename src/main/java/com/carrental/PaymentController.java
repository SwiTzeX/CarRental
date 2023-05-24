package com.carrental;

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
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PaymentController implements Initializable {

    @FXML
    private Button CheckoutB;

    @FXML
    private Button BackBtn;

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

    @FXML
    private ToggleGroup RadioGrp;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Payment-view.fxml"));
            Parent payview = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onClickBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("infopage-view.fxml"));
            Parent back = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(back));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRadioValue() {
        String method = null;
        if (RadioBPaypal.isSelected()) {
            method = "Paypal";
        } else if (RadioBOnSite.isSelected()) {
            method = "OnSite";
        }
        return method;
    }

}
