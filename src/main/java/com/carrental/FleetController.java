package com.carrental;

import com.carrental.models.Vehicle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class FleetController implements Initializable {
    @FXML
    private ComboBox<String> brandDropList;

    @FXML
    private ComboBox<String> modelDropList;

    @FXML
    private ComboBox<String> statusDropList;

    @FXML
    private Button clearFilterButton;

    @FXML
    private Button clearFilterButton1;

    @FXML
    private TableView<Vehicle> tableid;

    @FXML
    private TableColumn<?, ?> Actions;

    @FXML
    private TableColumn<Vehicle, String> Brand;

    @FXML
    private TableColumn<Vehicle, String> ModelN;

    @FXML
    private TableColumn<Vehicle, Integer> NumberRes;

    @FXML
    private TableColumn<Vehicle, String> PlateNum;

    @FXML
    private TableColumn<Vehicle, String> Status;

    @FXML
    private VBox vehicleCardsBox;

    @FXML
    private ObservableList<Vehicle> vehiculeList = FXCollections.observableArrayList();

    public ArrayList<Vehicle> vehicles =  new ArrayList<Vehicle>();

    public ArrayList<String> filterSettings = new ArrayList<String>(Arrays.asList(null,null,null,null,null,null,null));




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Vehicle> vehicles = Vehicle.getAllVehicles();
        vehiculeList.addAll(vehicles);
        Brand.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("brandName"));
        ModelN.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("modelName"));
       // NumberRes.setCellValueFactory(new PropertyValueFactory<Vehicle, Integer>("email"));
        PlateNum.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("plate number"));
        Status.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("Disponibility"));

        // columnisadmine.setCellValueFactory(new PropertyValueFactory<User, boolean>("isAdmin"));

        tableid.setVisible(true);
        tableid.setItems(vehiculeList);



        //statusDropList.getItems().addAll("true","false");
        for(String brand:Vehicle.getAllBrandsFromAvailableVehicles(vehicles)) {
            brandDropList.getItems().add(brand);
        }

        /**for(String model:Vehicle.getAllModelsFromAvailableVehicles(vehicles)) {
            modelDropList.getItems().add(model);
        }
        statusDropList.getItems().addAll("Disponible","indisponible");**/



    }

    public void filterVehicles(javafx.event.ActionEvent event) {
        ComboBox<String> dropList = (ComboBox<String>) event.getSource();
        Text theText = new Text(dropList.getValue());
        double width = (int)theText.getBoundsInLocal().getWidth()+63;
        dropList.setPrefWidth(width);
        if (dropList == brandDropList) filterSettings.set(0, dropList.getValue());
        else if (dropList == modelDropList) filterSettings.set(1, dropList.getValue());
        else if (dropList == statusDropList) filterSettings.set(2, dropList.getValue());

        vehicles = Vehicle.filterVehicles(filterSettings);
    }

    public void clearAllFilter(javafx.event.ActionEvent event) {
        filterSettings = new ArrayList<String>(Arrays.asList(null,null,null,null,null,null,null,null));
        vehicles = Vehicle.getAllVehicles();

    }

   /* public void refreshtable(){
        tableid.c*/
    }

