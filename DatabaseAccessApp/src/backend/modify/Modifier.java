package backend.modify;

import javafx.util.Pair;

import java.sql.*;
import java.util.HashMap;
import java.util.List;

public class Modifier {
    protected static HashMap<String, Integer> fields = new HashMap<>();
    protected Connection connection;

    protected String addSQL;
    protected String removeSQL;
    protected String updateSQL;

    protected PreparedStatement addStatement;
    protected PreparedStatement removeStatement;
    protected PreparedStatement updateStatement;

    public Modifier(Connection connection) {
        this.connection = connection;
    }

    public boolean add(List<Pair<String, ?>> values) {
        try {
            setStatementParams(addStatement, values);
            System.out.println(addStatement.executeUpdate() + " record added!");
            addStatement.close();
            connection.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean remove(int ID) {
        try {
            removeStatement.setInt(1, ID);
            System.out.println(removeStatement.executeUpdate() + " record deleted!");
            removeStatement.close();
            connection.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(int ID, List<Pair<String, ?>> values) {
        try {
            setStatementParams(updateStatement, values);
            updateStatement.setInt(fields.size() + 1, ID);
            updateStatement.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }


    protected void setStatementParams(PreparedStatement statement, List<Pair<String, ?>> values) {
        for (int index = 1; index <= 12; index++) {
            try {
                statement.setNull(index, Types.NULL);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        values.forEach(e -> {
            if (fields.containsKey(e.getKey()) && e.getValue() != null) {
                try {
                    statement.setObject(fields.get(e.getKey()), e.getValue());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.err.println("Unable to set insert statement parameters!");
                }
            }
        });
    }


    protected boolean updateField(int ID, Object value, String SQL) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setObject(1, value);
            statement.setInt(2, ID);
            statement.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
