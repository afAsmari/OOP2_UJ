package org.example.serveces.crud;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class insertOrUpdateQueriesBuilder {
    static public void insertToPatientsTable(HashMap<String, Object> map){
        DatabaseHandler.insertOrUpdateQueriesBuilder(map, "INSERT INTO check_ins (");
    }

    static public void updateSettingsTable(HashMap<String, Object> map){
        DatabaseHandler.updateATable(map, "UPDATE settings", "id = 1");
    }
}
