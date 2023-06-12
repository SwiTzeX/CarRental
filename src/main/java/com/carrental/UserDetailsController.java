package com.carrental;

import com.carrental.utils.DataReservation;
import com.carrental.models.Reservation;
import com.carrental.models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class UserDetailsController implements Initializable {
    @FXML
    private  Label usernamelabel;
    @FXML
    private Label usernamelabela;

    @FXML
    private Label taskdone;

    @FXML
    private  Label emaillabel;

    @FXML
    private  Label rolelabel;

    @FXML
    private  Label agelabel;

    @FXML
    private  Label nidlabel;
    @FXML
    private TableView<DataReservation> tableview1;
    @FXML
    private TableColumn<DataReservation, String> brandnamecolunmn;

    @FXML
    private TableColumn<DataReservation, String> modelenamecolumn;

    @FXML
    private TableColumn<DataReservation, Date> startdatecolumn;

    @FXML
    private TableColumn<DataReservation, Date> enddatecolumn;

    @FXML
    private TableColumn<DataReservation, Float> pricecolumn;





    public  void displayUserDetails(User user) {
        usernamelabela.setText(user.getFullName());
        usernamelabel.setText(user.getFullName());
        emaillabel.setText("Email: " + user.getEmail());
        rolelabel.setText("Role: " + (user.getIsAdmin() ? "Admin" : "Client"));
        agelabel.setText("Age: " + user.getAge());
        nidlabel.setText("NID: " + user.getNId());
        ObservableList<DataReservation> reservationList = FXCollections.observableArrayList();
        ArrayList<Reservation> allreservations = user.getReservations();
        int l = allreservations.size();
        taskdone.setText(String.valueOf(l));
        for(Reservation i:allreservations) {
            DataReservation res = new DataReservation(i.getUser().getId(),i.getVehicle().getId(),i.getUser().getFullName(), i.getUser().getPhoneNumber(), i.getVehicle().getBrandName(), i.getVehicle().getModelName(), i.getVehicle().getPrice(), i.getStartDate(), i.getEndDate(), String.valueOf(i.getStatus()));
            reservationList.add(res);
        }

        tableview1.setItems(reservationList);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        brandnamecolunmn.setCellValueFactory(new PropertyValueFactory<>("brandName"));
        modelenamecolumn.setCellValueFactory(new PropertyValueFactory<>("modelName"));
        startdatecolumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        enddatecolumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        pricecolumn.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
}