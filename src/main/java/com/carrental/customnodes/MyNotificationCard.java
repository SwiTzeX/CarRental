package com.carrental.customnodes;

import com.carrental.models.Notification;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MyNotificationCard extends VBox {
    HBox hBox = new HBox();
    Label title = new Label();
    Label time = new Label();
    Label content = new Label();
    public MyNotificationCard(Notification notification) {
        title.setText(notification.title);
        title.setStyle("-fx-text-fill: black");
        title.setFont(Font.font("Arial", FontWeight.BOLD,12));
        time.setText(notification.getTime());
        time.setFont(new Font("Arial",10));
        title.widthProperty().addListener((obs, oldWidth, newWidth) -> {
            time.setPrefWidth(230-title.getWidth());
        });
        time.setStyle("-fx-text-fill: #B5BAC4;-fx-alignment: center-right;");
        hBox.getChildren().addAll(title,time);
        content.setText(notification.content);
        content.setWrapText(true);
        content.setStyle("-fx-text-fill: black");
        content.setFont(new Font("Arial",12));
        //box.setPrefHeight(20);
        this.setMaxHeight(Double.MAX_VALUE);
        this.getChildren().addAll(hBox,content);
    }
    public void setScrollForm(){
        title.widthProperty().addListener((obs, oldWidth, newWidth) -> {
            time.setPrefWidth(230-title.getWidth()-5);
        });
    }
}
