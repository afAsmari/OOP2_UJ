package org.example.views;

import org.example.Main;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenu viewMenu = new JMenu("View");
    JMenu helpMenu= new JMenu("Help");

    JMenuItem newPatient = new JMenuItem("New Patient Record");
    JMenuItem openPatient = new JMenuItem("Open Patient Record");
    JMenuItem printPatient = new JMenuItem("Print Patient Record");

    JMenuItem settingMenuItem = new JMenuItem("Change Appearance");
    JMenuItem changePasswordMenuItem = new JMenuItem("change password");

    JMenuItem guideMenuItem = new JMenuItem("User Guide");
    JMenuItem aboutMenuItem = new JMenuItem("About");
    JMenuItem contactItem = new JMenuItem("Contact support");


    JPanel mainPanel = new JPanel();
    public MainWindow(){
        // main configurations
        this.setSize(1600,1000);
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

        menuBar.add(fileMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);
        mainPanel.add(menuBar);
        this.add(mainPanel);
        this.setVisible(true);
    }
}
