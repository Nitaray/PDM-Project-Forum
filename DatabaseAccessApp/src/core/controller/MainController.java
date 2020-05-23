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
        } catch (IOException e) {
            e.printStackTrace();
        }
        LoginController.mainController = this;
        NavPaneController.mainController = this;
        SignUpHandler.mainController = this;
    }

    public void clearBody() {
        scrollBodyContent.getChildren().clear();
    }

    public void loadPaneToBody(Pane pane) {
        try {
            scrollBodyContent.getChildren().add(pane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
