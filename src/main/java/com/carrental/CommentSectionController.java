package com.carrental;

import com.carrental.models.Review;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class CommentSectionController implements Initializable {

    @FXML
    private TextArea commentArea;

    @FXML
    private Label errorLabel;

    @FXML
    private Label nationalIdLabel;

    @FXML
    private Button notNowButton;

    @FXML
    private Label emailLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Button publishButton;

    @FXML
    private ImageView star1;

    @FXML
    private ImageView star2;

    @FXML
    private ImageView star3;

    @FXML
    private ImageView star4;

    @FXML
    private ImageView star5;

    Image str = new Image(getClass().getResourceAsStream("icons/star.png"), 512, 512, true, true);
    Image emptystr = new Image(getClass().getResourceAsStream("icons/emptystar.png"), 512, 512, true, true);

    ArrayList<ImageView> stars = null;
    Integer actualStars = 0;
    public void setStars(Integer nbrStar) {
        for(ImageView img : stars){
            img.setImage(emptystr);
        }
        for(int i=0; i < nbrStar ; i++){
            stars.get(i).setImage(str);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        stars = new ArrayList<>(Arrays.asList(star1, star2, star3, star4, star5));
        setStars(actualStars);
        String username = App.getUser().getFullName();
        nameLabel.setText(username);
        String nationalId = App.getUser().getNId();
        nationalIdLabel.setText(nationalId);
        String email = App.getUser().getEmail();
        emailLabel.setText(email);

        star1.setOnMouseEntered(event -> {
            setStars(1);
        });
        star2.setOnMouseEntered(event -> {
            setStars(2);
        });
        star3.setOnMouseEntered(event -> {
            setStars(3);
        });
        star4.setOnMouseEntered(event -> {
            setStars(4);
        });
        star5.setOnMouseEntered(event -> {
            setStars(5);
        });

        star1.setOnMouseExited(event -> {
            setStars(actualStars);
        });
        star2.setOnMouseExited(event -> {
            setStars(actualStars);
        });
        star3.setOnMouseExited(event -> {
            setStars(actualStars);
        });
        star4.setOnMouseExited(event -> {
            setStars(actualStars);
        });
        star5.setOnMouseExited(event -> {
            setStars(actualStars);
        });

        star1.setOnMouseClicked(event -> {
            actualStars = 1;
        });
        star2.setOnMouseClicked(event -> {
            actualStars = 2;
        });
        star3.setOnMouseClicked(event -> {
            actualStars = 3;
        });
        star4.setOnMouseClicked(event -> {
            actualStars = 4;
        });
        star5.setOnMouseClicked(event -> {
            actualStars = 5;
        });

        publishButton.setOnAction(event -> {
            String description = commentArea.getText();
            if(actualStars != 0 ) {
                Review.create(App.getUser().getId(), actualStars, description);
                ((Stage)star1.getScene().getWindow()).close();
            }else{
                errorLabel.setText("You must rate, at least 1 star");
            }
        });

        notNowButton.setOnAction(event -> {
            ((Stage)star1.getScene().getWindow()).close();
        });

    }
}
