package Main;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Backend.Session;
import Containers.*;
import Model.ModelUser;
import Utils.*;

public class HomeFrame extends JFrame {

    MainFrame mainFrame;
    ModelUser user;
    PanelBody panelBody;
    public String username;
    
    PanelHUserBar panelHUserBar = new PanelHUserBar(this, mainFrame);
    PanelHDepositBar panelDepBar = new PanelHDepositBar();

    ColorPalette colors = new ColorPalette();
    Defaults def = new Defaults();
    PanelHNavBar panelHNavBar = new PanelHNavBar(panelHUserBar, panelDepBar, this);
    PanelHFooterBar panelHFooter = new PanelHFooterBar();

    public HomeFrame(ModelUser user) {
        this.user = user;

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
