package com.carrental;

import com.carrental.models.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class UserDetailsController implements Initializable {
    @FXML
    private static Label usernamelabel;

    @FXML
    private static Label emaillabel;

    @FXML
    private static Label rolelabel;

    @FXML
    private static Label agelabel;

    @FXML
    private static Label nidlabel;

    public static void displayUserDetails(User user) {
        usernamelabel.setText(user.getFullName());
        emaillabel.setText("Email: " + user.getEmail());
        rolelabel.setText("Role: " + (user.getIsAdmin() ? "Admin" : "Client"));
        agelabel.setText("Age: " + user.getAge());
        nidlabel.setText("NID: " + user.getNId());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}