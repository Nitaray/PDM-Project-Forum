package backend.auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Communicates with the database and validates the user's authenticity.
 */
public class UserAuthenticator {
    private Connection connection;

    public UserAuthenticator(Connection connection) {
        this.connection = connection;
    }

    public boolean auth(String username, String hashedPassword) {
        boolean authentication = false;
        try {
            String SQL = "SELECT Password FROM \"User\" WHERE Username = ?";

            PreparedStatement statement = connection.prepareStatement(SQL);

            statement.setString(1, username);
            ResultSet res = statement.executeQuery();

            if (!res.isBeforeFirst())
                return false;

            res.next();
            String correctPassword = res.getString(1);

            if (correctPassword.equals(hashedPassword))
                authentication = true;

            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authentication;
    }
}
