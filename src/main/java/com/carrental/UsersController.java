package com.carrental;





import com.carrental.models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;

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
       // columnisadmine.setCellValueFactory(new PropertyValueFactory<User, boolean>("isAdmin"));

        tableview.setVisible(true);
        tableview.setItems(userList);




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
}
}



