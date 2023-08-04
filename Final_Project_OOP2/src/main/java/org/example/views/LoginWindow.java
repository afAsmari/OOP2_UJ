package org.example.views;

import org.example.serveces.auth.Auth_service;
import org.example.CostumeWidgets.*;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {
    Label emailLabel, passwordLabel;
    TextField emailTextField;
    PasswordField passwordTextField;
    Button loginButton;
    JPanel mainPanel, topPanel, centerPanel, bottomPanel;

    public LoginWindow (){
        // main configurations
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Login");

        mainPanel = new JPanel(new GridLayout(3, 0));
        topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        emailLabel = new Label("Email: ");
        passwordLabel = new Label("Password: ");

        emailTextField = new TextField(10);
        passwordTextField = new PasswordField(10);

        loginButton = new Button("Login");

        loginButton.addActionListener(new LoginAction());

        topPanel.add(emailLabel);
        topPanel.add(emailTextField);

        centerPanel.add(passwordLabel);
        centerPanel.add(passwordTextField);

        bottomPanel.add(loginButton);

        mainPanel.add(topPanel);
        mainPanel.add(centerPanel);
        mainPanel.add(bottomPanel);

        this.add(mainPanel);
        this.setVisible(true);

    }

    private class LoginAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //TODO validation
            String email = emailTextField.getText();
            String password = passwordTextField.getText();
            if(!email.contains("@") || !email.contains("."))
                new ExceptionWindow("please write a valid email");
            else if(email.contains("'") || email.contains("\"") || email.contains(";") || email.contains("%") || email.contains("_"))
                new ExceptionWindow("please write a valid email");
            else if(password.length() < 8)
                new ExceptionWindow("Password must be more than 8 characters");
            else if(password.length() > 30)
                new ExceptionWindow("password must be less than 30 characters");
            else{
                //TODO AUTHENTICATION
                boolean loggedIn = Auth_service.login(email, password);
                if(!loggedIn)
                    new ExceptionWindow("Email or password is wrong");
                else{
                    LoginWindow.this.dispose();
                    new MainWindow();
                }


            }
        }
    }
}
