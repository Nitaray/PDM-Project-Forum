package core.controller;

import backend.component.Thread;
import backend.component.User;
import backend.modify.Modifier;
import backend.modify.ThreadModifier;
import backend.query.CommentQuerier;
import backend.query.Querier;
import backend.query.ThreadQuerier;
import backend.query.UserQuerier;
import core.DatabaseConnectionManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.util.Pair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ThreadEditController {
    static MainController mainController;

    @FXML
    private TextField title;

    @FXML
    private TextArea content;

    @FXML
    private Hyperlink authorName;

    private Thread thread;

    private Querier threadQuerier = new ThreadQuerier(DatabaseConnectionManager.getDBConnection());
    private Querier userQuerier = new UserQuerier(DatabaseConnectionManager.getDBConnection());
    private Modifier threadModifier = new ThreadModifier(DatabaseConnectionManager.getDBConnection());

    public void init(int id) {
        thread = threadQuerier.getByID(id);
        loadThread();
    }

    public void init(Thread thread) {
        this.thread = thread;
        loadThread();
    }

    public void loadThread() {
        title.setText(thread.getTitle());
        content.setText(thread.getContent());
        User author = userQuerier.getByID(thread.getUserID());
        authorName.setText(author.getUsername());
    }

    public void submitEdit() {
        thread.setTitle(title.getText());
        thread.setContent(content.getText());
        thread.updateToDatabase(threadModifier);
        mainController.clearBody();
    }

    public void cancelEdit() {
        mainController.clearBody();
    }

    public void loadUserPage(){

    }
}
