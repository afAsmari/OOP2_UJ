import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    // declaration of universal objects and variables
    JPanel panel;
    JLabel label;
    JList list;
    JComboBox comboBox;
    JSlider slider;
    String[] cities = {"jeddah", "makkah", "abha"};;
    MainWindow(){
        // main configurations
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(".");

        // initialization of components
        panel = new JPanel();
        list = new JList(cities);
        label = new JLabel("choose a city");
        comboBox = new JComboBox<>(cities);
        slider = new JSlider(0, 100);

        // slider configurations
        slider.setOrientation(JSlider.HORIZONTAL);
        slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing(25);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        // adding components to the panel and frame
        panel.add(list);
        panel.add(label);
        panel.add(comboBox);
        panel.add(slider);
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
            label.setText(cities[list.getSelectedIndex()]);
        }
    }

    private class comboSelecter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            label.setText((String) comboBox.getSelectedItem());
        }
    }

    private class sliderChanger implements ChangeListener{

        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            label.setText(Integer.toString(slider.getValue()));
        }
    }
}
