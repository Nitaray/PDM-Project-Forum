package core.controller;

import backend.auth.AuthUtil;
import backend.component.User;
import backend.modify.UserModifier;
import backend.query.UserQuerier;
import core.DatabaseConnectionManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.util.Pair;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;

public class SignUpHandler {

    static MainController mainController;

    @FXML
    private TextField usrField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwdField;

    @FXML
    private TextField confirmPasswdField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField genderField;

    @FXML
    private TextField countryField;

    @FXML
    private TextField dayField;

    @FXML
    private TextField monthField;

    @FXML
    private TextField yearField;

    @FXML
    private TextArea aboutField;

    @FXML
    private Label usrFieldWarning, emailFieldWarning, passwdFieldWarning, confirmPasswdFieldWarning;

    private UserQuerier userQuerier = new UserQuerier(DatabaseConnectionManager.getDBConnection());


    public void submitSignUpForm() {
        if (!verifyRequiredFields()) {
            usrFieldWarning.setText("Username cannot be empty!");
            emailFieldWarning.setText("Email cannot be empty!");
            passwdFieldWarning.setText("Password cannot be empty!");
            confirmPasswdFieldWarning.setText("Confirm password cannot be empty!");
            return;
        }

        if (!isUniqueUsername()) {
            usrFieldWarning.setText("This username has been used!");
            return;
        }
        else {
            usrFieldWarning.setText("");
        }

        if (!isUniqueEmail()) {
            emailFieldWarning.setText("This email has been used!");
            return;
        }
        else {
            emailFieldWarning.setText("");
        }

        if (!passwordMatches()) {
            passwdFieldWarning.setText("The passwords do not match!");
            confirmPasswdFieldWarning.setText("The passwords do not match!");
            passwdField.clear();
            confirmPasswdField.clear();
            return;
        }
        else {
            passwdFieldWarning.setText("");
            confirmPasswdFieldWarning.setText("");
        }

        String dobStr = yearField.getText() + '-' + monthField.getText() + '-' + dayField.getText();
        Timestamp DOB = null;
        if (dobStr.matches("\\d{1,4}-\\d{1,2}-\\d{1,2}"))
            DOB = Timestamp.valueOf(dobStr + " 00:00:00.000000000");

        Timestamp regDate = new Timestamp(System.currentTimeMillis());
        String hashedPassword = AuthUtil.hashString(passwdField.getText() + new Random(regDate.getTime()).nextInt());
        Timestamp finalDOB = DOB;

        UserModifier userModifier = new UserModifier(DatabaseConnectionManager.getDBConnection());
        userModifier.add(new ArrayList<Pair<String, ?>>() {{
            add(new Pair<>("Username", usrField.getText()));
            add(new Pair<>("Email", emailField.getText()));
            add(new Pair<>("FirstName", firstNameField.getText()));
            add(new Pair<>("LastName", lastNameField.getText()));
            add(new Pair<>("DateOfBirth", finalDOB));
            add(new Pair<>("Status", "ACTIVE"));
            add(new Pair<>("RegistrationDate", regDate));
            add(new Pair<>("Gender", genderField.getText()));
            add(new Pair<>("Country", countryField.getText()));
            add(new Pair<>("Password", hashedPassword));
            add(new Pair<>("About", aboutField.getText()));
            add(new Pair<>("RoleID", 1));
        }});

        Pane confirmation = null;
        try {
            confirmation = FXMLLoader.load(getClass().getResource("../../gui/signUpConfirmationNotification.fxml"));
            mainController.clearBody();
            mainController.loadPaneToBody(confirmation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void verifyDay() {
        if (!dayField.getText().matches("\\d*")) {
            dayField.setText(dayField.getText().replaceAll("\\D", ""));
            dayField.positionCaret(dayField.getText().length());
        }
        if (!dayField.getText().equals(""))
            if (Integer.parseInt(dayField.getText()) > 31)
                dayField.deletePreviousChar();
    }

    public void verifyMonth() {
        if (!monthField.getText().matches("\\d*")) {
            monthField.setText(monthField.getText().replaceAll("\\D", ""));
            monthField.positionCaret(monthField.getText().length());
        }
        if (!monthField.getText().equals(""))
            if (Integer.parseInt(monthField.getText()) > 12)
                monthField.deletePreviousChar();
    }

    public void verifyYear() {
        if (!yearField.getText().matches("\\d*")) {
            yearField.setText(yearField.getText().replaceAll("\\D", ""));
            yearField.positionCaret(yearField.getText().length());
        }
        if (!yearField.getText().equals(""))
            if (Integer.parseInt(yearField.getText()) > 2020)
                yearField.deletePreviousChar();
    }

    private boolean verifyRequiredFields() {
        return !usrField.getText().isEmpty() && !emailField.getText().isEmpty() && !passwdField.getText().isEmpty() && !confirmPasswdField.getText().isEmpty();
    }

    private boolean isUniqueUsername() {
        return !userQuerier.checkUsername(usrField.getText());
    }

    private boolean isUniqueEmail() {
        return !userQuerier.checkEmail(emailField.getText());
    }

    private boolean passwordMatches() {
        return passwdField.getText().equals(confirmPasswdField.getText());
    }
}
