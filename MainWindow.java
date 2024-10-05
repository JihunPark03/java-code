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

        /********************************/
        JRadioButton pen = createRadioButton("Pen");
        JRadioButton rectangleFill = createRadioButton("RectangleFill");
        JRadioButton circleFill = createRadioButton("CircleFill");
        JRadioButton rectangleOutline = createRadioButton("RectangleOutline");
        JRadioButton circleOutline = createRadioButton("CircleOutline");

        ButtonGroup toolGroup = new ButtonGroup();
        toolGroup.add(pen);
        toolGroup.add(rectangleFill);
        toolGroup.add(circleFill);
        toolGroup.add(rectangleOutline);
        toolGroup.add(circleOutline);
        pen.setSelected(true);

        ActionListener radioButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pen.isSelected()) {
                    canvas.setDrawingMode(DrawingMode.Pen);
                } else if (rectangleFill.isSelected()) {
                    canvas.setDrawingMode(DrawingMode.RectangleFill);
                } else if (circleFill.isSelected()) {
                    canvas.setDrawingMode(DrawingMode.CircleFill);
                } else if (rectangleOutline.isSelected()) {
                    canvas.setDrawingMode(DrawingMode.RectangleOutline);
                } else if (circleOutline.isSelected()) {
                    canvas.setDrawingMode(DrawingMode.CircleOutline);
                }
            }
        };
        pen.addActionListener(radioButtonListener);
        rectangleFill.addActionListener(radioButtonListener);
        circleFill.addActionListener(radioButtonListener);
        rectangleOutline.addActionListener(radioButtonListener);
        circleOutline.addActionListener(radioButtonListener);


        JRadioButton black = createRadioButton("Black");
        JRadioButton white = createRadioButton("White");
        JRadioButton red = createRadioButton("Red");
        JRadioButton green = createRadioButton("Green");
        JRadioButton blue = createRadioButton("Blue");

        ButtonGroup colorGroup = new ButtonGroup();
        colorGroup.add(black);
        colorGroup.add(white);
        colorGroup.add(red);
        colorGroup.add(green);
        colorGroup.add(blue);
        black.setSelected(true);

        ActionListener colorRadioButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = Color.BLACK;
                if (black.isSelected()) {
                    color = Color.BLACK;
                } else if (white.isSelected()) {
                    color = Color.WHITE;
                } else if (red.isSelected()) {
                    color = Color.RED;
                } else if (green.isSelected()) {
                    color = Color.GREEN;
                } else if (blue.isSelected()) {
                    color = Color.BLUE;
                }
                canvas.setColor(color);
            }
        };
        black.addActionListener(colorRadioButtonListener);
        white.addActionListener(colorRadioButtonListener);
        red.addActionListener(colorRadioButtonListener);
        green.addActionListener(colorRadioButtonListener);
        blue.addActionListener(colorRadioButtonListener);
        

        JComboBox<Integer> thickness = new JComboBox<>(new Integer[]{1, 2, 3, 5});
        thickness.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.setPenSize((int) thickness.getSelectedItem());
            }
        });


        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(canvas, BorderLayout.CENTER);

        JPanel toolPanel = new JPanel();
        toolPanel.setLayout(new BoxLayout(toolPanel, BoxLayout.X_AXIS));
        toolPanel.add(pen);
        toolPanel.add(rectangleFill);
        toolPanel.add(circleFill);
        toolPanel.add(rectangleOutline);
        toolPanel.add(circleOutline);

        JPanel colorPanel = new JPanel();
        colorPanel.setLayout(new BoxLayout(colorPanel, BoxLayout.X_AXIS));
        colorPanel.add(black);
        colorPanel.add(white);
        colorPanel.add(red);
        colorPanel.add(green);
        colorPanel.add(blue);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(toolPanel);
        buttonPanel.add(colorPanel);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        JPanel thicknessPanel = new JPanel();
        thicknessPanel.add(new JLabel("Thickness: "));
        thicknessPanel.add(thickness);
        contentPane.add(thicknessPanel, BorderLayout.EAST);
        /********************************/
        return contentPane;
    }

    private JRadioButton createRadioButton(String label) {
        JRadioButton radioButton = new JRadioButton(label);
        radioButton.setName("label");
        return radioButton;
    }
}


/********************************/
enum DrawingMode {
    Pen,
    RectangleOutline,
    RectangleFill,
    CircleOutline,
    CircleFill,
}

class MouseListener extends MouseAdapter {
    private final CanvasPanel canvasPanel;
    private int startX, startY, endX, endY;

    MouseListener(CanvasPanel canvas) {
        canvasPanel = canvas;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
        canvasPanel.drawLine(startX, startY, startX, startY);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        endX = e.getX();
        endY = e.getY();
        if (canvasPanel.getDrawingMode() == DrawingMode.Pen) {
            canvasPanel.drawLine(startX, startY, endX, endY);
            startX = endX;
            startY = endY;
        }

        else {
            canvasPanel.drawShape(getRectangle(startX, startY, endX, endY), true);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        canvasPanel.drawShape(getRectangle(startX, startY, endX, endY), false);
    }

    private Rectangle getRectangle(int x1, int y1, int x2, int y2) {
        int minX = Math.min(x1, x2);
        int minY = Math.min(y1, y2);
        int maxX = Math.max(x1, x2);
        int maxY = Math.max(y1, y2);
        return new Rectangle(minX, minY, maxX - minX, maxY - minY);
    }
}

class CanvasPanel extends JPanel {
    private final BufferedImage image;
    private final Graphics2D graphics;
    private DrawingMode mode;
    private BasicStroke stroke;

    public CanvasPanel() {
        setName("canvas");
        image = new BufferedImage(320, 240, BufferedImage.TYPE_INT_RGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
        mode = DrawingMode.Pen;
        graphics.setColor(Color.BLACK);
        stroke = new BasicStroke(1);
    }

    public void setDrawingMode(DrawingMode newMode) {
        mode = newMode;
    }

    public DrawingMode getDrawingMode() {
        return mode;
    }

    public void setColor(Color color) {
        graphics.setColor(color);
    }

    public void setPenSize(int size) {
        stroke = new BasicStroke(size);
    }

    public void drawLine(int startX, int startY, int endX, int endY) {
        graphics.setStroke(stroke);
        graphics.drawLine(startX, startY, endX, endY);
        repaint();
    }

    public void drawShape(Rectangle rectangle, boolean inProgress) {
        Graphics2D g = image.createGraphics();
        if (inProgress) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, image.getWidth(), image.getHeight());
            g.drawImage(image, 0, 0, this);
        }
        g.setColor(graphics.getColor());
        g.setStroke(stroke);

        switch (mode) {
            case Pen:
            break;
            case RectangleFill:
                graphics.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            break;
            case CircleFill:
                graphics.fillOval(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            break;
            case RectangleOutline:
                graphics.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            break;
            case CircleOutline:
                graphics.drawOval(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            break;
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}
/********************************/