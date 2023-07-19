import javax.swing.*;
import java.awt.*;

public class ExceptionWindow extends Exception {
    ExceptionWindow(String exceptionMessage){
        super(exceptionMessage);

        final int WINDOW_WIDTH = 300;
        final int WINDOW_HEIGHT = 100;
        // main configurations of the frame
        JFrame exceptionFrame = new JFrame();
        exceptionFrame.setSize(new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT));
        exceptionFrame.setLocationRelativeTo(null);
        exceptionFrame.setTitle("Error");

        // label configurations
        JLabel exceptionLabel = new JLabel(exceptionMessage);
        exceptionLabel.setFont(new Font("Roboto", Font.PLAIN, 20));
        exceptionLabel.setForeground(Color.red);

        // panel configurations
        JPanel exceptionPanel = new JPanel();
        exceptionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        exceptionPanel.add(exceptionLabel);
        exceptionFrame.add(exceptionPanel);

        // IMPORTANT
        // NOTE: must be last line
        exceptionFrame.setVisible(true);
    }
}
