import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1800,1090);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("gui 3");

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();

        frame.setLayout(new BorderLayout(10,10));

        /*p1.setLayout(new BorderLayout());
        p2.setLayout(new BorderLayout());
        p3.setLayout(new BorderLayout());
        p4.setLayout(new BorderLayout());
        p5.setLayout(new BorderLayout());*/

        p1.setBackground(Color.red);
        p2.setBackground(Color.blue);
        p3.setBackground(Color.green);
        p4.setBackground(Color.yellow);
        p5.setBackground(Color.black);



        p1.setPreferredSize(new Dimension(100,300));
        p2.setPreferredSize(new Dimension(500,100));
        p3.setMaximumSize(new Dimension(50, 100));
        p4.setPreferredSize(new Dimension(500,100));
        p5.setPreferredSize(new Dimension(300,250));

        frame.add(p1,BorderLayout.NORTH);
        frame.add(p2, BorderLayout.WEST);
//        frame.add(p3, BorderLayout.CENTER);
//        frame.add(p4, BorderLayout.EAST);
//        frame.add(p5, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}