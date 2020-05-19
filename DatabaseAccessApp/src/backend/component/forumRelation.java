package backend.component;

import backend.modify.Modifier;

public interface forumRelation {
    public void addToDatabase(Modifier modifier);
    public void removeFromDatabase(Modifier modifier);
    public void cloneFromDatabase(int ID, Modifier modifier);
    public void updateToDatabase(Modifier modifier);
}
