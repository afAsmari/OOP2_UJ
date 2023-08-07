package org.example.serveces.auth;

import org.example.serveces.crud.DatabaseHandler;

public class Auth_service {

    static public boolean login(String email, String password){
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM doctors where email = ").append("'").append(email).append("'").append(" AND password = ").append("'").append(password).append("';");
        boolean loggedIn = DatabaseHandler.SelectForAuth(query.toString());
        if(loggedIn)
            return true;
        return false;
    }

    static public boolean checkPassword(final String password) {
        final StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM doctors WHERE password = '").append(password).append("';");
        final boolean correctPassword = DatabaseHandler.SelectForAuth(query.toString());
        return correctPassword;
    }

}
