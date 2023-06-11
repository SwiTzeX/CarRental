package com.carrental;

import com.carrental.models.Reservation;
import com.carrental.models.User;
import com.carrental.models.Vehicle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class App extends Application {
    public User user;
    private MainController mainController;
    private static App app;
    @Override
    public void start(Stage stage) throws IOException {
        user = User.getUserById(48);
        //App.getUser().sendNotification("Hassan trami","asfdjhkEWGRIUKGDSAHBSDIUGDSA\nDSFDSDSFfDS\nSDAFSADFDS");
        //sApp.getUser().getAllNotifications().get(0).delete();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1400, 800);
        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Sora");
        mainController = fxmlLoader.getController();
        stage.setTitle("Rent Ez");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static User getUser() {
        return app.user;
    }

    public static void setUser(User user) {
        app.user = user;
    }

    public static MainController getMainController() {
        return app.mainController;
    }

    public static void setMainController(MainController mainController) {
        app.mainController = mainController;
    }

    public static void openLogin(Node source){
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("login-view.fxml"));
            Parent login = loader.load();
            Stage stage =(Stage) source.getScene().getWindow();
            stage.setScene(new Scene(login));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void openRegister(Node source){
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("register-view.fxml"));
            Parent register = loader.load();
            Stage stage =(Stage)source.getScene().getWindow();
            stage.setScene(new Scene(register));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openAdmin(Node source){
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("admin-view.fxml"));
            Parent adminPage = loader.load();
            Stage stage =(Stage)source.getScene().getWindow();
            stage.setScene(new Scene(adminPage));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() {
        app = this;
    }

    public static void main(String[] args) {
        launch();
    }
}
