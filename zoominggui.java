import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class MainWindow extends JFrame {
    private final MyCanvas canvas;
    public MainWindow() {
        setTitle("Problem3");
        canvas = new MyCanvas();
        JButton zoomOutButton = new JButton("Zoom Out");
        JButton zoomInButton = new JButton("Zoom In");
        setLayout(new BorderLayout());
        add(zoomOutButton, BorderLayout.EAST);
        add(zoomInButton, BorderLayout.WEST);
        add(canvas, BorderLayout.CENTER);
        zoomOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.zoomout();
            }
        });
        zoomInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.zoomin();
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainWindow::new);
    }
}
class MyCanvas extends Canvas {
    private BufferedImage image;
    public MyCanvas() {
        try {
            image = ImageIO.read(new URL("https://docs.oracle.com/javase/tutorial/2d/images/examples/strawberry.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void zoomout() {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage reducedImage = new BufferedImage(width / 2, height / 2, image.getType());
        for (int x = 0; x < width; x += 2) {
            for (int y = 0; y < height; y += 2) {
                int rgb = image.getRGB(x, y);
                reducedImage.setRGB(x / 2, y / 2, rgb);
            }
        }
        image = reducedImage;
        repaint();
    }
    public void zoomin() {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage enlargedImage = new BufferedImage(width * 2, height * 2, image.getType());
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int rgb = image.getRGB(x, y);
                enlargedImage.setRGB(2 * x, 2 * y, rgb);
                enlargedImage.setRGB(2 * x + 1, 2 * y, rgb);
                enlargedImage.setRGB(2 * x, 2 * y + 1, rgb);
                enlargedImage.setRGB(2 * x + 1, 2 * y + 1, rgb);
            }
        }
        image = enlargedImage;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.drawImage(image, 0, 0, this);
    }
}