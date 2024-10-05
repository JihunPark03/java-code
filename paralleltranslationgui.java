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
        setTitle("Problem1");
        JButton upButton = new JButton("Up");
        JButton downButton = new JButton("Down");
        JButton leftButton = new JButton("Left");
        JButton rightButton = new JButton("Right");

        setLayout(new BorderLayout());
        add(upButton, BorderLayout.NORTH);
        add(downButton, BorderLayout.SOUTH);
        add(leftButton, BorderLayout.WEST);
        add(rightButton, BorderLayout.EAST);
        add(canvas, BorderLayout.CENTER);

        upButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.shift(0, -1);
            }
        });

        downButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.shift(0, 1);
            }
        });

        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.shift(-1, 0);
            }
        });

        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.shift(1, 0);
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

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.drawImage(this.image, 0, 0, this);
    }

    public void shift(int dx, int dy) {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        BufferedImage newImage = new BufferedImage(width, height, this.image.getType());

        Graphics2D g2d = newImage.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);
        g2d.drawImage(this.image, dx, dy, null);
        g2d.dispose();

        image = newImage;
        repaint();
    }
}
