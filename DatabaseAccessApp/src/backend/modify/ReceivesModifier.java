package backend.modify;

import javafx.util.Pair;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ReceivesModifier extends Modifier{
    public ReceivesModifier(Connection connection) {
        super(connection);

        fields.put("UserID", 1);
        fields.put("NotificationID", 2);
        fields.put("DateReceived", 3);
        fields.put("DateRead", 4);

        addSQL = "INSERT INTO \"Receives\" (UserID, NotificationID, DateReceived, DateRead)" +
                " VALUES (?, ?, ?, ?)";

        removeSQL = "DELETE FROM \"Receives\" WHERE UserID = ? AND NotificationID = ?";

        try {
            addStatement = connection.prepareStatement(addSQL);
            removeStatement = connection.prepareStatement(removeSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean remove(int ID) {
        System.err.println("This schema does not allow removing using only one ID! Please use remove(userID, notificationID) instead!");
        return false;
    }

    public boolean remove(int userID, int notificationID) {
        try {
            removeStatement.setInt(1, userID);
            removeStatement.setInt(2, notificationID);
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
        System.err.println("This schema only allow updating of DateRead! Please use updateDateRead() instead!");
        return false;
    }

    public boolean updateDateRead(int userID, int notificationID, Date readDate) {
        String SQL = "UPDATE \"Receives\" SET DateRead = ? WHERE UserID = ? AND NotificationID = ?";
        java.sql.Date rd = new java.sql.Date(readDate.getTime());
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setObject(1, rd);
            statement.setInt(2, userID);
            statement.setInt(3, notificationID);
            statement.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
