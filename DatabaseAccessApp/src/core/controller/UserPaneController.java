package core.controller;

import backend.component.Thread;
import backend.modify.ThreadModifier;
import core.DatabaseConnectionManager;
import core.UserSession;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class UserPaneController {
    static MainController mainController;

    @FXML
    private Circle rankCircle;

    @FXML
    private Hyperlink username;

    @FXML
    private Button adminBtn;

    public void init(String username, int roleID) {
        this.username.setText(username);
        switch (roleID) {
            case 2:
                rankCircle.setFill(Paint.valueOf("yellow"));
                break;
            case 3:
                rankCircle.setFill(Paint.valueOf("red"));
                adminBtn.setVisible(true);
                break;
            default:
                break;
        }
    }

    public void loadAdminPage() {
        Pane adminPage = null;
        try {
            mainController.clearBody();
            adminPage = FXMLLoader.load(getClass().getResource("../../gui/adminQueryView.fxml"));
            mainController.loadPaneToBody(adminPage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadUserPage() {

    }

    public void logout() {
        UserSession.setUserID(0);
        UserSession.setUsername(null);
        UserSession.setUserRoleID(0);
        UserSession.setLoggedIn(false);
        mainController.updateUI();
    }

    public void createNewThread() {
        Thread newThread = new Thread(UserSession.getUserID(), "", "");
        newThread.addToDatabase(new ThreadModifier(DatabaseConnectionManager.getDBConnection()));
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../gui/ThreadEdit.fxml"));
            Pane threadEdit = loader.load();
            ThreadEditController threadEditController = loader.getController();
            threadEditController.init(newThread);
            mainController.clearBody();
            mainController.loadPaneToBody(threadEdit);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
