package core.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class LoginController {

    static MainController mainController;

    public void login() {

    }

    public void signUp() {
        Pane signUpForm = null;
        try {
            signUpForm = FXMLLoader.load(getClass().getResource("../../gui/signUpForm.fxml"));
            mainController.clearBody();
            mainController.loadPaneToBody(signUpForm);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
