import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::showWindow);
    }

    public MainWindow() {
        setTitle("Problem1");

        JButton leftButton = new JButton("Left");
        JButton rightButton = new JButton("Right");

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        setLayout(new BorderLayout());

        add(leftButton, BorderLayout.WEST);
        add(rightButton, BorderLayout.EAST);
        add(textArea, BorderLayout.CENTER);

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