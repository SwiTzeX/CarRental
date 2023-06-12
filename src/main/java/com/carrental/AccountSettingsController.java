package com.carrental;

import com.carrental.models.Reservation;
import com.carrental.models.User;
import com.carrental.models.Vehicle;
import javafx.animation.FadeTransition;
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

public class AccountSettingsController implements Initializable {

    @FXML
    private Label agevar;

    @FXML
    private ImageView avatarimg;

    @FXML
    private Button editb;

    @FXML
    private Label emailvar;

    @FXML
    private Label fullname1var;

    @FXML
    private Label fullnamevar;

    @FXML
    private Label nidvar;

    @FXML
    private Label phonevar;

    @FXML
    private Label statusvar;


    public  void setData(User user) {
        fullname1var.setText(user.getFullName());
        fullnamevar.setText(user.getFullName());
        emailvar.setText(user.getEmail());
        statusvar.setText((user.getIsAdmin() ? "Admin" : "Client"));
        agevar.setText(String.valueOf(user.getAge()));
        nidvar.setText(user.getNId());
        phonevar.setText(user.getPhoneNumber());
       // avatarimg.setImage(user.getImage());
    }



     /*editb.setOnAction(event -> {
    });*/




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    User user1 = App.getUser();
    setData(user1);

    }}

