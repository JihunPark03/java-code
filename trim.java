import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

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
        contentPane.add(canvas, BorderLayout.CENTER);
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
        canvasPanel.drawRectangle(new Rectangle(startX, startY, 0, 0));
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int currentX = e.getX();
        int currentY = e.getY();
        canvasPanel.drawRectangle(new Rectangle(startX, startY, currentX - startX, currentY - startY));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int endX = e.getX();
        int endY = e.getY();
        canvasPanel.trim(new Rectangle(startX, startY, endX - startX, endY - startY));
        canvasPanel.repaint();
    }
}

class CanvasPanel extends JPanel {
    private final BufferedImage image;
    private final BufferedImage imageInProgress;
    private boolean isInProgress;
    private static final BasicStroke DASHED_LINE = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, new float[]{7, 3}, 0);

    public CanvasPanel() {
        setName("canvas");
        try {
            URI uri = new URI("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Kagami_mochi_%28Japanese_New_Year_decoration%29%3B_January_2020.jpg/320px-Kagami_mochi_%28Japanese_New_Year_decoration%29%3B_January_2020.jpg");
            image = ImageIO.read(uri.toURL());
            imageInProgress = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public void drawRectangle(Rectangle rectangle) {
        isInProgress = true;

        Graphics2D g = imageInProgress.createGraphics();
        g.drawImage(image, 0, 0, this);

        g.setColor(Color.BLACK);
        g.setStroke(DASHED_LINE);
        g.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);

        g.dispose();
        repaint();
    }
    public void removeDashedLine() {
        Graphics2D g = imageInProgress.createGraphics();
        g.setColor(getBackground());
        g.drawImage(image, 0, 0, this);
        g.dispose();
        isInProgress = false;
        repaint();
    }

    public void trim(Rectangle rectangle) {
        isInProgress = false;

        Graphics2D g = image.createGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, rectangle.x, image.getHeight());
        g.fillRect(rectangle.x + rectangle.width, 0, image.getWidth() - rectangle.x - rectangle.width, image.getHeight());
        g.fillRect(rectangle.x, 0, rectangle.width, rectangle.y);
        g.fillRect(rectangle.x, rectangle.y + rectangle.height, rectangle.width, image.getHeight() - rectangle.y - rectangle.height);

        g.dispose();
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(isInProgress ? imageInProgress : image, 0, 0, this);
    }
}
