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

    private boolean validatePassword(String password) {
        // Define regular expressions for different character types
        String lowercaseRegex = ".*[a-z].*";
        String uppercaseRegex = ".*[A-Z].*";
        String numberRegex = ".*\\d.*";
        String specialCharRegex = ".*[!@#$%^&*()_+\\-=[\\\\]{};':\"\\\\|,.<>/?].*";

        if (password.matches(lowercaseRegex) && password.matches(uppercaseRegex) &&
                password.matches(numberRegex) && password.matches(specialCharRegex)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validatePhoneNum(String phonen) {
        String lowercaseRegex = ".*[a-z].*";
        String uppercaseRegex = ".*[A-Z].*";
        String specialCharRegex = ".*[!@#$%^&*()_+\\-=[\\\\]{};':\"\\\\|,.<>/?].*";

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

        if (!Nid.isError() && !fullnameid.isError() && !ageid.isError() && !phonenumid.isError() && !mailid.isError() && !passwordid.isError() && !Vpasswordid.isError()){
            User user = User.create(nationalId,email,phone,Integer.parseInt(age),name,password,0);
            App.openLogin(Nid);
            new Thread(() -> 
                Platform.runLater(()-> GMailer.sendAccountConfirmation(email)
            )).start();

        }
    }

    @FXML
    void goToLogin(MouseEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view.fxml"));
            Parent login = loader.load();

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Main-view.fxml"));
            Parent home = loader.load();

            Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(home));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
                    long phone = Long.parseLong(phonenumid.getText());
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