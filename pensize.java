import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class MainWindow extends JFrame {
    public static void main(String[] args) {
        new MainWindow();
    }

    public MainWindow() {
        super("Paint Tool");
        setContentPane(createContentPane());
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createContentPane() {
        CanvasPanel canvas = new CanvasPanel();
        MouseListener listener = new MouseListener(canvas);
        canvas.addMouseListener(listener);
        canvas.addMouseMotionListener(listener);

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(createComboBox(canvas), BorderLayout.NORTH);
        contentPane.add(canvas, BorderLayout.CENTER);

        return contentPane;
    }

    private JComboBox<Integer> createComboBox(CanvasPanel canvas) {
        JComboBox<Integer> comboBox = new JComboBox<>(new Integer[]{1, 2, 3, 5});
        comboBox.addActionListener(e -> canvas.setPenSize((Integer) comboBox.getSelectedItem()));
        return comboBox;
    }
}

class MouseListener extends MouseAdapter {
    private final CanvasPanel canvasPanel;
    private int lastX;
    private int lastY;

    MouseListener(CanvasPanel canvas) {
        canvasPanel = canvas;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        lastX = e.getX();
        lastY = e.getY();
        canvasPanel.drawLine(lastX, lastY, lastX, lastY);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int currentX = e.getX();
        int currentY = e.getY();
        canvasPanel.drawLine(lastX, lastY, currentX, currentY);
        lastX = currentX;
        lastY = currentY;
    }
}

class CanvasPanel extends JPanel {
    private final BufferedImage image;
    private final Graphics2D graphics;
    private int penSize;

    public CanvasPanel() {
        setName("canvas");
        image = new BufferedImage(320, 240, BufferedImage.TYPE_INT_RGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
        graphics.setColor(Color.BLACK);
        penSize = 1;
    }

    public void setPenSize(int size) {
        penSize = size;
    }

    public void drawLine(int startX, int startY, int endX, int endY) {
        graphics.setStroke(new BasicStroke(penSize));
        graphics.drawLine(startX, startY, endX, endY);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}
