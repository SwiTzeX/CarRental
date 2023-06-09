package com.carrental;

import com.carrental.models.Reservation;
import com.carrental.models.User;
import com.carrental.models.Vehicle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    Label countCust;
    @FXML
    Label countTotalSales;
    @FXML
    Label countCars;
    @FXML
    Label countRented;
    @FXML
    Button reportButton;
    @FXML
    Label revCur;
    @FXML
    Label revPrev;
    @FXML
    static VBox dashvbox;
    @FXML
    final NumberAxis xAxis = new NumberAxis();
    @FXML
    final NumberAxis yAxis = new NumberAxis();
    @FXML
    final CategoryAxis xAx = new CategoryAxis();
    @FXML
    final NumberAxis yAx = new NumberAxis();
    @FXML
    private LineChart<Number, Number> lineChart = new LineChart<>(xAxis,yAxis);
    @FXML
    private BarChart<String, Number> barChart=new BarChart<>(xAx,yAx);
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        iniLineChart();
        getCountCust();
        getCountCars();
        getCountTotalSales();
        getRented();
        iniBarChart();
    }
    @FXML
    static Stage csvpopupStage = new Stage();

    public void iniLineChart(){
        xAxis.setLabel("Month");
        yAxis.setLabel("Value");
        XYChart.Series<Number,Number> series = new XYChart.Series();
        series.getData().add(new XYChart.Data("January",Reservation.totalSaleInMonth(1)));
        series.getData().add(new XYChart.Data("February",Reservation.totalSaleInMonth(2)));
        series.getData().add(new XYChart.Data("March",Reservation.totalSaleInMonth(3)));
        series.getData().add(new XYChart.Data("April",Reservation.totalSaleInMonth(4)));
        series.getData().add(new XYChart.Data("May",Reservation.totalSaleInMonth(5)));
        series.getData().add(new XYChart.Data("June",Reservation.totalSaleInMonth(6)));
        series.getData().add(new XYChart.Data("July",Reservation.totalSaleInMonth(7)));
        series.getData().add(new XYChart.Data("August",Reservation.totalSaleInMonth(8)));
        series.getData().add(new XYChart.Data("September",Reservation.totalSaleInMonth(9)));
        series.getData().add(new XYChart.Data("October",Reservation.totalSaleInMonth(10)));
        series.getData().add(new XYChart.Data("November",Reservation.totalSaleInMonth(11)));
        series.getData().add(new XYChart.Data("December",Reservation.totalSaleInMonth(12)));
        lineChart.getData().addAll(series);
        lineChart.lookup(".chart-plot-background").setStyle("-fx-background-color:transparent");
        series.getNode().setStyle("-fx-stroke:#6279FF");
        for(XYChart.Data<Number,Number> data : series.getData()){
            data.setNode(null);
        }
    }

    public void iniBarChart(){
        xAx.setLabel("Brand");
        yAx.setLabel("Value");
        ArrayList<String> bl = new ArrayList<>();
        bl = Vehicle.getAllBrandsAvailable(Vehicle.getAllVehicles());
        XYChart.Series<String,Number> serie = new XYChart.Series();
        for(String b : bl){
            serie.getData().add(new XYChart.Data(b,Vehicle.getRevenueOfBrand(b)));
        }
        barChart.getData().add(serie);
        barChart.lookup(".chart-plot-background").setStyle("-fx-background-color:transparent");
        for(Node n:barChart.lookupAll(".default-color0.chart-bar")) {
            n.setStyle("-fx-bar-fill: #6279FF;");
        }
    }

    public void getCountCust() {
        int countC = User.getAllUsers().size();
        countCust.setText(String.valueOf(countC));
    }

    public void getCountCars() {
        int countCar = Vehicle.getAllVehicles().size();
        countCars.setText(String.valueOf(countCar));
    }

    public void getCountTotalSales() {
        float s=0;

        for(int i=1;i<=12;i++){
         s = s+Reservation.totalSaleInMonth(i);
        }
        countTotalSales.setText(String.valueOf(s));
    }
    public void getRented(){
        int countR = Reservation.getAllEndedReservations().size();
        countRented.setText(String.valueOf(countR));
    }
    public void getRevPrev(){
        //int revP;
        //revPrev.setText(String.valueOf(revP));
    }
    public void getRevCur(){
        //int revC
        //revCur.setText(String.valueOf(revC));
    }
    @FXML
    public void onClickReportButton(ActionEvent e){
        CsvExport exporter = new CsvExport();
        exporter.export();
        onClickCsvReport(e);
    }

    public static Stage getCsvpopupStage() {
        return csvpopupStage;
    }

    @FXML
    public void onClickCsvReport(ActionEvent e){
        try {
            //GaussianBlur blurEffect = new GaussianBlur(15);
            //dashvbox.setEffect(blurEffect);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CsvPopUp-view.fxml"));
            csvpopupStage.setScene(new Scene(loader.load()));
            csvpopupStage.setTitle("Csv Pop Up");
            csvpopupStage.initModality(Modality.APPLICATION_MODAL); // Set modality to block main window
            csvpopupStage.initStyle(StageStyle.UNDECORATED);
            csvpopupStage.show();
        }
        catch (IOException b) {
            b.printStackTrace();
        }
    }


}
