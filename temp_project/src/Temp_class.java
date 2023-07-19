import javax.print.attribute.standard.JobStateReason;
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
    Temp_class(){
    this.setSize(500,500);
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    textArea = new JTextArea(1,20);
    button = new JButton("click!");
    radioButton1 = new JRadioButton("hello", true);
    radioButton2 = new JRadioButton("hi");
    radioButton3 = new JRadioButton("hey");
    checkBox = new JCheckBox("this is a check box");
    radioGroup = new ButtonGroup();
    radioGroup.add(radioButton1);
    radioGroup.add(radioButton2);
    radioGroup.add(radioButton3);
    button.addActionListener(this::actionPerformed);
    panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    panel.add(textArea);
    panel.add(button);
    panel.add(radioButton1);
    panel.add(radioButton2);
    panel.add(radioButton3);
    panel.add(checkBox);
    this.add(panel);
    this.setVisible(true);
    }

}
