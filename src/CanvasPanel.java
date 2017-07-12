
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.JPanel;

class CanvasPanel extends JPanel {

    private final Rectangle rect;
    private static final int RECT_WIDTH = 20;
    private static final int RECT_HEIGHT = 30;

    public CanvasPanel() {
        rect = new Rectangle(0, 0, RECT_WIDTH, RECT_HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.blue);
        g2.fill(rect);
    }

    /**
     * Resets the rectangle to the top left corner.
     */
    public void reset() {
        rect.setLocation(0, 0);
        repaint();
    }

    /**
     * Moves the rectangle to a random position.
     */
    public void randomize() {
        Random generator = new Random();
        rect.setLocation(generator.nextInt(getWidth()),
                generator.nextInt(getHeight()));
        repaint();
    }

    /**
     * Moves the rectangle and repaints it. The rectangle is moved by multiples
     * of its full width or height.
     *
     * @param dx the number of width units
     * @param dy the number of height units
     */
    public void moveRectangle(int dx, int dy) {
        rect.translate(dx * RECT_WIDTH, dy * RECT_HEIGHT);
        repaint();
    }
}
