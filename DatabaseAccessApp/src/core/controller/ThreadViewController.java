package core.controller;

import backend.component.Thread;
import backend.query.ThreadQuerier;
import core.DatabaseConnectionManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ThreadViewController {
    static MainController mainController;

    @FXML
    private TextField title;

    @FXML
    private TextArea content;

    private Thread thread;

    private ThreadQuerier threadQuerier = new ThreadQuerier(DatabaseConnectionManager.getDBConnection());

    public void init(int id) {
        thread = threadQuerier.getByID(id);
        loadThread();
    }

    public void loadThread() {
        title.setText(thread.getTitle());
        content.setText(thread.getContent());
    }
}
