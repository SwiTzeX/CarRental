package com.carrental;

import com.carrental.customnodes.MyTextField;
import com.carrental.models.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import com.carrental.models.Vehicle;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
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
        User u = new User(null,null,null,false,null,null,null,false);
        System.out.println(User.addToDatabase(u));
        System.out.println(User.deleteFromDatabase(User.getUserById(3)));

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
            brandsDropList.getItems().add(brand);
        }
    }
    @FXML
    public void filterVehicles(javafx.event.ActionEvent event) {
            Text theText = new Text(brandsDropList.getValue());
            double width = (int)theText.getBoundsInLocal().getWidth()+63;
            brandsDropList.setPrefWidth(width);
            /*RadioMenuItem item = new RadioMenuItem(brand);
            brandsDropList.getItems().add(item);
            item.setOnAction(event ->{
                        brandsDropList.setP(brand);
                        Text theText = new Text(brandsDropList.getText());
                        theText.setFont(brandsDropList.getFont());
                        double width = (int)theText.getBoundsInLocal().getWidth()+53;
                        brandsDropList.setPrefWidth(width);
                    }
                    );*/
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
}