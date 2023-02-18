package Main;

// Imports
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Containers.*;
import Utils.*;

public class MainFrame extends JFrame {

    // Main Frame Components
    PanelHeader panelHeader = new PanelHeader();
    PanelBody panelBody = new PanelBody(this);
    PanelFooter panelFooter = new PanelFooter();
    ImageIcon logo = new ImageIcon("Images/JustLogo.png");

    // Utilities
    ColorPalette colors = new ColorPalette();
    Defaults def = new Defaults();

    // Main frame
    public MainFrame() {
        // Main frame configuration
        setIconImage(new ImageIcon(getClass().getResource("/Images/JustLogo.png")).getImage());
        setTitle("GWN Bank");
        setPreferredSize(new Dimension(def.getFrameWidth(), def.getFrameHeight()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(getPreferredSize().width, getPreferredSize().height);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(colors.getColorBackground());
        setLocationRelativeTo(null);

        // Add Components
        add(panelHeader);
        add(panelBody);
        add(panelFooter);

    }
}
