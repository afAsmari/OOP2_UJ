package org.example.CostumeWidgets;

import org.example.Context;
import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;

public class TextArea extends JTextArea {
    public TextArea(int rows, int columns){
        super(rows, columns);
        setForeground(Context.color);
        setFont(Context.font);
    }
    public TextArea(){
        setSize(new Dimension(8, 3));
        setEditable(false);
        setLineWrap(true);
        setWrapStyleWord(true);
        setForeground(Context.color);
        setFont(Context.font);
    }
}
