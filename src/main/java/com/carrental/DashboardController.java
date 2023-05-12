package com.carrental;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;


import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private PieChart piechart;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        iniPieChart();
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
}
