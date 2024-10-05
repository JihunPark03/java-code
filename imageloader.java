import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class MainWindow extends JFrame {
    public static void main(String[] args) {
        new MainWindow();
    }
    public MainWindow(){
        setTitle("Problem3");
        MyCanvas canvas = new MyCanvas();
        JButton loadButton = new JButton("Load");
        JTextArea textArea = new JTextArea();
        setLayout(new BorderLayout());
        add(loadButton, BorderLayout.CENTER);
        add(canvas, BorderLayout.CENTER);
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.loadImage("https://docs.oracle.com/javase/tutorial/2d/images/examples/strawberry.jpg");;
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
    }
}

class MyCanvas extends Canvas {
    private BufferedImage image;

    public void loadImage(String urlString) {
        try {
            image = ImageIO.read(urlString);
            this.repaint();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.drawImage(this.image, 0, 0, this);
    }
}
