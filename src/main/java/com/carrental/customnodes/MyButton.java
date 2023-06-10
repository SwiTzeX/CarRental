package com.carrental.customnodes;
import javafx.animation.TranslateTransition;

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
    public MyButton() {
        super();
        createAnimation();
        createHoverBorder();
        setOnMouseEntered(event -> setBorder(hoverBorder));
        setOnMouseExited(event -> setBorder(null));
        setOnMouseClicked(event -> startAnimation());
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
