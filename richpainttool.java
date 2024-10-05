import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class MainWindow extends JFrame {
    public static void main(String[] args) {
        new MainWindow();
    }

    public MainWindow() {
        super("Paint Tool");
        initializeComponents();
        setContentPane(createContentPane());
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private CanvasPanel canvas;
    private ButtonGroup shapeButtonGroup;
    private ButtonGroup colorButtonGroup;
    private JComboBox<Integer> penSizeComboBox;

    private void initializeComponents() {
        shapeButtonGroup = new ButtonGroup();
        colorButtonGroup = new ButtonGroup();

        canvas = new CanvasPanel();
        penSizeComboBox = new JComboBox<>(new Integer[]{1, 2, 3, 5});
        penSizeComboBox.setName("PenSize");
        penSizeComboBox.setSelectedItem(1);
        penSizeComboBox.addActionListener(e -> canvas.setPenSize((Integer) penSizeComboBox.getSelectedItem()));
    }

    private JPanel createContentPane() {
        JPanel contentPane = new JPanel(new BorderLayout());

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));

        controlPanel.add(createRadioButton("Pen", "Pen", true, CanvasPanel.DrawingMode.Pen));
        controlPanel.add(createRadioButton("RectangleFill", "Rectangle Fill", false, CanvasPanel.DrawingMode.RectangleFill));
        controlPanel.add(createRadioButton("CircleFill", "Circle Fill", false, CanvasPanel.DrawingMode.CircleFill));
        controlPanel.add(createRadioButton("RectangleOutline", "Rectangle Outline", false, CanvasPanel.DrawingMode.RectangleOutline));
        controlPanel.add(createRadioButton("CircleOutline", "Circle Outline", false, CanvasPanel.DrawingMode.CircleOutline));
        controlPanel.add(createColorButton("Black", "Black", Color.BLACK, true));
        controlPanel.add(createColorButton("White", "White", Color.WHITE, false));
        controlPanel.add(createColorButton("Red", "Red", Color.RED, false));
        controlPanel.add(createColorButton("Green", "Green", Color.GREEN, false));
        controlPanel.add(createColorButton("Blue", "Blue", Color.BLUE, false));
        penSizeComboBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, penSizeComboBox.getPreferredSize().height));
        controlPanel.add(penSizeComboBox);
        contentPane.add(controlPanel, BorderLayout.WEST);
        contentPane.add(canvas, BorderLayout.CENTER);
        return contentPane;
    }

    private JRadioButton createRadioButton(String name, String text, boolean selected, CanvasPanel.DrawingMode mode) {
        JRadioButton button = new JRadioButton(text, selected);
        button.setName(name);
        button.addActionListener(e -> canvas.setDrawingMode(mode));
        shapeButtonGroup.add(button);
        return button;
    }

    private JRadioButton createColorButton(String name, String text, Color color, boolean selected) {
        JRadioButton button = new JRadioButton(text, selected);
        button.setName(name);
        button.addActionListener(e -> canvas.setColor(color));
        colorButtonGroup.add(button);
        return button;
    }
}

class CanvasPanel extends JPanel {
    private BufferedImage image;
    private BufferedImage imageInProgress;
    private DrawingMode currentMode;
    private Color currentColor;
    private int currentPenSize;
    private boolean isInProgress; 

    public enum DrawingMode {
        Pen, RectangleFill, CircleFill, RectangleOutline, CircleOutline
    }

    public CanvasPanel() {
        setName("canvas");
        image = new BufferedImage(320, 240, BufferedImage.TYPE_INT_RGB);
        imageInProgress = new BufferedImage(320, 240, BufferedImage.TYPE_INT_RGB);
        clearImage();
        currentMode = DrawingMode.Pen;
        currentColor = Color.BLACK;
        currentPenSize = 1;
        MouseAdapter mouseHandler = new DrawingMouseAdapter();
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);
    }

    public void setDrawingMode(DrawingMode mode) {
        this.currentMode = mode;
    }

    public void setColor(Color color) {
        this.currentColor = color;
    }

    public void setPenSize(int size) {
        this.currentPenSize = size;
    }

    private void clearImage() {
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, image.getWidth(), image.getHeight());
        g2d.dispose();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (isInProgress) {
            g.drawImage(imageInProgress, 0, 0, this);
        } else {
            g.drawImage(image, 0, 0, this);
        }
    }

    public void drawShape(Rectangle shape, boolean inProgress) {
        isInProgress = inProgress;
        Graphics2D g = (inProgress ? imageInProgress : image).createGraphics();
        if (inProgress) {
            g.drawImage(image, 0, 0, this);
        }
        setupGraphics(g);
    
        switch (currentMode) {
            case RectangleFill:
                g.fillRect(shape.x, shape.y, shape.width, shape.height);
                break;
            case RectangleOutline:
                g.drawRect(shape.x, shape.y, shape.width, shape.height);
                break;
            case CircleFill:
                g.fillOval(shape.x, shape.y, shape.width, shape.height);
                break;
            case CircleOutline:
                g.drawOval(shape.x, shape.y, shape.width, shape.height);
                break;
        }
    
        g.dispose();
        repaint();
    }
    

    private class DrawingMouseAdapter extends MouseAdapter {
        private int startX, startY;

        @Override
        public void mousePressed(MouseEvent e) {
            startX = e.getX();
            startY = e.getY();
            if (currentMode == DrawingMode.Pen) {
                drawPoint(startX, startY);
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (currentMode == DrawingMode.Pen) {
                drawLine(startX, startY, e.getX(), e.getY());
                startX = e.getX();
                startY = e.getY();
            } else {
                Rectangle rect = makeRectangle(startX, startY, e.getX(), e.getY());
                drawShape(rect, true);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (currentMode != DrawingMode.Pen) {
                Rectangle rect = makeRectangle(startX, startY, e.getX(), e.getY());
                drawShape(rect, false);
            }
        }

        private Rectangle makeRectangle(int x1, int y1, int x2, int y2) {
            int x = Math.min(x1, x2);
            int y = Math.min(y1, y2);
            int width = Math.abs(x1 - x2);
            int height = Math.abs(y1 - y2);
            return new Rectangle(x, y, width, height);
        }
    }


    private void drawPoint(int x, int y) {
        Graphics2D g2d = image.createGraphics();
        setupGraphics(g2d);
        g2d.drawLine(x, y, x, y);
        g2d.dispose();
        repaint();
    }

    private void drawLine(int x1, int y1, int x2, int y2) {
        Graphics2D g2d = image.createGraphics();
        setupGraphics(g2d);
        g2d.drawLine(x1, y1, x2, y2);
        g2d.dispose();
        repaint();
    }
 

    private void setupGraphics(Graphics2D g2d) {
        g2d.setColor(currentColor);
        g2d.setStroke(new BasicStroke((float) currentPenSize));
    }
}
