package org.example.views;


import org.example.CostumeWidgets.Label;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class AboutWindow extends JFrame {
    private Label label;

    public AboutWindow(){
        setTitle("About");
        setSize(500,200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout( new FlowLayout(FlowLayout.CENTER));
        label = new Label ("This program belongs to the hospital all right reserved");

        add(label);
        pack();
        setVisible(true);
    }

}



