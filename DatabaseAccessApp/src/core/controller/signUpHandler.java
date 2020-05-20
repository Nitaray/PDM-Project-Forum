package core.controller;

import backend.component.User;
import backend.modify.UserModifier;
import backend.query.UserQuerier;
import core.DatabaseConnectionManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Pair;

import java.util.ArrayList;

public class signUpHandler {

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

    public void submitSignUpForm() {
        UserQuerier userQuerier = new UserQuerier(DatabaseConnectionManager.getDBConnection());
        if (!userQuerier.checkUsername(usrField.getText()) && !userQuerier.checkEmail(emailField.getText())) {
            UserModifier userModifier = new UserModifier(DatabaseConnectionManager.getDBConnection());
            userModifier.add(new ArrayList<Pair<String, ?>>() {{
                add(new Pair<>("Username", usrField.getText()));
                add(new Pair<>("Email", emailField.getText()));
                add(new Pair<>("FirstName", firstNameField.getText()));
                add(new Pair<>("LastName", lastNameField.getText()));
                add(new Pair<>("DateOfBirth"))
            }});
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
}
