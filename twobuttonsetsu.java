import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::showWindow);
    }

    public MainWindow() {
        // Set the title of the window
        setTitle("Problem1");

        // Create buttons
        JButton leftButton = new JButton("Left");
        JButton rightButton = new JButton("Right");

        // Create text area
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false); // Make the text area readonly

        // Set layout manager
        setLayout(new BorderLayout());

        // Add components to the content pane
        add(leftButton, BorderLayout.WEST);
        add(rightButton, BorderLayout.EAST);
        add(textArea, BorderLayout.CENTER);

        // Add action listeners to the buttons
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("Left!\n");
            }
        });

        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("Right!\n");
            }
        });

        // Set default close operation, size, and visibility
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
    }
}

class Main {
    public static void showWindow() {
        new MainWindow();
    }
}