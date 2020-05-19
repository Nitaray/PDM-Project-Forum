package backend.component;

import backend.modify.Modifier;
import backend.modify.RoleModifier;

import java.sql.Connection;

public class Role implements forumRelation{
    private int ID;
    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role(int ID, RoleModifier modifier) {
        cloneFromDatabase(ID, modifier);
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
    public void cloneFromDatabase(int ID, Modifier modifier) {

    }

    @Override
    public void updateToDatabase(Modifier modifier) {

    }
}
