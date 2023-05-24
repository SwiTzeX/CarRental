package com.carrental;

import com.carrental.models.Vehicle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    VBox mainBox;
    @FXML
    Button signinBtn;
    @FXML
    Button signupBtn;
    @FXML
    HBox userBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        signupBtn.setVisible(false);
        signinBtn.setVisible(false);
        if (App.getUser() == null){
            signupBtn.setVisible(true);
            signinBtn.setVisible(true);
        } else{
            ImageView avatarImage = new ImageView(new Image(getClass().getResourceAsStream("test.png"),40,40,true,true));
            Circle avatarCircle = new Circle();
            avatarCircle.setCenterX(40 / 2);
            avatarCircle.setCenterY(40 / 2);
            avatarCircle.setRadius(40 / 2);
            avatarImage.setClip(avatarCircle);
            ImageView arrow = new ImageView(new Image(getClass().getResourceAsStream("icons/arrow-down.png"),11,7,true,true));
            VBox avatar = new VBox(avatarImage,arrow);
            avatar.setAlignment(Pos.CENTER);
            avatar.setSpacing(1);


            ImageView notifBell = new ImageView(new Image(getClass().getResourceAsStream("icons/notification.png"),20,20,true,true));
            Circle notifCircle = new Circle();
            notifCircle.setRadius(6);
            notifCircle.setStyle("-fx-fill: red");
            Label notifsNumber = new Label("1");
            notifsNumber.setFont(new Font(10));
            notifsNumber.setStyle("-fx-text-fill: white");
            StackPane notification = new StackPane();

            notifCircle.setTranslateX(7);
            notifCircle.setTranslateY(-7);
            notifsNumber.setTranslateX(7);
            notifsNumber.setTranslateY(-7);

            notification.getChildren().addAll(notifBell,notifCircle,notifsNumber);
            Button signoutBtn = new Button("Sign out");
            signoutBtn.getStyleClass().addAll(signinBtn.getStyleClass());
            signoutBtn.setStyle(signinBtn.getStyle());
            signoutBtn.setFont(signinBtn.getFont());
            userBox.getChildren().addAll(signoutBtn,notification,avatar);
        }
        try {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("home-view.fxml"));
        VBox home = fxmlLoader.load();
        HomeController homeController = fxmlLoader.getController();
        mainBox.getChildren().add(home);
        //homeController.loadIn();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void goToLogin(javafx.event.ActionEvent event) {
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
    void goToRegister(javafx.event.ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("register-view.fxml"));
            Parent register = loader.load();

            Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(register));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
