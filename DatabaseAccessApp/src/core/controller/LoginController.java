package core.controller;

import backend.auth.UserAuthenticator;
import backend.query.UserQuerier;
import core.DatabaseConnectionManager;
import core.UserSession;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


import java.io.IOException;
import java.sql.Timestamp;
import java.util.Random;

public class LoginController {

    static MainController mainController;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Label usernameWarning, passwdWarning;

    private UserQuerier userQuerier = new UserQuerier(DatabaseConnectionManager.getDBConnection());

    public void login() {
        boolean login = false;
        if (checkUsername()) {
            String usr = username.getText();
            String pass = password.getText();
            int id = userQuerier.getID(usr);
            Timestamp regDate = userQuerier.getRegDate(id);
            if (UserAuthenticator.auth(usr, pass + new Random(regDate.getTime()).nextInt())) {
                UserSession.setUserID(id);
                UserSession.setUsername(usr);
                UserSession.setUserRoleID(userQuerier.getRoleID(id));
                UserSession.setLoggedIn(true);
                mainController.updateUI();
                login = true;
            }
        }
        if (!login) {
            usernameWarning.setText("*Authentication failed!");
            passwdWarning.setText("*Username/Password does not match!");
            password.clear();
        }

    }

    public void signUp() {
        Pane signUpForm = null;
        try {
            signUpForm = FXMLLoader.load(getClass().getResource("../../gui/signUpForm.fxml"));
            mainController.clearBody();
            clearLogin();
            mainController.loadPaneToBody(signUpForm);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checkUsername() {
        return userQuerier.checkUsername(username.getText());
    }

    public void clearLogin() {
        username.clear();
        password.clear();
        usernameWarning.setText("");
        passwdWarning.setText("");
    }

}
