package com.carrental;

import com.carrental.models.Reservation;
import com.carrental.models.Vehicle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

public class InfoPageController implements Initializable{

    @FXML
    private Button btnBookNow;

    @FXML
    private ImageView carpic;

    @FXML
    private Label comment;

    @FXML
    private Label infoBrand;

    @FXML
    private Label infoColor;

    @FXML
    private Label infoDuration;

    @FXML
    private Label infoEndDate;

    @FXML
    private Label infoFuel;

    @FXML
    private Label infoGear;

    @FXML
    private Label infoHp;

    @FXML
    private Label infoModel;

    @FXML
    private Label infoPpd;

    @FXML
    private Label infoPsngr;

    @FXML
    private Label infoStartDate;

    @FXML
    private Label infoTotP;

    @FXML
    private Label infoTrunk;

    @FXML
    private Label username;

    public void setData(Vehicle vehicle, Reservation reservation){

        Image image = new Image(getClass().getResourceAsStream(vehicle.getImage()));
        carpic.setImage(image);
        infoBrand.setText(vehicle.getBrandName());
        infoModel.setText(vehicle.getModelName());
        infoColor.setText(vehicle.getColor());
        infoHp.setText(vehicle.getHorsePower().toString());
        infoFuel.setText(vehicle.fuelType);
        infoGear.setText(vehicle.gearType);
        infoTrunk.setText(vehicle.getTrunkCapacity().toString());
        infoPsngr.setText(vehicle.getPassengers().toString());
        infoStartDate.setText(reservation.getStartDate().toString());
        infoEndDate.setText(reservation.getEndDate().toString());
        LocalDate first_date = convertToLocalDateViaInstant(reservation.getStartDate());
        LocalDate second_date = convertToLocalDateViaInstant(reservation.getEndDate());
        Period duration = Period.between(first_date,second_date);
        infoDuration.setText(duration.toString());
        infoPpd.setText(String.valueOf(vehicle.getPrice()));
        infoTotP.setText(String.valueOf(reservation.totalPrice()));
    }

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //setData();
    }


    /*
    void onClickBookNow(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Payment-view.fxml"));
            Parent login = loader.load();
            Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(login));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     */
}
