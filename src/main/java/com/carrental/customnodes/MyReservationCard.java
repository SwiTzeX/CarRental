package com.carrental.customnodes;

import com.carrental.models.Notification;
import com.carrental.models.Reservation;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MyReservationCard extends HBox {
    Label title = new Label();

    public MyReservationCard(Reservation reservation) {
        setData(reservation);
    }
    private void setData(Reservation reservation){
        this.getChildren().clear();
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
        VBox cardBox = new VBox(title,line1);
        cardBox.setPrefWidth(175);
        //cardBox.setAlignment(Pos.CENTER_RIGHT);
        this.getChildren().addAll(cardBox);
        if (reservation.getStatus() == 0){
            status.setText("Pending");
            status.setStyle("-fx-text-fill: orange");
            Button cancel = new Button("Cancel");
            this.getChildren().add(cancel);
            //setMargin(cancel,new Insets(0 ,5,0,0));
            cancel.setStyle("-fx-background-color: red;-fx-text-fill: white");
            cancel.setOnAction(event->{
                reservation.setStatus(-2);
                setData(reservation);
            });
        }else if (reservation.getStatus() == -1){
            status.setText("Denied");
            status.setStyle("-fx-text-fill: red");
        }else if (reservation.getStatus() == -2){
            status.setText("Canceled");
            status.setStyle("-fx-text-fill: red");
        }else{
            if (reservation.getStatus() == 1){
                status.setText("Approved");
            }
            if (reservation.getStatus() == 2){
                status.setText("Ended");
            }
            HBox line2 = new HBox();
            String timeleft = reservation.getTimeLeft();
            Label lbl2 = new Label("Ends in ");
            if (timeleft.contains("ago")) lbl2 = new Label("Ended ");
            lbl2.setStyle("-fx-text-fill: black");
            lbl2.setFont(Font.font("Arial", FontWeight.BOLD,11));
            Label timeLeft = new Label(timeleft);
            timeLeft.setStyle("-fx-text-fill: black");
            if(reservation.getPercentageOfTimeLeft()<10){
                timeLeft.setStyle("-fx-text-fill: red");
            } else if (reservation.getPercentageOfTimeLeft()<20) {
                timeLeft.setStyle("-fx-text-fill: orange");
            }
            timeLeft.setFont(new Font("Arial",11));
            line2.getChildren().addAll(lbl2,timeLeft);
            cardBox.getChildren().add(line2);
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
