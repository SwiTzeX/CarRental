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


public class LoginController implements Initializable {

    @FXML
    public Button button_signin;

    @FXML
    public Label label_login;
    @FXML
    public TextField usernamefield;

    @FXML
    public PasswordField passwordfield;

    @FXML
    private javafx.scene.control.Label a;

    @FXML
    void login(ActionEvent event) {
        String username = usernamefield.getText();
        String password = passwordfield.getText();


        User u = User.getUserByEmail(username);
        if ( u == null){

            a.setVisible(true);
            a.setText("sadly we didnt find this username on our data base");

        }
        if ( u != null){

            boolean o = u.checkPassword(password);
               if ( o == false){

               }
        }


    }

    @FXML
    void transfertoregister(MouseEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Register-view.fxml"));
            Parent Register = loader.load();
            Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(Register));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
















