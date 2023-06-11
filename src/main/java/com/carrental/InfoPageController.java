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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

public class InfoPageController{

    @FXML
    private AnchorPane infoPane;

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
    Vehicle vehicle;
    Date startDate;
    Date endDate;

    public void setData(Vehicle vehicle, Date startDate, Date endDate ){ //search
        Image image = new Image(getClass().getResourceAsStream(vehicle.getImage()),1900, 800, true, true);
        carpic.setImage(image);
        this.vehicle=vehicle;
        this.startDate=startDate;
        this.endDate=endDate;
        this.infoBrand.setText(vehicle.getBrandName());
        infoModel.setText(vehicle.getModelName());
        infoColor.setText(vehicle.getColor());
        infoFuel.setText(vehicle.getFuelType());
        infoGear.setText(vehicle.getGearType());
        infoHp.setText(vehicle.getHorsePower().toString());
        infoTrunk.setText(vehicle.getTrunkCapacity().toString());
        infoPsngr.setText(vehicle.getPassengers().toString());
        infoStartDate.setText(startDate.toString());
        infoEndDate.setText(endDate.toString());
        LocalDate first_date = convertToLocalDateViaInstant(startDate);
        LocalDate second_date = convertToLocalDateViaInstant(endDate);
        Period duration = Period.between(first_date,second_date);
        infoDuration.setText(duration.toString());
        infoPpd.setText(String.valueOf(vehicle.getPrice()));
        infoTotP.setText(String.valueOf(Reservation.totalPriceD(vehicle,startDate,endDate)));

    }

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }



    @FXML
    void onClickBookNow(ActionEvent event){
            App.getMainController().openCheckOut(vehicle,startDate,endDate);
        }


}
