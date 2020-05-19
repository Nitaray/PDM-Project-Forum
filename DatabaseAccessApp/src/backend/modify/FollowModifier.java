package backend.modify;

import javafx.util.Pair;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class FollowModifier extends Modifier {
    public FollowModifier(Connection connection) {
        super(connection);

        fields.put("UserID", 1);
        fields.put("ThreadID", 2);
        fields.put("FollowDate", 3);

        addSQL = "INSERT INTO \"Follows\" (UserID, ThreadID, FollowDate)" +
                " VALUES (?, ?, ?)";

        removeSQL = "DELETE FROM \"Follows\" WHERE UserID = ? AND ThreadID = ?";

        try {
            addStatement = connection.prepareStatement(addSQL);
            removeStatement = connection.prepareStatement(removeSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean remove(int ID) {
        System.err.println("This schema does not allow remove by one ID! Please use remove(userID, threadID) instead!");
        return false;
    }

    public boolean remove(int userID, int threadID) {
        try {
            removeStatement.setInt(1, userID);
            removeStatement.setInt(2, threadID);
            System.out.println(removeStatement.executeUpdate() + " record deleted!");
            removeStatement.close();
            connection.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int ID, List<Pair<String, ?>> values) {
        System.err.println("This schema does not support updating! Please use add and remove instead!");
        return false;
    }
}
