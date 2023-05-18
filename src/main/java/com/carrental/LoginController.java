package com.carrental;

import com.carrental.models.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.print.DocFlavor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public abstract class LoginController implements Initializable{

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
    void login(ActionEvent ev){
    String username = usernamefield.getText();
    String password = passwordfield.getText();


    User u = User.create(NULL,username,NULL,NULL,NULL,password);

    ArrayList<User> users;
    if (u.equals(NULL)) {
        a.setVisible(true);
        a.setText("it looks like something is wrong , please double check ur inputs.");
    }
    if ( u != NULL){
        a.setVisible(false);
        users = new ArrayList<User>.getAllUsers();
         for (int i = 0; i <= users.size(); i++){
            if (u.username == users.email(i)){
                if (u.password == users.password(i)){
                    try{}
                    catch{}
                }
                if(u.password != users.password(i)){
                    a.setVisible(true);
                    a.setText("password is not correct");
                }
            }
            if(u.username != users.email(i)){}



         }
    }
    }


    public void initialize(URL location, ResourceBundle resources){

        label_login.setOnAction(new EventHandler<ActionEvent>()){
           @Override
            public void handle(ActionEvent action){

            }

        }


    }






    }















