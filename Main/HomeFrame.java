package Main;

import java.awt.Dimension;

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
        this.setTitle("Home");
        this.setPreferredSize(new Dimension(def.getFrameWidth(), def.getFrameHeight()));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(getPreferredSize().width, getPreferredSize().height);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(colors.getColorBackground());
        this.setLocationRelativeTo(null);

        add(panelHNavBar);
        add(panelHFooter);
        add(panelHUserBar);
        add(panelDepBar);
    }
}
