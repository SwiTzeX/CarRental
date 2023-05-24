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

    }

    @FXML
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

@FXML
    public String getRadioValue() {
        String method = null;
        if (RadioBPaypal.isSelected()) {
            method = "Paypal";
        } else if (RadioBOnSite.isSelected()) {
            method = "OnSite";
        }
        return method;
    }

    public void setData(Vehicle vehicle, Reservation reservation){
        BrandNameVar.setText(vehicle.getBrandName());
        PricePerDay.setText(String.valueOf(vehicle.getPrice())+" DH");
        NumPVar.setText(String.valueOf(vehicle.getPassengers()));
        FuelTypeVar.setText(vehicle.getFuelType());
        GearTypeVar.setText(vehicle.getGearType());
        HpVar.setText(String.valueOf(vehicle.getHorsePower()));
        Image image = new Image(getClass().getResourceAsStream(vehicle.getImage()));
        CarImageVar.setImage(image);
        Image brandImage = new Image(getClass().getResourceAsStream(vehicle.getBrandImage()));
        BrandLogoVar.setImage(brandImage);
        TrunkCapVar.setText(String.valueOf(vehicle.getTrunkCapacity()));
        TotalPrice.setText(String.valueOf(reservation.totalPrice()));
    }

    @FXML
    public void EndCheckout(ActionEvent e) {
        //Payment Method Paypal
        if(this.getRadioValue()=="Paypal"){
        // Define the URL to redirect to
        String url = "https://www.paypal.com/fr/webapps/mpp/home";

        // Open the web page in the default browser
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (java.io.IOException ex) {
            // Display an error message if the web page cannot be opened
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Failed to open web page");
            alert.setContentText("Please check your internet connection.");
            alert.showAndWait();
        }
    }}

}
