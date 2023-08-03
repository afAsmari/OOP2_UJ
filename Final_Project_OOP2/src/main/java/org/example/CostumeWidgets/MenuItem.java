package org.example.CostumeWidgets;

import org.example.Context;

import javax.swing.*;

public class MenuItem extends JMenuItem {
    public MenuItem(String text){
        super(text);
        setForeground(Context.color);
        setFont(Context.font);
    }
}
