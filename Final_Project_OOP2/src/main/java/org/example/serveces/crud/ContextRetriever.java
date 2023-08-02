package org.example.serveces.crud;

import org.example.Context;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.serveces.crud.DatabaseHandler.selectForContext;

public class ContextRetriever {
    public ContextRetriever(Context context){
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM settings WHERE id=1;");
        int[] columns = selectForContext(query.toString());

        try{
            int color;
            assert columns != null;
            color = columns[0];
            if(color == 0)
                context.color = Color.black;
            else if (color == 1)
                context.color = Color.darkGray;
            else if (color == 2)
                context.color = Color.orange;
            context.font = new Font(Font.SANS_SERIF, columns[1], columns[2]);
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
