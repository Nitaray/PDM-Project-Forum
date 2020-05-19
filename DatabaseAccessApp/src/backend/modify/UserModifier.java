package backend.modify;

import java.sql.*;
import java.util.Date;

public class UserModifier extends Modifier {

    public UserModifier(Connection connection) {
        super(connection);

        fields.put("Username", 1);
        fields.put("Email", 2);
        fields.put("FirstName", 3);
        fields.put("LastName", 4);
        fields.put("DateOfBirth", 5);
        fields.put("Gender", 6);
        fields.put("Country", 7);
        fields.put("Password", 8);
        fields.put("About", 9);
        fields.put("RoleID", 10);

        addSQL = "INSERT INTO \"User\" (Username, Email, FirstName, LastName, DateOfBirth, Gender, Country, Password, About, RoleID)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        removeSQL = "DELETE FROM \"User\" WHERE UserID = ?";
        updateSQL = "UPDATE \"User\" SET" +
                " Username = ?," +
                " Email = ?," +
                " FirstName = ?," +
                " LastName = ?," +
                " DateOfBirth = ?," +
                " Status = ?," +
                " RegistrationDate = ?," +
                " Gender = ?," +
                " Country = ?," +
                " Password = ?," +
                " About = ?," +
                " RoleID = ?" +
                " WHERE UserID = ?";

        try {
            addStatement = connection.prepareStatement(addSQL);
            removeStatement = connection.prepareStatement(removeSQL);
            updateStatement = connection.prepareStatement(updateSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean updateUsername(int ID, String newUsername) {
        String SQL = "UPDATE \"User\" SET Username = ? WHERE UserID = ?";
        return updateField(ID, newUsername, SQL);
    }

    public boolean updateEmail(int ID, String newEmail) {
        String SQL = "UPDATE \"User\" SET Email = ? WHERE UserID = ?";
        return updateField(ID, newEmail, SQL);
    }

    public boolean updateFirstName(int ID, String newFirstName) {
        String SQL = "UPDATE \"User\" SET FirstName = ? WHERE UserID = ?";
        return updateField(ID, newFirstName, SQL);
    }

    public boolean updateLastName(int ID, String newLastName) {
        String SQL = "UPDATE \"User\" SET LastName = ? WHERE UserID = ?";
        return updateField(ID, newLastName, SQL);
    }

    public boolean updateDOB(int ID, Date newDOB) {
        String SQL = "UPDATE \"User\" SET DateOfBirth = ? WHERE UserID = ?";
        java.sql.Date dob = new java.sql.Date(newDOB.getTime());
        return updateField(ID, dob, SQL);
    }

    public boolean updateStatus(int ID, String newStatus) {
        String SQL = "UPDATE \"User\" SET Status = ? WHERE UserID = ?";
        return updateField(ID, newStatus, SQL);
    }

    public boolean updateGender(int ID, String newGender) {
        String SQL = "UPDATE \"User\" SET Gender = ? WHERE UserID = ?";
        return updateField(ID, newGender, SQL);
    }

    public boolean updateCountry(int ID, String newCountry) {
        String SQL = "UPDATE \"User\" SET Country = ? WHERE UserID = ?";
        return updateField(ID, newCountry, SQL);
    }

    public boolean updatePassword(int ID, String newPassword) {
        String SQL = "UPDATE \"User\" SET Password = ? WHERE UserID = ?";
        return updateField(ID, newPassword, SQL);
    }

    public boolean updateAbout(int ID, String newAbout) {
        String SQL = "UPDATE \"User\" SET LastName = ? WHERE UserID = ?";
        return updateField(ID, newAbout, SQL);
    }

    public boolean updateRole(int ID, int newRoleID) {
        String SQL = "UPDATE \"User\" SET RoleID = ? WHERE UserID = ?";
        return updateField(ID, newRoleID, SQL);
    }
}
