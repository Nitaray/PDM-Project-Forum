package backend.query;

import backend.component.Comment;
import backend.component.forumRelation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentQuerier extends Querier {
    public CommentQuerier(Connection connection) {
        super(connection);

        querySQL = "SELECT * FROM \"Comment\" WHERE CommentID = ?";

        try {
            queryStatement = connection.prepareStatement(querySQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected <E extends forumRelation> ArrayList<E> prepareRelations(ResultSet res) {
        ArrayList<Comment> relations = new ArrayList<>();

        try {
            String content;
            Timestamp dateCreated;
            int commentID, creatorID, threadID;

            while (res.next()) {
                int idx = 1;
                commentID = res.getInt(idx++);
                creatorID = res.getInt(idx++);
                dateCreated = res.getTimestamp(idx++);
                threadID = res.getInt(idx++);
                content = res.getString(idx++);

                relations.add(new Comment(commentID, creatorID, dateCreated, threadID, content));
            }
            return (ArrayList<E>) relations;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Integer> getCommentIDsByThreadID(int threadID) {
        String SQL = "SELECT CommentID FROM Comment WHERE ThreadID = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setInt(1, threadID);
            ResultSet res = statement.executeQuery();
            ArrayList<Integer> ids = new ArrayList<>();

            while (res.next()) {
                ids.add(res.getInt(1));
            }
            return ids;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

