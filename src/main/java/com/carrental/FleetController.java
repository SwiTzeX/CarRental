package com.carrental;

import com.carrental.models.Vehicle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;


import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class FleetController implements Initializable {

    @FXML
    private TableColumn<Vehicle, Void> Actions;

    @FXML
    private TableColumn<Vehicle, String> Brand;

    @FXML
    private TableColumn<Vehicle, Integer> IdV;

    @FXML
    private TableColumn<Vehicle, String> Model;

    @FXML
    private TableColumn<Vehicle, Integer> NumberRes;

    @FXML
    private TableColumn<Vehicle, String> PlateNum;

    @FXML
    private TableColumn<Vehicle, Boolean> Status;

    @FXML
    private Button addvehiculebtn;

    @FXML
    private ComboBox<String> brandDropList;

    @FXML
    private Button clearfilterbtn;


    @FXML
    private TextField searchbar;

    @FXML
    private ComboBox<String> statusDropList;

    @FXML
    private TableView<Vehicle> tableid;

    @FXML
    private VBox vehicleCardsBox;

    @FXML
    private ObservableList<Vehicle> vehicleList = FXCollections.observableArrayList();
    public ArrayList<Vehicle> vehicles =  new ArrayList<Vehicle>();
    public ArrayList<String> filterSettings = new ArrayList<String>(Arrays.asList(null,null,null,null,null,null,null));
    public List<List<Vehicle>> vehiclesHolder = new ArrayList<>();


    String selectedBrandName;


    String selectedStatus;




    public void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    @Override
    public void initialize(URL url,ResourceBundle resourceBundle){
        searchbar.setOnAction(event -> {
            String searchKeyword = searchbar.getText();
            applySearchFilter(searchKeyword);
        });
        addvehiculebtn.setOnAction(event -> {
            Dialog<Vehicle> dialog = new Dialog<>();
            dialog.setTitle("Add Vehicule");
            dialog.setHeaderText(null);

            ButtonType buttonTypeOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(buttonTypeOk, ButtonType.CANCEL);

            GridPane grid = new GridPane();
            TextField brandnameField = new TextField();
            TextField modelnameField = new TextField();
            TextField colorField = new TextField();
            TextField disponibilityField = new TextField();
            TextField vehiculestateField = new TextField();
            TextField priceField = new TextField();
            TextField typeField = new TextField();
            TextField passengersField = new TextField();
            TextField fueltypeField = new TextField();
            TextField geartypeField = new TextField();
            TextField depositField = new TextField();
            TextField trunkcapacityField = new TextField();
            TextField maxspeedField = new TextField();
            TextField horsepowerField = new TextField();
            TextField plateField = new TextField();
            /**TextField numreservationsField = new TextField();
             TextField statusField = new TextField();**/


            grid.add(new Label("Brand Name:"), 0, 0);
            grid.add(brandnameField, 1, 0);

            grid.add(new Label("Model Name:"), 0, 1);
            grid.add(modelnameField, 1, 1);

            grid.add(new Label("Color:"), 0, 2);
            grid.add(colorField, 1, 2);

            grid.add(new Label("Availability:"), 0, 3);
            grid.add(disponibilityField, 1, 3);

            grid.add(new Label("Vehicle State:"), 0, 4);
            grid.add(vehiculestateField, 1, 4);

            grid.add(new Label("Price:"), 0, 5);
            grid.add(priceField, 1, 5);

            grid.add(new Label("Type:"), 0, 6);
            grid.add(typeField, 1, 6);

            grid.add(new Label("Passengers:"), 0, 7);
            grid.add(passengersField, 1, 7);

            grid.add(new Label("Fuel Type:"), 0, 8);
            grid.add(fueltypeField, 1, 8);

            grid.add(new Label("Gear Type:"), 0, 9);
            grid.add(geartypeField, 1, 9);

            grid.add(new Label("Deposit:"), 0, 10);
            grid.add(depositField, 1, 10);

            grid.add(new Label("Trunk Capacity:"), 0, 11);
            grid.add(trunkcapacityField, 1, 11);

            grid.add(new Label("Max Speed:"), 0, 12);
            grid.add(maxspeedField, 1, 12);

            grid.add(new Label("Horsepower:"), 0, 13);
            grid.add(horsepowerField, 1, 13);

            grid.add(new Label("License Plate:"), 0, 14);
            grid.add(plateField, 1, 14);


            dialog.getDialogPane().setContent(grid);

            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == buttonTypeOk) {
                    try {
                        String newBrandname = brandnameField.getText();
                        String newModelname = modelnameField.getText();
                        String newColor = colorField.getText();
                        boolean newDisponibility = Boolean.parseBoolean(disponibilityField.getText());
                        boolean newVehiculestate = Boolean.parseBoolean(vehiculestateField.getText());
                        float newPrice = Float.parseFloat(priceField.getText());
                        String newType = typeField.getText();
                        int newPassengers = Integer.parseInt(passengersField.getText());
                        String newFueltype = fueltypeField.getText();
                        String newGeartype = geartypeField.getText();
                        float newDeposit = Float.parseFloat(depositField.getText());
                        int newTrunkcapacity = Integer.parseInt(trunkcapacityField.getText());
                        int newMaxspeed = Integer.parseInt(maxspeedField.getText());
                        int newHorsepower = Integer.parseInt(horsepowerField.getText());
                        String newPlate = plateField.getText();


                        boolean platenumExists = vehicleList.stream().anyMatch(vehicle -> vehicle.getPlate().equals(newPlate));

                        if (platenumExists) {
                            showAlert("Error", "Cannot add vehicule. Plate number already exists.");
                        } else {
                            String dispoRegex = "^[01]$"; // Regular expression for 0 or 1
                            boolean isDispoValid = Pattern.matches(dispoRegex, Boolean.toString(newDisponibility));

                            String priceRegex = "^[0-9]+(\\.[0-9]+)?$"; // Regular expression for a float number
                            boolean isPriceValid = Pattern.matches(priceRegex, Float.toString(newPrice));

                            String passengersRegex = "^[0-9]+$"; // Regular expression for an integer number
                            boolean isPassengersValid = Pattern.matches(passengersRegex, Integer.toString(newPassengers));

                            String depositRegex = "^[0-9]+$"; // Regular expression for an integer number
                            boolean isDepositValid = Pattern.matches(depositRegex, Float.toString(newDeposit));

                            String trunkCapacityRegex = "^[0-9]+$"; // Regular expression for an integer number
                            boolean isTrunkCapacityValid = Pattern.matches(trunkCapacityRegex, Integer.toString(newTrunkcapacity));

                            String maxSpeedRegex = "^[0-9]+$"; // Regular expression for an integer number
                            boolean isMaxSpeedValid = Pattern.matches(maxSpeedRegex, Integer.toString(newMaxspeed));

                            String horsepowerRegex = "^[0-9]+$"; // Regular expression for an integer number
                            boolean isHorsepowerValid = Pattern.matches(horsepowerRegex, Integer.toString(newHorsepower));


                            if (!isDispoValid) {
                                // Display an error message if the dispo is not valid
                                showAlert("Error", "Invalid dispo value. Please enter either 0 or 1.");
                            } else if (!isPriceValid) {
                                // Display an error message if the price is not in a valid format
                                showAlert("Error", "Invalid price format. Please enter a valid numeric value.");
                            } else if (!isPassengersValid) {
                                // Display an error message if the passengers value is not in a valid format
                                showAlert("Error", "Invalid passengers format. Please enter a valid integer value.");
                            } else if (!isDepositValid) {
                                // Display an error message if the deposit value is not in a valid format
                                showAlert("Error", "Invalid deposit format. Please enter a valid integer value.");
                            } else if (!isTrunkCapacityValid) {
                                // Display an error message if the trunk capacity value is not in a valid format
                                showAlert("Error", "Invalid trunk capacity format. Please enter a valid integer value.");
                            } else if (!isMaxSpeedValid) {
                                // Display an error message if the max speed value is not in a valid format
                                showAlert("Error", "Invalid max speed format. Please enter a valid integer value.");
                            } else if (!isHorsepowerValid) {
                                // Display an error message if the horsepower value is not in a valid format
                                showAlert("Error", "Invalid horsepower format. Please enter a valid integer value.");
                            } else {
                                Vehicle newVehicule = Vehicle.create(newBrandname, newModelname, newColor, newDisponibility, newVehiculestate, newPrice, newType, newPassengers, newFueltype, newGeartype, newDeposit, newTrunkcapacity, newMaxspeed, newHorsepower, newPlate);

                                if (newVehicule != null) {
                                    vehicleList.add(newVehicule);
                                    tableid.setItems(vehicleList);
                                } else {
                                    showAlert("Error", "Failed to add vehicle");

                                }
                            }
                        }
                    } catch (NumberFormatException e) {
                        throw new RuntimeException(e);
                    }
                }
                return null;
            });

            dialog.showAndWait();
            tableid.refresh();
        });


        brandDropList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedBrandName = newValue;
            applyFilters(new ActionEvent());
        });


        statusDropList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedStatus = newValue;
            applyFilters(new ActionEvent());
        });


        for (String brand : Vehicle.getAllBrandsFromAvailableVehicles(vehicles)) {
            brandDropList.getItems().add(brand);
        }
        statusDropList.getItems().addAll("Available","Not Available");



        vehicles = Vehicle.getAllVehicles();
        vehicleList.addAll(vehicles);
        IdV.setCellValueFactory(new PropertyValueFactory<>("IdV"));
        Brand.setCellValueFactory(new PropertyValueFactory<>("BrandName"));
        Model.setCellValueFactory(new PropertyValueFactory<>("ModelName"));
        PlateNum.setCellValueFactory(new PropertyValueFactory<>("PlateNumber"));
        Status.setCellValueFactory(new PropertyValueFactory<>("Disponibility"));

        // columnisadmine.setCellValueFactory(new PropertyValueFactory<User, boolean>("isAdmin"));

        tableid.setVisible(true);
        tableid.setItems(vehicleList);


        //statusDropList.getItems().addAll("true","false");
        for (String brand : Vehicle.getAllBrandsFromAvailableVehicles(vehicles)) {
            brandDropList.getItems().add(brand);
        }

        /**for(String model:Vehicle.getAllModelsFromAvailableVehicles(vehicles)) {
         modelDropList.getItems().add(model);
         }
         statusDropList.getItems().addAll("Disponible","indisponible");**/


    }

        private void applyFilters(javafx.event.ActionEvent event) {
            ComboBox<String> dropList = (ComboBox<String>) event.getSource();
            Text theText = new Text(dropList.getValue());
            double width = (int)theText.getBoundsInLocal().getWidth()+63;
            dropList.setPrefWidth(width);
            if (dropList == statusDropList) filterSettings.set(0, dropList.getValue());
            else if (dropList == brandDropList) filterSettings.set(2, dropList.getValue());
            System.out.println(filterSettings);
            vehicles = Vehicle.filterVehicles(filterSettings,null,null);
        }


        @FXML
        private void clearallfilters(ActionEvent event) {
            brandDropList.getSelectionModel().clearSelection();
            statusDropList.getSelectionModel().clearSelection();
            tableid.setItems(vehicleList);

            // Réinitialiser les valeurs par défaut des JComboBox
            brandDropList.getSelectionModel().clearSelection();
            statusDropList.getSelectionModel().clearSelection();
        }

        private void applySearchFilter(String searchKeyword) {
            tableid.setItems(vehicleList.filtered(vehicle -> {
                if (searchKeyword.isEmpty()) {
                    return true;
                } else {
                    String lowerCaseSearchTerm = searchKeyword.toLowerCase();
                    String plate = vehicle.getPlate();
                    plate = plate != null ? plate : "";
                    return plate.contains(lowerCaseSearchTerm);
                }
            }));
        }
    }


