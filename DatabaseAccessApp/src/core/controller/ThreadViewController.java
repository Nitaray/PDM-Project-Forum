package core.controller;

import backend.component.Thread;
import backend.component.User;
import backend.query.CommentQuerier;
import backend.query.Querier;
import backend.query.ThreadQuerier;
import backend.query.UserQuerier;
import core.DatabaseConnectionManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ThreadViewController {
    static MainController mainController;

    @FXML
    private TextField title;

    @FXML
    private TextArea content;

    @FXML
    private Hyperlink authorName;

    private Thread thread;

    private Querier threadQuerier = new ThreadQuerier(DatabaseConnectionManager.getDBConnection());
    private CommentQuerier commentQuerier = new CommentQuerier(DatabaseConnectionManager.getDBConnection());
    private Querier userQuerier = new UserQuerier(DatabaseConnectionManager.getDBConnection());

    public void init(int id) {
        thread = threadQuerier.getByID(id);
        loadThread();
    }

    public void loadThread() {
        title.setText(thread.getTitle());
        content.setText(thread.getContent());
        User author = userQuerier.getByID(thread.getUserID());
        authorName.setText(author.getUsername());
    }

    public void loadComments() {
        List<Integer> commentIDs = commentQuerier.getCommentIDsByThreadID(thread.getID());
        if (commentIDs != null) {
            commentIDs.forEach(id -> {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../../gui/CommentView.fxml"));
                    Pane commentPane = loader.load();
                    CommentViewController commentViewController = loader.getController();
                    commentViewController.init(id);
                    mainController.loadPaneToBody(commentPane);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public void loadUserPage(){

    }
}
