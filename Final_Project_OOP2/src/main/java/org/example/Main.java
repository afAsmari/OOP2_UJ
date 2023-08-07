package org.example;

import org.example.serveces.crud.ContextRetriever;
import org.example.serveces.crud.DatabaseHandler;
import org.example.views.MainWindow;

public class Main {
    public static void main(String[] args) {
        new DatabaseHandler();
        new ContextRetriever();
        Context.mainWindow = new MainWindow();
    }
}