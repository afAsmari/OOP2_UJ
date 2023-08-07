package org.example.CostumeWidgets;

import org.example.Context;

import javax.swing.*;

public class TextField extends JTextField {
    public TextField(int columns){
        super(columns);
        setForeground(Context.color);
        setFont(Context.font);
    }
    public TextField(){
        setColumns(8);
        setEditable(false);
        setForeground(Context.color);
        setFont(Context.font);

    }
}
