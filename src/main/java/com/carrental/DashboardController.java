package com.carrental;

import com.carrental.models.User;
import com.carrental.models.Vehicle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.chart.NumberAxis;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    Label countCust;
    @FXML
    Label countTotalSales;
    @FXML
    Label countCars;
    @FXML
    Button reportButton;
    @FXML
    final NumberAxis xAxis = new NumberAxis();
    @FXML
    final NumberAxis yAxis = new NumberAxis();
    @FXML
    private LineChart<Number, Number> lineChart = new LineChart<>(xAxis,yAxis);
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        iniLineChart();
        getCountCust();
        getCountCars();
        //getCountTotalSales();
    }


    public void iniLineChart(){
        xAxis.setLabel("Month");
        yAxis.setLabel("Value");
        XYChart.Series<Number,Number> series = new XYChart.Series();
        series.getData().add(new XYChart.Data("January",210));
        series.getData().add(new XYChart.Data("February",183));
        series.getData().add(new XYChart.Data("March",322));
        series.getData().add(new XYChart.Data("April",288));
        series.getData().add(new XYChart.Data("May",312));
        lineChart.getData().addAll(series);
        lineChart.lookup(".chart-plot-background").setStyle("-fx-background-color:transparent");
        series.getNode().setStyle("-fx-stroke:#6279FF");
    }

    public void getCountCust() {
        int countC = User.getAllUsers().size();
        countCust.setText(String.valueOf(countC));
    }

    public void getCountCars() {
        int countCar = Vehicle.getAllVehicles().size();
        countCars.setText(String.valueOf(countCar));
    }

    /* public void getCountTotalSales() {

    } */
    public void reportButton(){

    }
}
