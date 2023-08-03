package org.example.CostumeWidgets;

import org.example.Context;
import org.w3c.dom.Text;

import javax.swing.*;

public class TextArea extends JTextArea {
    public TextArea(int rows, int columns){
        super(rows, columns);
        setForeground(Context.color);
        setFont(Context.font);
    }
}
