package org.example.serveces.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateFakeDate {
    Connection connection;
    Statement statement;
    public  CreateFakeDate(){
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/databases/hospital.db");
            statement = connection.createStatement();
            String createTable = createFakeTable();
            statement.executeUpdate(createTable);
            String insertToTable = insertToFakeTable();
            statement.executeUpdate(insertToTable);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private String createFakeTable(){
        StringBuilder query = new StringBuilder();
        query.append("CREATE TABLE IF NOT EXISTS doctors (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name VARCHAR(255) NOT NULL," +
                    "email VARCHAR(255) NOT NULL," +
                    "password VARCHAR(255) NOT NULL);"
        );
        return query.toString();
    }

    private String insertToFakeTable(){
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO doctors " +
                    "(name, email, password) " +
                    "VALUES (" + "'" + "Lujain" + "','" + "LujainTahiyatDaher@armyspy.com','" + "nie0Ouj0ei0');"
        );
        return query.toString();
    }

}
