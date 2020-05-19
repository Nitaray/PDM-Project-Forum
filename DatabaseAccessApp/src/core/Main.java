package core;

import backend.auth.UserAuthenticator;
import backend.modify.UserModifier;
import gui.Window;
import javafx.util.Pair;

import java.util.ArrayList;


public class Main {
    private static final String URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=Forum;"
            + "integratedSecurity=True;";
    private static final String username = "forumApp";
    private static final String password = "123456789";

    public static void main(String[] args) {
        DatabaseConnectionManager.init(URL, username, password);
//        UserModifier userModifier = new UserModifier(DatabaseConnectionManager.getDBConnection());
//        UserAuthenticator auth = new UserAuthenticator(DatabaseConnectionManager.getDBConnection());
//        userModifier.updatePassword(1, "8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92");
//        System.out.println(auth.auth("NLNGUYEN", "123456"));
//        Window.start(args);
    }
}
