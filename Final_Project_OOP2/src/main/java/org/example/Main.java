package org.example;

import org.example.serveces.crud.ContextRetriever;
import org.example.serveces.crud.DatabaseHandler;
import org.example.views.LoginWindow;
import org.example.views.MainWindow;
import org.example.views.SettingsWindow;

public class Main {
    public static void main(String[] args) {
        new DatabaseHandler();
        new ContextRetriever();
        new MainWindow();
    }
}