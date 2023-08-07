package org.example.views;

import org.example.CostumeWidgets.Label;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class Contact_Support_Window extends JFrame {
    private Label label;
    private Label label2;
    JPanel mainPanel = new JPanel(new GridLayout(2, 0));

    public Contact_Support_Window(){
        setLayout( new FlowLayout(FlowLayout.LEFT,10, 7));
        setTitle("Contact");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        label = new Label ("at this email : hospital@gmail.com");
        label2 = new Label("or at this number : 0532185495");
        mainPanel.add(label);
        mainPanel.add(label2);
        this.add(mainPanel);
        pack();
        setVisible(true);

    }

}