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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.effect.*;
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
    public Label homeBtn;
    public Label reviewsBtn;
    public Label contactBtn;
    public Label termsBtn;
    Label pageSelected = null;
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
    Boolean isProfileMenuShown = false;
    VBox notificationsBox = null;
    ScrollPane notificationMenu = null;
    Boolean isNotificationMenuShown = false;
    VBox reservationsBox = null;
    ScrollPane reservationMenu = null;
    Boolean isReservationMenuShown = false;

    Boolean showed = false;
    Timeline bellTimeline = null;
    Circle notifCircle;
    Circle reservationCircle;
    Label notifsNumber;

    private Date startDate = null;
    private Date endDate = null;
    private Date startTime = null;
    private Date endTime = null;
    private String location = null;

    public VBox getMainBox() {
        return mainBox;
    }
    public HBox getNavBar() {
        return navBar;
    }

    public void setNavBar(HBox navBar) {
        this.navBar = navBar;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pageSelected = homeBtn;
        homeBtn.setOnMouseEntered(event->{
            homeBtn.setStyle("-fx-text-fill: white; -fx-cursor: hand;");
                });
        reviewsBtn.setOnMouseEntered(event->{
            reviewsBtn.setStyle("-fx-text-fill: white; -fx-cursor: hand;");
        });
        contactBtn.setOnMouseEntered(event->{
            contactBtn.setStyle("-fx-text-fill: white; -fx-cursor: hand;");
        });
        termsBtn.setOnMouseEntered(event->{
            termsBtn.setStyle("-fx-text-fill: white; -fx-cursor: hand;");
        });
        homeBtn.setOnMouseExited(event->{
            if(pageSelected !=homeBtn) homeBtn.setStyle("-fx-text-fill: #d9deff; -fx-cursor: hand;");
        });
        reviewsBtn.setOnMouseExited(event->{
            if(pageSelected !=reviewsBtn) reviewsBtn.setStyle("-fx-text-fill: #d9deff; -fx-cursor: hand;");
        });
        contactBtn.setOnMouseExited(event->{
            if(pageSelected !=contactBtn) contactBtn.setStyle("-fx-text-fill: #d9deff; -fx-cursor: hand;");
        });
        termsBtn.setOnMouseExited(event->{
            if(pageSelected !=termsBtn) termsBtn.setStyle("-fx-text-fill: #d9deff; -fx-cursor: hand;");
        });
        if(App.getUser() != null){
            userBox.getChildren().clear();
            ImageView avatarImage = new ImageView(new Image(getClass().getResourceAsStream("icons/blank-user.png"),40,40,true,true));
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
            carsIcon.setClip(new ImageView(new Image(getClass().getResourceAsStream("icons/cars.png"),20,20,true,true)));
            reservationsBtn = new StackPane(carsIcon);

            refreshUserBox();


            Button signoutBtn = new Button("Sign out");
            signoutBtn.getStyleClass().addAll(signinBtn.getStyleClass());
            signoutBtn.setStyle(signinBtn.getStyle());
            signoutBtn.setFont(signinBtn.getFont());
                logIn();
        }else{
            logOut();
        }
        try {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("search-view.fxml"));
        AnchorPane searchPage = fxmlLoader.load();
        SearchController searchController = fxmlLoader.getController();
        mainBox.getChildren().add(searchPage);
        //homeController.loadIn();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void showProfileMenu(){
        if(mainPane.getChildren().contains(profileMenu)) {
            return;
        }
        isProfileMenuShown = true;
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
        ImageView profileImage = new ImageView(new Image(getClass().getResourceAsStream("icons/profile.png"),14,14,true,true));
        HBox profile = new HBox(profileImage,new Label("Profile"));
        profile.setAlignment(Pos.CENTER_LEFT);
        profile.setSpacing(4);
        profile.setPadding(new Insets(0, 0, 0,4));
        profile.setOnMouseEntered(event -> profile.setStyle("-fx-background-color: #F6F8FF"));
        profile.setOnMouseExited(event -> profile.setStyle("-fx-background-color: white"));
        profile.setOnMouseClicked(event -> openProfileSetting());
        profileMenu.setPrefWidth(80);
        profileMenu.getChildren().add(profile);
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
        isProfileMenuShown = false;
        mainPane.getChildren().remove(profileMenu);
    }

    private void showNotifications(){
        if(mainPane.getChildren().contains(notificationMenu)) {
            return;
        }
        isNotificationMenuShown = true;
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
            MyNotificationCard notificationCard = new MyNotificationCard(notification);
            Separator separator = new Separator();
            separator.setStyle("-fx-background: #E1E7EF");
            notificationsBox.getChildren().addAll(notificationCard,separator);
        }
        notificationsBox.getChildren().remove(notificationsBox.getChildren().size()-1);
        notificationsBox.setMaxHeight(Double.MAX_VALUE);
        if(notificationsBox.getChildren().size() == 2){
            Label txt = new Label("There is no notification");
            txt.setFont(new Font("Arial",12));
            txt.setStyle("-fx-text-fill: black");
            txt.setPrefWidth(250);
            txt.setAlignment(Pos.CENTER);
            notificationsBox.getChildren().add(txt);
        }
        notificationMenu = new ScrollPane(notificationsBox);

        notificationsBox.heightProperty().addListener((obs, oldWidth, newWidth) -> {
            if(notificationsBox.getHeight()>250){
                for(int i =2;i<notificationsBox.getChildren().size();i=i+2){
                    MyNotificationCard card = (MyNotificationCard)notificationsBox.getChildren().get(i);
                    card.setScrollForm();
                }
            }
                });
        //notificationPane.setStyle("-fx-background-color: transparent;");
        notificationMenu.setLayoutY(45);
        notificationMenu.setLayoutX(1395-250-55);
        notificationMenu.setPrefWidth(251);
        notificationMenu.setPrefHeight(250);
        notificationMenu.setPadding(new Insets(5,5,5,5));
        notificationMenu.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        notificationMenu.setStyle("-fx-background: transparent;-fx-background-radius: 10;-fx-background-color: white");
        notificationMenu.getStylesheets().add(this.getClass().getResource("style/scroll.css").toExternalForm());
        notificationMenu.setEffect(new DropShadow(10,Color.web("#6279FF")));
        mainPane.getChildren().add(notificationMenu);
        //animation
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.2), notificationMenu);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        TranslateTransition moveTransition = new TranslateTransition(Duration.seconds(0.2), notificationMenu);
        moveTransition.setFromY(-8);
        moveTransition.setToY(0);
        moveTransition.play();
    }
    public void hideNotifications(){
        isNotificationMenuShown = false;
        mainPane.getChildren().remove(notificationMenu);
    }


    private void showReservations() {
        if (mainPane.getChildren().contains(reservationMenu)) {
            return;
        }
        isReservationMenuShown = true;
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
        reservationMenu = new ScrollPane(reservationsBox);
        reservationMenu.setLayoutY(45);
        reservationMenu.setLayoutX(1395-250-80);
        reservationMenu.setPrefWidth(251);
        reservationMenu.setPrefHeight(250);
        reservationMenu.setPadding(new Insets(5,5,5,5));
        reservationMenu.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        reservationMenu.setStyle("-fx-background: transparent;-fx-background-radius: 10;-fx-background-color: white");
        reservationMenu.getStylesheets().add(this.getClass().getResource("style/scroll.css").toExternalForm());
        reservationMenu.setEffect(new DropShadow(10,Color.web("#6279FF")));
        mainPane.getChildren().add(reservationMenu);
        //animation
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.2), reservationMenu);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        TranslateTransition moveTransition = new TranslateTransition(Duration.seconds(0.2), reservationMenu);
        moveTransition.setFromY(-8);
        moveTransition.setToY(0);
        moveTransition.play();
    }
    public void hideReservations(){

        isReservationMenuShown = false;
        mainPane.getChildren().remove(reservationMenu);
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
            if(this.startDate == null || this.endDate == null || this.startTime == null || this.endTime == null){
                openSearch();
                return;
            }
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("home-view.fxml"));
            VBox home = fxmlLoader.load();
            HomeController homeController = fxmlLoader.getController();
            homeController.setData(startDate,endDate,startTime,endTime,location);
            //homeController.loadIn();
            mainBox.getChildren().clear();
            mainBox.getChildren().addAll(navBar,home);
            pageSelected.setStyle("-fx-text-fill: #d9deff");
            homeBtn.setStyle("-fx-text-fill: white");
            pageSelected = homeBtn;
            if(App.getUser()!=null){
                new Thread(this::refreshUserBox).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void openSearch(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("search-view.fxml"));
            AnchorPane searchPage = fxmlLoader.load();
            mainBox.getChildren().clear();
            mainBox.getChildren().addAll(navBar,searchPage);
            pageSelected.setStyle("-fx-text-fill: #d9deff");
            homeBtn.setStyle("-fx-text-fill: white");
            pageSelected = homeBtn;
            if(App.getUser()!=null){
                refreshUserBox();}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openVehicle(Vehicle vehicle, Date startDate,Date endDate){
        try {
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("infopage-view.fxml"));
            AnchorPane infoPage = loader.load();
            Stage stage =(Stage)userBox.getScene().getWindow();
            InfoPageController infoPageController = loader.getController();
            infoPageController.setData(vehicle, startDate, endDate);
            mainBox.getChildren().clear();
            mainBox.getChildren().addAll(navBar,infoPage);
            pageSelected.setStyle("-fx-text-fill: #d9deff");
            homeBtn.setStyle("-fx-text-fill: white");
            pageSelected = homeBtn;
            refreshUserBox();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openCheckOut(Vehicle vehicle, Date startDate,Date endDate){
        try {
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("payment-view.fxml"));
            HBox paymentPage = loader.load();
            Stage stage =(Stage)userBox.getScene().getWindow();
            PaymentController paymentController = loader.getController();
            paymentController.setData(vehicle, startDate, endDate);
            mainBox.getChildren().clear();
            mainBox.getChildren().addAll(navBar,paymentPage);
            refreshUserBox();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void openReviews(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("comments-page-view.fxml"));
            VBox searchPage = fxmlLoader.load();
            mainBox.getChildren().clear();
            mainBox.getChildren().addAll(navBar,searchPage);
            pageSelected.setStyle("-fx-text-fill: #d9deff");
            reviewsBtn.setStyle("-fx-text-fill: white");
            pageSelected = reviewsBtn;
            if(App.getUser()!=null){
                refreshUserBox();}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void openTerms(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("terms&conditions-view.fxml"));
            ScrollPane termsPage = fxmlLoader.load();
            mainBox.getChildren().clear();
            mainBox.getChildren().addAll(navBar,termsPage);
            pageSelected.setStyle("-fx-text-fill: #d9deff");
            termsBtn.setStyle("-fx-text-fill: white");
            pageSelected = termsBtn;
            if(App.getUser()!=null){
                refreshUserBox();}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void openContact(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("contact-view.fxml"));
            AnchorPane contactPage = fxmlLoader.load();
            mainBox.getChildren().clear();
            mainBox.getChildren().addAll(navBar,contactPage);
            pageSelected.setStyle("-fx-text-fill: #d9deff");
            contactBtn.setStyle("-fx-text-fill: white");
            pageSelected = contactBtn;
            if(App.getUser()!=null){
                refreshUserBox();}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openProfileSetting(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("AccountSettings-view.fxml"));
            VBox profilePage = fxmlLoader.load();
            mainBox.getChildren().clear();
            mainBox.getChildren().addAll(navBar,profilePage);
            pageSelected.setStyle("-fx-text-fill: #d9deff");
            homeBtn.setStyle("-fx-text-fill: white");
            pageSelected = homeBtn;
            if(App.getUser()!=null){
                refreshUserBox();}
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
        openSearch();
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
        if (!isNotificationMenuShown){
            if(event.getTarget().equals(notificationBtn) || ((Node)event.getTarget()).getParent().equals(notificationBtn)){
                showNotifications();
                if (bellTimeline != null) {
                    bellTimeline.stop();
                }
                notificationBtn.getChildren().removeAll(notifCircle,notifsNumber);
                for (Notification notification:App.getUser().getAllUnreadNotifications()){
                    notification.setRead(true);
                }
            }
        }else{
            if(!event.getTarget().equals(notificationMenu)&& !event.getTarget().equals(notificationsBox) && !((Node)event.getTarget()).getParent().equals(notificationsBox)){
                hideNotifications();

            }
        }
        if (!isProfileMenuShown){
            if(event.getTarget().equals(avatar) || ((Node)event.getTarget()).getParent().equals(avatar)){
                showProfileMenu();

            }
        }else{
            if(!event.getTarget().equals(profileMenu)){
                hideProfileMenu();

            }
        }

        if (!isReservationMenuShown){
            if(event.getTarget().equals(reservationsBtn) || ((Node)event.getTarget()).getParent().equals(reservationsBtn)){
                showReservations();
            }
        }else{
            if( !event.getTarget().equals(reservationMenu)&& !event.getTarget().equals(reservationsBox) && !((Node)event.getTarget()).getParent().equals(reservationsBox)){
                hideReservations();
            }
        }

    }

}
