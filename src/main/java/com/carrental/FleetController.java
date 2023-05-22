package com.carrental;

import com.carrental.models.Vehicle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class FleetController implements Initializable {
    @FXML
    private ComboBox<?> brandsDropList;

    @FXML
    private Button clearFilterButton;

    @FXML
    private Button clearFilterButton1;

    @FXML
    private ComboBox<?> colorsDropList;

    @FXML
    private ComboBox<?> fuelDropList;

    @FXML
    private ComboBox<?> gearDropList;

    @FXML
    private TableView<Vehicle> tableid;

    @FXML
    private TableColumn<?, ?> Actions;

    @FXML
    private TableColumn<Vehicle, ?> Brand;

    @FXML
    private TableColumn<Vehicle, String> ModelN;

    @FXML
    private TableColumn<Vehicle, Integer> NumberRes;

    @FXML
    private TableColumn<Vehicle, String> PlateNum;

    @FXML
    private TableColumn<Vehicle, Boolean> Status;


    @FXML
    private ComboBox<?> typeDropList;

    @FXML
    private VBox vehicleCardsBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Brand.setCellValueFactory(new PropertyValueFactory<>("brandName"));
        ModelN.setCellValueFactory(new PropertyValueFactory<>("modelName"));
        NumberRes.setCellValueFactory(new PropertyValueFactory<>(""));
        PlateNum.setCellValueFactory(new PropertyValueFactory<>(""));
        Status.setCellValueFactory(new PropertyValueFactory<>("disponibility"));
        //tableid.setItems();
      loadData();
    }

    private void loadData() {
       Vehicle v1 = new Vehicle();
       v1.setBrandName(v1.brandName);
       v1.setModelName(v1.modelName);
       v1.setDisponibility(v1.disponibility);
       tableid.getItems().add(v1);

    }


}
