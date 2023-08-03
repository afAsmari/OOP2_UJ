package org.example.CostumeWidgets;

import org.example.Context;

import javax.swing.*;

public class RadioButton extends JRadioButton {
    public RadioButton(String text){
        super(text);
        setForeground(Context.color);
        setFont(Context.font);
    }
    public RadioButton(String text, boolean selected){
        super(text, selected);
        setForeground(Context.color);
        setFont(Context.font);
    }
}
