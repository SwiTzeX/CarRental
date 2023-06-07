package com.carrental;

import com.carrental.models.Review;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CommentsPageController implements Initializable {


    @FXML
    private VBox commentsVbox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void loadComments(){
        ArrayList<Review> revs = Review.getComments();

        for(Review r : revs){

        }

    }


}
