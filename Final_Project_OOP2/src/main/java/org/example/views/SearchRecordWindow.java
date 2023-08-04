package org.example.views;

import org.example.CostumeWidgets.Button;
import org.example.CostumeWidgets.Label;
import org.example.CostumeWidgets.TextField;
import org.example.Main;
import org.example.serveces.crud.DatabaseHandler;
import org.example.views.subViews.ShowRecordsPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import static org.example.serveces.crud.DatabaseHandler.SelectForRecordSearch;

public class SearchRecordWindow extends JFrame {
    static HashMap<String, Object> map;
    Label contactNumber = new Label("Contact Number: ");
    TextField contactNumberTextField = new TextField(8);
    Button searchButton = new Button("Search");
    JPanel mainPanel = new JPanel();
    JPanel topPanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    public SearchRecordWindow(){
        // main configurations
        this.setSize(400,300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Search a Patient");

        searchButton.addActionListener(new SearchAction());

        topPanel.setLayout(new GridLayout(0, 2));
        topPanel.add(contactNumber);
        topPanel.add(contactNumberTextField);
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(searchButton);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(bottomPanel, BorderLayout.CENTER);

        this.add(mainPanel);
        this.setVisible(true);
    }

    private class SearchAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            // TODO validation
            if(contactNumberTextField.getText().isEmpty())
                new ExceptionWindow("please enter a valid contact number");
            else{
                // TODO passing query
                StringBuilder query = new StringBuilder();
                query.append("SELECT * FROM records WHERE contact_number = ").append(contactNumberTextField.getText()).append(";");
                SearchRecordWindow.map = SelectForRecordSearch(query.toString());
                swapPanel();
            }
        }
        protected void swapPanel(){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    MainWindow.bottomPanel.remove(0);
                    MainWindow.bottomPanel.add(new ShowRecordsPanel(SearchRecordWindow.map));
                    MainWindow.bottomPanel.revalidate();
                    MainWindow.bottomPanel.repaint();
                    //MainWindow.bottomPanel.invalidate();
                    //MainWindow.bottomPanel.validate();
                }
            });
        }
    }
}
