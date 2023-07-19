import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args){
        mainView();
    }

    static public void mainView(){
        // main configurations of the frame
        JFrame frame = new JFrame();
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Calculator");

        // widgets
        JTextArea textArea = new JTextArea(1, 20);

        // creating the calculator buttons
        JButton num1 = new JButton("1");
        JButton num2 = new JButton("2");
        JButton num3 = new JButton("3");
        JButton num4 = new JButton("4");
        JButton num5 = new JButton("5");
        JButton num6 = new JButton("6");
        JButton num7 = new JButton("7");
        JButton num8 = new JButton("8");
        JButton num9 = new JButton("9");

        JButton num0 = new JButton("0");
        JButton rootButton = new JButton("");
        JButton equalButton = new JButton("=");

        JButton deleteButton = new JButton("C");
        JButton additionButton = new JButton("+");
        JButton subtractionButton = new JButton("-");
        JButton multiplicationButton = new JButton("*");
        JButton divisionButton = new JButton("/");

        // changing properties of the buttons
        deleteButton.setPreferredSize(new Dimension(50,50));

        additionButton.setForeground(Color.red);
        subtractionButton.setForeground(Color.red);
        multiplicationButton.setForeground(Color.red);
        divisionButton.setForeground(Color.red);

        // creating the panels
        JPanel mainPanel = new JPanel(new BorderLayout(0,5));
        mainPanel.setPreferredSize(new Dimension(2,50));
        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        // adding the other panels to the main panel
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(bottomPanel, BorderLayout.CENTER);

        // adding components to top panel
        topPanel.setLayout(new BorderLayout());
        topPanel.add(textArea, BorderLayout.WEST);
        topPanel.add(deleteButton, BorderLayout.EAST);

        // adding components to bottom panel
        bottomPanel.setLayout(new GridLayout(4, 4, 5, 5));
        bottomPanel.add(num1);
        bottomPanel.add(num2);
        bottomPanel.add(num3);
        bottomPanel.add(additionButton);
        bottomPanel.add(num4);
        bottomPanel.add(num5);
        bottomPanel.add(num6);
        bottomPanel.add(subtractionButton);
        bottomPanel.add(num7);
        bottomPanel.add(num8);
        bottomPanel.add(num9);
        bottomPanel.add(multiplicationButton);
        bottomPanel.add(num0);
        bottomPanel.add(rootButton);
        bottomPanel.add(equalButton);
        bottomPanel.add(divisionButton);

        // creation of ActionListener objects
        ActionListener printValueAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(actionEvent.getActionCommand() == "root"){
                    textArea.append("q");
                }else{
                    textArea.append(actionEvent.getActionCommand());
                }
            }
        };

        ActionListener deleteTextAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea.setText("");
            }
        };

        ActionListener calculateAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Node node = new Node(textArea.getText());
                try{
                    Integer result = node.Calculate();
                    textArea.setText(result.toString());
                }catch(ArithmeticException e){
                    new ExceptionWindow("Arithmetic Error");
                }catch(NumberFormatException e){
                    new ExceptionWindow("Number Format Error");
                }
            }
        };

        // adding the action listener objects to the buttons
        deleteButton.addActionListener(deleteTextAction);

        equalButton.addActionListener(calculateAction);

        num0.addActionListener(printValueAction);
        num1.addActionListener(printValueAction);
        num2.addActionListener(printValueAction);
        num3.addActionListener(printValueAction);
        num4.addActionListener(printValueAction);
        num5.addActionListener(printValueAction);
        num6.addActionListener(printValueAction);
        num7.addActionListener(printValueAction);
        num8.addActionListener(printValueAction);
        num9.addActionListener(printValueAction);
        additionButton.addActionListener(printValueAction);
        subtractionButton.addActionListener(printValueAction);
        multiplicationButton.addActionListener(printValueAction);
        divisionButton.addActionListener(printValueAction);
        //rootButton.addActionListener(printValueAction);

        // adding main panel to the frame
        frame.add(mainPanel);

        // IMPORTANT
        // NOTE: must be last line
        frame.setVisible(true);

    }
}