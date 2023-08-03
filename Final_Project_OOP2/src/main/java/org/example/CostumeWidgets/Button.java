package org.example.CostumeWidgets;

import org.example.Context;

import javax.swing.*;

public class Button extends JButton {
    public Button(String text){
        super(text);
        setForeground(Context.color);
        setFont(Context.font);
    }
}
