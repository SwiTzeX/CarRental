package com.carrental;

import com.carrental.models.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    public User user;
    private MainController mainController;
    private static App app;
    public static Stage stg;
    @Override
    public void start(Stage stage) throws IOException {
        user = User.getUserById(48);
        Pane root = new Pane();
        Scene scene = new Scene(root, 1400, 800);
        stage.setTitle("Rent Ez");
        stage.setScene(scene);
        stage.setResizable(false);
        stg = stage;
        openMain();
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

    public static void openMain(){
        try {

            FXMLLoader loader = new FXMLLoader(App.class.getResource("main-view.fxml"));
            Parent homePage = loader.load();
            App.setMainController(loader.getController());
            Stage stage =stg;
            stage.setScene(new Scene(homePage));
            stage.show();
            if(App.getUser() != null && !App.getUser().isCommented()){
                Stage popupStage = new Stage();
                FXMLLoader loaderX = new FXMLLoader(App.class.getResource("commentSection-view.fxml"));
                popupStage.setScene(new Scene(loaderX.load()));
                popupStage.setTitle("Review Panel");
                popupStage.initModality(Modality.APPLICATION_MODAL);
                //popupStage.initStyle(StageStyle.UNDECORATED);
                popupStage.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void openLogin(){
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("login-view.fxml"));
            Parent login = loader.load();
            Stage stage =stg;
            stage.setScene(new Scene(login));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openRegister(){
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("register-view.fxml"));
            Parent register = loader.load();
            Stage stage =stg;
            stage.setScene(new Scene(register));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openAdmin(){
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("admin-view.fxml"));
            Parent adminPage = loader.load();
            Stage stage =stg;
            stage.setScene(new Scene(adminPage));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Stage getStage(){
    return stg;
    }
    @Override
    public void init() {
        app = this;
    }

    public static void main(String[] args) {
        launch();
    }
}
