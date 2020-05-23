package backend.component;

import backend.modify.Modifier;
import backend.modify.ThreadModifier;
import backend.query.Querier;

import java.sql.Date;
import java.sql.Timestamp;

public class Thread implements forumRelation {
    private int ID;
    private int userID;
    private Timestamp dateCreated;
    private String title;
    private String content;

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

    }

    @Override
    public void removeFromDatabase(Modifier modifier) {

    }

    @Override
    public void cloneFromDatabase(int ID, Querier querier) {

    }

    @Override
    public void updateToDatabase(Modifier modifier) {

    }
}
