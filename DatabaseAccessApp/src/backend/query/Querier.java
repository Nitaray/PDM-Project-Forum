package backend.query;

import backend.component.forumRelation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Querier {
    protected Connection connection;

    protected String querySQL;

    protected PreparedStatement queryStatement;

    public Querier(Connection connection) {
        this.connection = connection;
    }

    public <E extends forumRelation> E getByID(int id) {
        try {
            queryStatement.setInt(1, id);
            ResultSet res = queryStatement.executeQuery();
            return (E) prepareRelation(res).get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected abstract <E extends forumRelation> ArrayList<E> prepareRelation(ResultSet res);
}
