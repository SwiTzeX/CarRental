package com.carrental;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private PieChart piechart;
    @FXML
    private LineChart<?, ?> lineChart;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        iniPieChart();
        iniLineChart();
    }


    public void iniPieChart(){
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Kia", 25),
                new PieChart.Data("Peugeot", 32),
                new PieChart.Data("Citroen", 17),
                new PieChart.Data("Hyundai", 25),
                new PieChart.Data("Volkswagen", 38)
        );
                piechart.setData(pieChartData);
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
