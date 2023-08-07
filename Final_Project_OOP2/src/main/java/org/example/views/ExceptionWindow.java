package org.example.views;

import javax.swing.*;
import java.awt.*;

public class ExceptionWindow extends JFrame {
    JPanel mainPanel = new JPanel();
    JLabel exceptionLabel = new JLabel();
    public ExceptionWindow(String exception){
        // main configurations
        this.setSize(300,300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("an ERROR has occurred ");

        exceptionLabel.setText(exception);
        exceptionLabel.setForeground(Color.RED);
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        mainPanel.add(exceptionLabel);
        this.add(mainPanel);
        this.pack();
        this.setVisible(true);
    }
}
