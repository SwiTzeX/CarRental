package com.carrental;

import com.carrental.models.User;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class UsersController implements Initializable {

    @FXML
    private TableView<User> tableview;

    @FXML
    private TableColumn<User, Integer> IdColumn;

    @FXML
    private TableColumn<User, Boolean> isadmincolumn;

    @FXML
    private TableColumn<User, Boolean> statuecolumn;

    @FXML
    private TableColumn<User, String> nIdColumn;

    @FXML
    private TableColumn<User, String> emailColumn;

    @FXML
    private TableColumn<User, String> phoneColumn;

    @FXML
    private TableColumn<User, String> fullnameColumn;

    @FXML
    private TableColumn<User, String> passwordColumn;

    @FXML
    private TableColumn<User, Void> actionColumn;

    @FXML
    private ComboBox<String> invoicestatue;

    @FXML
    private ComboBox<String> invoicedate;

    @FXML
    private ComboBox<String> roles;

    @FXML
    private ObservableList<User> userList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

     roles.getItems().addAll("admin", "client");
     invoicestatue.getItems().addAll("bloqué", "active", "susp");
     invoicedate.getItems().addAll("newest", "oldest");


        ArrayList<User> users = User.getAllUsers();
        userList.addAll(users);

        IdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nIdColumn.setCellValueFactory(new PropertyValueFactory<>("nId"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        fullnameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        isadmincolumn.setCellValueFactory(param -> new SimpleBooleanProperty(param.getValue().getIsAdmin()));
        statuecolumn.setCellValueFactory(param -> new SimpleBooleanProperty(param.getValue().getStatus()));


        isadmincolumn.setCellFactory(column -> new TableCell<User, Boolean>() {
            @Override
            protected void updateItem(Boolean isAdmin, boolean empty) {
                super.updateItem(isAdmin, empty);
                if (empty || isAdmin == null) {
                    setText(null);
                } else {
                    if (isAdmin) {
                        setText("Admin");
                        setTextFill(javafx.scene.paint.Color.GREEN);
                    } else {
                        setText("Client");
                        setTextFill(javafx.scene.paint.Color.RED);
                    }
                }
            }
        });
        statuecolumn.setCellFactory(column -> new TableCell<User, Boolean>() {
            @Override
            protected void updateItem(Boolean isAdmin, boolean empty) {
                super.updateItem(isAdmin, empty);
                if (empty || isAdmin == null) {
                    setText(null);
                } else {
                    setText(isAdmin ? "active" : "inactive");

                }
            }
        });



        actionColumn.setCellFactory(param -> new TableCell<>() {
            private final Button modifyButton = new Button("Modifier");
            private final Button blockButton = new Button("Bloquer");
            private final Button deleteButton = new Button("Supprimer");

            {
                modifyButton.setOnAction(event -> {
                    User user = getTableView().getItems().get(getIndex());
                    showEditDialog(user);
                });
                modifyButton.setStyle("-fx-background-radius: 30; -fx-background-color: #6279FF; -fx-border-radius: 30;");
                modifyButton.setTextFill(javafx.scene.paint.Color.WHITE);
                blockButton.setOnAction(event -> {
                    User user = getTableView().getItems().get(getIndex());
                    // logique
                });
                blockButton.setStyle("-fx-background-radius: 30; -fx-background-color: #6279FF; -fx-border-radius: 30;");
                blockButton.setTextFill(javafx.scene.paint.Color.WHITE);


                deleteButton.setOnAction(event -> {
                    User user = getTableView().getItems().get(getIndex());
                    // logique
                });
                deleteButton.setStyle("-fx-background-radius: 30; -fx-background-color: #6279FF; -fx-border-radius: 30;");
                deleteButton.setTextFill(javafx.scene.paint.Color.WHITE);

            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    HBox buttonBox = new HBox(modifyButton, blockButton, deleteButton);
                    setGraphic(buttonBox);
                }
            }
        });

        tableview.setItems(userList);
        tableview.getColumns().addAll(IdColumn, nIdColumn, emailColumn, phoneColumn, fullnameColumn, passwordColumn, isadmincolumn, statuecolumn, actionColumn);
    }

    private void showEditDialog(User user) {
        Dialog<User> dialog = new Dialog<>();
        dialog.setTitle("Modifier l'utilisateur");
        dialog.setHeaderText(null);

        ButtonType buttonTypeOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(buttonTypeOk, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        TextField idField = new TextField(String.valueOf(user.getId()));
        TextField nIdField = new TextField(user.getNId());
        TextField emailField = new TextField(user.getEmail());
        TextField phoneField = new TextField(user.getPhoneNumber());
        TextField fullnameField = new TextField(user.getFullName());
        TextField passwordField = new TextField(user.getPassword());

        grid.add(new Label("ID:"), 0, 0);
        grid.add(idField, 1, 0);
        grid.add(new Label("NID:"), 0, 1);
        grid.add(nIdField, 1, 1);
        grid.add(new Label("Email:"), 0, 2);
        grid.add(emailField, 1, 2);
        grid.add(new Label("phone number:"), 0, 3);
        grid.add(phoneField, 1, 3);
        grid.add(new Label("full name:"), 0, 4);
        grid.add(fullnameField, 1, 4);
        grid.add(new Label("password:"), 0, 5);
        grid.add(passwordField, 1, 5);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == buttonTypeOk) {
                int newId = Integer.parseInt(idField.getText());
                String newNId = nIdField.getText();
                String newEmail = emailField.getText();
                String newPhone = phoneField.getText();
                String newFullName = fullnameField.getText();
                String newPassword = passwordField.getText();

                user.setId(newId);
                user.setNId(newNId);
                user.setEmail(newEmail);
                user.setPhoneNumber(newPhone);
                user.setFullName(newFullName);
                user.setPassword(newPassword);

                return user;
            }
            return null;
        });

        Optional<User> result = dialog.showAndWait();
        result.ifPresent(updatedUser -> {
            int index = tableview.getItems().indexOf(updatedUser);
            if (index != -1) {
                userList.set(index, updatedUser);
            }
        });
    }
}