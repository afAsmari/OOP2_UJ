import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Temp_class extends JFrame implements ActionListener {
    JTextArea textArea;
    JButton button;
    JPanel panel;
    JRadioButton radioButton1;
    JRadioButton radioButton2;
    JRadioButton radioButton3;

    ButtonGroup radioGroup;
    JCheckBox checkBox;
    JList list;
    JComboBox dropDown;
    JScrollPane scrollPane;
    String[] cities = {"Makkah", "Jeddah", "Riydadh", "Abha"};
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == button){
            if (radioButton1.isSelected()){
                textArea.setText(radioButton1.getText());
            }else if(radioButton2.isSelected()){
                textArea.setText(radioButton2.getText());
            }else if (radioButton3.isSelected()){
                textArea.setText(radioButton3.getText());
            }
        }
        if(radioButton1.isSelected()){
            System.out.println("hello");
        }
        if(checkBox.isSelected()){
            System.out.println(checkBox.isSelected());
        }
    }

    ActionListener comboBoxAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JComboBox source = (JComboBox) actionEvent.getSource();
            String selectItem = (String) source.getSelectedItem();
            textArea.setText(selectItem);
        }
    };
    Temp_class(){

        this.setSize(500,500);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        textArea = new JTextArea(1,20);
        textArea.setEditable(false);

        button = new JButton("click!");
        button.addActionListener(this::actionPerformed);
        button.setOpaque(true);

        radioButton1 = new JRadioButton("CS", true);
        radioButton2 = new JRadioButton("OIT");
        radioButton3 = new JRadioButton("OIS");
        radioGroup = new ButtonGroup();
        radioGroup.add(radioButton1);
        radioGroup.add(radioButton2);
        radioGroup.add(radioButton3);

        checkBox = new JCheckBox("this is a check box");

        list = new JList(cities);
        dropDown = new JComboBox(cities);
        scrollPane = new JScrollPane(list);

        list.setSelectionMode(0);
        list.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        list.setVisibleRowCount(3);
        dropDown.setBorder(BorderFactory.createLineBorder(Color.red, 2, false));
        dropDown.addActionListener(comboBoxAction);

        panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(textArea);
        panel.add(button);
        panel.add(radioButton1);
        panel.add(radioButton2);
        panel.add(radioButton3);
        panel.add(checkBox);
        panel.add(scrollPane);
        panel.add(dropDown);
        this.add(panel);

        this.setVisible(true);
    }

}
