package com.carrental;

import com.carrental.models.Reservation;
import com.carrental.models.User;
import com.carrental.models.Vehicle;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
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
    private Label growthRent;
    @FXML
    private Label growthRev;
    @FXML
    private Label growthUser;
    @FXML
    ImageView arrowCars;
    @FXML
    ImageView arrowCust;
    @FXML
    ImageView arrowRent;
    @FXML
    ImageView arrowRev;
    @FXML
    private VBox dashvbox;
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
    private AreaChart<Number, Number> areaChart = new AreaChart<>(xAxis,yAxis);
    @FXML
    private BarChart<String, Number> barChart=new BarChart<>(xAx,yAx);
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //iniLineChart();
        iniAreaChart();
        iniBarChart();
        new Thread(() -> Platform.runLater(()->{
            getCountCust();
            getCountCars();
            getCountTotalSales();
            getRented();
            getRevCur();
            getRevPrev();
            growthRented();
            growthRevenue();
            //growthCars();
            growthUsers();
        })).start();

    }


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
    public void iniAreaChart(){
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
        areaChart.getData().addAll(series);
        areaChart.lookup(".chart-plot-background").setStyle("-fx-background-color:transparent");
        for(Node n:areaChart.lookupAll(".chart-series-area-fill")) {
            n.setStyle("-fx-fill: #d2d9ff; -fx-opacity: 0.8");
        }
        for (XYChart.Data<Number, Number> data : series.getData()) {
            data.setNode(null);
        }
        series.getNode().lookup(".chart-series-area-line").setStyle("-fx-stroke: #d2d9ff");

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
            n.setStyle("-fx-bar-fill: #d2d9ff; -fx-opacity: 0.8");
        }
        barChart.setCategoryGap(80);
        barChart.setBarGap(1);
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
        float s;
        s= Reservation.totalSales();
        countTotalSales.setText(String.valueOf(s));
    }
    public void getRented(){
        int countR = Reservation.getAllReservationsByStatus(2).size();
        countRented.setText(String.valueOf(countR));
    }
    private static int getPreviousYear() {
        Calendar prevYear = Calendar.getInstance();
        prevYear.add(Calendar.YEAR, -1);
        return prevYear.get(Calendar.YEAR);
    }
    public void getRevPrev(){
        float revP=Reservation.totalSaleInYear(getPreviousYear());
        revPrev.setText(String.valueOf(revP));
    }
    public void getRevCur(){
        float revC=Reservation.totalSaleInYear(Calendar.getInstance().get(Calendar.YEAR));
        revCur.setText(String.valueOf(revC));
    }
    public void growthRevenue(){
        float g = Reservation.getRevenueGrowth();
        if(g >= 0){
            Image image = new Image(getClass().getResourceAsStream("icons/dashboard-pack/up.png"),512,512,true,true);
            arrowRev.setImage(image);
            growthRev.setStyle("-fx-text-fill: #57BF72");
            growthRev.setText("+" + String.valueOf(g) + "%");
        }
        else {
            Image image = new Image(getClass().getResourceAsStream("icons/dashboard-pack/down.png"),512,512,true,true);
            arrowRev.setImage(image);
            growthRev.setStyle("-fx-text-fill: #D53131");
            growthRev.setText(String.valueOf(g) + "%");
        }
    }
    public void growthUsers(){
        float g = User.getGrowth();
        if(g >= 0){
            Image image = new Image(getClass().getResourceAsStream("icons/dashboard-pack/up.png"),512,512,true,true);
            arrowCust.setImage(image);
            growthUser.setStyle("-fx-text-fill: #57BF72");
            growthUser.setText("+" + String.valueOf(g) + "%");
        }
        else {
            Image image = new Image(getClass().getResourceAsStream("icons/dashboard-pack/down.png"),512,512,true,true);
            arrowCust.setImage(image);
            growthUser.setStyle("-fx-text-fill: #D53131");
            growthUser.setText(String.valueOf(g) + "%");
        }
    }
    public void growthRented(){
        float g = Reservation.getGrowth();
        if(g >= 0){
            Image image = new Image(getClass().getResourceAsStream("icons/dashboard-pack/up.png"),512,512,true,true);
            arrowRent.setImage(image);
            growthRent.setStyle("-fx-text-fill: #57BF72");
            growthRent.setText("+" + String.valueOf(g) + "%");
        }
        else {
            Image image = new Image(getClass().getResourceAsStream("icons/dashboard-pack/down.png"),512,512,true,true);
            arrowRent.setImage(image);
            growthRent.setStyle("-fx-text-fill: #D53131");
            growthRent.setText(String.valueOf(g) + "%");
        }
    }

    @FXML
    public void onClickReportButton(ActionEvent e){
        CsvExport exporter = new CsvExport();
        exporter.export();
        try {
            GaussianBlur blurEffect = new GaussianBlur(15);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CsvPopUp-view.fxml"));
            Stage csvpopupStage = new Stage();
            csvpopupStage.setScene(new Scene(loader.load()));
            CsvPopUpController csvPopUpController = loader.getController();
            HBox hbox=(HBox) dashvbox.getParent();
            csvPopUpController.setH(hbox);
            hbox.setEffect(blurEffect);
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
