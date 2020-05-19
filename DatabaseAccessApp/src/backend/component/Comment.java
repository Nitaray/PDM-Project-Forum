package backend.component;

import backend.modify.CommentModifier;
import backend.modify.Modifier;

import java.sql.Connection;
import java.sql.Date;

public class Comment implements forumRelation{
    private int ID;
    private int creatorID;
    private int threadID;
    private Date dateCreated;
    private String content;

    public Comment(int creatorID, int threadID, String content) {
        this.creatorID = creatorID;
        this.threadID = threadID;
        this.dateCreated = new java.sql.Date(new java.util.Date().getTime());
        this.content = content;
    }

    public Comment(int ID, CommentModifier modifier) {
        cloneFromDatabase(ID, modifier);
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

    public Date getDateCreated() {
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
    public void cloneFromDatabase(int ID, Modifier modifier) {

    }

    @Override
    public void updateToDatabase(Modifier modifier) {

    }
}
