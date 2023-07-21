import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MainWindow extends JFrame {
    MainWindow(){
        // main configurations
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Counter");

        AtomicInteger counter = new AtomicInteger(240);
        JTextArea writeToTextArea = new JTextArea(1, 20);
        JTextArea counterTextArea = new JTextArea(1, 3);
        JLabel counterLabel = new JLabel("Characters left: ");
        JPanel panel = new JPanel();

        writeToTextArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                if(counter.get() == 0){
                    writeToTextArea.setForeground(Color.red);
                }
                counter.decrementAndGet();
                counterTextArea.setText(counter.toString());

            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                counter.incrementAndGet();
                if(counter.get() >= 0){
                    writeToTextArea.setForeground(Color.black);
                }

                counterTextArea.setText(counter.toString());
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {

            }
        });
        counterTextArea.setText(counter.toString());
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(writeToTextArea);
        panel.add(counterTextArea);
        panel.add(counterLabel);
        this.add(panel);

        this.setVisible(true);
    }
}
