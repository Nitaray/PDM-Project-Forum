package backend.component;

import backend.modify.Modifier;
import backend.modify.ThreadModifier;

import java.sql.Connection;
import java.sql.Date;

public class Thread implements forumRelation {
    private int ID;
    private int userID;
    private Date dateCreated;
    private String title;
    private String content;

    public Thread(int userID, String title, String content) {
        this.userID = userID;
        this.dateCreated = new Date(new java.util.Date().getTime());
        this.title = title;
        this.content = content;
    }

    public Thread(int ID, ThreadModifier modifier) {
        cloneFromDatabase(ID, modifier);
    }

    public int getID() {
        return ID;
    }

    public int getUserID() {
        return userID;
    }

    public Date getDateCreated() {
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
    public void cloneFromDatabase(int ID, Modifier modifier) {

    }

    @Override
    public void updateToDatabase(Modifier modifier) {

    }
}
