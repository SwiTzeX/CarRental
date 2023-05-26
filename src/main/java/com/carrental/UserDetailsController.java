package com.carrental;

import com.carrental.models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.print.DocFlavor;


import java.beans.EventHandler;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class UserDetailsController implements Initializable {
    @FXML
    public Label usernamelabel;

    @FXML
    public Label emaillabel;

    @FXML
    public Label rolelabel;

    @FXML
    public Label agelabel;

    @FXML
    public Label nidlabel;


    public void displayUserDetails(User user) {
        usernamelabel.setText(user.getFullName());
        emaillabel.setText("Email: " + user.getEmail());
        rolelabel.setText("Role: " + user.getIsAdmin());
        agelabel.setText("Age: " + user.getAge());
        nidlabel.setText("Nid: " + user.getNId());
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
