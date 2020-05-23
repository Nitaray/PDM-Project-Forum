package backend.component;

import backend.auth.AuthUtil;
import backend.modify.Modifier;
import backend.query.Querier;

import java.sql.Date;
import java.sql.Timestamp;

public class User implements forumRelation{
    private static final int passMOD = 31;

    private int ID;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private Timestamp dateOfBirth;
    private String status;
    private Timestamp registrationDate;
    private String gender;
    private String country;
    private String password;
    private String about;
    private int roleID;

    public User(int id, String username, String email, String firstName, String lastName, Timestamp dateOfBirth,
                String status, Timestamp registrationDate, String gender, String country, String password, String about, int roleID) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
        this.registrationDate = registrationDate;
        this.gender = gender;
        this.country = country;
        this.password = password;
        this.about = about;
        this.roleID = roleID;
    }

    public int getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public String getStatus() {
        return status;
    }

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    public String getPassword() {
        return password;
    }

    public String getAbout() {
        return about;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
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
