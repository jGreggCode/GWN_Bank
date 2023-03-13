package Main;

// Imports
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Graphics;

import Containers.*;
import Utils.*;

public class MainFrame extends JFrame {

    Methods resize = new Methods();

    // Prerequisite Obejects
    LoginMessage loginMsg = new LoginMessage();
    RegisterMessage registerMessage = new RegisterMessage();
    RegisterFrame registerFrame = new RegisterFrame(this, registerMessage);
    PanelHeader panelHeader = new PanelHeader();
    PanelBody panelBody = new PanelBody(this, loginMsg);
    PanelFooter panelFooter = new PanelFooter(loginMsg, this, registerFrame);
    JLabel back = new JLabel();

    // Image logo
    ImageIcon logo = new ImageIcon("Images/newLogo.png");
    ImageIcon loginBg = new ImageIcon("Images/loginBG.jpg");

    // Utilities
    ColorPalette colors = new ColorPalette();
    Defaults def = new Defaults();

    // Main frame
    public MainFrame() {
        // Main frame configuration
        setIconImage(new ImageIcon(getClass().getResource("/Images/mhJustLogo.png")).getImage());
        setTitle("Miracle Holdings (Alpha Build)");
        setPreferredSize(new Dimension(def.getFrameWidth(), def.getFrameHeight()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(getPreferredSize().width, getPreferredSize().height);
        setResizable(false);
        setLayout(null);
        //getContentPane().setBackground(colors.getColorWhite());
        setLocationRelativeTo(null);

        back.setIcon(resize.imageResize(loginBg, 1440, 800));
        back.setBounds(0,0, 1440, 800);

        // Add Components
        add(loginMsg);
        add(panelHeader);
        add(panelBody);
        add(panelFooter);
        add(back);

    }

}
