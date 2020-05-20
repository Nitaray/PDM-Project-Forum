package backend.component;

import backend.modify.Modifier;
import backend.query.Querier;

public interface forumRelation {
    public void addToDatabase(Modifier modifier);
    public void removeFromDatabase(Modifier modifier);
    public void cloneFromDatabase(int ID, Querier querier);
    public void updateToDatabase(Modifier modifier);
}
