package org.example.CostumeWidgets;

import org.example.Context;

import javax.swing.*;

public class CheckBox extends JCheckBox {
    public CheckBox(String text){
        super(text);
        setForeground(Context.color);
        setFont(Context.font);
    }
    public CheckBox(String text, boolean selected){
        super(text, selected);
        setForeground(Context.color);
        setFont(Context.font);
    }
}
