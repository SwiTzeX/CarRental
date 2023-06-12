package com.carrental;

import com.carrental.models.Vehicle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;

public class FleetController implements Initializable {

    public Label adminName;
    @FXML
    private TableColumn<Vehicle, Void> Actions;

    @FXML
    private TableColumn<Vehicle, String> Brand;

    @FXML
    private TableColumn<Vehicle, Integer> IdV;

    @FXML
    private TableColumn<Vehicle, String> Model;

    @FXML
    private TableColumn<Vehicle, Integer> Price;

    @FXML
    private TableColumn<Vehicle, String> PlateNum;

    @FXML
    private TableColumn<Vehicle, Boolean> Status;

    @FXML
    private Button addvehiclebtn;

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
        adminName.setText(App.getUser().getFullName());
        searchbar.setOnAction(event -> {
            String searchKeyword = searchbar.getText();
            applySearchFilter(searchKeyword);
        });
        addvehiclebtn.setOnAction(event -> {
            Dialog<Vehicle> dialog = new Dialog<>();
            dialog.setTitle("Add Vehicle");
            dialog.setHeaderText(null);

            ButtonType buttonTypeOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(buttonTypeOk, ButtonType.CANCEL);

            GridPane grid = new GridPane();
            TextField brandnameField = new TextField();
            TextField modelnameField = new TextField();
            TextField colorField = new TextField();
            //CheckBox disponibilityField = new CheckBox();
            ComboBox<String> disponibilityField = new ComboBox<String>();
            disponibilityField.setPrefWidth(200);
            disponibilityField.setValue("Available");
            ObservableList<String> availabilitylist = disponibilityField.getItems();
            availabilitylist.add("Available");
            availabilitylist.add("Not Available");

            TextField vehiculestateField = new TextField();
            TextField priceField = new TextField();
            ComboBox<String> typeField = new ComboBox<String>();
            typeField.setPrefWidth(200);
            typeField.setPromptText("Sedan");
            ObservableList<String> typelist = typeField.getItems();

            typeField.getItems().addAll("Sedan","Wagon","SUV","Hatchback","Coupe","Sport","Pickup","Micro");


            TextField passengersField = new TextField();

            ComboBox<String> fueltypeField = new ComboBox<String>();
            fueltypeField.setPrefWidth(200);
            fueltypeField.setPromptText("Diesel");
            ObservableList<String> fuellist = fueltypeField.getItems();
            fuellist.add("Diesel");
            fuellist.add("Petrol");
            fuellist.add("Electric");
            fuellist.add("Hybrid");

            ComboBox<String> geartypeField = new ComboBox<String>();
            geartypeField.setPrefWidth(200);
            geartypeField.setValue("Manual");
            ObservableList<String> gearlist = geartypeField.getItems();
            gearlist.add("Manual");
            gearlist.add("Automated");
            TextField depositField = new TextField();
            TextField trunkcapacityField = new TextField();
            TextField maxspeedField = new TextField();
            TextField horsepowerField = new TextField();
            TextField plateField = new TextField();

            grid.add(new Label("Brand Name:"), 0, 0);
            grid.add(brandnameField, 1, 0);

            grid.add(new Label("Model Name:"), 0, 1);
            grid.add(modelnameField, 1, 1);

            grid.add(new Label("Color:"), 0, 2);
            grid.add(colorField, 1, 2);

            grid.add(new Label("Availability:"), 0, 3);
            grid.add(disponibilityField, 1, 3);

            grid.add(new Label("Price:"), 0, 4);
            grid.add(priceField, 1, 4);

            grid.add(new Label("Type:"), 0, 5);
            grid.add(typeField, 1, 5);

            grid.add(new Label("Passengers:"), 0, 6);
            grid.add(passengersField, 1, 6);

            grid.add(new Label("Fuel Type:"), 0, 7);
            grid.add(fueltypeField, 1, 7);

            grid.add(new Label("Gear Type:"), 0, 8);
            grid.add(geartypeField, 1, 8);

            grid.add(new Label("Deposit:"), 0, 9);
            grid.add(depositField, 1, 9);

            grid.add(new Label("Trunk Capacity:"), 0, 10);
            grid.add(trunkcapacityField, 1, 10);

            grid.add(new Label("Max Speed:"), 0, 11);
            grid.add(maxspeedField, 1, 11);

            grid.add(new Label("Horsepower:"), 0, 12);
            grid.add(horsepowerField, 1, 12);

            grid.add(new Label("License Plate:"), 0, 13);
            grid.add(plateField, 1, 13);

            dialog.getDialogPane().setContent(grid);

            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == buttonTypeOk) {
                   Boolean test = true;
                    try {
                        String newBrandname = brandnameField.getText();
                        String newModelname = modelnameField.getText();
                        String newColor = colorField.getText();
                        //String newDisponibility = disponibilityField.getValue();
                        float newPrice = 0;
                        try {
                            newPrice = Float.parseFloat(priceField.getText());
                        }catch (Exception ignored){
                            showAlert("Error", "Invalid price format. Please enter a valid numeric value.");
                            dialog.showAndWait();
                        }
                        String newDisponibility = disponibilityField.getValue();
                        Boolean Disponibilty = null;
                        if(newDisponibility.equals("Not Available")){
                            Disponibilty = false;}
                        else if(newDisponibility.equals("Available")){
                            Disponibilty = true;
                        }

                        String newType = typeField.getValue();
                        int newPassengers = 0;
                        try {
                            newPassengers = Integer.parseInt(passengersField.getText());
                        }catch (Exception ignored){
                            showAlert("Error", "Invalid Passengers format. Please enter a valid numeric value.");
                            dialog.showAndWait();
                        }

                        String newFueltype = fueltypeField.getValue();
                        String newGeartype = geartypeField.getValue();
                        float newDeposit = 0;
                        try {
                            newDeposit = Float.parseFloat(depositField.getText());
                        }catch (Exception ignored){
                            showAlert("Error", "Invalid deposit format. Please enter a valid numeric value.");
                            dialog.showAndWait();
                        }
                        int newTrunkcapacity = 0;
                        try {
                            newTrunkcapacity = Integer.parseInt(trunkcapacityField.getText());
                        }catch (Exception ignored){
                            showAlert("Error", "Invalid Trunk Capacity format. Please enter a valid numeric value.");
                            dialog.showAndWait();

                        }
                        int newMaxspeed = 0;
                        try{
                            newMaxspeed = Integer.parseInt(maxspeedField.getText());
                        }catch (Exception ignored){
                            showAlert("Error", "Invalid Max Speed format. Please enter a valid numeric value.");
                            dialog.showAndWait();
                        }
                        int newHorsepower = 0;
                        try {
                            newHorsepower = Integer.parseInt(horsepowerField.getText());
                        }catch (Exception ignored){
                            showAlert("Error", "Invalid Horse Power format. Please enter a valid numeric value.");
                            dialog.showAndWait();
                        }
                        String newPlate = plateField.getText();

                        boolean platenumExists = vehicleList.stream().anyMatch(vehicle -> vehicle.getPlate().equals(newPlate));

                        if (platenumExists) {
                            showAlert("Error", "Cannot add vehicule. Plate number already exists.");
                            dialog.showAndWait();
                        } else {

                            String passengersRegex = "^[0-9]+$"; // Regular expression for an integer number
                            boolean isPassengersValid = Pattern.matches(passengersRegex, Integer.toString(newPassengers));

                            /*String depositRegex = "^[0-9]+(\\.[0-9]+)?$"; // Regular expression for an integer number
                            boolean isDepositValid = Pattern.matches(depositRegex, Float.toString(newDeposit));
                            */
                            String trunkCapacityRegex = "^[0-9]+$"; // Regular expression for an integer number
                            boolean isTrunkCapacityValid = Pattern.matches(trunkCapacityRegex, Integer.toString(newTrunkcapacity));

                            String maxSpeedRegex = "^[0-9]+$"; // Regular expression for an integer number
                            boolean isMaxSpeedValid = Pattern.matches(maxSpeedRegex, Integer.toString(newMaxspeed));

                            String horsepowerRegex = "^[0-9]+$"; // Regular expression for an integer number
                            boolean isHorsepowerValid = Pattern.matches(horsepowerRegex, Integer.toString(newHorsepower));

                            if (!isPassengersValid) {
                                // Display an error message if the passengers value is not in a valid format
                                showAlert("Error", "Invalid passengers format. Please enter a valid integer value.");
                                dialog.showAndWait();
                            }else if (!isTrunkCapacityValid) {
                                // Display an error message if the trunk capacity value is not in a valid format
                                showAlert("Error", "Invalid trunk capacity format. Please enter a valid integer value.");
                                dialog.showAndWait();
                            } else if (!isMaxSpeedValid) {
                                // Display an error message if the max speed value is not in a valid format
                                showAlert("Error", "Invalid max speed format. Please enter a valid integer value.");
                                dialog.showAndWait();
                            } else if (!isHorsepowerValid) {
                                // Display an error message if the horsepower value is not in a valid format
                                showAlert("Error", "Invalid horsepower format. Please enter a valid integer value.");
                                dialog.showAndWait();
                            } else {
                                Vehicle vehic = Vehicle.create(newBrandname, newModelname, newColor, Disponibilty, null, newPrice, newType, newPassengers, newFueltype, newGeartype, newDeposit, newTrunkcapacity, newMaxspeed, newHorsepower, newPlate);
                                if (vehic != null) {
                                    vehicleList.add(vehic);
                                    tableid.setItems(vehicleList);
                                } else {
                                    showAlert("Error", "Failed to add vehicle");
                                }
                            }
                        }

                    } catch(Exception e){
                        throw new RuntimeException(e);
                    }
                }
                return null;
            });
            ;
            dialog.showAndWait();
            tableid.refresh();

        });

        brandDropList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedBrandName = newValue;
            applyFilters();
        });

        statusDropList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedStatus = newValue;
            applyFilters();
        });

        for (String brand : Vehicle.getAllBrandsAvailable(vehicles)) {
            brandDropList.getItems().add(brand);
        }
        statusDropList.getItems().addAll("Available","Not Available");

        vehicles = Vehicle.getAllVehicles();

        vehicleList.addAll(vehicles);

        IdV.setCellValueFactory(new PropertyValueFactory<>("id"));
        Brand.setCellValueFactory(new PropertyValueFactory<>("brandName"));
        Model.setCellValueFactory(new PropertyValueFactory<>("modelName"));
        Price.setCellValueFactory(new PropertyValueFactory<>("price"));
        PlateNum.setCellValueFactory(new PropertyValueFactory<>("plate"));
        Status.setCellValueFactory(new PropertyValueFactory<>("disponibility"));
        Status.setCellFactory(param -> new TableCell<Vehicle, Boolean>() {
            private final Label status = new Label();

            @Override
            protected void updateItem(Boolean item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                    setTextFill(Color.BLACK);
                    setGraphic(null);
                } else {
                    if(item) {
                        status.setText("Available");
                        status.setTextFill(Color.GREEN);
                        setGraphic(status);
                    }else{
                        status.setText("Not Available");
                        status.setTextFill(Color.RED);
                        setGraphic(status);
                }
            }
        }});
        Actions.setCellFactory(param -> new TableCell<Vehicle, Void>() {
            private final Button modifyButton = new Button("Modify");
            private final Button deleteButton = new Button("Delete");

            {
                modifyButton.setOnAction(event -> {
                    Vehicle vehicle = getTableView().getItems().get(getIndex());
                    showEditDialog(vehicle);
                });
                modifyButton.setStyle("-fx-background-radius: 30; -fx-background-color: #6279FF; -fx-border-radius: 30;-fx-min-width: 75px;");
                modifyButton.setTextFill(javafx.scene.paint.Color.WHITE);

                deleteButton.setOnAction(event -> {
                    Vehicle vehicle = getTableView().getItems().get(getIndex());
                    // Prompt the vehicle for confirmation
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation");
                    alert.setHeaderText("delete this vehicle");
                    alert.setContentText("are you sure?");
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        tableid.getItems().remove(vehicle);
                        boolean delete = vehicle.delete();
                        if (delete) {
                            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                            successAlert.setTitle("delete");
                            successAlert.setHeaderText(null);
                            successAlert.setContentText("vehicle is no longer in the data base.");
                            successAlert.showAndWait();
                        } else {
                            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                            errorAlert.setTitle("Erreur delete");
                            errorAlert.setHeaderText(null);
                            errorAlert.setContentText("erreur delete");
                            errorAlert.showAndWait();
                        }
                    }
                });
                deleteButton.setStyle("-fx-background-radius: 30; -fx-background-color: #6279FF; -fx-border-radius: 30;-fx-min-width: 75px;");
                deleteButton.setTextFill(Color.WHITE);
            }
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    HBox buttonBox = new HBox(modifyButton, deleteButton);
                    buttonBox.setSpacing(20);
                    buttonBox.setAlignment(Pos.CENTER);
                    setGraphic(buttonBox);
                }
            }
        });
        tableid.setItems(vehicleList);


        //statusDropList.getItems().addAll("Available","Not");
        for (String brand : Vehicle.getAllBrandsAvailable(vehicles)) {
            brandDropList.getItems().add(brand);
        }
    }
    private void showEditDialog(Vehicle vehicle) {
        Dialog<Vehicle> dialog = new Dialog<>();
        dialog.setTitle("Modify the vehicle");
        dialog.setHeaderText(null);

        ButtonType buttonTypeOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(buttonTypeOk, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        TextField brandnameField = new TextField(vehicle.getBrandName());
        TextField modelnameField = new TextField(vehicle.getModelName());
        TextField priceField = new TextField(String.valueOf(vehicle.getPrice()));
        TextField plateField = new TextField(vehicle.getPlate());
        //CheckBox disponibilityField = new CheckBox();
        ComboBox<String> disponibilityField = new ComboBox<String>();
        Boolean dispo=vehicle.getDisponibility();
        if (dispo){
            disponibilityField.setValue("Available");
        } else if (!dispo) {
            disponibilityField.setValue("Not Available");
        }
        disponibilityField.setPrefWidth(200);
        //disponibilityField.setPromptText("Available");
        ObservableList<String> availabilitylist = disponibilityField.getItems();
        availabilitylist.add("Available");
        availabilitylist.add("Not Available");



        grid.add(new Label("Brand Name:"), 0, 0);
        grid.add(brandnameField, 1, 0);
        grid.add(new Label("Model Name:"), 0, 1);
        grid.add(modelnameField, 1, 1);
        grid.add(new Label("Availability:"), 0, 2);
        grid.add(disponibilityField, 1, 2);
        grid.add(new Label("Price:"), 0, 3);
        grid.add(priceField, 1, 3);
        grid.add(new Label("Plate:"), 0, 4);
        grid.add(plateField, 1, 4);


        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == buttonTypeOk) {

                String newbrandname = brandnameField.getText();
                String newmodelname = modelnameField.getText();
                //float newprice = Float.parseFloat(priceField.getText());
                String newplate = plateField.getText();
                String newDisponibility = disponibilityField.getValue();

                Boolean Disponibilty = null;
                if (newDisponibility.equals("Not Available")) {
                    Disponibilty = false;
                } else if (newDisponibility.equals("Available")) {
                    Disponibilty = true;
                }

                float newprice = 0;
                try {
                    newprice = Float.parseFloat(priceField.getText());
                }catch (Exception ignored){
                    showAlert("Error", "Invalid price format. Please enter a valid numeric value.");
                    dialog.showAndWait();
                }

                boolean platenumExists = vehicleList.stream().anyMatch(vehicle1 -> vehicle1.getPlate().equals(newplate));

                if (platenumExists) {
                    showAlert("Error", "Cannot add vehicule. Plate number already exists.");
                    //test =false;
                    dialog.showAndWait();

                    vehicle.setBrandName(newbrandname);
                    vehicle.setModelName(newmodelname);
                    vehicle.setPrice(newprice);
                    vehicle.setPlate(newplate);
                    vehicle.setDisponibility(Disponibilty);

                    return vehicle;
                }
            }

            return null;
        });

        Optional<Vehicle> result = dialog.showAndWait();
        result.ifPresent(updatedvehicle -> {
            int index = tableid.getItems().indexOf(updatedvehicle);
            if (index != -1) {
                vehicleList.set(index, updatedvehicle);
            }
        });
    }


    private void applyFilters() {
        tableid.setItems(vehicleList.filtered(vehicle -> {
            boolean statusFilter = selectedStatus == null || selectedStatus.isEmpty() ||
                    (selectedStatus.equals("Available") && vehicle.getDisponibility() ||
                            (selectedStatus.equals("Not Available") && !vehicle.getDisponibility()));

            boolean brandFilter = (selectedBrandName == null) || selectedBrandName.isEmpty() ||
                    (selectedBrandName.equals(vehicle.getBrandName()));


            return statusFilter && brandFilter;
        }));
    }

    @FXML
    private void clearallfilters(ActionEvent event) {
        brandDropList.getSelectionModel().clearSelection();
        statusDropList.getSelectionModel().clearSelection();
        tableid.setItems(vehicleList);

        tableid.refresh();

        //refreshfilter();
        brandDropList.setPromptText("Brand");
        statusDropList.setPromptText("status");

    }

    private void applySearchFilter(String searchKeyword) {
        tableid.setItems(vehicleList.filtered(vehicle -> {
            if (searchKeyword.isEmpty()) {
                return true;
            } else {
                String lowerCaseSearchTerm = searchKeyword.toLowerCase();
                String plate = vehicle.getPlate().toLowerCase();
                String brand = vehicle.getBrandName().toLowerCase();
                String model = vehicle.getModelName().toLowerCase();
                plate = plate != null ? plate : "";
                brand = brand != null ? brand : "";
                model = model != null ? model : "";

                return brand.contains(lowerCaseSearchTerm) ||
                        model.contains(lowerCaseSearchTerm) ||
                        plate.contains(lowerCaseSearchTerm) ;
            }
        }));
    }
}


