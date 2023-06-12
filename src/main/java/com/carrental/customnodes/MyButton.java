package com.carrental.customnodes;
import javafx.animation.TranslateTransition;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class MyButton extends Button {
    private TranslateTransition translateTransition;
    private Border hoverBorder;
    Color color = null;
    Boolean darker = true;

    public MyButton() {
        super();
        createAnimation();
        createHoverBorder();

        setOnMouseClicked(event -> startAnimation());
            Platform.runLater(() -> {
                color= (Color) this.getBackground().getFills().get(0).getFill();
                double darkenFactor = 0.9;

                double red = Math.min(color.getRed() * darkenFactor, 1.0);;
                double green = Math.min(color.getGreen() * darkenFactor, 1.0);
                double blue = Math.min(color.getBlue() * darkenFactor, 1.0);
                Color finalColor = null;
                if(darker) {
                    finalColor = new Color(red, green, blue, 1);
                }else{
                    finalColor = Color.rgb( 227, 231, 255);
                }

                double radius = getBackground().getFills().get(0).getRadii().getTopLeftHorizontalRadius();
                Color finalColor1 = finalColor;
                setOnMouseEntered(event -> setStyle("-fx-background-color: #" + finalColor1.toString().substring(2, 8) + ";-fx-background-radius: "+radius+";"));
                setOnMouseExited(event -> setStyle("-fx-background-color: #" + color.toString().substring(2, 8) + ";-fx-background-radius: "+radius+";"));
            });
    }

    public Boolean getDarker() {
        return darker;
    }

    public void setDarker(Boolean darker) {
        this.darker = darker;
    }

    private void createAnimation() {
        translateTransition = new TranslateTransition(Duration.millis(100), this);
        translateTransition.setFromY(0);
        translateTransition.setToY(1);
        translateTransition.setCycleCount(2);
        translateTransition.setAutoReverse(true);
    }

    public void startAnimation() {
        translateTransition.playFromStart();
    }

    private void createHoverBorder() {
        hoverBorder = new Border(new BorderStroke(Color.web("#6279ff"), BorderStrokeStyle.SOLID,  new CornerRadii(10), new BorderWidths(1)));
    }


}
