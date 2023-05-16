package com.carrental.customnodes;
import javafx.animation.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class MyTextField extends StackPane {
    private TextField textField = new TextField();
    private final String promptText;
    private Label promptTextLabel = new Label();
    private boolean isPromptTextShowing = true;
    private double FontSize = 16;

    public MyTextField(String promptText) {
        this.promptText = promptText;
        setupTextField();
        setupPromptText();
    }

    private void setupTextField() {
        textField.setStyle("-fx-border-color: grey;-fx-border-width: 0 0 1 0;-fx-background-color: transparent;");
        textField.setPadding(new Insets(0, 0, 0, -0.8));
        textField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                showPromptText();
                textField.setStyle("-fx-border-color: #a390f0;;-fx-border-width: 0 0 1 0;-fx-background-color: transparent;");
            } else if (!newValue && textField.getText().isEmpty()) {
                textField.setStyle("-fx-border-color: grey;-fx-border-width: 0 0 1 0;-fx-background-color: transparent;");
                hidePromptText();
            }else{
                textField.setStyle("-fx-border-color: grey;-fx-border-width: 0 0 1 0;-fx-background-color: transparent;");
            }
        });

        getChildren().add(textField);
    }

    private void setupPromptText() {
        promptTextLabel.setText(promptText);
        promptTextLabel.setFont(new Font(FontSize));
        getChildren().add(promptTextLabel);
        this.setAlignment(Pos.CENTER_LEFT);
    }

    private void showPromptText() {
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.25), promptTextLabel);
        translateTransition.setToY(-textField.getHeight());
        translateTransition.setToX(-2);
        translateTransition.play();
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.1), promptTextLabel);
        scaleTransition.setToX(0.9);
        scaleTransition.setToY(0.9);
        scaleTransition.play();
    }

    private void hidePromptText() {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.1), promptTextLabel);
        scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);
        scaleTransition.play();
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.25), promptTextLabel);
        translateTransition.setToX(0);
        translateTransition.setToY(0);
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
    }
}
