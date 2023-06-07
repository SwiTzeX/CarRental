package com.carrental;

import com.carrental.models.Review;
import com.carrental.models.Vehicle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CommentsPageController implements Initializable {


    @FXML
    private VBox commentsVbox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadComments();
    }

    public void loadComments(){
        ArrayList<Review> revs = Review.getComments();
        try {
        for(Review r : revs){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("comment-view.fxml"));

                HBox commentCard = fxmlLoader.load();
            CommentController commentController = fxmlLoader.getController();
            commentController.setData(r);
            commentsVbox.getChildren().add(commentCard);
        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
