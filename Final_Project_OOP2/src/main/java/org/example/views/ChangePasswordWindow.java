package org.example.views;

import org.example.CostumeWidgets.Button;
import org.example.CostumeWidgets.Label;
import org.example.CostumeWidgets.PasswordField;
import org.example.serveces.auth.Auth_service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.jar.JarEntry;

import static org.example.serveces.crud.insertOrUpdateQueriesBuilder.updateDoctorsTable;

public class ChangePasswordWindow extends JFrame {
    Label currentPassword, newPassword;
    PasswordField currentPasswordField, newPasswordField;
    Button saveButton;
    JPanel mainPanel, topTopPanel, topPanel, centerPanel, bottomPanel;
    ChangePasswordWindow(){
        this.setSize(800, 200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Change Password");

        currentPassword = new Label("Current Password:");
        newPassword = new Label("New Password:");
        currentPasswordField = new PasswordField(8);
        newPasswordField = new PasswordField(8);
        saveButton = new Button("Save");
        saveButton.addActionListener(new SaveNewPassword());

        mainPanel = new JPanel(new BorderLayout());
        topPanel = new JPanel(new GridLayout(0, 2));
        centerPanel = new JPanel(new GridLayout(0, 2));
        bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topTopPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        topPanel.add(currentPassword);
        topPanel.add(currentPasswordField);
        centerPanel.add(newPassword);
        centerPanel.add(newPasswordField);
        bottomPanel.add(saveButton);
        topTopPanel.add(topPanel);
        topTopPanel.add(centerPanel);
        mainPanel.add(topTopPanel, BorderLayout.NORTH);
        mainPanel.add(bottomPanel, BorderLayout.CENTER);
        this.add(mainPanel);
        this.pack();
        this.setVisible(true);
    }

    private class SaveNewPassword implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            HashMap<String, Object> map = new HashMap<>();
            boolean correctPassword = Auth_service.checkPassword(currentPasswordField.getText());
            if(correctPassword){
                map.put("password", newPasswordField.getText());
                updateDoctorsTable(map);
            }else{
                new ExceptionWindow("please enter the correct password");
            }
        }
    }
}