package core.controller;

import backend.component.Comment;
import backend.component.User;
import backend.query.CommentQuerier;
import backend.query.Querier;
import backend.query.UserQuerier;
import core.DatabaseConnectionManager;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;

public class CommentViewController {

    static MainController mainController;

    @FXML
    private Hyperlink creatorName;

    @FXML
    private TextArea content;

    private Comment comment;

    private Querier commentQuerier = new CommentQuerier(DatabaseConnectionManager.getDBConnection());
    private Querier userQuerier = new UserQuerier(DatabaseConnectionManager.getDBConnection());

    public void init(int ID) {
        comment = commentQuerier.getByID(ID);
        loadComment();
    }

    private void loadComment() {
        User creator = userQuerier.getByID(comment.getCreatorID());
        creatorName.setText(creator.getUsername());
        content.setText(comment.getContent());
    }

    public void loadUserPage() {

    }
}
