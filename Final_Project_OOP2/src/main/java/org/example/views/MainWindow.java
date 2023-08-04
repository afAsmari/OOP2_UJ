package org.example.views;

import org.example.CostumeWidgets.*;
import org.example.views.subViews.PatientRegistrationForm;
import org.example.views.subViews.ShowRecordsPanel;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class MainWindow extends JFrame {
    MenuBar menuBar = new MenuBar();
    Menu fileMenu = new Menu("File");
    Menu viewMenu = new Menu("View");
    Menu helpMenu = new Menu("Help");
    Menu exitProgram = new Menu("Exit");

    MenuItem newPatientItem = new MenuItem("New Patient Record");
    MenuItem openPatientItem = new MenuItem("Open Patient Record");
    MenuItem printPatientItem = new MenuItem("Print Patient Record");

    MenuItem settingMenuItem = new MenuItem("Change Appearance");
    MenuItem changePasswordMenuItem = new MenuItem("change password");

    MenuItem guideMenuItem = new MenuItem("User Guide");
    MenuItem aboutMenuItem = new MenuItem("About");
    MenuItem contactItem = new MenuItem("Contact support");

    MenuItem exitItem = new MenuItem("Exit");

    JPanel mainPanel = new JPanel();
    static JPanel bottomPanel = new JPanel();
    static PatientRegistrationForm patientForm = new PatientRegistrationForm();

    public MainWindow(){
        // main configurations
        this.setSize(1000,450);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Welcome");

        fileMenu.add(newPatientItem);
        fileMenu.add(openPatientItem);
        fileMenu.add(printPatientItem);

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

        newPatientItem.addActionListener(new newPatientFormAction());
        openPatientItem.addActionListener(new showRecordAction());
        settingMenuItem.addActionListener(new openSettingsWindowAction());
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

    private class newPatientFormAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    MainWindow.bottomPanel.remove(0);
                    MainWindow.bottomPanel.add(patientForm);
                    MainWindow.bottomPanel.revalidate();
                    MainWindow.bottomPanel.repaint();
                    //MainWindow.bottomPanel.invalidate();
                    //MainWindow.bottomPanel.validate();
                }
            });
        }
    }

    private static class showRecordAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            new SearchRecordWindow();
        }
    }

    private static class openSettingsWindowAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            new SettingsWindow();
        }
    }

}
