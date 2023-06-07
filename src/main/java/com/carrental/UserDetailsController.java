package com.carrental;

import com.carrental.models.Reservation;
import com.carrental.models.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
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

    public  void displayUserDetails(User user) {
        usernamelabela.setText(user.getFullName());
        usernamelabel.setText(user.getFullName());
        emaillabel.setText("Email: " + user.getEmail());
        rolelabel.setText("Role: " + (user.getIsAdmin() ? "Admin" : "Client"));
        agelabel.setText("Age: " + user.getAge());
        nidlabel.setText("NID: " + user.getNId());
        ArrayList<Reservation> allreservations = user.getReservations();
        int l = allreservations.size();
        taskdone.setText(String.valueOf(l));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}