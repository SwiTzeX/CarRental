package com.carrental;

import com.carrental.models.Reservation;
import com.carrental.models.User;
import com.carrental.models.Vehicle;
import com.carrental.tables.DataReservation;
import com.carrental.tables.DataReservation;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;

import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.util.Duration;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;


public class ReservationController implements Initializable {

    @FXML
    private TableView<DataReservation> TableViewReservation;

    @FXML
    private Button addReservation;

    @FXML
    private TableColumn<DataReservation, String> col_brandName;

    @FXML
    private TableColumn<DataReservation, String> col_edit;

    @FXML
    private TableColumn<DataReservation, Date> col_endDate;

    @FXML
    private TableColumn<DataReservation, String> col_fullname;

    @FXML
    private TableColumn<DataReservation, String> col_modelName;

    @FXML
    private TableColumn<DataReservation, String> col_phoneNumber;

    @FXML
    private TableColumn<DataReservation, Float> col_price;

    @FXML
    private TableColumn<DataReservation, Date> col_startDate;

    @FXML
    private TableColumn<DataReservation, String> col_status;

    @FXML
    private TextField searchId;

    @FXML
    private CheckBox statusId0;

    @FXML
    private CheckBox statusId1;

    @FXML
    private CheckBox statusId2;

    @FXML
    private CheckBox statusId3;

    ObservableList<DataReservation> dataResList = FXCollections.observableArrayList();
    ArrayList<Reservation> resList ;
    public String searchKeyword;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        searchId.setOnAction(event -> {
            searchKeyword = searchId.getText();
            applySearchFilter(searchKeyword);
        });

        addReservation.setOnAction(event -> {
            showAddDialog();
        });

        resList = Reservation.getAllReservations();
        for(Reservation i:resList) {
            DataReservation res = new DataReservation(i.getUser().getId(),i.getVehicle().getId(),i.getUser().getFullName(), i.getUser().getPhoneNumber(), i.getVehicle().getBrandName(), i.getVehicle().getModelName(), i.getVehicle().getPrice(), i.getStartDate(), i.getEndDate(), String.valueOf(i.getStatus()));
            dataResList.add(res);
        }
        col_fullname.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        col_phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        col_brandName.setCellValueFactory(new PropertyValueFactory<>("brandName"));
        col_modelName.setCellValueFactory(new PropertyValueFactory<>("modelName"));
        col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        col_startDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        col_endDate.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
        col_edit.setCellFactory(param -> new TableCell<DataReservation, String>() {
            private final Button modifyButton = new Button("Modify");
            private final Button deleteButton = new Button("Delete");

            {
                modifyButton.setOnAction(event -> {
                    DataReservation dataReservation = getTableView().getItems().get(getIndex());
                    showEditDialog(dataReservation);
                });
                modifyButton.setStyle("-fx-background-radius: 30; -fx-background-color: #6279FF; -fx-border-radius: 30;");
                modifyButton.setTextFill(javafx.scene.paint.Color.WHITE);

                deleteButton.setOnAction(event -> {
                    DataReservation dataReservation = getTableView().getItems().get(getIndex());

                    Alert alertConfirm = new Alert(Alert.AlertType.CONFIRMATION);
                    alertConfirm.setTitle("Confirmation");
                    alertConfirm.setHeaderText("Are you sure?");
                    alertConfirm.setContentText("This action cannot be undone.");
                    DialogPane dialogPaneConfirm = alertConfirm.getDialogPane();
                    dialogPaneConfirm.getStylesheets().add(
                            getClass().getResource("style/stylesDelete.css").toExternalForm()
                    );
                    dialogPaneConfirm.getStyleClass().add("custom-alert");

                    Alert alertSure = new Alert(Alert.AlertType.INFORMATION);
                    alertSure.setTitle("Account Deleted");
                    alertSure.setHeaderText(null);
                    alertSure.setContentText("Your account has been deleted.");
                    // Apply custom CSS to the alert dialog
                    DialogPane dialogPane = alertSure.getDialogPane();
                    dialogPane.getStylesheets().add(
                            getClass().getResource("style/stylesDelete.css").toExternalForm()
                    );
                    dialogPane.getStyleClass().add("custom-alert");

                    // Set a custom graphic
                    ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("icons/delete.png")));
                    dialogPane.setGraphic(imageView);

                    alertConfirm.showAndWait().ifPresent(response -> {
                        if (response == ButtonType.OK) {
                            // User clicked "OK"
                            int i = dataResList.indexOf(dataReservation);
                            Reservation res = resList.get(i);
                            res.delete();
                            TableViewReservation.getItems().remove(dataReservation);
                            alertSure.showAndWait();
                        } else {
                            // User clicked "Cancel" or closed the confirmation alert
                            System.out.println("Action canceled!");
                        }
                    });


                });

                deleteButton.setStyle("-fx-background-radius: 30; -fx-background-color: #6279FF; -fx-border-radius: 30;");
                deleteButton.setTextFill(javafx.scene.paint.Color.WHITE);

            }
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    HBox buttonBox = new HBox(modifyButton, deleteButton);
                    buttonBox.setSpacing(15);
                    buttonBox.setAlignment(Pos.CENTER);
                    setGraphic(buttonBox);
                }
            }
        });
        TableViewReservation.setItems(dataResList);

        statusId0.setOnAction(event -> {
            updateTableView();
        });
        statusId1.setOnAction(event -> {
            updateTableView();
        });
        statusId2.setOnAction(event -> {
            updateTableView();
        });
        statusId3.setOnAction(event -> {
            updateTableView();
        });
    }
    private void showEditDialog(DataReservation dataRes) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        Dialog<DataReservation> dialog = new Dialog<>();
        dialog.setTitle("Modify the reservation");
        dialog.setHeaderText(null);

        ButtonType buttonTypeOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(buttonTypeOk, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        ComboBox<Integer> idUserField = new ComboBox<>();
        idUserField.setItems(FXCollections.observableList(User.getAllUsersId()));
        idUserField.getSelectionModel().select(User.getAllUsersId().indexOf(dataRes.getIdU()));
        ComboBox<Integer> idVehicleField = new ComboBox<>();
        idVehicleField.setItems(FXCollections.observableList(Vehicle.getAllVehicleId()));
        idUserField.getSelectionModel().select(Vehicle.getAllVehicleId().indexOf(dataRes.getIdV()));
        TextField startDateField = new TextField(format.format(dataRes.getStartDate()));
        TextField endDateField = new TextField(format.format(dataRes.getEndDate()));
        TextField statusField = new TextField(String.valueOf(dataRes.getStatus()));
        grid.add(new Label("Id User"), 0, 1);
        grid.add(idUserField, 1, 1);
        grid.add(new Label("Id Vehicle"), 0, 2);
        grid.add(idVehicleField, 1, 2);
        grid.add(new Label("Start Date"), 0, 3);
        grid.add(startDateField, 1, 3);
        grid.add(new Label("End Date"),0,4);
        grid.add(endDateField, 1, 4);
        grid.add(new Label("Status"),0,5);
        grid.add(statusField, 1, 5);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == buttonTypeOk) {
                Integer newIdUser = idUserField.getValue();
                Integer newIdVehicle = idVehicleField.getValue();
                String newFullName = User.getUserById(newIdUser).getFullName();
                String newPhoneNumber = User.getUserById(newIdUser).getPhoneNumber();
                String newBrandName = Vehicle.getVehiclesById(newIdVehicle).getBrandName();
                String newModelName = Vehicle.getVehiclesById(newIdVehicle).getModelName();
                Float newPrice = Vehicle.getVehiclesById(newIdVehicle).getPrice();
                String newStartDate = startDateField.getText();
                String newEndDate = endDateField.getText();
                String newStatus = statusField.getText();
                dataRes.setFullName(newFullName);
                dataRes.setPhoneNumber(newPhoneNumber);
                dataRes.setBrandName(newBrandName);
                dataRes.setModelName(newModelName);
                dataRes.setPrice(newPrice);
                int i = dataResList.indexOf(dataRes);
                Reservation res = resList.get(i);
                res.setUser(User.getUserById(newIdUser));
                res.setVehicle(Vehicle.getVehiclesById(newIdVehicle));
                try {
                res.setStartDate(format.parse(newStartDate));
                res.setEndDate(format.parse(newEndDate));
                res.setStatus(Integer.parseInt(newStatus));
                dataRes.setStartDate(format.parse(newStartDate));
                dataRes.setEndDate(format.parse(newEndDate));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                dataRes.setStatus(newStatus);
                return dataRes;
            }
            return null;
        });

        Optional<DataReservation> result = dialog.showAndWait();
        result.ifPresent(updatedRes -> {
            int index = TableViewReservation.getItems().indexOf(updatedRes);
            if (index != -1) {
                dataResList.set(index, updatedRes);
            }
        });
    }

    private void showAddDialog() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        Dialog<DataReservation> dialog = new Dialog<>();
        dialog.setTitle("Add a reservation");
        dialog.setHeaderText(null);

        ButtonType buttonTypeOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(buttonTypeOk, ButtonType.CANCEL);

        GridPane grid = new GridPane();

        ComboBox<Integer> idUserField = new ComboBox<>();
        ObservableList<Integer> idUList = FXCollections.observableArrayList();
        for(int idUser: User.getAllUsersId()){
            idUList.add(idUser);
        }
        idUserField.setItems(idUList);
        ComboBox<Integer> idVehicleField = new ComboBox<>();
        ObservableList<Integer> idVList = FXCollections.observableArrayList();
        for(int idVehicle: Vehicle.getAllVehicleId()){
                idVList.add(idVehicle);
        }
        idVehicleField.setItems(idVList);

        /*VBox vboxStartDate = new VBox(10);
        DatePicker startDateField = new DatePicker();

        VBox vboxEndDate = new VBox(10);
        DatePicker endDateField = new DatePicker();

        final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        long p = ChronoUnit.DAYS.between(startDateField.getValue(), item);
                        setTooltip(new Tooltip("You're about to stay for " + p + " days"));
                    }
                };
            }
        };

        endDateField.setDayCellFactory(dayCellFactory);
        startDateField.setValue(LocalDate.now());
        endDateField.setValue(startDateField.getValue().plusDays(1));
        vboxStartDate.getChildren().add(startDateField);
        vboxEndDate.getChildren().add(endDateField);*/
        TextField startDateField = new TextField();
        startDateField.setPromptText("yyyy-MM-dd HH:mm:ss");
        TextField endDateField = new TextField();
        endDateField.setPromptText("yyyy-MM-dd HH:mm:ss");
        TextField statusField = new TextField();
        grid.add(new Label("Id User"), 0, 1);
        grid.add(idUserField, 1, 1);
        grid.add(new Label("Id Vehicle"), 0, 2);
        grid.add(idVehicleField, 1, 2);
        grid.add(new Label("Start Date"), 0, 3);
        grid.add(startDateField, 1, 3);
        grid.add(new Label("End Date"),0,4);
        grid.add(endDateField, 1, 4);
        grid.add(new Label("Status"),0,5);
        grid.add(statusField, 1, 5);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == buttonTypeOk) {
                Integer newIdUser = idUserField.getValue();
                Integer newIdVehicle = idVehicleField.getValue();
                String newFullName = User.getUserById(newIdUser).getFullName();
                String newPhoneNumber = User.getUserById(newIdUser).getPhoneNumber();
                String newBrandName = Vehicle.getVehiclesById(newIdVehicle).getBrandName();
                String newModelName = Vehicle.getVehiclesById(newIdVehicle).getModelName();
                float newPrice = Vehicle.getVehiclesById(newIdVehicle).getPrice();
                String newStartDate = String.valueOf(startDateField.getText());
                String newEndDate = String.valueOf(endDateField.getText());
                String newStatus = statusField.getText();
                try {
                    Reservation.create(User.getUserById(newIdUser), Vehicle.getVehiclesById(newIdVehicle), format.parse(newStartDate), format.parse(newEndDate), Integer.parseInt(newStatus));
                    DataReservation data = new DataReservation(newFullName, newPhoneNumber, newBrandName, newModelName, newPrice, format.parse(newStartDate), format.parse(newEndDate), newStatus);
                    dataResList.add(data);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                TableViewReservation.setItems(dataResList);
            }
            return null;
        });

        Optional<DataReservation> result = dialog.showAndWait();
        result.ifPresent(updatedRes -> {
            int index = TableViewReservation.getItems().indexOf(updatedRes);
            if (index != -1) {
                dataResList.set(index, updatedRes);
            }
        });
    }

    private void applySearchFilter(String searchKeyword) {
        TableViewReservation.setItems(dataResList.filtered(resData -> {
            if (searchKeyword.isEmpty()) {
                return true;
            } else {
                String lowerCaseSearchTerm = searchKeyword.toLowerCase();
                return resData.getFullName().contains(lowerCaseSearchTerm) ||
                        resData.getBrandName().contains(lowerCaseSearchTerm) ||
                        resData.getModelName().contains(lowerCaseSearchTerm) ||
                        resData.getPhoneNumber().contains(lowerCaseSearchTerm);

            }
        }));
    }

    private void updateTableView() {
        TableViewReservation.setItems(dataResList.filtered(reservation -> {
            boolean statusFilter = statusId0.isSelected() && reservation.getStatus().equals("0") ||
                    (statusId1.isSelected() && reservation.getStatus().equals("1")) ||
                    (statusId2.isSelected() && reservation.getStatus().equals("2")) ||
                    (statusId3.isSelected() && reservation.getStatus().equals("3"));
            return statusFilter;
        }));
        if(!statusId0.isSelected() && !statusId1.isSelected() &&!statusId2.isSelected() &&!statusId3.isSelected()){
            clearFilter();
        }
    }

    private void clearFilter(){
        dataResList.clear();
        resList = Reservation.getAllReservations();
        for(Reservation i:resList) {
            DataReservation res = new DataReservation(i.getUser().getId(),i.getVehicle().getId(),i.getUser().getFullName(), i.getUser().getPhoneNumber(), i.getVehicle().getBrandName(), i.getVehicle().getModelName(), i.getVehicle().getPrice(), i.getStartDate(), i.getEndDate(), String.valueOf(i.getStatus()));
            dataResList.add(res);
        }
        TableViewReservation.setItems(dataResList);
    }
}