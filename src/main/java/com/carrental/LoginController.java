package com.carrental;

import com.carrental.customnodes.MyButton;
import com.carrental.customnodes.MyPasswordField;
import com.carrental.customnodes.MyTextField;
import com.carrental.models.User;
import javafx.application.Platform;
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
    public MyButton button_home;
    @FXML
    public Button button_signin;
    @FXML
    public Label label_login;
    @FXML
    public MyTextField usernamefield;
    @FXML
    public MyPasswordField passwordfield;
    @FXML
    private Label a;

   public User u = null;


   @FXML
    void login(ActionEvent event) {
       if (u != null && !usernamefield.isError() && !passwordfield.isError() && passwordfield.getText().length()>0) {
           App.setUser(u);
           App.openMain((Node)event.getSource());

           }

       }

    @FXML
    void transfertoregister(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Register-view.fxml"));
            Parent Register = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(Register));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void homeButton(ActionEvent event){
       App.openMain((Node) event.getSource());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       // Platform.runLater(() -> mainBox.requestFocus());

        a.setVisible(false);
       usernamefield.myFocusedProperty().addListener((observable, oldValue, newValue) -> {
          // System.out.println("Account not found!");
            if (!newValue){
                String username = usernamefield.getText();
                //System.out.println(username);
                 u = User.getUserByEmail(username);
                 if (u == null){
                     usernamefield.showError("Account not found!");
                 }
                 else{
                     if(u.getStatus() == 2){
                         usernamefield.showError("Account inactive");
                     } else if (u.getStatus() == 1) {
                         usernamefield.showError("Account banned");
                     }else{
                         usernamefield.hideError();
                     }

                 }
            }
        });
       passwordfield.myFocusedProperty().addListener((observable, oldValue, newValue) -> {
           if (!newValue && u != null) {

               //String password = passwordfield.getText();
              /* System.out.println(u.getEmail());
               System.out.println(u.getPassword());
               System.out.println(password);*/
               boolean o = u.checkPassword(passwordfield.getText());
               if (!o) {
                   passwordfield.showError("Password is not working");
               }
               else {

                   passwordfield.hideError();
               }

           }
           });

    }}



















