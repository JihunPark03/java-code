import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.net.URL;

public class MainWindow extends JFrame {
    public static void main(String[] args) {
        new MainWindow();
    }

    public MainWindow() {
        setTitle("Problem3");
        initComponents();
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initComponents() {
        JButton loadButton = new JButton("Load");
        JTextArea textBox = new JTextArea();
        MyCanvas canvas = new MyCanvas();
        loadButton.addActionListener(e -> canvas.loadImage(textBox.getText()));
        setLayout(new BorderLayout());
        add(textBox, BorderLayout.NORTH);
        add(loadButton, BorderLayout.SOUTH);
        add(canvas, BorderLayout.CENTER);
    }
}

class MyCanvas extends Canvas {
    private BufferedImage image;
    public void loadImage(String urlString) {
        try {
            URL url = new URL(urlString);
            image = ImageIO.read(url);
        } catch (Exception e) {
            e.printStackTrace();
            image = null;
        }
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        } else {
            g.drawString("Image not loaded", 20, 50);
        }
    }
}
