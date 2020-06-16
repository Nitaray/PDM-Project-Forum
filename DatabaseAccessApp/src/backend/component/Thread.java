package backend.component;

import backend.modify.Modifier;
import backend.modify.ThreadModifier;
import backend.query.Querier;
import backend.query.ThreadQuerier;
import core.DatabaseConnectionManager;
import javafx.util.Pair;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

public class Thread implements forumRelation {
    private int ID;
    private int userID;
    private Timestamp dateCreated;
    private String title;
    private String content;

    public Thread(int userID, String title, String content) {
        this.userID = userID;
        this.dateCreated = new Timestamp(System.currentTimeMillis());
        this.title = title;
        this.content = content;
    }

    public Thread(int ID, int userID, Timestamp dateCreated, String title, String content) {
        this.ID = ID;
        this.userID = userID;
        this.dateCreated = dateCreated;
        this.title = title;
        this.content = content;
    }

    public int getID() {
        return ID;
    }

    public int getUserID() {
        return userID;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void addToDatabase(Modifier modifier) {
        List<Pair<String, ?>> values = new LinkedList<Pair<String, ?>>() {{
            add(new Pair<String, Integer>("UserID", userID));
            add(new Pair<String, Timestamp>("DateCreated", dateCreated));
            add(new Pair<String, String>("ThreadTitle", title));
            add(new Pair<String, String>("Content", content));
        }};
        modifier.add(values);
        ID = new ThreadQuerier(DatabaseConnectionManager.getDBConnection()).getThreadIDByUserIDAndTime(userID, dateCreated);
    }

    @Override
    public void removeFromDatabase(Modifier modifier) {

    }

    @Override
    public void cloneFromDatabase(int ID, Querier querier) {

    }

    @Override
    public void updateToDatabase(Modifier modifier) {
        List<Pair<String, ?>> values = new LinkedList<Pair<String, ?>>() {{
            add(new Pair<>("UserID", userID));
            add(new Pair<>("DateCreated", dateCreated));
            add(new Pair<>("ThreadTitle", title));
            add(new Pair<>("Content", content));
        }};
        modifier.update(ID, values);
    }

//    public void updateToDatabase(ThreadModifier modifier) {
//        List<Pair<String, ?>> values = new LinkedList<Pair<String, ?>>() {{
//            add(new Pair<>("UserID", userID));
//            add(new Pair<>("DateCreated", dateCreated));
//            add(new Pair<>("ThreadTitle", title));
//            add(new Pair<>("Content", content));
//        }};
//        modifier.update(ID, values);
//    }
}
