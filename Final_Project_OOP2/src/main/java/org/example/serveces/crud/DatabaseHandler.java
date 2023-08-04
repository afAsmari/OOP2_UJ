package org.example.serveces.crud;

import org.example.serveces.fake_service.CreateFakeDate;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static org.example.Constants.arr.healthConditions;

public class DatabaseHandler {
    static Connection connection;
    static Statement statement;

    // TODO HUGE PROBLEM closing connection should be in the finally clause
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
            statement.executeUpdate(createPatientsRecord());
            statement.executeUpdate(insertDefaultSetting());
            new CreateFakeDate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try{
                connection.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }

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

    private String createPatientsRecord(){
        StringBuilder query = new StringBuilder();
        query.append("CREATE TABLE IF NOT EXISTS records(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "first_name VARCHAR(255) NOT NULL," +
                    "last_name VARCHAR(255) NOT NULL," +
                    "date_of_birth VARCHAR(255)," +
                    "gender VARCHAR(255) NOT NULL," +
                    "address VARCHAR(255)," +
                    "email VARCHAR(255)," +
                    "contact_number VARCHAR(255) NOT NULL UNIQUE," +
                    "emergency_contact VARCHAR(255),"+
                    "medical_history VARCHAR(1000));"
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
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/databases/hospital.db");
            statement = connection.createStatement();
            statement.executeUpdate(query);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            status = 1;
        }finally {
            try{
                connection.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
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
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/databases/hospital.db");
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                int[] context = {resultSet.getInt("color"), resultSet.getInt("style"), resultSet.getInt("size")};
                connection.close();
                return context;
            }

            return null;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try{
                connection.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    static public boolean SelectForAuth(String query){
        boolean status = false;
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/databases/hospital.db");
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                status = true;
            }
            connection.close();
            return status;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try{
                connection.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return status;
    }

    static public HashMap<String, Object> SelectForRecordSearch(String query){
        HashMap<String, Object> map = new HashMap<>();
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/databases/hospital.db");
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                Object firstname = resultSet.getObject("first_name");
                if(!resultSet.wasNull())
                    map.put("first_name", firstname);
                Object lastname = resultSet.getObject("last_name");
                if(!resultSet.wasNull())
                    map.put("last_name", lastname);
                Object dateOfBirth = resultSet.getObject("date_of_birth");
                if(!resultSet.wasNull())
                    map.put("date_of_birth", dateOfBirth);
                Object gender = resultSet.getObject("gender");
                if(!resultSet.wasNull())
                    map.put("gender", gender);
                Object address = resultSet.getObject("address");
                if(!resultSet.wasNull())
                    map.put("address", address);
                Object email = resultSet.getObject("email");
                if(!resultSet.wasNull())
                    map.put("email", email);
                Object contactNumber = resultSet.getObject("contact_number");
                if(!resultSet.wasNull())
                    map.put("contact_number", contactNumber);
                Object emergencyContact = resultSet.getObject("emergency_contact");
                if(!resultSet.wasNull())
                    map.put("emergency_contact", emergencyContact);
                Object medicalHistory = resultSet.getObject("medical_history");
                if(!resultSet.wasNull())
                    map.put("medical_history", medicalHistory);
            }
            connection.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try{
                connection.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return map;
    }
}
