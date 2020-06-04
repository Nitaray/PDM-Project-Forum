package core.controller;

import core.UserSession;
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
    @FXML
    private Pane leftBodyPane, rightBodyPane;

    private Pane navPane, loginPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UserSession.reset();
        try {
            navPane = FXMLLoader.load(getClass().getResource("../../gui/navPane.fxml"));
            loginPane = FXMLLoader.load(getClass().getResource("../../gui/loginPane.fxml"));
            header.getChildren().add(navPane);
            header.getChildren().add(loginPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setMainControllers();
        new NavPaneController().loadMainPage();
    }

    private void setMainControllers() {
        LoginController.mainController = this;
        NavPaneController.mainController = this;
        SignUpHandler.mainController = this;
        ThreadViewController.mainController = this;
        ThreadPreviewController.mainController = this;
        UserPaneController.mainController = this;
        CommentViewController.mainController = this;
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

    public void updateUI() {
        if (UserSession.isLoggedIn()) {
            header.getChildren().remove(loginPane);
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../../gui/userPane.fxml"));
                Pane userPane = loader.load();
                header.getChildren().add(userPane);
                UserPaneController userPaneController = loader.getController();
                userPaneController.init(UserSession.getUsername(), UserSession.getUserRoleID());
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            header.getChildren().remove(1);
            header.getChildren().add(loginPane);
        }
    }
}
