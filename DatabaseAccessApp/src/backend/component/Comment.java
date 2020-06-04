package backend.component;

import backend.modify.CommentModifier;
import backend.modify.Modifier;
import backend.query.Querier;

import java.sql.Date;
import java.sql.Timestamp;

public class Comment implements forumRelation{
    private int ID;
    private int creatorID;
    private int threadID;
    private Timestamp dateCreated;
    private String content;

    public Comment(int ID, int creatorID, Timestamp dateCreated, int threadID, String content) {
        this.ID = ID;
        this.creatorID = creatorID;
        this.threadID = threadID;
        this.dateCreated = dateCreated;
        this.content = content;
    }

    public int getID() {
        return ID;
    }

    public int getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(int creatorID) {
        this.creatorID = creatorID;
    }

    public int getThreadID() {
        return threadID;
    }

    public void setThreadID(int threadID) {
        this.threadID = threadID;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
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
