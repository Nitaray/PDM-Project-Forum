package backend.modify;

import javafx.util.Pair;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class NotificationModifier extends Modifier {
    public NotificationModifier(Connection connection) {
        super(connection);

        fields.put("DateSent", 1);
        fields.put("Content", 2);

        addSQL = "INSERT INTO \"Notification\" (DateSent, Content)" +
                " VALUES (?, ?)";

        removeSQL = "DELETE FROM \"Notification\" WHERE NotificationID = ?";

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
        String SQL = "UPDATE \"Notification\" SET Content = ? WHERE NotificationID = ?";
        return updateField(ID, newContent, SQL);
    }
}
