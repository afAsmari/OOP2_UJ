package org.example.serveces.crud;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static org.example.Constants.arr.healthConditions;

public class DatabaseHandler {
    Connection connection;
    Statement statement;

    public DatabaseHandler() {
        // check if the database exists
        String databasePath = "src/main/databases/hospital.db";
        File databaseFile = new File(databasePath);
        if(!databaseFile.exists()){
            try{
                databaseFile.createNewFile();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }

        // creating tables
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/databases/hospital.db");
            statement = connection.createStatement();
            String createPatientsTable = createPatientsTable();
            statement.executeUpdate(createPatientsTable);
            String createSettingsTable = createSettingsTable();
            statement.executeUpdate(createSettingsTable);
            statement.executeUpdate(insertDefaultSetting());
            connection.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }


    }

    private String createPatientsTable(){
        StringBuilder query = new StringBuilder();
        query.append("CREATE TABLE IF NOT EXISTS patients (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name VARCHAR(255) NOT NULL UNIQUE," +
                    "date DATETIME NOT NULL," +
                    "age INTEGER NOT NULL,");
        for(int i = 0; i < healthConditions.length; i++){
            //TODO make the default false
            query.append(healthConditions[i] + " BOOLEAN,");
        }
        query.deleteCharAt(query.length() - 1);
        query.append(");");

        return query.toString();
    }

    private String createSettingsTable(){
        StringBuilder query = new StringBuilder();
        query.append("CREATE TABLE IF NOT EXISTS settings(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "color VARCHAR(255) NOT NULL," +
                    "style VARCHAR(255) NOT NULL," +
                    "size VARCHAR(255) NOT NULL);"
                );
        return query.toString();
    }

    private String insertDefaultSetting(){
        StringBuilder query = new StringBuilder();

        query.append("INSERT INTO settings " +
                    "(color, style, size) " +
                    "SELECT 'black','SansSerif','20' " +
                    "WHERE NOT EXISTS (SELECT * FROM settings);"
                );
        return query.toString();
    }

    static private int executeQuery(String query){
        int status = 0;
        new DatabaseHandler();
        try{
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/databases/hospital.db");
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
            status = 1;
        }
        return status;
    }

    static public void insertOrUpdateQueriesBuilder(HashMap<String, Object> map, String table){
        StringBuilder query = new StringBuilder();
        StringBuilder columns = new StringBuilder();
        StringBuilder values = new StringBuilder();
        columns.append(table);
        values.append(" VALUES (");
        for(Map.Entry<String, Object> entry : map.entrySet()){
            columns.append(entry.getKey() + ",");
            values.append("'" + entry.getValue() + "'" + ",");
        }
        columns.deleteCharAt(columns.length() - 1);
        values.deleteCharAt(values.length() - 1);
        columns.append(")");
        values.append(")");
        query.append(columns);
        query.append(values);

        executeQuery(query.toString());
    }

    static public void updateATable(HashMap<String, Object> map, String table, String condition){
        StringBuilder query = new StringBuilder();
        query.append(table);
        query.append(" SET ");
        for(Map.Entry<String, Object> entry : map.entrySet()){
            query.append(entry.getKey());
            query.append(" = ");
            query.append("'" + entry.getValue() + "'");
            query.append(",");
        }
        query.deleteCharAt(query.length() - 1);
        query.append(" WHERE ").append(condition).append(";");

        executeQuery(query.toString());
    }

    static public int[] selectForContext(String query){
        ResultSet resultSet = null;

        try{
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/databases/hospital.db");
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                int[] context = {resultSet.getInt("color"), resultSet.getInt("style"), resultSet.getInt("size")};
                return context;
            }
            connection.close();
            return null;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
