package core.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class NavPaneController implements Initializable {
    static MainController mainController;

    @FXML
    ImageView logo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void loadMainPage() {
        mainController.clearBody();
    }

    public void loadTopPosts() {

    }

    public void loadHotPosts() {

    }

    public void loadFollowedPosts() {

    }
}
