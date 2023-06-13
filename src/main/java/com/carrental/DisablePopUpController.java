package com.carrental;

import com.carrental.models.User;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DisablePopUpController implements Initializable{


    @FXML
    private Button cancelpop;


    @FXML
    private Button deactivate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        User user = App.getUser();

        deactivate.setOnAction(event -> {

            user.setStatus(2);
            System.out.println(user.getStatus());
           App.openLogin(deactivate);
           App.setUser(null);

        });

    }
    @FXML
    public static void onClickPOP(ActionEvent event) {

        Stage stage = AccountSettingsController.getPop();
        stage.close();

    }


}






