package com.carrental.customnodes;

import javafx.animation.*;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class MyPasswordField extends StackPane {
    private Image openEye = new Image(new File("src/main/resources/com/carrental/icons/eye.png").toURI().toString());
    private Image closeEye = new Image(new File("src/main/resources/com/carrental/icons/eye-crossed.png").toURI().toString());
    private ImageView eyeView = new ImageView(closeEye);
    private TextField textField = new TextField();
    private Label errorLabel = new Label();
    private Line backLine = new Line();
    private Line frontLine = new Line();

    private  String promptText;
    private Label promptTextLabel = new Label();
    private boolean isPromptTextShowing = true;
    private double FontSize = 16;
    public static final char BULLET = '\u2022';

    private String text = "";

    private boolean showPassword = false;

    public MyPasswordField() {
        super();
        setupTexts();
        setupTextField();
        setupEye();
        textField.setOnKeyTyped(event -> {
            if (!showPassword) {
                String typedCharacter = event.getCharacter();
                if (typedCharacter.matches("[a-zA-Z0-9\\p{P}]")) {
                    text += typedCharacter;
                    StringBuilder bullets = new StringBuilder();
                    for (int i = 0; i < textField.getText().length(); i++) {
                        bullets.append(BULLET);
                    }
                    textField.setText(bullets.toString());
                    textField.positionCaret(bullets.length());
                } else if (event.getCharacter().charAt(0) == '\b') {
                    if (text.length() > 0) text = text.substring(0, text.length() - 1);
                }
            }
        });
    }
    public MyPasswordField(String promptText) {
        super();
        this.promptText = promptText;
        setupTexts();
        setupTextField();
        setupEye();
        textField.setOnKeyTyped(event -> {
            if (!showPassword) {
                String typedCharacter = event.getCharacter();
                if (typedCharacter.matches("[a-zA-Z0-9\\p{P}]")) {
                    text += typedCharacter;
                    StringBuilder bullets = new StringBuilder();
                    for (int i = 0; i < textField.getText().length(); i++) {
                        bullets.append(BULLET);
                    }
                    textField.setText(bullets.toString());
                    textField.positionCaret(bullets.length());
                } else if (event.getCharacter().charAt(0) == '\b') {
                    if (text.length() > 0) text = text.substring(0, text.length() - 1);
                }
            }
        });
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
        textField.setFont(new Font(getFontSize()));
        eyeView.fitWidthProperty().addListener((observable, oldValue, newValue) -> {
            textField.setMaxWidth(this.getWidth()-eyeView.getFitWidth());
            textField.setTranslateX(-eyeView.getFitWidth()/2);
        });

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

    private void setupTexts() {
        promptTextLabel.setText(promptText);
        promptTextLabel.setFont(new Font(FontSize));
        promptTextLabel.setFont(new Font(FontSize));
        getChildren().add(promptTextLabel);
        promptTextLabel.setTranslateY(-1);
        errorLabel.setText("test");
        errorLabel.setStyle("-fx-text-fill: red;");
        errorLabel.setVisible(false);
        backLine.setStrokeWidth(1.5);
        frontLine.setStrokeWidth(1.5);
        frontLine.setStyle("-fx-stroke: #a390f0;");
        getChildren().addAll(backLine,frontLine, errorLabel);
        promptTextLabel.widthProperty().addListener((obs, oldWidth, newWidth) -> {
            promptTextLabel.setTranslateX(-(this.getWidth()-promptTextLabel.getWidth()) / 2);
            backLine.setStartX(this.getWidth());
        });


        textField.heightProperty().addListener((obs, oldWidth, newWidth) -> {
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

    private void setupEye(){
        this.getChildren().add(eyeView);
        this.heightProperty().addListener((obs, oldWidth, newWidth) -> {
        eyeView.setFitHeight(this.getHeight());
        eyeView.setFitWidth(this.getHeight());
        eyeView.setTranslateX((int) (this.getWidth()/2 - eyeView.getFitWidth()/2));
        eyeView.setScaleX(0.9);
        eyeView.setScaleY(0.9);
        });
        eyeView.setOnMouseClicked((MouseEvent event) -> {
            if (showPassword) {
                text = textField.getText();
                eyeView.setImage(closeEye);
                showPassword = false;
                StringBuilder bullets = new StringBuilder();
                for (int i = 0; i < textField.getText().length(); i++) {
                    bullets.append(BULLET);
                }
                textField.setText(bullets.toString());
                textField.positionCaret(bullets.length());
            }else{
                eyeView.setImage(openEye);
                showPassword = true;
                textField.setText(text);
                textField.positionCaret(text.length());
            }
        });
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
    }

    public void hideError(){
        errorLabel.setVisible(false);
        promptTextLabel.setStyle("-fx-text-fill: #353535;");
        backLine.setStyle("-fx-stroke: #353535;");
    }

    public String getText() {
        return text;
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
