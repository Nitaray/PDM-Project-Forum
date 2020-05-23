package core.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class UserPaneController {
    static MainController mainController;

    @FXML
    private Circle rankCircle;

    @FXML
    private Label username;

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
            adminPage = FXMLLoader.load(getClass().getResource("../../gui/adminQueryView.fxml"));
            mainController.clearBody();
            mainController.loadPaneToBody(adminPage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
