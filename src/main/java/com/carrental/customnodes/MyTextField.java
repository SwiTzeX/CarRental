package com.carrental.customnodes;
import javafx.animation.*;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class MyTextField extends StackPane {
    private TextField textField = new TextField();
    private Label errorLabel = new Label();
    private Line backLine = new Line();
    private Line frontLine = new Line();

    private  String promptText;
    private Label promptTextLabel = new Label();
    private boolean isPromptTextShowing = true;
    private double FontSize = 16;
    public MyTextField() {
        super();
        setupTextField();
        setupPromptText();
    }
    public MyTextField(String promptText) {
        super();
        this.promptText = promptText;
        setupPromptText();
        setupTextField();
    }

    public String getPromptText() {
        return promptText;
    }

    public void setPromptText(String promptText) {
        this.promptText = promptText;
        promptTextLabel.setText(promptText);
    }


    private void setupTextField() {
        textField.setStyle("-fx-background-color: transparent;");
        textField.setPadding(new Insets(0, 0, 0, -0.8));
        textField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                showPromptText();
                addLine();
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
        getChildren().add(textField);
    }

    private void setupPromptText() {
        promptTextLabel.setText(promptText);
        System.out.println(this.getWidth());
        promptTextLabel.setFont(new Font(FontSize));
        promptTextLabel.setFont(new Font(FontSize));
        getChildren().add(promptTextLabel);
        promptTextLabel.setTranslateY(-1);
        errorLabel.setTranslateY(18);
        errorLabel.setText("test");
        errorLabel.setStyle("-fx-text-fill: red;");
        errorLabel.setVisible(false);
        backLine.setTranslateY(10);
        frontLine.setTranslateY(10);
        backLine.setStrokeWidth(1.5);
        frontLine.setStrokeWidth(1.5);
        frontLine.setStyle("-fx-stroke: #a390f0;");
        getChildren().addAll(backLine,frontLine, errorLabel);
        promptTextLabel.widthProperty().addListener((obs, oldWidth, newWidth) -> {
            promptTextLabel.setTranslateX(-(this.getWidth()-promptTextLabel.getWidth()) / 2);
            backLine.setStartX(this.getWidth());
        });
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
        double X = (-(this.getWidth()-test.getBoundsInLocal().getWidth())/ 2);
        translateTransition.setToX(X+(test.getBoundsInLocal().getWidth()-(test.getBoundsInLocal().getWidth()*0.9)));
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
        translateTransition.setToY(-1);
        translateTransition.play();
    }

    private void addLine(){
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(frontLine.startXProperty(), 0)),
                new KeyFrame(Duration.seconds(0.2), new KeyValue(frontLine.startXProperty(), this.getWidth()-2))
        );
        timeline.setCycleCount(1);
        timeline.play();
    }
    private void removeLine(){
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(frontLine.startXProperty(), this.getWidth())),
                new KeyFrame(Duration.seconds(0.2), new KeyValue(frontLine.startXProperty(), 0))
        );
        timeline.setCycleCount(1);
        timeline.play();
    }

    public void error(String errorText){
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
    }

    public String getText() {
        return textField.getText();
    }

    public double getFontSize() {
        return FontSize;
    }

    public void setFontSize(double fontSize) {
        FontSize = fontSize;
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

    public ReadOnlyBooleanProperty myFocusedProperty(){
        return textField.focusedProperty();
    }
}
