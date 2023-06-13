package com.carrental;

import com.carrental.customnodes.MyButton;
import com.carrental.models.User;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.geometry.Insets;

import javax.swing.*;
import java.util.regex.Pattern;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

public class UsersController implements Initializable {


    public Label adminName;
    public HBox searchbar;
    public ImageView findImg;
    public MyButton clearallfilters;
    @FXML
    private TableColumn<User, Date> creationDate;

    @FXML
    private TableView<User> tableview;

    @FXML
    private TextField find;

    @FXML
    private TableColumn<User, Integer> IdColumn;

    @FXML
    private TableColumn<User, Boolean> isadmincolumn;

    @FXML
    private TableColumn<User, Integer> statuecolumn;

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

    public String searchKeyword ;

    @FXML
    private TableColumn<User, Void> actionColumn;

    @FXML
    private ComboBox<String> invoicestatue;

    @FXML
    private ComboBox<String> invoicedate;

    @FXML
    private ComboBox<String> roles;

    @FXML
    private Button clearAllFilters;

    @FXML
    private Button addUser;

    @FXML
    private String selectedInvoiceStatus;

    @FXML
    private String selectedInvoiceDate;

    @FXML
    private String selectedRole;

    @FXML
    private ObservableList<User> userList = FXCollections.observableArrayList();

    public void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        adminName.setText(App.getUser().getFullName());
        find.setOnAction(event -> {
            searchKeyword = find.getText();
            applySearchFilter(searchKeyword);
        });
        addUser.setOnAction(event -> {
            Dialog<User> dialog = new Dialog<>();
            dialog.setTitle("Add User");
            dialog.setHeaderText(null);
            ButtonType buttonTypeOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(buttonTypeOk, ButtonType.CANCEL);
            GridPane grid = new GridPane();
            TextField nIdField = new TextField();
            TextField emailField = new TextField();
            TextField agefield = new TextField();
            TextField phoneField = new TextField();
            TextField fullnameField = new TextField();
            TextField passwordField = new TextField();
            TextField NIDField = new TextField();
            ComboBox<String> roleComboBox = new ComboBox<>();
            roleComboBox.getItems().addAll("Admin", "Client");

            grid.add(new Label("National ID"), 0, 1);
            grid.add(NIDField, 1, 1);
            grid.add(new Label("Email"), 0, 2);
            grid.add(emailField, 1, 2);
            grid.add(new Label("Phone Number"), 0, 3);
            grid.add(phoneField, 1, 3);
            grid.add(new Label("Full Name"), 0, 4);
            grid.add(fullnameField, 1, 4);
            grid.add(new Label("Age"), 0, 5);
            grid.add(agefield, 1, 5);
            grid.add(new Label("Password"), 0, 6);
            grid.add(passwordField, 1, 6);
            grid.add(new Label("Role"), 0, 7);
            grid.add(roleComboBox, 1, 7);

            grid.setVgap(10);
            grid.setHgap(10);

            GridPane.setHalignment(NIDField, HPos.LEFT);
            GridPane.setHalignment(emailField, HPos.LEFT);
            GridPane.setHalignment(phoneField, HPos.LEFT);
            GridPane.setHalignment(fullnameField, HPos.LEFT);
            GridPane.setHalignment(agefield, HPos.LEFT);
            GridPane.setHalignment(passwordField, HPos.LEFT);
            GridPane.setHalignment(roleComboBox, HPos.LEFT);
            GridPane.setValignment(NIDField, VPos.CENTER);
            GridPane.setValignment(emailField, VPos.CENTER);
            GridPane.setValignment(phoneField, VPos.CENTER);
            GridPane.setValignment(fullnameField, VPos.CENTER);
            GridPane.setValignment(agefield, VPos.CENTER);
            GridPane.setValignment(passwordField, VPos.CENTER);
            GridPane.setValignment(roleComboBox, VPos.CENTER);

            grid.setPadding(new Insets(10));

            dialog.getDialogPane().setContent(grid);
            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == buttonTypeOk) {
                    try {
                        String newNId = NIDField.getText();
                        String newEmail = emailField.getText();
                        String newPhone = phoneField.getText();
                        String newAge = agefield.getText();
                        String newFullName = fullnameField.getText();
                        String newPassword = passwordField.getText();
                        if (Integer.parseInt(newAge) < 18) {
                            showAlert("Error", "Age must be 18 or above.");
                        } else {
                            boolean nidExists = userList.stream().anyMatch(user -> user.getNId().equals(newNId));
                            boolean phoneNumberExists = userList.stream().anyMatch(user -> user.getPhoneNumber().equals(newPhone));
                            String emailRegex = "^\\w+@+\\w+.+\\w$";
                            boolean isEmailValid = Pattern.matches(emailRegex, newEmail);
                            String phoneRegex = "^(06|07|05)\\d{8}$";
                            boolean isPhoneValid = Pattern.matches(phoneRegex, newPhone);
                            if (!isEmailValid) {
                                showAlert("Error", "Invalid email format. Please enter a valid email address.");
                            } else if (!isPhoneValid) {
                                showAlert("Error", "Invalid phone number format. Please enter a valid phone number starting with '06', '07', or '05' and having 10 digits.");
                            } else {
                                // Récupérer la valeur sélectionnée dans le ComboBox du rôle
                                String selectedRole = roleComboBox.getValue();
                                Integer age = null;
                                if (!newAge.isEmpty()) {
                                    age = Integer.parseInt(newAge);
                                }
                                int isAdmin = 0;
                                if (selectedRole.equals("Admin")) {
                                    isAdmin = 1;
                                }
                                User newUser = User.create(newNId, newEmail, newPhone, age, newFullName, newPassword, isAdmin);
                                if (newUser != null) {
                                    userList.add(newUser);
                                    tableview.setItems(userList);
                                } else {
                                    showAlert("Error", "Failed to create user. Please check the input fields.");
                                }
                            }
                        }
                    } catch (NumberFormatException e) {
                        showAlert("Error", "Invalid ID. Please enter a valid number.");
                    }
                }
                return null;
            });
            dialog.showAndWait();
            tableview.refresh();
        });
        roles.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedRole = newValue;
            applyFilters();
        });
        invoicestatue.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedInvoiceStatus = newValue;
            applyFilters();
        });
        invoicedate.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedInvoiceDate = newValue;
            applyFilters();
        });
        roles.getItems().addAll("admin", "client");
        invoicestatue.getItems().addAll("banned", "active");
        invoicedate.getItems().addAll("newest", "oldest");
        applyFilters();
        ArrayList<User> users = User.getAllUsers();
        userList.addAll(users);
        IdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nIdColumn.setCellValueFactory(new PropertyValueFactory<>("nId"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        fullnameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        isadmincolumn.setCellValueFactory(param -> new SimpleBooleanProperty(param.getValue().getIsAdmin()));
        statuecolumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        creationDate.setCellValueFactory(new PropertyValueFactory<>("creationDate"));
        isadmincolumn.setCellFactory(column -> new TableCell<User, Boolean>() {
            @Override
            protected void updateItem(Boolean isAdmin, boolean empty) {
                super.updateItem(isAdmin, empty);
                if (empty || isAdmin == null ) {
                    setText(null);
                    setGraphic(null);
                } else {
                    if (isAdmin) {
                        setText("Admin");
                        setTextFill(Color.RED);
                    } else {
                        setText("Client");
                        setTextFill(Color.BLACK);
                    }
                }
            }
        });
        statuecolumn.setCellFactory(column -> new TableCell<User, Integer>() {
            @Override
            protected void updateItem(Integer isBlocked, boolean empty) {
                super.updateItem(isBlocked, empty);
                if(empty || isBlocked == null){
                    setText(null);
                    setGraphic(null);
                }else {
                    if (isBlocked == 0) {
                        setText("Active");
                        setTextFill(Color.GREEN);
                    } else if (isBlocked == 1) {
                        setText("Banned");
                        setTextFill(Color.RED);
                    } else if (isBlocked == 2) {
                        setText("unActive");
                        setTextFill(Color.RED);
                    }
                }
            }
        });
        tableview.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                User selectedUser = tableview.getSelectionModel().getSelectedItem();
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("UserDetails-view.fxml"));
                    Parent userDetailsRoot = loader.load();
                    UserDetailsController userDetailsController = loader.getController();
                    userDetailsController.displayUserDetails(selectedUser);
                    Stage stage = new Stage();
                    stage.setScene(new Scene(userDetailsRoot));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        actionColumn.setCellFactory(param -> new TableCell<>() {
            private final Button modifyButton = new Button("Modify");
            private final Button blockButton = new Button("Ban");
            private final Button deleteButton = new Button("Delete");
            private final Button activeButton = new Button("Active");

            {
                activeButton.setOnAction(event -> {
                    User user = getTableView().getItems().get(getIndex());
                    int status = user.getStatus();
                    if (status == 2) {
                        user.setStatus(0);
                        activeButton.setText("Active");}
                    tableview.refresh();
                });
                activeButton.setStyle("-fx-background-radius: 30; -fx-background-color: forestgreen; -fx-border-radius: 30;-fx-min-width: 75px; -fx-cursor: hand");
                activeButton.setTextFill(Color.WHITE);
                modifyButton.setOnAction(event -> {
                    User user = getTableView().getItems().get(getIndex());
                    showEditDialog(user);
                });
                modifyButton.setStyle("-fx-cursor: hand; -fx-background-radius: 30; -fx-background-color: #6279FF; -fx-border-radius: 30;-fx-min-width: 75px;");
                modifyButton.setTextFill(Color.WHITE);
                blockButton.setOnAction(event -> {
                    User user = getTableView().getItems().get(getIndex());
                    int isBlocked = user.getStatus();
                    if (isBlocked == 1) {
                        user.setStatus(0);
                        blockButton.setText("Ban");
                    } else {
                        user.setStatus(1);
                        blockButton.setText("Unban");
                    }
                    tableview.refresh();
                });
                blockButton.setStyle("-fx-cursor: hand; -fx-background-radius: 30; -fx-background-color: red; -fx-border-radius: 30;-fx-min-width: 75px;");
                blockButton.setTextFill(javafx.scene.paint.Color.WHITE);
                deleteButton.setOnAction(event -> {
                    User user = getTableView().getItems().get(getIndex());
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation");
                    alert.setHeaderText("delete this user");
                    alert.setContentText("are you sure?");
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        tableview.getItems().remove(user);
                        boolean alphacool = user.delete();
                        if (alphacool) {
                            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                            successAlert.setTitle("delete");
                            successAlert.setHeaderText(null);
                            successAlert.setContentText("user is no longer in the data base.");
                            successAlert.showAndWait();
                        } else {
                            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                            errorAlert.setTitle("Erreur alpha");
                            errorAlert.setHeaderText(null);
                            errorAlert.setContentText("erreur alpha.");
                            errorAlert.showAndWait();
                        }
                    }
                });
                deleteButton.setStyle("-fx-cursor: hand; -fx-background-radius: 30; -fx-background-color: red; -fx-border-radius: 30;-fx-min-width: 75px;");
                deleteButton.setTextFill(Color.WHITE);
            }
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                }else {
                    User user = getTableView().getItems().get(getIndex());
                    int status = user.getStatus();
                    if (status == 2) {
                        HBox buttonBox = new HBox(modifyButton, activeButton, deleteButton);
                        buttonBox.setAlignment(Pos.CENTER);
                        buttonBox.setSpacing(5);
                        setGraphic(buttonBox);
                    } else {
                        HBox buttonBox = new HBox(modifyButton, blockButton, deleteButton);
                        buttonBox.setAlignment(Pos.CENTER);
                        buttonBox.setSpacing(5);
                        setGraphic(buttonBox);
                    }
                }
            }
        });
        tableview.setItems(userList);
    }

    private void showEditDialog(User user) {
        Dialog<User> dialog = new Dialog<>();
        dialog.setTitle("Modify the user");
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
    private void applyFilters() {
        tableview.setItems(userList.filtered(user -> {
            boolean statusFilter = selectedInvoiceStatus == null || selectedInvoiceStatus.isEmpty() ||
                    (selectedInvoiceStatus.equals("banned") && user.getStatus() == 1) ||
                    (selectedInvoiceStatus.equals("active") && user.getStatus() == 0)||
                    (selectedInvoiceStatus.equals("unactive") && user.getStatus() == 2);

            boolean dateFilter = selectedInvoiceDate == null || selectedInvoiceDate.isEmpty() ||
                    (selectedInvoiceDate.equals("newest") && user.getCreationDate().equals(getNewestInvoiceDate())) ||
                    (selectedInvoiceDate.equals("oldest") && user.getCreationDate().equals(getOldestInvoiceDate()));

            boolean roleFilter = selectedRole == null || selectedRole.isEmpty() ||
                    (selectedRole.equals("admin") && user.getIsAdmin()) ||
                    (selectedRole.equals("client") && !user.getIsAdmin());

            return statusFilter && dateFilter && roleFilter;
        }));
    }
    private Date getNewestInvoiceDate() {
        Date newestDate = null;
        for (User user : userList) {
            Date invoiceDate = user.getCreationDate();
            if (invoiceDate != null && (newestDate == null || invoiceDate.compareTo(newestDate) > 0)) {
                newestDate = invoiceDate;
            }
        }
        return newestDate;
    }

    private Date getOldestInvoiceDate() {
        Date oldestDate = null;
        for (User user : userList) {
            Date invoiceDate = user.getCreationDate();
            if (invoiceDate != null && (oldestDate == null || invoiceDate.compareTo(oldestDate) < 0)) {
                oldestDate = invoiceDate;
            }
        }
        return oldestDate;
    }
    @FXML
    private void clearallfilters(ActionEvent event) {
        /*invoicestatue.getSelectionModel().clearSelection();
        invoicedate.getSelectionModel().clearSelection();
        roles.getSelectionModel().clearSelection();*/
        invoicestatue = new ComboBox<>();
        invoicestatue.getStyleClass().add("menu");
        invoicestatue.getStylesheets().add(getClass().getResource("style/menu.css").toExternalForm());
        invoicestatue.setPromptText("Status");
        invoicestatue.setPrefWidth(169);
        invoicestatue.setOnAction(e -> {
                    applyFilters();
                }
        );
        invoicedate = new ComboBox<>();
        invoicedate.getStyleClass().add("menu");
        invoicedate.getStylesheets().add(getClass().getResource("style/menu.css").toExternalForm());
        invoicedate.setPromptText("Invoice Date");
        invoicedate.setPrefWidth(161);
        invoicedate.setOnAction(e -> {
                    applyFilters();
                }
        );
        roles = new ComboBox<>();
        roles.getStyleClass().add("menu");
        roles.getStylesheets().add(getClass().getResource("style/menu.css").toExternalForm());
        roles.setPromptText("Select Roles");
        roles.setPrefWidth(160);
        roles.setOnAction(e -> {
                    applyFilters();
                }
        );
        roles.getItems().addAll("admin", "client");
        invoicestatue.getItems().addAll("banned", "active");
        invoicedate.getItems().addAll("newest", "oldest");
        roles.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedRole = newValue;
            applyFilters();
        });
        invoicestatue.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedInvoiceStatus = newValue;
            applyFilters();
        });
        invoicedate.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedInvoiceDate = newValue;
            applyFilters();
        });
        searchbar.getChildren().clear();
        HBox.setMargin(roles, new Insets(0,0,0,130));
        searchbar.getChildren().addAll(find,findImg,roles,invoicedate,invoicestatue,clearallfilters,addUser);
        tableview.setItems(userList);

        tableview.refresh();
    }

    private void applySearchFilter(String searchKeyword) {
        tableview.setItems(userList.filtered(user -> {
            if (searchKeyword.isEmpty()) {
                return true;
            } else {
                String lowerCaseSearchTerm = searchKeyword.toLowerCase();
                String phoneNumber = user.getPhoneNumber();
                phoneNumber = phoneNumber != null ? phoneNumber : "";
                String nId = user.getNId().toLowerCase();
                return user.getFullName().contains(lowerCaseSearchTerm) ||
                        user.getEmail().contains(lowerCaseSearchTerm) ||
                        nId.contains(lowerCaseSearchTerm) ||
                        phoneNumber.contains(lowerCaseSearchTerm);
            }
        }));
    }
}