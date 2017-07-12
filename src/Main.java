
import javax.swing.JFrame;


public class Main {
    public static void main(String[] args) {
        MenuFrame frame = new MenuFrame();
        frame.initialize();
        frame.setTitle("MenuTest");
        frame.setSize(500,300);
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
