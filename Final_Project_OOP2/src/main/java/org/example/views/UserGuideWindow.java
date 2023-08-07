package org.example.views;

import org.example.CostumeWidgets.Label;

import java.awt.FlowLayout;
import javax.swing.*;

public class UserGuideWindow extends JFrame {
    private Label label;

    public UserGuideWindow(){
        setTitle("UserGuide");
        setSize(540,240);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout( new FlowLayout());
        label = new Label("in this program we register the new Patients and "
                + "u can adjust the size of text and the colors");
        add(label);
        pack();
        setVisible(true);
    }
}