package core;

import gui.Window;

public class Main {
    private static final String URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=Forum;"
            + "integratedSecurity=True;";
    private static final String username = "forumApp";
    private static final String password = "123456789";

    public static void main(String[] args) {
        DatabaseConnectionManager.init(URL, username, password);
        Window.start(args);
    }
}
