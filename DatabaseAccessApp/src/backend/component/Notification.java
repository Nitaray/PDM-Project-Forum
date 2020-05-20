package backend.component;

import backend.modify.Modifier;
import backend.modify.NotificationModifier;
import backend.query.Querier;

import java.sql.Date;

public class Notification implements forumRelation{
    private int ID;
    private Date dateSent;
    private String content;

    public Notification(int ID, Date dateSent, String content) {
        this.ID = ID;
        this.dateSent = dateSent;
        this.content = content;
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
    public void cloneFromDatabase(int ID, Querier querier) {

    }

    @Override
    public void updateToDatabase(Modifier modifier) {

    }
}
