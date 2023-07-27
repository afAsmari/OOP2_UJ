import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    int total;

    JRadioButton smallCoffee;
    JRadioButton midCoffee;
    JRadioButton largeCoffee;
    ButtonGroup sizeGroup;
    JRadioButton cappuccino;
    JRadioButton flatWhite;
    JRadioButton latte;
    ButtonGroup drinkGroup;
    JCheckBox extraShot;
    JCheckBox caramel;
    JCheckBox vanilla;
    JButton orderButton;
    JLabel totalLabel;
    JTextField totalTextField;
    JPanel mainPanel;
    JPanel sizePanel;
    JPanel drinkPanel;
    JPanel extraPanel;
    JPanel totalPanel;
    MainWindow(){
        // Main configuration
        this.setSize(390,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("coffee house");

        // initialization to all objects related to the size
        smallCoffee = new JRadioButton("Small");
        midCoffee = new JRadioButton("Medium");
        largeCoffee = new JRadioButton("Large");
        sizeGroup = new ButtonGroup();
        sizeGroup.add(smallCoffee);
        sizeGroup.add(midCoffee);
        sizeGroup.add(largeCoffee);
        smallCoffee.setSelected(true);

        // initialization to all objects related to the drinks
        cappuccino = new JRadioButton("Cappuccino");
        flatWhite = new JRadioButton("Flat White");
        latte = new JRadioButton("Latte");
        drinkGroup = new ButtonGroup();
        drinkGroup.add(cappuccino);
        drinkGroup.add(flatWhite);
        drinkGroup.add(latte);

        // initialization to all objects related to the extra orders
        extraShot = new JCheckBox("Extra Shot");
        caramel = new JCheckBox("Caramel");
        vanilla = new JCheckBox("Vanilla");

        // initialization to the button and total text field
        orderButton = new JButton("Done");
        orderButton.addActionListener(new CalculateTotal());
        totalLabel = new JLabel("Total");
        totalTextField = new JTextField(10);

        // initialization to the panels
        mainPanel = new JPanel();
        sizePanel = new JPanel();
        drinkPanel = new JPanel();
        extraPanel = new JPanel();
        totalPanel = new JPanel();

        // setting the panels layouts
        mainPanel.setLayout(new FlowLayout());
        sizePanel.setLayout(new GridLayout(3, 0));
        drinkPanel.setLayout(new GridLayout(3, 0));
        extraPanel.setLayout(new GridLayout(3, 0));

        // adding widgets to the sizes panel
        sizePanel.add(smallCoffee);
        sizePanel.add(midCoffee);
        sizePanel.add(largeCoffee);
        sizePanel.setBorder(BorderFactory.createTitledBorder("Size"));

        // adding widgets to the drinks panel
        drinkPanel.add(cappuccino);
        drinkPanel.add(flatWhite);
        drinkPanel.add(latte);
        drinkPanel.setBorder(BorderFactory.createTitledBorder("Drink"));

        // adding widgets to the extras panel
        extraPanel.add(extraShot);
        extraPanel.add(caramel);
        extraPanel.add(vanilla);
        extraPanel.setBorder(BorderFactory.createTitledBorder("Extra"));

        // adding widgets to total panel
        totalPanel.add(orderButton);
        totalPanel.add(totalLabel);
        totalPanel.add(totalTextField);

        // adding all panels to the main panel
        mainPanel.add(sizePanel);
        mainPanel.add(drinkPanel);
        mainPanel.add(extraPanel);
        mainPanel.add(totalPanel);

        // adding the main panel to the frame
        this.add(mainPanel);

        // setting the frame to visible
        this.setVisible(true);
    }
    // event listener to the total button
    private class CalculateTotal implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            // making sure the total is rested every time the button is clicked
            total = 0;
            // logic
            if(cappuccino.isSelected() || latte.isSelected()){
                if (smallCoffee.isSelected()) total += 12;
                else if (midCoffee.isSelected()) total += 14;
                else if(largeCoffee.isSelected()) total += 16;
            }else if(flatWhite.isSelected()){
                if (smallCoffee.isSelected()) total += 10;
                else if (midCoffee.isSelected()) total += 12;
                else if(largeCoffee.isSelected()) total += 14;
            }
            if(extraShot.isSelected()) total += 2;
            if(caramel.isSelected()) total += 2;
            if(vanilla.isSelected()) total +=2;

            // adding the total value to the total text field
            totalTextField.setText(Integer.toString(total));
        }
    }
}
