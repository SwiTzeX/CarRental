package com.carrental.customnodes;
import javafx.animation.TranslateTransition;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class MyButton extends Button {
    private TranslateTransition startTranslateTransition;
    private TranslateTransition endTranslateTransition;
    private Border hoverBorder;
    Color color = null;
    Boolean darker = true;

    public MyButton(String text) {
        super(text);
        createEndAnimation();
        createStartAnimation();

        setOnMousePressed(event -> startAnimation());
        setOnMouseReleased(event -> endAnimation());
            Platform.runLater(() -> {
                try {
                    color = ((Color) this.getBackground().getFills().get(0).getFill());
                    if (color == null) {
                        color = Color.web("#6279ff");
                    }
                    double darkenFactor = 0.9;

                    double red = Math.min(color.getRed() * darkenFactor, 1.0);
                    double green = Math.min(color.getGreen() * darkenFactor, 1.0);
                    double blue = Math.min(color.getBlue() * darkenFactor, 1.0);
                    Color finalColor = null;
                    if (darker) {
                        finalColor = new Color(red, green, blue, 1);
                    } else {
                        finalColor = Color.rgb(227, 231, 255);
                    }

                    double radius = getBackground().getFills().get(0).getRadii().getTopLeftHorizontalRadius();
                    Color finalColor1 = finalColor;
                    setOnMouseEntered(event -> setStyle("-fx-background-color: #" + finalColor1.toString().substring(2, 8) + ";-fx-background-radius: " + radius + ";-fx-cursor: hand;"));
                    setOnMouseExited(event -> setStyle("-fx-background-color: #" + color.toString().substring(2, 8) + ";-fx-background-radius: " + radius + ";-fx-cursor: hand;"));
                } catch (Exception e) {
                    ;
                }
            });
    }
    public MyButton() {
        super();
        createEndAnimation();
        createStartAnimation();

        setOnMousePressed(event -> startAnimation());
        setOnMouseReleased(event -> endAnimation());
        Platform.runLater(() -> {
            try {
                color = ((Color) this.getBackground().getFills().get(0).getFill());
                if (color == null) {
                    color = Color.web("#6279ff");
                }
                double darkenFactor = 0.9;

                double red = Math.min(color.getRed() * darkenFactor, 1.0);
                double green = Math.min(color.getGreen() * darkenFactor, 1.0);
                double blue = Math.min(color.getBlue() * darkenFactor, 1.0);
                Color finalColor = null;
                if (darker) {
                    finalColor = new Color(red, green, blue, 1);
                } else {
                    finalColor = Color.rgb(227, 231, 255);
                }

                double radius = getBackground().getFills().get(0).getRadii().getTopLeftHorizontalRadius();
                Color finalColor1 = finalColor;
                setOnMouseEntered(event -> setStyle("-fx-background-color: #" + finalColor1.toString().substring(2, 8) + ";-fx-background-radius: " + radius + ";-fx-cursor: hand;"));
                setOnMouseExited(event -> setStyle("-fx-background-color: #" + color.toString().substring(2, 8) + ";-fx-background-radius: " + radius + ";-fx-cursor: hand;"));
            } catch (Exception e) {
                ;
            }
        });
    }

    public Boolean getDarker() {
        return darker;
    }

    public void setDarker(Boolean darker) {
        this.darker = darker;
    }

    private void createStartAnimation() {
        startTranslateTransition = new TranslateTransition(Duration.millis(100), this);
        startTranslateTransition.setFromY(0);
        startTranslateTransition.setToY(1);
        startTranslateTransition.setCycleCount(1);
    }

    public void startAnimation() {
        startTranslateTransition.playFromStart();
    }
    private void createEndAnimation() {
        endTranslateTransition = new TranslateTransition(Duration.millis(100), this);
        endTranslateTransition.setFromY(1);
        endTranslateTransition.setToY(0);
        endTranslateTransition.setCycleCount(1);
    }

    public void endAnimation() {
        endTranslateTransition.playFromStart();
    }



}
