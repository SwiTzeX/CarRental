package com.carrental;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private LineChart<?, ?> lineChart;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        iniLineChart();
    }


    public void iniLineChart(){
        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data("January",210));
        series.getData().add(new XYChart.Data("February",183));
        series.getData().add(new XYChart.Data("March",322));
        series.getData().add(new XYChart.Data("April",288));
        series.getData().add(new XYChart.Data("May",312));
        lineChart.getData().addAll(series);
        lineChart.lookup(".chart-plot-background").setStyle("-fx-background-color:transparent");
        series.getNode().setStyle("-fx-stroke:#6279FF");
    }
}
