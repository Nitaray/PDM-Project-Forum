package backend.component;

import backend.modify.Modifier;
import backend.modify.RoleModifier;
import backend.query.Querier;

public class Role implements forumRelation{
    private int ID;
    private String roleName;

    public Role(int ID, String roleName) {
        this.ID = ID;
        this.roleName = roleName;
    }

    public int getID() {
        return ID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
