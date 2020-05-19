package backend.component;

import backend.auth.AuthUtil;
import backend.modify.Modifier;
import backend.modify.UserModifier;

import java.sql.Date;

public class User implements forumRelation{
    private static final int passMOD = 31;

    private int ID;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String status;
    private Date registrationDate;
    private String gender;
    private String country;
    private String password;
    private String about;
    private int roleID;

    public User(String username, String email, String firstName, String lastName, Date dateOfBirth,
                String gender, String country, String password, String about, int roleID) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.status = "Active";
        this.registrationDate = new Date(new java.util.Date().getTime());
        this.gender = gender;
        this.country = country;
        this.password = password;
        this.about = about;
        this.roleID = roleID;
        initPassword();
    }

    public User(int ID, UserModifier modifier) {
        this.ID = ID;
        cloneFromDatabase(ID, modifier);
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getStatus() {
        return status;
    }

    public Date getRegistrationDate() {
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

    public void setDateOfBirth(Date dateOfBirth) {
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

    private void initPassword() {
        long loops = registrationDate.getTime() % (ID % passMOD);
        for (int i = 0; i < loops; i++)
            SaltHashPassword();
    }

    private void SaltHashPassword() {
        password = AuthUtil.hashString(registrationDate.toString() + password + ID);
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
