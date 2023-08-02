package org.example.views;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static org.example.Constants.arr.healthConditions;
public class healthConditionsWindow extends JFrame {
    JPanel mainPanel;
    Map<String, Object> map;
    healthConditionsWindow(){
        this.setSize(400,600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("new Check In");

        map = new HashMap<>();

        mainPanel = new JPanel();


        for(int i = 0; i < healthConditions.length; i++){
            mainPanel.add(new JCheckBox(healthConditions[i]));
        }

        this.add(mainPanel);

        this.setVisible(true);
    }
    public Map<String, Object> getMap() {
        return map;
    }
}
