// Imports
import javax.swing.JFrame;
// --------

import Components.LabelWelcome;

public class MainFrame extends JFrame {

    // Main Frame Components
    LabelWelcome labelWelcome = new LabelWelcome();
    // --------

    // Color
    ColorPalette colors = new ColorPalette();
    // --------

    // Main frame
    public MainFrame() {
        // Main frame configuration
        this.setTitle("GWN Bank");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(720, 720);
        this.setResizable(false);
        this.getContentPane().setBackground(colors.getColorBackground());
        // --------

        // Add Components
        this.add(labelWelcome);
        // --------
    }
    // --------
}
