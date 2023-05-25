package com.carrental;

import com.carrental.models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UsersController implements Initializable {

    @FXML
    private TableView<User> tableview;

    @FXML
    private TableColumn<User, Integer> IdColumn;

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
    private ObservableList<User> userList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<User> users = User.getAllUsers();
        userList.addAll(users);

        IdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nIdColumn.setCellValueFactory(new PropertyValueFactory<>("nId"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        fullnameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));

        actionColumn.setCellFactory(param -> new TableCell<>() {
            private final Button modifyButton = new Button("Modifier");
            private final Button blockButton = new Button("Bloquer");
            private final Button deleteButton = new Button("Supprimer");

            {
                modifyButton.setOnAction(event -> {
                    User user = getTableView().getItems().get(getIndex());
                    // Logique de modification pour l'utilisateur sélectionné
                });

                blockButton.setOnAction(event -> {
                    User user = getTableView().getItems().get(getIndex());
                    // Logique de blocage pour l'utilisateur sélectionné
                });

                deleteButton.setOnAction(event -> {
                    User user = getTableView().getItems().get(getIndex());
                    // Logique de suppression pour l'utilisateur sélectionné
                });
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
        tableview.getColumns().addAll(IdColumn, nIdColumn, emailColumn, phoneColumn, fullnameColumn, passwordColumn, actionColumn);
    }
}



























/* com.carrental;





import com.carrental.models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;




public class UsersController implements Initializable {

    @FXML
    private TableView<User> tableview;



    // admin - client
    @FXML
     private ComboBox<String> roles;

    // ordre croissante et ordre decroissante

    @FXML
    private ComboBox<String> invoicedate;

    // active - suspende - bloqueee
    @FXML
    private ComboBox<String> invoicestatue;

    // add user
    @FXML
    private Button addUser;

    // clearALLfilters
    @FXML
    private Button clearAllFilter;

    // label for errors
    @FXML
    private Label a;

    //@FXML
    //public ArrayList<String> roles = new ArrayList<>(Arrays.asList(null,null));


   // @FXML
   // public ArrayList<String> filterSettings = new ArrayList<String>(Arrays.asList(null,null,null));

    // private ArrayList<User> userlist = new ArrayList<User>();
    @FXML
    private ObservableList<User> userList = FXCollections.observableArrayList();

    @FXML
    private TableColumn<User, Integer> IdColumn;

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

    //private TableColumn<User, boolean> columnisadmine;


    //@FXML
  //  public ArrayList<User> Users = User.getAllUsers();


    //@FXML
    //public void clearAllfilter(ActionEvent event){







   // }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    ArrayList<User> users = User.getAllUsers();
        userList.addAll(users);
        IdColumn.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        nIdColumn.setCellValueFactory(new PropertyValueFactory<User, String>("nId"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<User, String>("phoneNumber"));
        fullnameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("fullName"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<User, String>("password"));
        actionColumn.setCellValueFactory(new PropertyValueFactory<User, Void>("actionnn"));
       // columnisadmine.setCellValueFactory(new PropertyValueFactory<User, boolean>("isAdmin"));

        tableview.setVisible(true);
        tableview.setItems(userList);


        TableColumn<User, Void> actionColumn = new TableColumn<>("Action");
        actionColumn.setCellFactory(param -> createActionButtonCell());
        tableview.getColumns().add(actionColumn);

        // a.setVisible(false);
      /*  roles.getItems().addAll("admin","client");
        invoicestatue.getItems().addAll("active","blocked","suspended");
    }

    @FXML
     public void filters(javafx.event.ActionEvent event) {
        ComboBox<String> lists = (ComboBox<String>) event.getSource();
        Text theText = new Text(lists.getValue());
        double width = (int)theText.getBoundsInLocal().getWidth()+63;
        lists.setPrefWidth(width);
        if (lists == roles) filterSettings.set(0, lists.getValue());
        else if (lists == invoicedate) filterSettings.set(1, lists.getValue());
        else if (lists == invoicestatue) filterSettings.set(3, lists.getValue());
        else if (lists == invoicedate) filterSettings.set(2, lists.getValue());

        //roles = Users.filters(filterSettings);
        //invoicestatue = Users.filters(filterSettings);
        //invoicedate = Users.filters(filterSettings);
    }
*/


  /*  private TableCell<User, Void> createActionButtonCell() {
        TableCell<User, Void> cell = new TableCell<User, Void>() {
            private final Button modifyButton = new Button("Modifier");
            private final Button blockButton = new Button("Bloquer");
            private final Button deleteButton = new Button("Supprimer");

            {
                modifyButton.setOnAction(event -> {
                    User user = getTableView().getItems().get(getIndex());
                    // Logique de modification pour l'utilisateur sélectionné
                });

                blockButton.setOnAction(event -> {
                    User user = getTableView().getItems().get(getIndex());
                    // Logique de blocage pour l'utilisateur sélectionné
                });

                deleteButton.setOnAction(event -> {
                    User user = getTableView().getItems().get(getIndex());
                    // Logique de suppression pour l'utilisateur sélectionné
                });
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
        };

        return cell;
    }
   /* private void initializeActionColumn(MouseEvent event) throws IOException {
        actionColumn.setCellFactory(param -> new TableCell<>() {
            @FXML
            private final Button editButton = new Button("Modifier");
            @FXML
            private final Button deleteButton = new Button("Supprimer");

            @FXML
            private final Button blockButton = new Button("Bloquer");

            {
                // Gestionnaire d'événements pour le bouton Modifier
                editButton.setOnAction(event -> {
                    User data = getTableView().getItems().get(getIndex());
                    // Code pour gérer l'action du bouton Modifier
                });

                // Gestionnaire d'événements pour le bouton Supprimer
                deleteButton.setOnAction(event -> {
                    User data = getTableView().getItems().get(getIndex());
                    // Code pour gérer l'action du bouton Supprimer
                });

                // Gestionnaire d'événements pour le bouton Bloquer
                blockButton.setOnAction(event -> {
                    User data = getTableView().getItems().get(getIndex());
                    // Code pour gérer l'action du bouton Bloquer
                });
            }

            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (!empty) {
                    HBox buttonsContainer = new HBox(5.0);
                    buttonsContainer.getChildren().addAll(editButton, deleteButton, blockButton);
                    setGraphic(buttonsContainer);
                } else {
                    setGraphic(null);
                }
            }
        });

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Users-view.fxml"));
        Parent Users = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(Users));
        stage.show();*/

    /*FXMLLoader loader = new FXMLLoader(getClass().getResource("users-view.fxml"));
    Parent  = loader.load();
    UsersController controller = loader.getController();
    controller.initialize();*/




