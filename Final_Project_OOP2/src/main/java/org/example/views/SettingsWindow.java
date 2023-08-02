package org.example.views;

import org.example.Context;
import org.example.serveces.crud.insertOrUpdateQueriesBuilder;

import javax.print.attribute.standard.NumberOfInterveningJobs;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class SettingsWindow extends JFrame {
    Context context;
    JRadioButton black, darkGray, orange;
    ButtonGroup buttonGroup = new ButtonGroup();
    String[] style = {"Plain", "Bold", "Italic"};
    String [] size = {"20", "22", "24", "26", "28"};
    JComboBox<String> styleComboBox = new JComboBox<>(style);
    JComboBox<String> sizeComboBox = new JComboBox<>(size);
    JPanel mainPanel = new JPanel(new GridLayout(2,0));
    JPanel topPanel = new JPanel();
    JPanel radioButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel bottomPanel= new JPanel(new FlowLayout(FlowLayout.CENTER));
    JButton saveButton = new JButton("Save");
    public SettingsWindow(Context context){
        this.context = context;
        //main configurations
        this.setSize(300,300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Settings");

        black = new JRadioButton("Black", true);
        darkGray = new JRadioButton("Dark Gray");
        orange = new JRadioButton("Orange");
        buttonGroup.add(black);
        buttonGroup.add(darkGray);
        buttonGroup.add(orange);

        radioButtonPanel.add(black);
        radioButtonPanel.add(darkGray);
        radioButtonPanel.add(orange);

        topPanel.add(radioButtonPanel);
        topPanel.add(styleComboBox);
        topPanel.add(sizeComboBox);
        bottomPanel.add(saveButton);

        saveButton.addActionListener(new ButtonAction());


        mainPanel.add(topPanel);
        mainPanel.add(bottomPanel);
        this.add(mainPanel);
        this.setVisible(true);
    }

    private class ButtonAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            HashMap<String, Object> map = new HashMap<>();
            int newStyle = 0;
            int newSize = 20;
            int newColor = 0;
            Color color = new Color(0, 0, 0);;
            // default color is black
            if(black.isSelected())
                newColor = 0;
            else if(darkGray.isSelected())
                newColor = 1;
            else if(orange.isSelected())
                newColor = 2;
            if(styleComboBox.getSelectedItem() == (String) style[0])
                newStyle = 0;
            else if(styleComboBox.getSelectedItem() == (String) style[1])
                newStyle = 1;
            else if(styleComboBox.getSelectedItem() == (String) style[2])
                newStyle = 2;
            if(sizeComboBox.getSelectedItem() == (String) size[0])
                newSize = 20;
            else if(sizeComboBox.getSelectedItem() == (String) size[1])
                newSize = 22;
            else if(sizeComboBox.getSelectedItem() == (String) size[2])
                newSize = 24;
            else if(sizeComboBox.getSelectedItem() == (String) size[3])
                newSize = 26;
            else if(sizeComboBox.getSelectedItem() == (String) size[4])
                newSize = 28;

            if(newColor == 0)
                color = new Color(0, 0, 0);
            else if(newColor == 1)
                color = new Color(64, 64, 64);
            else if (newColor == 2)
                color = new Color(255, 200, 0);

            context.color = color;
            context.font = new Font(Font.SANS_SERIF, newStyle, newSize);

            map.put("color", newColor);
            map.put("style", newStyle);
            map.put("size", newSize);

            insertOrUpdateQueriesBuilder.updateSettingsTable(map);

        }
    }
}
