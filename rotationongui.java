import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    public static void main(String[] args) {
        new MainWindow();
    }
    public MainWindow() {
        MyCanvas canvas = new MyCanvas();
        setTitle("Problem2");
        JButton cButton = new JButton("Clockwise");
        JButton ccButton = new JButton("Counterclockwise");

        setLayout(new BorderLayout());
        add(cButton, BorderLayout.WEST);
        add(ccButton, BorderLayout.EAST);
        add(canvas, BorderLayout.CENTER);

        cButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.rotate();
            }
        });

        ccButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.counterrotate();
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
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
    public void rotate(){
        image = rotate(image, 90);
        repaint();
    }
    public void counterrotate(){
        image = rotate(image, -90);
        repaint();
    }
    public BufferedImage rotate(BufferedImage originalImage,int degrees) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        BufferedImage rotatedImage = new BufferedImage(height, width, originalImage.getType());
        Graphics2D g2d = rotatedImage.createGraphics();
        g2d.rotate(Math.toRadians(degrees), height / 2.0, width / 2.0);
        g2d.drawImage(originalImage, (height - width) / 2, (width - height) / 2, null);
        g2d.dispose();

        return rotatedImage;
    }
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.drawImage(this.image, 0, 0, this);
    }
}
