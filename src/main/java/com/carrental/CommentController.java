package com.carrental;

import com.carrental.models.Reservation;
import com.carrental.models.Review;
import com.carrental.models.User;
import com.carrental.models.Vehicle;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.time.LocalDate;
import java.time.Period;

public class CommentController {

    @FXML
    private MenuButton choiceMenu;

    @FXML
    private Label commentText;

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

    @FXML
    private Label username;

    @FXML
    private ImageView userIcon;

    Image str = new Image("main.resources.icons.star", 20, 20, true, true);
    Image emptystr = new Image("main.resources.icons.emptystar", 20, 20, true, true);


    public void setData(Review review){

        Image image = new Image("main.resources.icons.user-icon", 43, 46, true, true);
        userIcon.setImage(image);
        username.setText(User.getUserById(review.idU).fullName);
        commentText.setText(review.getComment());
        int numStars = review.getStars();
        if(numStars == 5) fiveStars();
        else if(numStars == 4) fourStars();
        else if(numStars == 3) threeStars();
        else if(numStars == 2) twoStars();
        else if(numStars == 1) oneStar();
    }

    public void fiveStars() {
        star1.setImage(str);
        star2.setImage(str);
        star3.setImage(str);
        star4.setImage(str);
        star5.setImage(str);
    }

    public void fourStars() {
        star1.setImage(str);
        star2.setImage(str);
        star3.setImage(str);
        star4.setImage(str);
        star5.setImage(emptystr);
    }
    public void threeStars() {
        star1.setImage(str);
        star2.setImage(str);
        star3.setImage(str);
        star4.setImage(emptystr);
        star5.setImage(emptystr);
    }
    public void twoStars() {
        star1.setImage(str);
        star2.setImage(str);
        star3.setImage(emptystr);
        star4.setImage(emptystr);
        star5.setImage(emptystr);
    }
    public void oneStar() {
        star1.setImage(str);
        star2.setImage(emptystr);
        star3.setImage(emptystr);
        star4.setImage(emptystr);
        star5.setImage(emptystr);
    }


}
