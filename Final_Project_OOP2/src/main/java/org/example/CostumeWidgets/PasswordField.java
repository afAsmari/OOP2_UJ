package org.example.CostumeWidgets;

import org.example.Context;

import javax.swing.*;

public class PasswordField extends JPasswordField {
    public PasswordField(int columns){
        super(columns);
        setForeground(Context.color);
        setFont(Context.font);
    }
}
