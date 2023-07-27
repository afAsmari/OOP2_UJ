import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    ImageIcon icon;
    JLabel label;
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem openItem;
    JMenuItem saveItem;
    JMenuItem exitItem;
    JMenu editMenu;
    JMenuItem undoItem;
    JMenuItem copyItem;
    JMenu aboutMenu;
    JMenuItem aboutItem;
    JPanel panel;
    JFileChooser fileChooser = new JFileChooser();
    MainWindow(){
        // main configuration
        this.setSize(390,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("coffee house");

        icon = new ImageIcon("/home/nines/IdeaProjects/OOP2_UJ/Gui_app7/icons8-adobe-illustrator-94.png");
        label = new JLabel(icon);

        panel = new JPanel();
        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("save");
        exitItem = new JMenuItem("Exit");

        editMenu = new JMenu("Edit");
        undoItem = new JMenuItem("Undo");
        copyItem = new JMenuItem("copy");

        aboutMenu = new JMenu("About");
        aboutItem = new JMenuItem("About this product");

        openItem.addActionListener(new OpenFileChooser());
        exitItem.addActionListener(new CloseProgram());

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        editMenu.add(undoItem);
        editMenu.add(copyItem);

        aboutMenu.add(aboutItem);


        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(aboutMenu);

        panel.add(menuBar);


        this.add(panel);


        this.setVisible(true);

    }

    private class CloseProgram implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.exit(0);
        }
    }

    private class OpenFileChooser implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            fileChooser.showOpenDialog(new JFrame());
        }
    }

}
