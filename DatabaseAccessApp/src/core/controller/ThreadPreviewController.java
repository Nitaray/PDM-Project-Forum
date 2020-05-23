package core.controller;

import backend.query.ThreadQuerier;
import core.DatabaseConnectionManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ThreadPreviewController {
    static MainController mainController;

    @FXML
    private Label title;

    private int threadID;

    private ThreadQuerier threadQuerier = new ThreadQuerier(DatabaseConnectionManager.getDBConnection());

    public void init(int id) {
        this.threadID = id;
        title.setText(threadQuerier.getThreadTitle(id));
    }

    public void select() {
        title.setStyle("-fx-underline: true");
    }

    public void deselect() {
        title.setStyle("-fx-underline: false");
    }

    public void loadThread() {
        mainController.clearBody();
        Pane threadPane = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../gui/threadView.fxml"));
            threadPane = loader.load();
            ThreadViewController threadViewController = loader.getController();
            threadViewController.init(threadID);
            mainController.clearBody();
            mainController.loadPaneToBody(threadPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
