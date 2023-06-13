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
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
    private Button disable;

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


    static Stage pop = new Stage();


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


    public void initialize(URL url, ResourceBundle resourceBundle) {


        User user = App.getUser();


        setData(user);

        editb.setOnAction(event -> {

            openEditDialog(user);

        });

        disable.setOnAction(event -> {



        });
    }
    private void openEditDialog(User user) {
        Dialog<User> dialog = new Dialog<>();
        dialog.setTitle("Modify the user");
        dialog.setHeaderText(null);

        ButtonType buttonTypeOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(buttonTypeOk, ButtonType.CANCEL);

        GridPane grid = new GridPane();

        TextField nIdField = new TextField(user.getNId());
        TextField emailField = new TextField(user.getEmail());
        TextField phoneField = new TextField(user.getPhoneNumber());
        TextField fullnameField = new TextField(user.getFullName());
        TextField passwordField = new TextField(user.getPassword());


        grid.add(new Label("NID:"), 0, 1);
        grid.add(nIdField, 1, 1);
        grid.add(new Label("Email:"), 0, 2);
        grid.add(emailField, 1, 2);
        grid.add(new Label("phone number:"), 0, 3);
        grid.add(phoneField, 1, 3);
        grid.add(new Label("full name:"), 0, 4);
        grid.add(fullnameField, 1, 4);
        grid.add(new Label("password:"), 0, 5);
        grid.add(passwordField, 1, 5);

        dialog.getDialogPane().setContent(grid);

        dialog.showAndWait();

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == buttonTypeOk) {
              user.setNId(nIdField.getText());
              user.setEmail(emailField.getText());
              user.setPhoneNumber(phoneField.getText());
              user.setFullName(fullnameField.getText());
              user.setPassword(passwordField.getText());

               setData(user);

            }
            return null;
        });




}
    public void RedirectCheckouthh(ActionEvent e){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DisablePopUp-view.fxml"));
            pop.setScene(new Scene(loader.load()));
            pop.setTitle("Pop-up Panel");
            pop.initModality(Modality.APPLICATION_MODAL);
            pop.initStyle(StageStyle.UNDECORATED);
            pop.show();

        }
        catch (IOException b) {
            b.printStackTrace();
        }
    }
    @FXML
    public static Stage getPop(){
        return pop;
    }

}


