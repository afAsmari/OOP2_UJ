import javax.swing.*;
import java.awt.*;

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
    ButtonGroup extraGroup;
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

        smallCoffee = new JRadioButton("Small");
        midCoffee = new JRadioButton("Medium");
        largeCoffee = new JRadioButton("Large");
        sizeGroup = new ButtonGroup();
        sizeGroup.add(smallCoffee);
        sizeGroup.add(midCoffee);
        sizeGroup.add(largeCoffee);
        smallCoffee.setSelected(true);


        cappuccino = new JRadioButton("Cappuccino");
        flatWhite = new JRadioButton("Flat White");
        latte = new JRadioButton("Latte");
        drinkGroup = new ButtonGroup();
        drinkGroup.add(cappuccino);
        drinkGroup.add(flatWhite);
        drinkGroup.add(latte);

        extraShot = new JCheckBox("Extra Shot");
        caramel = new JCheckBox("Caramel");
        vanilla = new JCheckBox("Vanilla");
        extraGroup = new ButtonGroup();
        extraGroup.add(extraShot);
        extraGroup.add(caramel);
        extraGroup.add(vanilla);

        orderButton = new JButton("Done");
        totalLabel = new JLabel("Total");
        totalTextField = new JTextField(10);

        mainPanel = new JPanel();
        sizePanel = new JPanel();
        drinkPanel = new JPanel();
        extraPanel = new JPanel();
        totalPanel = new JPanel();

        mainPanel.setLayout(new FlowLayout());
        sizePanel.setLayout(new GridLayout(3, 0));
        drinkPanel.setLayout(new GridLayout(3, 0));
        extraPanel.setLayout(new GridLayout(3, 0));

        sizePanel.add(smallCoffee);
        sizePanel.add(midCoffee);
        sizePanel.add(largeCoffee);
        sizePanel.setBorder(BorderFactory.createTitledBorder("Size"));

        drinkPanel.add(cappuccino);
        drinkPanel.add(flatWhite);
        drinkPanel.add(latte);
        drinkPanel.setBorder(BorderFactory.createTitledBorder("Drink"));

        extraPanel.add(extraShot);
        extraPanel.add(caramel);
        extraPanel.add(vanilla);
        extraPanel.setBorder(BorderFactory.createTitledBorder("Extra"));

        totalPanel.add(orderButton);
        totalPanel.add(totalLabel);
        totalPanel.add(totalTextField);

        mainPanel.add(sizePanel);
        mainPanel.add(drinkPanel);
        mainPanel.add(extraPanel);
        mainPanel.add(totalPanel);

        this.add(mainPanel);

        this.setVisible(true);
    }

}
