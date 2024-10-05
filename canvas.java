import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class MainWindow extends JFrame {
    public static void main(String[] args) {
        new MainWindow();
    }

    public MainWindow() {
        super("Problem2");
        this.setContentPane(this.createContentPane());
        this.setSize(320, 240);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private JPanel createContentPane() {
        MyCanvas canvas = new MyCanvas();
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(canvas, BorderLayout.CENTER);
        return contentPane;
    }
}

class MyCanvas extends Canvas {
    private final BufferedImage image;

    public MyCanvas() {
        try {
            this.image = ImageIO.read(new URL("https://docs.oracle.com/javase/tutorial/2d/images/examples/strawberry.jpg"));
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
