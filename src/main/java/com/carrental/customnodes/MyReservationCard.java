package com.carrental.customnodes;

import com.carrental.models.Notification;
import com.carrental.models.Reservation;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MyReservationCard extends VBox {
    Label title = new Label();

    public MyReservationCard(Reservation reservation) {
        title.setText(reservation.getVehicle().getBrandName()+" "+reservation.getVehicle().getModelName());
        title.setStyle("-fx-text-fill: black");
        title.setFont(Font.font("Arial", FontWeight.BOLD,13));
        //hBox.getChildren().addAll(title);
        HBox line1 = new HBox();
        Label lbl1 = new Label("Status: ");
        lbl1.setStyle("-fx-text-fill: black");
        lbl1.setFont(Font.font("Arial", FontWeight.BOLD,11));
        Label status = new Label();
        status.setStyle("-fx-text-fill: black");
        status.setFont(new Font("Arial",11));
        line1.getChildren().addAll(lbl1,status);
        this.getChildren().addAll(title,line1);
        if (reservation.getStatus() == 0){
            status.setText("Waiting approval");
        }else{
            if (reservation.getStatus() == 1){
                status.setText("Approved");
            }
            HBox line2 = new HBox();
            Label lbl2 = new Label("Ends in ");
            lbl2.setStyle("-fx-text-fill: black");
            lbl2.setFont(Font.font("Arial", FontWeight.BOLD,11));
            Label timeLeft = new Label(reservation.getTimeLeft());
            timeLeft.setStyle("-fx-text-fill: black");
            if(reservation.getPercentageOfTimeLeft()<10){
                timeLeft.setStyle("-fx-text-fill: red");
            } else if (reservation.getPercentageOfTimeLeft()<20) {
                timeLeft.setStyle("-fx-text-fill: orange");
            }
            timeLeft.setFont(new Font("Arial",11));
            line2.getChildren().addAll(lbl2,timeLeft);
            this.getChildren().add(line2);
        }

        
        //box.setPrefHeight(20);
        this.setMaxHeight(Double.MAX_VALUE);
    }
    /*public void setScrollForm(){
        title.widthProperty().addListener((obs, oldWidth, newWidth) -> {
            time.setPrefWidth(230-title.getWidth()-5);
        });
    }*/
}
