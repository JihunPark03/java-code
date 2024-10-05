import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class drawrectanglesandcircles extends JFrame {
    public static void main(String[] args) {
        new drawrectanglesandcircles();
    }

    public drawrectanglesandcircles() {
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
        contentPane.add(canvas, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        contentPane.add(rightPanel, BorderLayout.EAST);

        JRadioButton circle = new JRadioButton("Circle");
        JRadioButton rectangle = new JRadioButton("Rectangle");

        ButtonGroup group = new ButtonGroup();
        group.add(circle);
        group.add(rectangle);

        ActionListener modeChangeListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rectangle.isSelected()) {
                    canvas.setDrawingMode(DrawingMode.Rectangle);
                } else if (circle.isSelected()) {
                    canvas.setDrawingMode(DrawingMode.Circle);
                }
            }
        };

        rectangle.addActionListener(modeChangeListener);
        circle.addActionListener(modeChangeListener);

        rectangle.setSelected(true);

        rightPanel.add(rectangle);
        rightPanel.add(circle);

        return contentPane;
    }
}

class MouseListener extends MouseAdapter {
    private final CanvasPanel canvasPanel;
    private int startX;
    private int startY;

    MouseListener(CanvasPanel canvas) {
        canvasPanel = canvas;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x1 = Math.min(startX, e.getX());
        int y1 = Math.min(startY, e.getY());
        int x2 = Math.abs(e.getX()-startX);
        int y2 = Math.abs(e.getY()-startY);

        Rectangle rectangle = new Rectangle(x1, y1, x2, y2);
        canvasPanel.drawShape(rectangle, true);    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int x1 = Math.min(startX, e.getX());
        int y1 = Math.min(startY, e.getY());
        int x2 = Math.abs(e.getX()-startX);
        int y2 = Math.abs(e.getY()-startY);

        Rectangle rectangle = new Rectangle(x1, y1, x2, y2);
        canvasPanel.drawShape(rectangle, false);
    }

}

enum DrawingMode {
    Rectangle,
    Circle,
}

class CanvasPanel extends JPanel {
    private final BufferedImage image;
    private final BufferedImage imageInProgress;
    private boolean Progress;
    private DrawingMode mode;

    public CanvasPanel() {
        setName("canvas");
        image = new BufferedImage(320, 240, BufferedImage.TYPE_INT_RGB);
        imageInProgress = new BufferedImage(320, 240, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
        g.dispose();
    }

    public void setDrawingMode(DrawingMode newMode) {
        mode = newMode;
    }

    public void drawShape(Rectangle rectangle, boolean inProgress) {
        Progress = inProgress;
        Graphics2D g = (inProgress ? imageInProgress : image).createGraphics();
        if (inProgress) {
            g.drawImage(image, 0, 0, this);
        }
        g.setColor(Color.BLACK);
        if (mode == DrawingMode.Rectangle) {
            g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        } else if (mode == DrawingMode.Circle) {
            g.fillOval(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(Progress ? imageInProgress : image, 0, 0, this);
    }
}