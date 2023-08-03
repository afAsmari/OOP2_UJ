package org.example.CostumeWidgets;

import org.example.Context;

import javax.swing.*;

public class Menu extends JMenu {
    public Menu(String text){
        super(text);
        setForeground(Context.color);
        setFont(Context.font);
    }
}
