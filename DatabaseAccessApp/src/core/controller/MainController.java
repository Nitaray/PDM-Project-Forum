package core.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    static LoginController loginController;

    @FXML
    private HBox header;
    @FXML
    private HBox body;
    @FXML
    private VBox scrollBodyContent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Pane navPane = FXMLLoader.load(getClass().getResource("../../gui/navPane.fxml"));
            Pane loginPane = FXMLLoader.load(getClass().getResource("../../gui/loginPane.fxml"));
            header.getChildren().add(navPane);
            header.getChildren().add(loginPane);
            System.out.println(this.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        LoginController.mainController = this;
        NavPaneController.mainController = this;
    }

    public void loadSignUpForm() {
        try {
            Pane signUpForm = FXMLLoader.load(getClass().getResource("../../gui/signUpForm.fxml"));
            scrollBodyContent.getChildren().add(signUpForm);
            System.out.println(this.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
