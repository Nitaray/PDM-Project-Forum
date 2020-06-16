package backend.modify;

import java.sql.*;

public class ThreadModifier extends Modifier {

    public ThreadModifier(Connection connection) {
        super(connection);

        fields.put("UserID", 1);
        fields.put("DateCreated", 2);
        fields.put("ThreadTitle", 3);
        fields.put("Content", 4);

        param_size = 4;

        updateSQL = "UPDATE \"Thread\" SET" +
                " UserID = ?," +
                " DateCreated = ?," +
                " ThreadTitle = ?," +
                " Content = ?" +
                " WHERE ThreadID = ?";

        addSQL = "INSERT INTO \"Thread\" (UserID, DateCreated, ThreadTitle, Content)" +
                " VALUES (?, CONVERT(datetime2, ?), ?, ?)";

        removeSQL = "DELETE FROM \"Thread\" WHERE ThreadID = ?";

        try {
            addStatement = connection.prepareStatement(addSQL);
            removeStatement = connection.prepareStatement(removeSQL);
            updateStatement = connection.prepareStatement(updateSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean updateUserID(int ID, String newUserID) {
        String SQL = "UPDATE \"Thread\" SET UserID = ? WHERE ThreadID = ?";
        return updateField(ID, newUserID, SQL);
    }

    public boolean updateThreadTitle(int ID, String newThreadTitle) {
        String SQL = "UPDATE \"Thread\" SET ThreadTitle = ? WHERE TheadID = ?";
        return updateField(ID, newThreadTitle, SQL);
    }

    public boolean updateContent(int ID, String newContent) {
        String SQL = "UPDATE \"Thread\" SET Content = ? WHERE ThreadID = ?";
        return updateField(ID, newContent, SQL);
    }
}
