package com.carrental;

import com.carrental.models.User;
import com.carrental.models.Vehicle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class UsersController implements Initializable {

    // admin - client
    @FXML
     private ComboBox<String> roles;

    // ordre croissante et ordre decroissante

    @FXML
    private ComboBox<String> invoicedate;

    // active - suspende - bloqueee
    @FXML
    private ComboBox<String> invoicestatue;

    // add user
    @FXML
    private Button addUser;

    // clearALLfilters
    @FXML
    private Button clearAllFilter;

    // label for errors
    @FXML
    private Label a;

    //@FXML
    //public ArrayList<String> roles = new ArrayList<>(Arrays.asList(null,null));


    @FXML
    public ArrayList<String> filterSettings = new ArrayList<String>(Arrays.asList(null,null,null));


    @FXML
    public ArrayList<User> Users = User.getAllUsers();


    @FXML
    //public void clearAllfilter(ActionEvent event){




   // }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // a.setVisible(false);
        roles.getItems().addAll("admin","client");
        invoicestatue.getItems().addAll("active","blocked","suspended");
    }

    @FXML
     public void filters(javafx.event.ActionEvent event) {
        ComboBox<String> lists = (ComboBox<String>) event.getSource();
        Text theText = new Text(lists.getValue());
        double width = (int)theText.getBoundsInLocal().getWidth()+63;
        lists.setPrefWidth(width);
        if (lists == roles) filterSettings.set(0, lists.getValue());
        else if (lists == invoicedate) filterSettings.set(1, lists.getValue());
        else if (lists == invoicestatue) filterSettings.set(3, lists.getValue());
        else if (lists == invoicedate) filterSettings.set(2, lists.getValue());

        //roles = Users.filters(filterSettings);
        //invoicestatue = Users.filters(filterSettings);
        //invoicedate = Users.filters(filterSettings);
    }

}



