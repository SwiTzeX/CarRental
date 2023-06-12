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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class RegisterController implements Initializable {

    @FXML
    public MyButton register;
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

/*    @FXML
    private Label errorid;*/


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
        //String numberRegex = ".*\\d.*";


        // Check if the password meets the required criteria
        if (phonen.matches(lowercaseRegex) || phonen.matches(uppercaseRegex) ||
                phonen.matches(specialCharRegex)) {
            return true;
        } else {
            return false;
        }
    }
    private boolean ValidateNid(String nid) {
        String nid1 = "[A-Za-z0-9]+";
        if (nid.matches(nid1)){
            return true;
        } else {
            return false;
        }
    }

    private boolean ValidateFullName(String fullname) {
        String fullname1 = "([A-Za-z]+" + " " + "[A-Za-z]+)+";
        if (fullname.matches(fullname1)){
            return true;
        } else {
            return false;
        }
    }

    private boolean ValidateEmail(String mail) {
        String emailRegex=".+@.+\\..+";
        if (mail.matches(emailRegex)){
            return true;
        } else {
        return false;
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



        /*User u1 = User.getUserByEmail(email);
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

*/
        if (!Nid.isError() && !fullnameid.isError() && !ageid.isError() && !phonenumid.isError() && !mailid.isError() && !passwordid.isError() && !Vpasswordid.isError()){
            User user = User.create(nationalId,email,phone,Integer.parseInt(age),name,password,0);
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
        // Check if the password meets the required criteria
        Nid.myFocusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                boolean test2 = ValidateNid(String.valueOf(Nid.getText()));
                if (test2){
                    Nid.hideError();
                }else {
                    Nid.showError("Invalid National ID");
                }
            }
        });
        fullnameid.myFocusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                boolean test2 = ValidateFullName(String.valueOf(fullnameid.getText()));
                if (test2){
                    fullnameid.hideError();
                }else {
                    fullnameid.showError("Invalid Full Name");
                }
            }
        });

        ageid.myFocusedProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("test");
            if (!newValue) {
                try {
                    int age = Integer.parseInt(ageid.getText());
                    if (age < 18) {
                        ageid.showError("Your age is under 18 !");
                    } else if (age > 100) {
                        ageid.showError("Your age must be under 100 !");
                    } else {
                        ageid.hideError();
                    }
                } catch (Exception ignored) {
                    ageid.showError("Age must contain only numbers");
                }
            }
        });
        mailid.myFocusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                boolean test2 = ValidateEmail(String.valueOf(mailid.getText()));
                if (test2){
                    mailid.hideError();
                }else {
                    mailid.showError("Invalid Email");
                }
            }
        });

        passwordid.myFocusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                    boolean test = validatePassword(String.valueOf(passwordid.getText()));
                if (passwordid.getText().length() < 8)
                    passwordid.showError("Password must contain at least 8 characters.");

                else if (test) {
                    passwordid.hideError();
                }

                else {
                    passwordid.showError("Must contain:" +
                            "Upper case" +
                            "/Lower case" +
                            "/At least one number" +
                            " and one special character");           }
            }
        });
        Vpasswordid.myFocusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {

                    boolean test = Vpasswordid.getText().matches(passwordid.getText());
                    if (test)
                    Vpasswordid.hideError();
                    else{
                    Vpasswordid.showError("Your Password isn't the same");
                }
            }
        });
        phonenumid.myFocusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                try {
                    int phone = Integer.parseInt(phonenumid.getText());
                    /*if(validatePhoneNum(String.valueOf(phone))){
                        phonenumid.showError("needs to contain only numbers");
                    }*/
                    phonenumid.hideError();
                } catch (Exception ignored) {
                    phonenumid.showError("needs to contain only numbers");
                }
            }
        });

    }

    public void homeButton(ActionEvent event) {
        App.openMain((Node) event.getSource());
    }
}