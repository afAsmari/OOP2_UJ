import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainWindow extends JFrame {
    // declaration of universal objects and variables
    JPanel panel;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JList list;
    JComboBox comboBox;
    JSlider slider;
    JTextArea textArea;
    JScrollPane scrollPane;
    JTextField textField;
    JFileChooser fileChooser;
    JButton button;
    String[] cities = {"jeddah", "makkah", "abha"};;
    MainWindow(){
        // main configurations
        this.setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(".");

        // initialization of components
        panel = new JPanel();
        list = new JList(cities);
        label1 = new JLabel("choose a city");
        label1.setForeground(Color.BLACK);
        label2 = new JLabel("choose a city from the dropdown menu");
        label2.setForeground(Color.RED);
        label3 = new JLabel("move the slider");
        label3.setForeground(Color.BLUE);
        label4 = new JLabel();
        label4.setForeground(Color.ORANGE);

        comboBox = new JComboBox<>(cities);
        slider = new JSlider(0, 100);
        textArea = new JTextArea(5,5);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        textField = new JTextField(5);
        fileChooser = new JFileChooser();
        button = new JButton("select file");
        button.addActionListener(new buttonClick());
        // slider configurations
        slider.setOrientation(JSlider.HORIZONTAL);
        slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing(25);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        // adding components to the panel and frame
        panel.add(list);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(comboBox);
        panel.add(slider);
        panel.add(scrollPane);
        panel.add(textField);
        panel.add(button);
        panel.add(label4);
        this.add(panel);

        // adding event listeners
        list.addListSelectionListener(new citySelecter());
        comboBox.addActionListener(new comboSelecter());
        slider.addChangeListener(new sliderChanger());
        this.setVisible(true);
    }

    // creating event listeners as inner classes
    private class citySelecter implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent listSelectionEvent) {
            label1.setText(cities[list.getSelectedIndex()]);
        }
    }

    private class comboSelecter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            label2.setText((String) comboBox.getSelectedItem());
        }
    }

    private class sliderChanger implements ChangeListener{

        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            label3.setText(Integer.toString(slider.getValue()));
        }
    }

    private class buttonClick implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            int status = fileChooser.showOpenDialog(null);
            if(status == JFileChooser.APPROVE_OPTION){
                File selectedFile = fileChooser.getSelectedFile();
                String filename = selectedFile.getPath();
                fileChooser.cancelSelection();
                label4.setText(filename);
            }
        }
    }
}
