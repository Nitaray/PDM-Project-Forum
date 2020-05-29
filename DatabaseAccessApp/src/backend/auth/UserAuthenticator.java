package backend.auth;

import core.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Communicates with the database and validates the user's authenticity.
 */
public class UserAuthenticator {
    private static Connection connection = DatabaseConnectionManager.getDBConnection();

    public static boolean auth(String username, String password) {
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
            String hashed = AuthUtil.hashString(password);

            System.out.println(correctPassword);
            System.out.println(hashed);

            if (correctPassword.equals(hashed))
                authentication = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return authentication;
    }
}
