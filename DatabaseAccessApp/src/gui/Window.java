package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Window extends Application {
    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("../gui/main.fxml"));
        window.setTitle("Database Manager");
        window.setScene(new Scene(root, 1920, 1080));
        window.show();
        System.out.println("Program Started!");
    }

    public static void start(String[] args) {
        launch(args);
    }
}
