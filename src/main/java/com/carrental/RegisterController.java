package com.carrental;

import com.carrental.customnodes.MyPasswordField;
import com.carrental.customnodes.MyTextField;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class RegisterController implements Initializable {


    public Button register;
    @FXML
    private MyTextField Nid;

    @FXML
    private MyTextField ageid;

    @FXML
    private MyTextField mailid;

    @FXML
    private MyTextField fullnameid;

    @FXML
    private MyTextField phonenumid;

    @FXML
    private MyPasswordField passwordid;

    @FXML
    private MyPasswordField Vpasswordid;

    @FXML
    private Label loginbtnid;

    @FXML
    private Label errorid;


    private boolean validatePassword(String password) {
        // Define regular expressions for different character types
        String lowercaseRegex = ".*[a-z].*";
        String uppercaseRegex = ".*[A-Z].*";
        String numberRegex = ".*\\d.*";
        String specialCharRegex = ".*[!@#$%^&*()_+\\-=[\\\\]{};':\"\\\\|,.<>/?].*";

        // Check if the password meets the required criteria
        if (password.matches(lowercaseRegex) && password.matches(uppercaseRegex) &&
                password.matches(numberRegex) && password.matches(specialCharRegex)) {
            return true; // Password contains multiple character types
        } else {
            return false; // Password does not meet the criteria
        }
    }


    private boolean validatePhoneNum(String phonen) {
        // Define regular expressions for different character types
        String lowercaseRegex = ".*[a-z].*";
        String uppercaseRegex = ".*[A-Z].*";
        String specialCharRegex = ".*[!@#$%^&*()_+\\-=[\\\\]{};':\"\\\\|,.<>/?].*";

        // Check if the password meets the required criteria
        if (phonen.matches(lowercaseRegex) || phonen.matches(uppercaseRegex) ||
                phonen.matches(specialCharRegex)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean ValidateEmail(String mail) {
        String emailRegex=".+@.+\\..+";
        if (mail.matches(emailRegex)){
            return true; // Password contains multiple character types
        } else {
        return false; // Password does not meet the criteria
        }
    }


    @FXML
    void register(ActionEvent event) {
        String name = fullnameid.getText();
        String email = mailid.getText();
        String age = ageid.getText();
        String nationalId = Nid.getText();
        String phone = phonenumid.getText();
        String password = passwordid.getText();

        System.out.println(password);


        User u1 = User.getUserByEmail(email);
        if(u1 != null){
            errorid.setVisible(true);
            errorid.setText("THIS EMAIL ALREADY EXISTS !");

            return;
        }
        if (!password.equals(Vpasswordid.getText())) {
            errorid.setVisible(true);
            errorid.setText("Your password isn't the same !");

            return;
        }
        if (password.length()<8) {
            errorid.setVisible(true);
            errorid.setText("Your password should contain at least 8 characters !");

            return;
        }

        if (!validatePassword(password)) {
            errorid.setVisible(true);
            errorid.setText("Your password must contain:\n" +
                    "\t•Upper case\n" +
                    "\t•Lower case\n" +
                    "\t•At least one number\n" +
                    "\t•At least one special character");

            return;
        }

        if (!ValidateEmail(email)) {
            errorid.setVisible(true);
            errorid.setText("Invalid email");

            return;
        }
        //String numberRegex = ".*\\d.*";
        if(validatePhoneNum(phone)){
            errorid.setVisible(true);
            errorid.setText("needs to contain only numbers");
            return;
        }


        User user = User.create(nationalId,email,phone,Integer.parseInt(age),name,password);
        errorid.setVisible(false);
        try {
            // Load the FXML file for the second view
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view.fxml"));
            Parent login = loader.load();

            // Create a new stage and set the second view as the root
            Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(login));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void goToLogin(MouseEvent event) {

        try {
            // Load the FXML file for the second view
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view.fxml"));
            Parent login = loader.load();

            // Create a new stage and set the second view as the root
            Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(login));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gotohome(ActionEvent event) {
        try {
            // Load the FXML file for the second view
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Main-view.fxml"));
            Parent home = loader.load();

            // Create a new stage and set the second view as the root
            Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(home));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorid.setVisible(false);
        errorid.setStyle("-fx-text-fill: red");
        ageid.myFocusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                try {
                    int age = Integer.parseInt(ageid.getText());
                    if (age < 18) {
                        ageid.showError("Your age is under 18 !");
                    } else {
                        ageid.hideError();
                    }
                } catch (Exception ignored) {
                    ageid.hideError();

                }
            }
        });
        mailid.myFocusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                try {
                    if (!ValidateEmail(String.valueOf(mailid))) {
                        mailid.showError("Invalid email");

                    }
                } catch (Exception ignored) {
                    mailid.hideError();
                }
            }
        });
        /**passwordid.myFocusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                try {
                    if (!validatePassword(String.valueOf(passwordid))) {
                        passwordid.showError("Your password must contain:" +
                                "\t•Upper case" +
                                "\t•Lower case" +
                                "\t•At least one number" +
                                "\t•At least one special character");
                    }
                } catch (Exception ignored) {
                    passwordid.hideError();
                }
            }
        });**/
        /**phonenumid.myFocusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                try {
                    if(validatePhoneNum(String.valueOf(phonenumid))){
                        phonenumid.showError("needs to contain only numbers");
                    }
                } catch (Exception ignored) {
                    phonenumid.hideError();
                }
            }
        });**/
    }
}