package backend.query;

import backend.component.User;
import backend.component.forumRelation;

import java.sql.*;
import java.util.ArrayList;

public class UserQuerier extends Querier{

    public UserQuerier(Connection connection) {
        super(connection);

        querySQL = "SELECT  * FROM \"User\" WHERE UserID = ?";

        try {
            queryStatement = connection.prepareStatement(querySQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected <E extends forumRelation> ArrayList<E> prepareRelations(ResultSet res) {
        ArrayList<User> relations = new ArrayList<>();

        try {
            String username, email, firstName, lastName, status, gender, country, password, about;
            Date DOB, regDate;
            int userID, roleID;

            while (res.next()) {
                int idx = 1;
                userID = res.getInt(idx++);
                username = res.getString(idx++);
                email = res.getString(idx++);
                firstName = res.getString(idx++);
                lastName = res.getString(idx++);
                DOB = res.getDate(idx++);
                status = res.getString(idx++);
                regDate = res.getDate(idx++);
                gender = res.getString(idx++);
                country = res.getString(idx++);
                password = res.getString(idx++);
                about = res.getString(idx++);
                roleID = res.getInt(idx++);
                relations.add(new User(userID, username, email, firstName, lastName, DOB, status, regDate, gender,
                        country, password, about, roleID));
            }
            return (ArrayList<E>) relations;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean checkUsername(String username) {
        String SQL = "SELECT * FROM \"User\" WHERE Username = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1, username);
            ResultSet res = statement.executeQuery();

            return res.isBeforeFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkEmail(String email) {
        String SQL = "SELECT * FROM \"User\" WHERE Email = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1, email);
            ResultSet res = statement.executeQuery();

            return res.isBeforeFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
