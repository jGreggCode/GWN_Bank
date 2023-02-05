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
    PanelBody panelBody = new PanelBody();
    PanelFooter panelFooter = new PanelFooter();
    // --------


    // Color
    ColorPalette colors = new ColorPalette();

    Defaults def = new Defaults();
    // --------

    public int getHeight() {
        return this.getPreferredSize().height;
    }
    
    public int getWidth() {
        return this.getPreferredSize().width;
    }

    // Main frame
    public MainFrame() {
        initOfComponents();
        this.setVisible(true);
    }

    public void initOfComponents() {
        // Main frame configuration
        this.setTitle("GWN Bank");
        this.setPreferredSize(new Dimension(def.getFrameWidth(), def.getFrameHeight()));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(getPreferredSize().width, getPreferredSize().height);
        this.setResizable(false);
        setLayout(null);
        this.getContentPane().setBackground(colors.getColorBackground());
        // --------

        // Add Components
        this.add(panelHeader);
        this.add(panelBody);
        this.add(panelFooter);

        // --------
    }
}
