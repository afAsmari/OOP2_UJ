package org.example.views;

import org.example.Context;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {
    JLabel emailLabel, passwordLabel;
    JTextField emailTextField;
    JPasswordField passwordTextField;
    JButton loginButton;
    JPanel mainPanel, topPanel, centerPanel, bottomPanel;

    public LoginWindow (Context context){
        // main configurations
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Login");

        mainPanel = new JPanel(new GridLayout(3, 0));
        topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        emailLabel = new JLabel("Email: ");
        passwordLabel = new JLabel("Password: ");

        emailTextField = new JTextField(10);
        passwordTextField = new JPasswordField(10);

        loginButton = new JButton("Login");

        loginButton.addActionListener(new LoginAction());

        emailLabel.setForeground(context.color);
        emailLabel.setFont(context.font);

        passwordLabel.setForeground(context.color);
        passwordLabel.setFont(context.font);

        emailTextField.setForeground(context.color);
        emailTextField.setFont(context.font);

        passwordTextField.setForeground(context.color);
        passwordTextField.setFont(context.font);

        loginButton.setForeground(context.color);
        loginButton.setFont(context.font);

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
            //TODO AUTHENTICATION
        }
    }
}
