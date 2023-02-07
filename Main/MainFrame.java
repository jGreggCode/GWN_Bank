package Main;
import java.awt.Dimension;

// Imports
import javax.swing.JFrame;
import Containers.*;
import Utils.*;
// --------


public class MainFrame extends JFrame {

    // Main Frame Components
    PanelHeader panelHeader = new PanelHeader();
    PanelBody panelBody = new PanelBody(this);
    PanelFooter panelFooter = new PanelFooter();
    // --------


    // Color
    ColorPalette colors = new ColorPalette();
    Defaults def = new Defaults();
    // --------

    public final JFrame getJFrame() {
        return this;
    }

    public int getHeight() {
        return this.getPreferredSize().height;
    }

    // Main frame
    public MainFrame() {
        // Main frame configuration
        this.setTitle("GWN Bank");
        this.setPreferredSize(new Dimension(def.getFrameWidth(), def.getFrameHeight()));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(getPreferredSize().width, getPreferredSize().height);
        this.setResizable(false);
        setLayout(null);
        this.getContentPane().setBackground(colors.getColorBackground());
        this.setLocationRelativeTo(null);
        // --------

        
        // Add Components
        this.add(panelHeader);
        this.add(panelBody);
        this.add(panelFooter);

        // --------
    }
}
