package org.example.CostumeWidgets;

import org.example.Context;

import javax.swing.*;

public class List extends JList {
    public List(String[] arr){
        super(arr);
        setForeground(Context.color);
        setFont(Context.font);
    }
}
