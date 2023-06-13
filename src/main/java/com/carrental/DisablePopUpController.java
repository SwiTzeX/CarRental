package com.carrental;

import com.carrental.models.User;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Node;
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
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.close();
           App.openLogin();
           App.setUser(null);
        });

    }
    @FXML
    public void onClickPOP(ActionEvent event) {

        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();

    }



}






