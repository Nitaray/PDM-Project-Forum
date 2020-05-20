package backend.query;

import backend.component.forumRelation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ThreadQuerier extends Querier{
    public ThreadQuerier(Connection connection) {
        super(connection);

        querySQL = "SELECT * FROM Thread WHERE ThreadID = ?";

        try {
            queryStatement = connection.prepareStatement(querySQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected <E extends forumRelation> ArrayList<E> prepareRelation(ResultSet res) {
        return null;
    }
}
