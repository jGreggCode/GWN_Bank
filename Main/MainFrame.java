package Main;
// Imports
import javax.swing.JFrame;
import Components.*;
// --------
import Utils.ColorPalette;


public class MainFrame extends JFrame {

    // Main Frame Components
    PanelHeader panelHeader = new PanelHeader();
    PanelBody panelBody = new PanelBody();
    // --------

    // Color
    ColorPalette colors = new ColorPalette();
    // --------

    // Main frame
    public MainFrame() {
        initOfComponents();
        this.setVisible(true);
    }

    public void initOfComponents() {
        // Main frame configuration
        this.setTitle("GWN Bank");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(720, 500);
        this.setResizable(false);
        setLayout(null);
        this.getContentPane().setBackground(colors.getColorBackground());
        // --------

        // Add Components
        this.add(panelHeader);
        this.add(panelBody);
        // --------
    }
}
