package core.controller;

import backend.query.ThreadQuerier;
import core.DatabaseConnectionManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;

public class NavPaneController {
    static MainController mainController;

    @FXML
    private ImageView logo;

    @FXML
    private Label navTOP, navHOT, navFOLLOWED;

    public void selectTOP() {
        navTOP.setStyle("-fx-underline: true");
    }

    public void deselectTOP() {
        navTOP.setStyle("-fx-underline: false");
    }

    public void selectHOT() {
        navHOT.setStyle("-fx-underline: true");
    }

    public void deselectHOT() {
        navHOT.setStyle("-fx-underline: false");
    }

    public void selectFL() {
        navFOLLOWED.setStyle("-fx-underline: true");
    }

    public void deselectFL() {
        navFOLLOWED.setStyle("-fx-underline: false");
    }

    public void loadMainPage() {
        mainController.clearBody();
        ThreadQuerier threadQuerier = new ThreadQuerier(DatabaseConnectionManager.getDBConnection());
        ArrayList<Integer> recent = threadQuerier.getRecentThreadsID();
        loadThreadPreviews(recent);
    }

    public void loadTopPosts() {
        mainController.clearBody();
        ThreadQuerier threadQuerier = new ThreadQuerier(DatabaseConnectionManager.getDBConnection());
        ArrayList<Integer> topThreadsID = threadQuerier.getTopThreadsID();
        loadThreadPreviews(topThreadsID);
    }

    public void loadHotPosts() {
        mainController.clearBody();
        ThreadQuerier threadQuerier = new ThreadQuerier(DatabaseConnectionManager.getDBConnection());
        ArrayList<Integer> topThreadsID = threadQuerier.getHotThreadsID();
        loadThreadPreviews(topThreadsID);
    }

    public void loadFollowedPosts() {

    }

    private void loadThreadPreviews(ArrayList<Integer> threadIDS) {
        for (int id : threadIDS) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../../gui/threadPreview.fxml"));
                Pane threadPreview = loader.load();
                ThreadPreviewController threadPreviewController = loader.getController();
                threadPreviewController.init(id);

                mainController.loadPaneToBody(threadPreview);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("System error! Sorry for the inconvenience!");
                break;
            }
        }
    }
}
