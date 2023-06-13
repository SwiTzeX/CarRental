package com.carrental;

import com.carrental.models.Reservation;
import com.carrental.models.User;
import com.carrental.models.Vehicle;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import java.awt.event.MouseEvent;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;
import javafx.util.Duration;

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

    @FXML
    private Label DepositVar;

    @FXML
    private Label startDateVar;

    @FXML
    private Label endDateVar;

    @FXML
    private HBox mainHBox;

    static VBox mainvbox;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    static Stage popupStage = new Stage();


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

    Vehicle vehicle;
    Date startDate;
    Date endDate;

    public void setData(Vehicle vehicle, java.util.Date startDate, Date endDate ){
        this.vehicle=vehicle;
        this.startDate=startDate;
        this.endDate=endDate;
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
        TotalPrice.setText(String.valueOf(Reservation.totalPriceD(vehicle,startDate,endDate)));
        ColorVar.setText(vehicle.color);
        ModelNameVar.setText(vehicle.modelName);
        DepositVar.setText(String.valueOf((vehicle.deposit / 100)*Reservation.totalPriceD(vehicle, startDate, endDate)));
        startDateVar.setText(String.valueOf(startDate));
        endDateVar.setText(String.valueOf(endDate));
        TotalPrice.setText(String.valueOf(Reservation.totalPriceD(vehicle, startDate, endDate)));
    }

    private void performTransition(ActionEvent e) {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1),this.mainHBox);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setOnFinished(event -> RedirectCheckout(e));
        fadeTransition.play();
    }

    @FXML
   public void EndCheckout(ActionEvent e) {
        Reservation.create(App.getUser(),vehicle,startDate,endDate,0);
        App.getUser().sendNotification("Reservation","Your reservation for "+vehicle.getBrandName()+" "+vehicle.getModelName()+" will be pending until it is approved.");
        new Thread(() ->
                Platform.runLater(()-> GMailer.sendAccountConfirmation(App.getUser().getEmail())
                )).start();
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
    }
       performTransition(e);
    }

    public void RedirectCheckout(ActionEvent e){
        try {

            MainController maincontroller = App.getMainController();
            maincontroller.openHome();
            mainvbox = maincontroller.getMainBox();
            GaussianBlur blurEffect = new GaussianBlur(15);
            mainvbox.setEffect(blurEffect);
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), mainvbox);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PVpop_up-view.fxml"));
            popupStage.setScene(new Scene(loader.load()));
            popupStage.setTitle("Pop-up Panel");
            popupStage.initModality(Modality.APPLICATION_MODAL); // Set modality to block main window
            popupStage.initStyle(StageStyle.UNDECORATED);
            popupStage.show();
        }
        catch (IOException b) {
            b.printStackTrace();
        }
    }

@FXML
    public static Stage getPopupStage(){
        return popupStage;
    }

}
