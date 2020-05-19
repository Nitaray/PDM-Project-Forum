package backend.modify;

import javafx.util.Pair;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RoleModifier extends Modifier{
    public RoleModifier(Connection connection) {
        super(connection);

        fields.put("RoleName", 1);

        addSQL = "INSERT INTO \"Role\" (RoleName)" +
                " VALUES (?)";

        removeSQL = "DELETE FROM \"Role\" WHERE RoleID = ?";

        updateSQL = "UPDATE \"Role\" SET" +
                " RoleName = ?" +
                " WHERE RoleID = ?";

        try {
            addStatement = connection.prepareStatement(addSQL);
            removeStatement = connection.prepareStatement(removeSQL);
            updateStatement = connection.prepareStatement(updateSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
