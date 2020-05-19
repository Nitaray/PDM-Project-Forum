package backend.component;

import backend.modify.Modifier;
import backend.modify.NotificationModifier;

import java.sql.Connection;
import java.sql.Date;

public class Notification implements forumRelation{
    private int ID;
    private Date dateSent;
    private String content;

    public Notification(String content) {
        this.dateSent = new Date(new java.util.Date().getTime());
        this.content = content;
    }

    public Notification(int ID, NotificationModifier modifier) {
        cloneFromDatabase(ID, modifier);
    }

    public int getID() {
        return ID;
    }

    public Date getDateSent() {
        return dateSent;
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
