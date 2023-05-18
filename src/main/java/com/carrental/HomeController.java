package com.carrental;

import com.carrental.customnodes.MyTextField;
import com.carrental.models.Reservation;
import com.carrental.models.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import com.carrental.models.Vehicle;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;



public class HomeController implements Initializable {
    @FXML
    public ComboBox<String> typeDropList;
    @FXML
    private ComboBox<String> brandsDropList;

    @FXML
    private HBox cardLayout;

    @FXML
    private Button clearFilterButton;

    @FXML
    private ComboBox<String> colorsDropList;

    @FXML
    private ComboBox<String> fuelDropList;

    @FXML
    private ComboBox<String> gearDropList;

    @FXML
    private Button nextPageButton;

    @FXML
    private Label pageNumberLabel;

    @FXML
    private Button previousPageButton;

    @FXML
    private HBox searchBox;

    @FXML
    private Label totalVeh;

    @FXML
    private VBox vehicleCardsBox;

    public ArrayList<Vehicle> vehicles =  new ArrayList<Vehicle>();
    public List<List<Vehicle>> vehiclesHolder = new ArrayList<>();
    int maxPages;
    public ArrayList<String> filterSettings = new ArrayList<String>(Arrays.asList(null,null,null,null,null));

    public static <T> List<List<T>> split(Collection<T> data, int size)
    {
        List<List<T>> lists=new ArrayList<>((data.size()+size-1)/size);
        List<T> list=new ArrayList<>(size);
        for(T t:data)
        {
            list.add(t);
            if(list.size()==size)
            {
                lists.add(list);
                list=new ArrayList<>(size);
            }
        }
        if(list.size()>0) lists.add(list);
        return lists;
    }

    public void loadCardsByPage(int pageNumber){
        cardLayout.getChildren().clear();
        pageNumber--;
        try {
            for (int i = 0; i < vehiclesHolder.get(pageNumber).size(); i++) { // vehiclesHolder.get(0) = first 4 items in vehicles // first page
                Vehicle vehicle = vehiclesHolder.get(pageNumber).get(i);
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("vehicle-card-view.fxml"));
                VBox vehicleCard = fxmlLoader.load();
                VehicleCardController vehicleCardController = fxmlLoader.getController();
                vehicleCardController.setData(vehicle);
                cardLayout.getChildren().add(vehicleCard);
                vehicleCardController.loadIn();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       /* Date test1 = new Date(2023-1900, Calendar.MAY,16);
        Reservation res = Reservation.create(new User(1,"hh@","948",true,32,"nn","hh",false),
                new Vehicle(1,"hh","hh","hh",true,false,9384,"hh",4,"hh","hh",543,234,234,234),
                test1, test1,true);
        User user = User.create("sssdgds@ssss",null,false,null,null,null,false);
        System.out.println(user);*/
        MyTextField test = new MyTextField("test");
        searchBox.getChildren().add(test);
        previousPageButton.setVisible(false);
        nextPageButton.setVisible(false);
        vehicles = Vehicle.getAllVehicles();
        for(int i=0; i<5; i++) {
            vehicles.add(new Vehicle(2, "Volkswagen", "Touareg", "red", true, true, 200, "Family", 4, "Petrol", "Manual", 5, 1000, 140, 120));
        }
        vehicles.add(new Vehicle(2, "Test", "Touareg", "red", true, true, 200, "Family", 4, "Petrol", "Manual", 5, 1000, 140, 120));
        if(vehicles.size()> 1) {
            totalVeh.setText(String.valueOf(vehicles.size()) + " Vehicles found");
        }else{
            totalVeh.setText(String.valueOf(vehicles.size()) + " Vehicle found");
        }
        vehiclesHolder = HomeController.split(vehicles,4);
        maxPages = vehiclesHolder.size();
        if (maxPages > 1){
            nextPageButton.setVisible(true);
        }
        this.loadCardsByPage(1);
        for(String brand:Vehicle.getAllBrandsFromAvailableVehicles(vehicles)) {
            System.out.println(brandsDropList.getItems());
            brandsDropList.getItems().add(brand);
        }
    }
    @FXML
    public void filterVehicles(javafx.event.ActionEvent event) {
        Text theText = new Text(brandsDropList.getValue());
        double width = (int)theText.getBoundsInLocal().getWidth()+63;
        brandsDropList.setPrefWidth(width);
        filterSettings.set(2, brandsDropList.getValue());
        vehiclesHolder = HomeController.split(Vehicle.filterVehicles(filterSettings),4);
        loadCardsByPage(1);
    }
    @FXML
    public void nextPageDisplay(){
        int pageNumber = Integer.parseInt(pageNumberLabel.getText());
        pageNumber++;
        this.loadCardsByPage(pageNumber);
        pageNumberLabel.setText(String.valueOf(pageNumber));
        if(!previousPageButton.isVisible()) {
            previousPageButton.setVisible(true);
        }
        if(pageNumber == maxPages){
            nextPageButton.setVisible(false);
        }
    }
    @FXML
    public void previousPageDisplay(){
        int pageNumber = Integer.parseInt(pageNumberLabel.getText());
        pageNumber--;
        this.loadCardsByPage(pageNumber);
        pageNumberLabel.setText(String.valueOf(pageNumber));
        if (pageNumber == 1) {
            previousPageButton.setVisible(false);
        }
        if(pageNumber < maxPages){
            nextPageButton.setVisible(true);
        }
    }
    @FXML
    void goToLogin(javafx.event.ActionEvent event) {

        try {
            // Load the FXML file for the second view
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view.fxml"));
            Parent login = loader.load();

            // Create a new stage and set the second view as the root
            Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(login));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void goToRegister(javafx.event.ActionEvent event) {

        try {
            // Load the FXML file for the second view
            FXMLLoader loader = new FXMLLoader(getClass().getResource("register-view.fxml"));
            Parent register = loader.load();

            // Create a new stage and set the second view as the root
            Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(register));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
