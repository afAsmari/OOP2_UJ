package org.example.views;

import org.example.CostumeWidgets.*;
import org.example.views.subViews.PatientRegistrationForm;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    MenuBar menuBar = new MenuBar();
    Menu fileMenu = new Menu("File");
    Menu viewMenu = new Menu("View");
    Menu helpMenu = new Menu("Help");
    Menu exitProgram = new Menu("Exit");

    MenuItem newPatient = new MenuItem("New Patient Record");
    MenuItem openPatient = new MenuItem("Open Patient Record");
    MenuItem printPatient = new MenuItem("Print Patient Record");

    MenuItem settingMenuItem = new MenuItem("Change Appearance");
    MenuItem changePasswordMenuItem = new MenuItem("change password");

    MenuItem guideMenuItem = new MenuItem("User Guide");
    MenuItem aboutMenuItem = new MenuItem("About");
    MenuItem contactItem = new MenuItem("Contact support");

    MenuItem exitItem = new MenuItem("Exit");

    JPanel mainPanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    PatientRegistrationForm patientForm = new PatientRegistrationForm();

    public MainWindow(){
        // main configurations
        this.setSize(1000,450);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Welcome");

        fileMenu.add(newPatient);
        fileMenu.add(openPatient);
        fileMenu.add(printPatient);

        viewMenu.add(settingMenuItem);
        viewMenu.add(changePasswordMenuItem);

        helpMenu.add(guideMenuItem);
        helpMenu.add(aboutMenuItem);
        helpMenu.add(contactItem);

        exitProgram.add(exitItem);

        menuBar.add(fileMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);
        menuBar.add(exitProgram);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(menuBar, BorderLayout.NORTH);
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(patientForm);
        mainPanel.add(bottomPanel, BorderLayout.CENTER);

        exitItem.addActionListener(new ExitProgramAction());


        this.add(mainPanel);
        this.setVisible(true);
    }

    private static class ExitProgramAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.exit(1);
        }
    }

}
