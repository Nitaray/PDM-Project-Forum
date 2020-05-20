package core;

import gui.Window;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class LoginController {

    public void login() {

    }

    public void signUp() {
        FXMLLoader loader = new FXMLLoader(Window.class.getResource("../gui/main.fxml"));
        VBox root;
        try {
            root = loader.<VBox>load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MainController controller = loader.getController();
        controller.loadSignUpForm();
    }
}
