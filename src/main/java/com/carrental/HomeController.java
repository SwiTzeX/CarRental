package com.carrental;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import com.carrental.models.Vehicle;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private HBox cardLayout;

    @FXML
    private Label totalVeh;
    public ArrayList<Vehicle> vehicles =  new ArrayList<Vehicle>();

    @FXML
    private Button nextPageButton;

    @FXML
    private Label pageNumberLabel;

    @FXML
    private Button previousPageButton;
    int maxPages;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        previousPageButton.setVisible(false);
        nextPageButton.setVisible(false);
        vehicles.add(new Vehicle("Volkswagen","Touareg","Family","Petrol","Manual",5,1000,140,120,220,"vehicles/volkswagen-touareg.png","brands/volkswagen.png"));
        vehicles.add(new Vehicle("Volkswagen","Touareg","Family","Petrol","Manual",5,1000,140,120,220,"vehicles/volkswagen-touareg.png","brands/volkswagen.png"));
        vehicles.add(new Vehicle("Volkswagen","Touareg","Family","Petrol","Manual",5,1000,140,120,220,"vehicles/volkswagen-touareg.png","brands/volkswagen.png"));
        vehicles.add(new Vehicle("Volkswagen","Touareg","Family","Petrol","Manual",5,1000,140,120,220,"vehicles/volkswagen-touareg.png","brands/volkswagen.png"));
        vehicles.add(new Vehicle("Volkswagen","Touareg","Family","Petrol","Manual",5,1000,140,120,220,"vehicles/volkswagen-touareg.png","brands/volkswagen.png"));
        vehicles.add(new Vehicle("Volkswagen","Touareg","Family","Petrol","Manual",5,1000,140,120,220,"vehicles/volkswagen-touareg.png","brands/volkswagen.png"));
        totalVeh.setText(String.valueOf(vehicles.size())+" Vehicle found");
        List<List<Vehicle>> test = HomeController.split(vehicles,4);
        System.out.println(test.get(1).get(1).getBrandName());
        maxPages = (int) vehicles.size()/4 +1;
        if (maxPages > 1){
            nextPageButton.setVisible(true);
        }
        try {
            for (int i = 0; i < vehicles.size(); i++) {
                Vehicle vehicle = vehicles.get(i);
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("vehicle-card-view.fxml"));
                VBox vehicleCard = fxmlLoader.load();
                VehicleCardController vehicleCardController = fxmlLoader.getController();
                vehicleCardController.setData(vehicle);
                cardLayout.getChildren().add(vehicleCard);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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