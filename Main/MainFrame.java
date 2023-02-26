package Main;

// Imports
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Containers.*;
import Utils.*;

public class MainFrame extends JFrame {

    // Main Frame Components
    RegisterFrame registerFrame = new RegisterFrame(this);
    LoginMessage loginMsg = new LoginMessage();
    PanelHeader panelHeader = new PanelHeader();
    PanelBody panelBody = new PanelBody(this, loginMsg);
    PanelFooter panelFooter = new PanelFooter(loginMsg, this, registerFrame);
    ImageIcon logo = new ImageIcon("Images/JustLogo.png");

    // Utilities
    ColorPalette colors = new ColorPalette();
    Defaults def = new Defaults();

    // Main frame
    public MainFrame() {
        // Main frame configuration
        setIconImage(new ImageIcon(getClass().getResource("/Images/JustLogo.png")).getImage());
        setTitle("GWN Bank (Alpha Build)");
        setPreferredSize(new Dimension(def.getFrameWidth(), def.getFrameHeight()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(getPreferredSize().width, getPreferredSize().height);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(colors.getColorBackground());
        setLocationRelativeTo(null);

        // Add Components
        add(loginMsg);
        add(panelHeader);
        add(panelBody);
        add(panelFooter);

    }
}
