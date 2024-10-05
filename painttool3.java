import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class painttool3 extends JFrame{
    public static void main(String[] args) {
        new painttool3();
    }

    public painttool3() {
        setTitle("Problem1");
        setContentPane(createContentPane());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        setVisible(true);

    }

    private JPanel createContentPane() {
        CanvasPanel canvas = new CanvasPanel();
        MouseListener listener = new MouseListener(canvas);
        canvas.addMouseListener(listener);
        canvas.addMouseMotionListener(listener);

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(canvas, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        contentPane.add(buttonPanel, BorderLayout.EAST);

        String[] colorNames = {"Black","Red", "Green", "Blue"};
        Color[] colors = {Color.BLACK, Color.RED, Color.GREEN, Color.BLUE};
        JComboBox<String> colorComboBox = new JComboBox<>(colorNames);
        colorComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = colorComboBox.getSelectedIndex();
                Color selectedColor = colors[selectedIndex];
                canvas.setColor(selectedColor);
            }
        });
        buttonPanel.setLayout(new FlowLayout()); 
        buttonPanel.add(new JLabel("Select Color: "));
        buttonPanel.add(colorComboBox);
        
        contentPane.add(buttonPanel, BorderLayout.EAST);
    
        return contentPane;
    }
}

class MouseListener extends MouseAdapter {
    private final CanvasPanel canvasPanel;
    private int lX;
    private int lY;

    MouseListener(CanvasPanel canvas) {
        canvasPanel = canvas;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        lX = e.getX();
        lY = e.getY();
        canvasPanel.drawLine(lX, lY, lX, lY);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        canvasPanel.drawLine(lX, lY, e.getX(), e.getY());
        lX = e.getX();
        lY = e.getY();
    }
}

class CanvasPanel extends JPanel {
    private final BufferedImage image;
    private final Graphics2D graphics;

    public CanvasPanel() {
        setName("canvas");
        image = new BufferedImage(320, 240, BufferedImage.TYPE_INT_RGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
        graphics.setColor(Color.BLACK);
    }

    public void drawLine(int sX, int sY, int eX, int eY) {
        graphics.drawLine(sX, sY, eX, eY);
        repaint();
    }

    public void setColor(Color color) {
        graphics.setColor(color);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}
