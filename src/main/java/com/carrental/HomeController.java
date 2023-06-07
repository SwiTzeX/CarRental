package com.carrental;

import com.carrental.customnodes.MyTextField;
import com.carrental.models.Reservation;
import com.carrental.models.User;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import com.carrental.models.Vehicle;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;



public class HomeController implements Initializable {
    @FXML
    public ComboBox<String> typeDropList;
    @FXML
    public HBox paginationBox;
    public Button searchBtn;
    public HBox filtersBox;
    public ImageView locIcon;
    public MyTextField pickupDateTF;
    public MyTextField pickupTimeTF;
    public MyTextField returnDateTF;
    public MyTextField returnTimeTF;
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

    @FXML
    private VBox mainBox;

    public ArrayList<Vehicle> vehicles =  new ArrayList<Vehicle>();
    public List<List<Vehicle>> vehiclesHolder = new ArrayList<>();
    int maxPages;
    public ArrayList<String> filterSettings = new ArrayList<String>(Arrays.asList(null,null,null,null,null,null,null));
    public Date pickDate = null;
    public Date returnDate = null;
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
        paginationBox.getChildren().clear();
        paginationBox.getChildren().add(previousPageButton);
        int startPage = Math.max(1, pageNumber - 2);
        int endPage = Math.min(startPage + 4 - 1, maxPages);
        if (startPage > 1) {

            Label numberLbl = new Label("1");
            numberLbl.setFont(pageNumberLabel.getFont());
            numberLbl.setOnMouseEntered(event -> numberLbl.setUnderline(true));
            numberLbl.setOnMouseExited(event -> numberLbl.setUnderline(false));
            numberLbl.setOnMouseClicked(event -> loadCardsByPage(Integer.parseInt(numberLbl.getText())));
            Label separatorLabel = new Label("...");
            paginationBox.getChildren().addAll(numberLbl,separatorLabel);
        }

        for (int i = startPage; i <= endPage; i++) {
            Label numberLbl = new Label(String.valueOf(i));
            numberLbl.setFont(pageNumberLabel.getFont());
            if(i==pageNumber){
                numberLbl.setStyle("-fx-text-fill: #6279ff");
            }
            numberLbl.setOnMouseEntered(event -> numberLbl.setUnderline(true));
            numberLbl.setOnMouseExited(event -> numberLbl.setUnderline(false));
            numberLbl.setOnMouseClicked(event -> loadCardsByPage(Integer.parseInt(numberLbl.getText())));
            paginationBox.getChildren().add(numberLbl);
        }

        if (endPage < maxPages) {
            Label numberLbl = new Label(String.valueOf(maxPages));
            numberLbl.setFont(pageNumberLabel.getFont());
            numberLbl.setOnMouseEntered(event -> numberLbl.setUnderline(true));
            numberLbl.setOnMouseExited(event -> numberLbl.setUnderline(false));
            numberLbl.setOnMouseClicked(event -> loadCardsByPage(Integer.parseInt(numberLbl.getText())));
            Label separatorLabel = new Label("...");
            paginationBox.getChildren().addAll(separatorLabel,numberLbl);
        }
        paginationBox.getChildren().add(nextPageButton);
        cardLayout.getChildren().clear();
        nextPageButton.setVisible(false);
        previousPageButton.setVisible(false);
        pageNumberLabel.setText(String.valueOf(pageNumber));
        if (maxPages > pageNumber){
            nextPageButton.setVisible(true);
        }
        if (pageNumber > 1){
            previousPageButton.setVisible(true);
        }
        if(vehicles.size()> 0) {
            totalVeh.setText(vehicles.size() + " Vehicles found");
            pageNumber--;
            try {
                for (int i = 0; i < vehiclesHolder.get(pageNumber).size(); i++) { // vehiclesHolder.get(0) = first 4 items in vehicles // first page
                    Vehicle vehicle = vehiclesHolder.get(pageNumber).get(i);
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("vehicle-card-view.fxml"));
                    VBox vehicleCard = fxmlLoader.load();
                    VehicleCardController vehicleCardController = fxmlLoader.getController();
                    vehicleCardController.setData(vehicle,pickDate,returnDate);
                    cardLayout.getChildren().add(vehicleCard);
                    vehicleCardController.loadIn();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            totalVeh.setText("0 Vehicle found");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        locIcon.setImage(new Image(getClass().getResourceAsStream("icons/loc.png"),64,64,true,true));
       /* Date test1 = new Date(2023-1900, Calendar.MAY,16);
        Reservation res = Reservation.create(new User(1,"hh@","948",true,32,"nn","hh",false),
                new Vehicle(1,"hh","hh","hh",true,false,9384,"hh",4,"hh","hh",543,234,234,234),
                test1, test1,true);
        User user = User.create("sssdgds@ssss",null,false,null,null,null,false);
        previousPageButton.setVisible(false);
        nextPageButton.setVisible(false);
        Platform.runLater(() -> cardLayout.requestFocus());
        //vehicles.add(new Vehicle(2, "Ferrari", "F430", "red", true, true, 200, "Family", 4, "Petrol", "Manual", 5, 1000, 140, 120));
        //*/
        //Vehicle.create( "Volkswagen", "Golf", "white", true, true, 200, "SUV", 5, "Petrol", "Automated", 300000, 1000, 190, 240);

        vehicles = Vehicle.getAllVehicles();
        for(int i=0; i<20; i++) {
            vehicles.add(new Vehicle(2, "Volkswagen", "Touareg", "brown", true, true, 200, "Family", 4, "Petrol", "Manual", 5, 1000, 140, 120,"sASDSA"));
        }
        /*for(int i=0; i<2; i++) {
            vehicles.add(new Vehicle(2, "Ferrari", "F430", "red", true, true, 200, "SUV", 4, "Petrol", "Manual", 300000, 1000, 210, 350));
        }*/
        vehiclesHolder = HomeController.split(vehicles,4);
        maxPages = vehiclesHolder.size();
        this.loadCardsByPage(1);
        refreshComboBoxes();

        //
        //DatePicker datePicker = new DatePicker();
        //datePicker.setVisible(false);
        //searchBox.getChildren().add(datePicker);
        pickupDateTF.myFocusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue){
               //datePicker.show();
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy") ;
                try{
                    Date date = format.parse(pickupDateTF.getText());
                    pickupDateTF.hideError();
                } catch (ParseException e) {
                    pickupDateTF.showError("(Valid date: 10-12-2023)");
                }
            }
        });
        returnDateTF.myFocusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue){
                //datePicker.show();
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy") ;
                try{
                    Date date = format.parse(returnDateTF.getText());
                    returnDateTF.hideError();
                } catch (ParseException e) {
                    returnDateTF.showError("(Valid date: 10-12-2023)");
                }
            }
        });
    }


    public void refreshComboBoxes(){
        filtersBox.getChildren().clear();
        brandsDropList = new ComboBox<>();
        brandsDropList.getStyleClass().add("menu");
        brandsDropList.getStylesheets().add(getClass().getResource("style/menu.css").toExternalForm());
        brandsDropList.setPromptText("Brands");
        brandsDropList.setPrefWidth(99);
        brandsDropList.setOnAction(event -> {
                    filterVehicles(event);
                }
                );

        gearDropList = new ComboBox<>();
        gearDropList.getStyleClass().add("menu");
        gearDropList.getStylesheets().add(getClass().getResource("style/menu.css").toExternalForm());
        gearDropList.setPromptText("Gear Type");
        gearDropList.setPrefWidth(116);
        gearDropList.setOnAction(event -> {
                    filterVehicles(event);
                }
        );

        fuelDropList = new ComboBox<>();
        fuelDropList.getStyleClass().add("menu");
        fuelDropList.getStylesheets().add(getClass().getResource("style/menu.css").toExternalForm());
        fuelDropList.setPromptText("Fuel Type");
        fuelDropList.setPrefWidth(113);
        fuelDropList.setOnAction(event -> {
                    filterVehicles(event);
                }
        );

        colorsDropList = new ComboBox<>();
        colorsDropList.getStyleClass().add("menu");
        colorsDropList.getStylesheets().add(getClass().getResource("style/menu.css").toExternalForm());
        colorsDropList.setPromptText("Colors");
        colorsDropList.setPrefWidth(97);
        colorsDropList.setOnAction(event -> {
                    filterVehicles(event);
                }
        );

        typeDropList = new ComboBox<>();
        typeDropList.getStyleClass().add("menu");
        typeDropList.getStylesheets().add(getClass().getResource("style/menu.css").toExternalForm());
        typeDropList.setPromptText("Class");
        typeDropList.setPrefWidth(89);
        typeDropList.setOnAction(event -> {
                    filterVehicles(event);
                }
        );

        for(String brand:Vehicle.getAllBrandsFromAvailableVehicles(vehicles)) {
            brandsDropList.getItems().add(brand);
        }
        gearDropList.getItems().addAll("Manual","Automated");
        fuelDropList.getItems().addAll("Diesel","Petrol","Electric");
        colorsDropList.getItems().addAll("Red","Brown","Blue","Yellow","Green","White");
        typeDropList.getItems().addAll("Sedan","Wagon","SUV","Hatchback","Coupe","Sport","Pickup","Micro");
        filtersBox.getChildren().addAll(gearDropList,brandsDropList,fuelDropList,colorsDropList,typeDropList,clearFilterButton);
    }
    @FXML
    public void filterVehicles(javafx.event.ActionEvent event) {
        if(!pickupDateTF.isError() && pickupDateTF.getText().length()>0) {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            try {
                pickDate = format.parse(pickupDateTF.getText());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        if(!returnDateTF.isError() && returnDateTF.getText().length()>0) {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            try {
                returnDate = format.parse(returnDateTF.getText());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            ComboBox<String> dropList = (ComboBox<String>) event.getSource();
            Text theText = new Text(dropList.getValue());
            double width = (int) theText.getBoundsInLocal().getWidth() + 63;
            dropList.setPrefWidth(width);
            if (dropList == gearDropList) filterSettings.set(0, dropList.getValue());
            else if (dropList == fuelDropList) filterSettings.set(1, dropList.getValue());
            else if (dropList == brandsDropList) filterSettings.set(2, dropList.getValue());
            else if (dropList == colorsDropList) filterSettings.set(3, dropList.getValue());
            else if (dropList == typeDropList) filterSettings.set(4, dropList.getValue());
        } catch (Exception e) {
            ;
        }
        vehicles = Vehicle.filterVehicles(filterSettings,pickDate,returnDate);
        vehiclesHolder = HomeController.split(vehicles,4);
        maxPages = vehiclesHolder.size();
        this.loadCardsByPage(1);
    }

    @FXML
    public void clearAllFilters(javafx.event.ActionEvent event) {
        filterSettings = new ArrayList<String>(Arrays.asList(null,null,null,null,null,null,null));
        vehicles = Vehicle.getAllVehicles();
        vehiclesHolder = HomeController.split(vehicles,4);
        maxPages = vehiclesHolder.size();
        this.loadCardsByPage(1);
        gearDropList.getSelectionModel().clearSelection();
        gearDropList.setValue(null);
        //gearDropList.setPromptText("Gear Type");
        refreshComboBoxes();
        pickDate = null;
        returnDate = null;
        pickupDateTF.setText("");
        pickupDateTF.hideError();
        returnDateTF.setText("");
        returnDateTF.hideError();
    }
    @FXML
    public void nextPageDisplay(){
        int pageNumber = Integer.parseInt(pageNumberLabel.getText());
        pageNumber++;
        this.loadCardsByPage(pageNumber);
    }
    @FXML
    public void previousPageDisplay(){
        int pageNumber = Integer.parseInt(pageNumberLabel.getText());
        pageNumber--;
        this.loadCardsByPage(pageNumber);
    }
}
