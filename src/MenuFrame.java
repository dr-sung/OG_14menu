
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuFrame extends JFrame {

    private JMenuItem exitMenuItem;
    private JMenuItem newMenuItem;
    private JMenuItem upMenuItem;
    private JMenuItem downMenuItem;
    private JMenuItem leftMenuItem;
    private JMenuItem rightMenuItem;
    private JMenuItem randomizeMenuItem;
    private CanvasPanel canvas;

    public void initialize() {

        // add drawing canvas to content pane

        canvas = new CanvasPanel();
        Container contentPane = getContentPane();
        contentPane.add(canvas, BorderLayout.CENTER);

        // construct menu

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        MenuObserver listener = new MenuObserver();

        newMenuItem = new JMenuItem("New");
        fileMenu.add(newMenuItem);
        newMenuItem.addActionListener(listener);

        exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(exitMenuItem);
        exitMenuItem.addActionListener(listener);

        JMenu editMenu = new JMenu("Edit");
        menuBar.add(editMenu);

        JMenu moveMenu = new JMenu("Move");
        editMenu.add(moveMenu);

        upMenuItem = new JMenuItem("Up");
        moveMenu.add(upMenuItem);
        upMenuItem.addActionListener(listener);

        downMenuItem = new JMenuItem("Down");
        moveMenu.add(downMenuItem);
        downMenuItem.addActionListener(listener);

        leftMenuItem = new JMenuItem("Left");
        moveMenu.add(leftMenuItem);
        leftMenuItem.addActionListener(listener);

        rightMenuItem = new JMenuItem("Right");
        moveMenu.add(rightMenuItem);
        rightMenuItem.addActionListener(listener);

        randomizeMenuItem = new JMenuItem("Randomize");
        editMenu.add(randomizeMenuItem);
        randomizeMenuItem.addActionListener(listener);
    }

    private class MenuObserver implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            Object source = event.getSource();

            if (source == exitMenuItem) {
                System.exit(0);
            } else if (source == newMenuItem) {
                canvas.reset();
            } else if (source == upMenuItem) {
                canvas.moveRectangle(0, -1);
            } else if (source == downMenuItem) {
                canvas.moveRectangle(0, 1);
            } else if (source == leftMenuItem) {
                canvas.moveRectangle(-1, 0);
            } else if (source == rightMenuItem) {
                canvas.moveRectangle(1, 0);
            } else if (source == randomizeMenuItem) {
                canvas.randomize();
            }
        }
    }
}