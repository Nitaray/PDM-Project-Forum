package core;

public class UserSession {
    private static int userID = 0;
    private static String username = "";
    private static int userRoleID = 0;
    private static boolean loggedIn = false;

    public static int getUserID() {
        return userID;
    }

    public static void setUserID(int userID) {
        UserSession.userID = userID;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        UserSession.username = username;
    }

    public static int getUserRoleID() {
        return userRoleID;
    }

    public static void setUserRoleID(int userRoleID) {
        UserSession.userRoleID = userRoleID;
    }

    public static boolean isLoggedIn() {
        return loggedIn;
    }

    public static void setLoggedIn(boolean loggedIn) {
        UserSession.loggedIn = loggedIn;
    }

    public static void reset() {
        userID = 0;
        username = "";
        userRoleID = 0;
        loggedIn = false;
    }
}
