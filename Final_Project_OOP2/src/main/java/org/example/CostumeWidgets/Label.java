package org.example.CostumeWidgets;

import org.example.Context;

import javax.swing.*;

public class Label extends JLabel {
    public Label(String text){
        super(text);
        setForeground(Context.color);
        setFont(Context.font);
    }
    public Label(){
        setForeground(Context.color);
        setFont(Context.font);
    }
}
