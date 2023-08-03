package org.example.serveces.crud;

public class Auth_service {

    static public boolean login(String email, String password){
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM doctors where email = ").append("'").append(email).append("'").append(" AND password = ").append("'").append(password).append("';");
        boolean loggedIn = DatabaseHandler.SelectForAuth(query.toString());
        if(loggedIn == true)
            return true;
        return false;
    }
}
