package com.carrental.customnodes;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.util.Duration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class MyDatePicker extends StackPane {
    private TextField textField = new TextField();
    private Label errorLabel = new Label();
    private Line backLine = new Line();
    private Line frontLine = new Line();

    private String promptText;
    private Label promptTextLabel = new Label();
    private boolean isPromptTextShowing = true;
    private double promptFontSize = 16;
    private double inputFontSize = 16;
    private Boolean error = false;
    ComboBox<Integer> days = new ComboBox<>();
    ComboBox<String> months = new ComboBox<>();
    ComboBox<Integer> years = new ComboBox<>();
    Popup popup = new Popup();

    Date date = new Date();
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public MyDatePicker() {
        super();
        setupTexts();
        setupTextField();
        setupDatePicker();
    }
    public MyDatePicker(String promptText) {
        super();
        this.promptText = promptText;
        setupTextField();
        setupTexts();
        setupDatePicker();
    }

    public String getPromptText() {
        return promptText;
    }


    public void setPromptText(String promptText) {
        this.promptText = promptText;
        promptTextLabel.setText(promptText);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
        showPromptText();
        textField.setText(format.format(date));
    }

    private void updateTextField(){
        String strDate = days.getValue()+"/"+convertMonthToNumber(months.getValue().toLowerCase())+"/"+years.getValue();
        try {
            date = format.parse(strDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        textField.setText(format.format(date));
    }



    private void setupTextField() {
        textField.setStyle("-fx-background-color: transparent;");
        textField.setPadding(new Insets(0, 0, 0, -0.8));
        textField.setFont(new Font("Arial",inputFontSize));
        textField.setEditable(false);
        textField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                showPromptText();
                textField.setText(format.format(date));
                addLine();
                if (!popup.isShowing()) {
                    showPopup();
                }
                //textField.setStyle("-fx-border-color: #a390f0;;-fx-border-width: 0 0 1 0;-fx-background-color: transparent;");
            } else if (!newValue && textField.getText().isEmpty()) {
                //textField.setStyle("-fx-border-color: grey;-fx-border-width: 0 0 1 0;-fx-background-color: transparent;");
                hidePromptText();
                removeLine();

            }else{
                //textField.setStyle("-fx-border-color: grey;-fx-border-width: 0 0 1 0;-fx-background-color: transparent;");
                removeLine();

            }
        });
       textField.textProperty().addListener((observable, oldValue, newValue) -> {
           Platform.runLater(this::showPromptText);
                });
        getChildren().add(textField);

    }

    private void setupDatePicker(){
        popup.setAutoHide(true); // Close the popup when focus is lost
        days.getStyleClass().add("menu");
        days.getStylesheets().add(getClass().getResource("menu.css").toExternalForm());

        months.getStyleClass().add("menu");
        months.getStylesheets().add(getClass().getResource("menu.css").toExternalForm());

        years.getStyleClass().add("menu");
        years.getStylesheets().add(getClass().getResource("menu.css").toExternalForm());

        HBox popupContent = new HBox(days,months,years);
        popupContent.setSpacing(5);
        popupContent.setStyle("-fx-background-color: white;-fx-padding: 2");
        ArrayList<String> monthsText =  new ArrayList<>(Arrays.asList(
                "Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        ));
        for (String txt : monthsText) {
            months.getItems().add(txt);
        }
        months.getSelectionModel().selectFirst();
        for(int i = 0;i<10;i++){
            years.getItems().add(Year.now().getValue()+i);
        }
        years.getSelectionModel().selectFirst();

        int month = convertMonthToNumber(months.getValue().toLowerCase());
        int year = years.getValue();
        YearMonth yearMonth = YearMonth.of(year, month);
        int daysInMonth = yearMonth.lengthOfMonth();
        for(int i=1;i<=daysInMonth;i++) days.getItems().add(i);
        days.getSelectionModel().selectFirst();
        popup.getContent().add(popupContent);
        days.setOnAction(event -> {
            updateTextField();
                }
        );
        years.setOnAction(event -> {
                    updateTextField();
                }
        );
        months.setOnAction(event -> {
                    updateTextField();
                }
        );
    }

    private void showPopup() {
        Bounds bounds = localToScreen(textField.getBoundsInLocal());
        double x = bounds.getMinX();
        double y = bounds.getMaxY()+getHeight()/2;
        popup.show(this, x, y);
    }
    private void setupTexts() {
        promptTextLabel.setText(promptText);
        promptTextLabel.setFont(new Font("Arial",promptFontSize));
        getChildren().add(promptTextLabel);
        promptTextLabel.setTranslateY(-2);
        errorLabel.setText("test");
        errorLabel.setStyle("-fx-text-fill: red;");
        errorLabel.setVisible(false);
        backLine.setStrokeWidth(1.2);
        frontLine.setStrokeWidth(1.2);
        frontLine.setStyle("-fx-stroke: #6279ff;");
        getChildren().addAll(backLine,frontLine, errorLabel);
        promptTextLabel.widthProperty().addListener((obs, oldWidth, newWidth) -> {
            promptTextLabel.setTranslateX(-(this.getWidth()-promptTextLabel.getWidth()) / 2);
            backLine.setStartX(this.getWidth());
        });


        textField.widthProperty().addListener((obs, oldWidth, newWidth) -> {
            backLine.setTranslateY(textField.getHeight()/2);
            frontLine.setTranslateY(textField.getHeight()/2);
            errorLabel.setTranslateY(backLine.getTranslateY()+(errorLabel.getHeight()/2));
        });
        backLine.setTranslateY(textField.getHeight()/2);
        frontLine.setTranslateY(10);
        errorLabel.widthProperty().addListener((obs, oldWidth, newWidth) -> {
            errorLabel.setTranslateX(-(this.getWidth()- errorLabel.getWidth()) / 2);
        });
        this.setAlignment(Pos.CENTER);
    }

    private void showPromptText() {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.1), promptTextLabel);
        scaleTransition.setToX(0.9);
        scaleTransition.setToY(0.9);
        scaleTransition.play();
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.25), promptTextLabel);
        translateTransition.setToY(-textField.getHeight());
        Text test = new Text(getPromptText());
        test.setScaleX(0.9);
        test.setScaleY(0.9);
        test.setFont(new Font("Arial",promptFontSize));
        double X = (-(this.getWidth()-test.getBoundsInLocal().getWidth()*0.9)/ 2);
        translateTransition.setToX(X);
        translateTransition.play();

    }

    private void hidePromptText() {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.1), promptTextLabel);
        scaleTransition.setToX(1.0);
        scaleTransition.setToY(1.0);
        scaleTransition.play();
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.25), promptTextLabel);
        double X = -(this.getWidth()-promptTextLabel.getWidth()) / 2;
        translateTransition.setToX(X);
        translateTransition.setToY(-2);
        translateTransition.play();
    }

    private void addLine(){
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(frontLine.startXProperty(), 0)),
                new KeyFrame(Duration.seconds(0.5), new KeyValue(frontLine.startXProperty(), this.getWidth()-2))
        );
        timeline.setCycleCount(1);
        timeline.play();
    }
    private void removeLine(){
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(frontLine.startXProperty(), this.getWidth())),
                new KeyFrame(Duration.seconds(0.5), new KeyValue(frontLine.startXProperty(), 0))
        );
        timeline.setCycleCount(1);
        timeline.play();
    }

    public void showError(String errorText){
        errorLabel.setText(errorText);
        errorLabel.setVisible(true);
        promptTextLabel.setStyle("-fx-text-fill: red;");
        backLine.setStyle("-fx-stroke: red;");
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(50), this);
        translateTransition.setFromX(0);
        translateTransition.setByX(10);
        translateTransition.setCycleCount(6);
        translateTransition.setAutoReverse(true);
        translateTransition.play();
        this.error = true;
    }

    public void hideError(){
        errorLabel.setVisible(false);
        promptTextLabel.setStyle("-fx-text-fill: #353535;");
        backLine.setStyle("-fx-stroke: #353535;");
        this.error = false;
    }

    public String getText() {
        return textField.getText();
    }

    public double getPromptFontSize() {
        return promptFontSize;
    }

    public void setPromptFontSize(double promptFontSize) {
        this.promptFontSize = promptFontSize;
        promptTextLabel.setFont(new Font("Arial",promptFontSize));
    }

    public double getInputFontSize() {
        return inputFontSize;
    }

    public void setInputFontSize(double inputFontSize) {
        this.inputFontSize = inputFontSize;
        textField.setFont(new Font("Arial",inputFontSize));
    }

    public void setText(String text) {
        textField.setText(text);
        hidePromptText();
        this.focusedProperty();
    }

    public Label getErrorLabel() {
        return errorLabel;
    }

    public void setErrorLabel(Label errorLabel) {
        this.errorLabel = errorLabel;
    }

    public Boolean isError(){
        return error;
    }

    public ReadOnlyBooleanProperty myFocusedProperty(){
        return textField.focusedProperty();
    }

    public static int convertMonthToNumber(String monthName) {
        switch (monthName.toLowerCase()) {
            case "jan":
                return 1;
            case "feb":
                return 2;
            case "mar":
                return 3;
            case "apr":
                return 4;
            case "may":
                return 5;
            case "jun":
                return 6;
            case "jul":
                return 7;
            case "aug":
                return 8;
            case "sep":
                return 9;
            case "oct":
                return 10;
            case "nov":
                return 11;
            case "dec":
                return 12;
            default:
                throw new IllegalArgumentException("Invalid month name: " + monthName);
        }
    }


}
