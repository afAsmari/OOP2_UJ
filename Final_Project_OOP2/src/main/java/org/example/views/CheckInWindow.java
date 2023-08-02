package org.example.views;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import static org.example.Constants.arr.healthConditions;

public class CheckInWindow extends JFrame {
    JLabel doctorName, patientName;
    JPanel mainPanel, topPanel, topRightSidePanel, topLeftSidePanel, bottomPanel;
    Map<String, Object> map;
    JButton button = new JButton("click");

    public CheckInWindow(){
        // main configurations
        this.setSize(1600,1000);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("new Check In");


        doctorName = new JLabel("Doctor: " + "aaaa");
        patientName = new JLabel("Patient: " + "bbbbbb");

        doctorName.setForeground(Color.BLACK);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 0));
        mainPanel.add(patientName);
        mainPanel.add(doctorName);
        mainPanel.add(button);
        button.addActionListener(new healthConditionWindowActivate());
        this.add(mainPanel);

        this.setVisible(true);
    }
    private class healthConditionWindowActivate implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            healthConditionsWindow HCW = new healthConditionsWindow();
            map = HCW.getMap();
        }
    }
}
