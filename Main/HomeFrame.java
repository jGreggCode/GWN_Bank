package Main;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Containers.*;
import Utils.*;

public class HomeFrame extends JFrame {
    
    PanelHUserBar panelHUserBar = new PanelHUserBar();
    PanelHDepositBar panelDepBar = new PanelHDepositBar();

    ColorPalette colors = new ColorPalette();
    Defaults def = new Defaults();
    PanelHNavBar panelHNavBar = new PanelHNavBar(panelHUserBar, panelDepBar);
    PanelHFooterBar panelHFooter = new PanelHFooterBar();

    public HomeFrame() {
        setTitle("Home");
        setIconImage(new ImageIcon(getClass().getResource("/Images/JustLogo.png")).getImage());
        setPreferredSize(new Dimension(def.getFrameWidth(), def.getFrameHeight()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(getPreferredSize().width, getPreferredSize().height);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(colors.getColorBackground());
        setLocationRelativeTo(null);

        add(panelHNavBar);
        add(panelHFooter);
        add(panelHUserBar);
        add(panelDepBar);
    }
}
