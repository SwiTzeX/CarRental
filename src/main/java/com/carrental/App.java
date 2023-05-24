package com.carrental;

import com.carrental.models.Reservation;
import com.carrental.models.User;
import com.carrental.models.Vehicle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;

import java.io.IOException;
import java.sql.*;

public class App extends Application {
    public User user;
    private static App app;
    @Override
    public void start(Stage stage) throws IOException {
        //user = User.getUserById(22);
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("users.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1400, 800);
        stage.setTitle("Hello test!");
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



    @Override
    public void init() {
        app = this;
    }

    public static void main(String[] args) {
        launch();
    }
}
