package backend.query;

import backend.component.Thread;
import backend.component.User;
import backend.component.forumRelation;

import java.sql.*;
import java.util.ArrayList;

public class ThreadQuerier extends Querier{
    public ThreadQuerier(Connection connection) {
        super(connection);

        querySQL = "SELECT * FROM \"Thread\" WHERE ThreadID = ?";

        try {
            queryStatement = connection.prepareStatement(querySQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected <E extends forumRelation> ArrayList<E> prepareRelations(ResultSet res) {
        ArrayList<Thread> relations = new ArrayList<>();

        try {
            String title, content;
            Timestamp dateCreated;
            int threadID, userID;

            while (res.next()) {
                int idx = 1;
                threadID = res.getInt(idx++);
                userID = res.getInt(idx++);
                dateCreated = res.getTimestamp(idx++);
                title = res.getString(idx++);
                content = res.getString(idx++);

                relations.add(new Thread(threadID, userID, dateCreated, title, content));
            }
            return (ArrayList<E>) relations;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Integer> getRecentThreadsID() {
        String SQL = "SELECT TOP 100 ThreadID FROM \"Thread\" ORDER BY DateCreated DESC";
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            ResultSet res = statement.executeQuery();
            ArrayList<Integer> ids = new ArrayList<>();
            while (res.next()) {
                ids.add(res.getInt(1));
            }
            return ids;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getThreadTitle(int ID) {
        String SQL = "SELECT ThreadTitle FROM Thread WHERE ThreadID = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setInt(1, ID);
            ResultSet res = statement.executeQuery();

            if (res.isBeforeFirst()) {
                res.next();
                return res.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public ArrayList<Integer> getTopThreadsID() {
        String SQL = "SELECT TOP 100 Thread.ThreadID FROM \"Thread\" " +
                "JOIN Comment C on Thread.ThreadID = C.ThreadID " +
                "GROUP BY Thread.ThreadID " +
                "ORDER BY COUNT(CommentID) DESC;";
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            ResultSet res = statement.executeQuery();
            ArrayList<Integer> ids = new ArrayList<>();
            while (res.next()) {
                ids.add(res.getInt(1));
            }
            return ids;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Integer> getHotThreadsID() {
        String SQL = "SELECT TOP 100 Thread.ThreadID FROM Thread " +
                "JOIN Comment C on Thread.ThreadID = C.ThreadID " +
                "WHERE DATEDIFF(day, C.DateCreated, GETDATE()) <= 30 " +
                "GROUP BY Thread.ThreadID " +
                "ORDER BY COUNT(CommentID) DESC";
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            ResultSet res = statement.executeQuery();
            ArrayList<Integer> ids = new ArrayList<>();
            while (res.next()) {
                ids.add(res.getInt(1));
            }
            return ids;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Integer> getFollowedThreadsID(int userID) {
        String SQL = "SELECT Thread.ThreadID FROM Thread " +
                "JOIN Follows F on Thread.ThreadID = F.ThreadID " +
                "WHERE F.UserID = ? " +
                "ORDER BY FollowDate DESC ";
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setInt(1, userID);
            ResultSet res = statement.executeQuery();
            ArrayList<Integer> ids = new ArrayList<>();
            while (res.next()) {
                ids.add(res.getInt(1));
            }
            return ids;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
