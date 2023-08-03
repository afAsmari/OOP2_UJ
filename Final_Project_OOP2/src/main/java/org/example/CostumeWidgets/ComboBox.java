package org.example.CostumeWidgets;

import org.example.Context;

import javax.swing.*;

public class ComboBox extends JComboBox {
    public ComboBox(String[] arr){
        super(arr);
        setForeground(Context.color);
        setFont(Context.font);
    }
}
