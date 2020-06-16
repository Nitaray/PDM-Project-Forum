package backend.modify;

import javafx.util.Pair;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CommentModifier extends Modifier{
    public CommentModifier(Connection connection) {
        super(connection);

        fields.put("CreatorID", 1);
        fields.put("DateCreated", 2);
        fields.put("ThreadID", 3);
        fields.put("Content", 4);

        param_size = 4;

        addSQL = "INSERT INTO \"Comment\" (UserID, DateCreated, ThreadID, Content)" +
                " VALUES (?, ?, ?, ?)";

        removeSQL = "DELETE FROM \"Comment\" WHERE CommentID = ?";

        try {
            addStatement = connection.prepareStatement(addSQL);
            removeStatement = connection.prepareStatement(removeSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean update(int ID, List<Pair<String, ?>> values) {
        System.err.println("This schema only allows updating of the comment's content! Please use updateContent()!");
        return false;
    }

    public boolean updateContent(int ID, String newContent) {
        String SQL = "UPDATE \"Comment\" SET Content = ? WHERE CommentID = ?";
        return updateField(ID, newContent, SQL);
    }
}
