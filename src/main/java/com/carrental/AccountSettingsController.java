package com.carrental;

import com.carrental.models.User;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


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
    public void openAlert(ActionEvent e){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DisablePopUp-view.fxml"));
            Stage pop = new Stage();
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


}


