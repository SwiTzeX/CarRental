package com.carrental;

import com.carrental.customnodes.MyNotificationCard;
import com.carrental.customnodes.MyReservationCard;
import com.carrental.models.Notification;
import com.carrental.models.Reservation;
import com.carrental.models.Vehicle;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    public HBox navBar;
    @FXML
    VBox mainBox;
    @FXML
    Button signinBtn;
    @FXML
    Button signupBtn;
    @FXML
    HBox userBox;
    @FXML
    AnchorPane mainPane;

    VBox avatar = null;
    StackPane notificationBtn = null;
    StackPane reservationsBtn = null;
    VBox profileMenu = null;
    VBox notificationsBox = null;
    ScrollPane notificationPane = null;
    VBox reservationsBox = null;
    ScrollPane reservationPane = null;

    Boolean showed = false;
    Timeline bellTimeline = null;
    Circle notifCircle;
    Circle reservationCircle;
    Label notifsNumber;

    public VBox getMainBox() {
        return mainBox;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(App.getUser() != null){
            userBox.getChildren().clear();
            ImageView avatarImage = new ImageView(new Image(getClass().getResourceAsStream("test.png"),40,40,true,true));
            Circle avatarCircle = new Circle();
            avatarCircle.setCenterX(40 / 2);
            avatarCircle.setCenterY(40 / 2);
            avatarCircle.setRadius(40 / 2);
            avatarImage.setClip(avatarCircle);
            ImageView arrow = new ImageView(new Image(getClass().getResourceAsStream("icons/arrow-down.png"),11,7,true,true));
            avatar = new VBox(avatarImage,arrow);
            avatar.setAlignment(Pos.CENTER);
            avatar.setSpacing(1);


            ImageView notifBellIcon = new ImageView(new Image(getClass().getResourceAsStream("icons/notification.png"),20,20,true,true));
            notifCircle = new Circle();
            notifCircle.setRadius(6);
            notifCircle.setStyle("-fx-fill: red");
            notifsNumber = new Label(String.valueOf(App.getUser().getAllUnreadNotifications().size()));
            notifsNumber.setFont(new Font(10));
            notifsNumber.setStyle("-fx-text-fill: white");
            notificationBtn = new StackPane();
            notifCircle.setTranslateX(7);
            notifCircle.setTranslateY(-7);
            notifsNumber.setTranslateX(7);
            notifsNumber.setTranslateY(-7);

            notificationBtn.getChildren().add(notifBellIcon);
            reservationCircle = new Circle();
            reservationCircle.setRadius(4);
            reservationCircle.setTranslateX(7);
            reservationCircle.setTranslateY(-7);
            ImageView carsIcon = new ImageView(new Image(getClass().getResourceAsStream("icons/cars.png"),20,20,true,true));
            reservationsBtn = new StackPane(carsIcon);
            refreshUserBox();


            Button signoutBtn = new Button("Sign out");
            signoutBtn.getStyleClass().addAll(signinBtn.getStyleClass());
            signoutBtn.setStyle(signinBtn.getStyle());
            signoutBtn.setFont(signinBtn.getFont());

            avatar.setOnMouseClicked(event ->{
                showProfileMenu();
            });
            notificationBtn.setOnMouseClicked(event ->{
                showNotifications();
                if (bellTimeline != null) {
                    bellTimeline.stop();
                }
                notificationBtn.getChildren().removeAll(notifCircle,notifsNumber);
                for (Notification notification:App.getUser().getAllUnreadNotifications()){
                    notification.setRead(true);
                }
            });

            reservationsBtn.setOnMouseClicked(event ->{
                showReservations();
            });
                logIn();
        }else{
            logOut();
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

    private void showProfileMenu(){
        if(mainPane.getChildren().contains(profileMenu)) {
            return;
        }
        profileMenu = new VBox();
        profileMenu.setPadding(new Insets(1));
        profileMenu.setLayoutY(58);
        profileMenu.setLayoutX(1315);
        profileMenu.setStyle("-fx-background-color: white;-fx-background-radius: 10");
        profileMenu.setEffect(new DropShadow(10,Color.web("#6279FF")));
        //profileMenu.setAlignment(Pos.CENTER_LEFT);
        ImageView logoutImage = new ImageView(new Image(getClass().getResourceAsStream("icons/power.png"),14,14,true,true));
        HBox profileLogout = new HBox(logoutImage,new Label("Logout"));
        profileLogout.setAlignment(Pos.CENTER_LEFT);
        profileLogout.setSpacing(4);
        profileLogout.setPadding(new Insets(0, 0, 0,4));
        profileMenu.setAlignment(Pos.CENTER);
        profileLogout.setOnMouseEntered(event -> profileLogout.setStyle("-fx-background-color: #F6F8FF"));
        profileLogout.setOnMouseExited(event -> profileLogout.setStyle("-fx-background-color: white"));
        profileLogout.setOnMouseClicked(event -> logOut());
        ImageView adminImage = new ImageView(new Image(getClass().getResourceAsStream("icons/admin.png"),14,14,true,true));
        HBox admin = new HBox(adminImage,new Label("Administration"));
        admin.setAlignment(Pos.CENTER_LEFT);
        admin.setSpacing(4);
        admin.setPadding(new Insets(0, 0, 0,4));
        admin.setOnMouseEntered(event -> admin.setStyle("-fx-background-color: #F6F8FF"));
        admin.setOnMouseExited(event -> admin.setStyle("-fx-background-color: white"));
        admin.setOnMouseClicked(event -> App.openAdmin(userBox));
        profileMenu.setPrefWidth(80);
        if (App.getUser().getIsAdmin()){
            profileMenu.getChildren().add(admin);
            profileMenu.setLayoutX(1285);
            profileMenu.setPrefWidth(110);
        }
        profileMenu.getChildren().add(profileLogout);

        profileMenu.setPrefHeight(20*profileMenu.getChildren().size()+10);
        mainPane.getChildren().add(profileMenu);
        //animation
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.2),profileMenu);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        TranslateTransition moveTransition = new TranslateTransition(Duration.seconds(0.2),profileMenu);
        moveTransition.setFromY(-8);
        moveTransition.setToY(0);
        moveTransition.play();
    }

    public void hideProfileMenu(){
        mainPane.getChildren().remove(profileMenu);
    }

    private void showNotifications(){
        if(mainPane.getChildren().contains(notificationPane)) {
            return;
        }
        notificationsBox = new VBox();
        notificationsBox.setSpacing(5);
        notificationsBox.setPadding(new Insets(5,0,0,5));
        notificationsBox.setStyle("-fx-background-color: white;-fx-background-radius: 10");
        //profileMenu.setAlignment(Pos.CENTER_LEFT);
        notificationsBox.setPrefWidth(235);
        Label title = new Label("Notifications");
        title.setStyle("-fx-text-fill: #6279FF");
        title.setFont(Font.font("Arial", FontWeight.BOLD,14));
        Line line = new Line();
        line.setStyle("-fx-stroke: #6279FF");
        line.setEndX(230);
        notificationsBox.getChildren().addAll(title,line);
        /*for(int i =0;i<10;i++){
            MyNotificationCard test = new MyNotificationCard(new Notification(0,0,"Test","asdsad",false,new Date()));
            Separator separator = new Separator();
            separator.setStyle("-fx-background: #E1E7EF");
            notificationsBox.getChildren().addAll(test,separator);
        }*/
        for(Notification notification:App.getUser().getAllNotifications()){
            MyNotificationCard test = new MyNotificationCard(notification);
            Separator separator = new Separator();
            separator.setStyle("-fx-background: #E1E7EF");
            notificationsBox.getChildren().addAll(test,separator);
        }
        MyNotificationCard test = new MyNotificationCard(new Notification(0,0,"Test","asasdasdasdasdasdasdsadasdsassssssssssddddsaasds dsadas\ndsad",false,new Date()));
        notificationsBox.getChildren().addAll(test);

        notificationsBox.setMaxHeight(Double.MAX_VALUE);
        if(notificationsBox.getChildren().size() == 2){
            Label txt = new Label("There is no notification");
            txt.setFont(new Font("Arial",12));
            txt.setStyle("-fx-text-fill: black");
            txt.setPrefWidth(250);
            txt.setAlignment(Pos.CENTER);
            notificationsBox.getChildren().add(txt);
        }
        notificationPane = new ScrollPane(notificationsBox);

        notificationsBox.heightProperty().addListener((obs, oldWidth, newWidth) -> {
            if(notificationsBox.getHeight()>250){
                for(int i =2;i<notificationsBox.getChildren().size();i=i+2){
                    MyNotificationCard card = (MyNotificationCard)notificationsBox.getChildren().get(i);
                    card.setScrollForm();
                }
            }
                });
        //notificationPane.setStyle("-fx-background-color: transparent;");
        notificationPane.setLayoutY(45);
        notificationPane.setLayoutX(1395-250-55);
        notificationPane.setPrefWidth(251);
        notificationPane.setPrefHeight(250);
        notificationPane.setPadding(new Insets(5,5,5,5));
        notificationPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        notificationPane.setStyle("-fx-background: transparent;-fx-background-radius: 10;-fx-background-color: white");
        notificationPane.getStylesheets().add(this.getClass().getResource("style/scroll.css").toExternalForm());
        notificationPane.setEffect(new DropShadow(10,Color.web("#6279FF")));
        mainPane.getChildren().add(notificationPane);
        //animation
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.2),notificationPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        TranslateTransition moveTransition = new TranslateTransition(Duration.seconds(0.2),notificationPane);
        moveTransition.setFromY(-8);
        moveTransition.setToY(0);
        moveTransition.play();
    }
    public void hideNotifications(){
        mainPane.getChildren().remove(notificationPane);
    }


    private void showReservations() {
        if (mainPane.getChildren().contains(reservationPane)) {
            return;
        }
        reservationsBox = new VBox();
        reservationsBox.setSpacing(5);
        reservationsBox.setPadding(new Insets(5,0,0,5));
        reservationsBox.setStyle("-fx-background-color: white;-fx-background-radius: 10");
        //profileMenu.setAlignment(Pos.CENTER_LEFT);
        reservationsBox.setPrefWidth(235);
        Label title = new Label("Reservations");
        title.setStyle("-fx-text-fill: #6279FF");
        title.setFont(Font.font("Arial", FontWeight.BOLD,14));
        Line line = new Line();
        line.setStyle("-fx-stroke: #6279FF");
        line.setEndX(230);

        reservationsBox.getChildren().addAll(title,line);
        for(Reservation res:App.getUser().getReservations()){
            Separator separator = new Separator();
            separator.setStyle("-fx-background: #E1E7EF");
            reservationsBox.getChildren().addAll(new MyReservationCard(res),separator);
        }
        reservationsBox.getChildren().remove(reservationsBox.getChildren().size()-1);
        reservationPane = new ScrollPane(reservationsBox);
        reservationPane.setLayoutY(45);
        reservationPane.setLayoutX(1395-250-80);
        reservationPane.setPrefWidth(251);
        reservationPane.setPrefHeight(250);
        reservationPane.setPadding(new Insets(5,5,5,5));
        reservationPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        reservationPane.setStyle("-fx-background: transparent;-fx-background-radius: 10;-fx-background-color: white");
        reservationPane.getStylesheets().add(this.getClass().getResource("style/scroll.css").toExternalForm());
        reservationPane.setEffect(new DropShadow(10,Color.web("#6279FF")));
        mainPane.getChildren().add(reservationPane);
        //animation
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.2),reservationPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        TranslateTransition moveTransition = new TranslateTransition(Duration.seconds(0.2),reservationPane);
        moveTransition.setFromY(-8);
        moveTransition.setToY(0);
        moveTransition.play();
    }
    public void hideReservations(){
        mainPane.getChildren().remove(reservationPane);
    }

    public void refreshUserBox(){
        if(App.getUser().getAllUnreadNotifications().size()>0 && !notificationBtn.getChildren().contains(notifCircle)){
            notifsNumber.setText(String.valueOf(App.getUser().getAllUnreadNotifications().size()));
            notificationBtn.getChildren().addAll(notifCircle,notifsNumber);
            bellAnimation();
        }
        boolean redCheck = false;
        boolean orangeCheck = false;
        for(Reservation reservation:App.getUser().getReservations()){
            if (reservation.getPercentageOfTimeLeft() <10){
                redCheck = true;
                break;
            } else if (reservation.getPercentageOfTimeLeft() <20) {
                orangeCheck = true;
            }
        }
        if(redCheck){
            reservationCircle.setStyle("-fx-fill: red");
            if (!reservationsBtn.getChildren().contains(reservationCircle)) reservationsBtn.getChildren().add(reservationCircle);
        } else if (orangeCheck) {
            reservationCircle.setStyle("-fx-fill: orange");
            if (!reservationsBtn.getChildren().contains(reservationCircle)) reservationsBtn.getChildren().add(reservationCircle);
        }
    }
    @FXML
    public void openHome(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("home-view.fxml"));
            VBox home = fxmlLoader.load();
            HomeController homeController = fxmlLoader.getController();
            //homeController.loadIn();
            mainBox.getChildren().clear();
            mainBox.getChildren().addAll(navBar,home);
            if(App.getUser()!=null){
            refreshUserBox();}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openVehicle(Vehicle vehicle, Reservation reservation){
        try {
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("infopage-view.fxml"));
            AnchorPane infoPage = loader.load();
            Stage stage =(Stage)userBox.getScene().getWindow();
            InfoPageController infoPageController = loader.getController();
            //infoPageController.setData(vehicle,reservation);
            mainBox.getChildren().clear();
            mainBox.getChildren().addAll(navBar,infoPage);
            refreshUserBox();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void goToLogin(javafx.event.ActionEvent event) {
        App.openLogin((Node)event.getSource());
    }
    @FXML
    void goToRegister(javafx.event.ActionEvent event) {
        App.openRegister((Node)event.getSource());
    }

    public void logOut(){
        App.setUser(null);
        userBox.getChildren().clear();
        userBox.getChildren().addAll(signupBtn,signinBtn);
        openHome();
    }

    public void logIn(){
        userBox.getChildren().clear();
        userBox.getChildren().addAll(reservationsBtn,notificationBtn,avatar);
        userBox.setSpacing(10);
    }

    private void bellAnimation() {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(0.1), notificationBtn);
        rotateTransition.setFromAngle(-9);
        rotateTransition.setToAngle(9);
        rotateTransition.setInterpolator(Interpolator.LINEAR);
        rotateTransition.setCycleCount(6);
        rotateTransition.setAutoReverse(true);
        rotateTransition.setOnFinished(event -> {
            notificationBtn.setRotate(0);
        });
        bellTimeline = new Timeline(
                new KeyFrame(Duration.ZERO, e -> rotateTransition.play()),
                new KeyFrame(Duration.seconds(1), e -> rotateTransition.stop())
        );
        bellTimeline.setCycleCount(Timeline.INDEFINITE);
        bellTimeline.play();
    }


    @FXML
    void clear(MouseEvent event) {
        if (mainPane.getChildren().contains(profileMenu) ){
            if(!event.getTarget().equals(avatar) && !((Node)event.getTarget()).getParent().equals(avatar) && !event.getTarget().equals(profileMenu)){
               hideProfileMenu();
            }
        }
        if (mainPane.getChildren().contains(notificationPane) ){
            if(!event.getTarget().equals(notificationBtn) && !((Node)event.getTarget()).getParent().equals(notificationBtn) && !event.getTarget().equals(notificationPane)&& !event.getTarget().equals(notificationsBox) && !((Node)event.getTarget()).getParent().equals(notificationsBox)){
                hideNotifications();
            }
        }
        if (mainPane.getChildren().contains(reservationPane) ){
            if(!event.getTarget().equals(reservationsBtn) && !((Node)event.getTarget()).getParent().equals(reservationsBtn) && !event.getTarget().equals(reservationPane)&& !event.getTarget().equals(reservationsBox) && !((Node)event.getTarget()).getParent().equals(reservationsBox)){
                hideReservations();
            }
        }
    }

}
