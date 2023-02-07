package Main;

import java.awt.Dimension;

import javax.swing.JFrame;

import Containers.PanelHNavBar;
import Utils.*;

public class HomeFrame extends JFrame {
    
    ColorPalette colors = new ColorPalette();
    Defaults def = new Defaults();
    PanelHNavBar panelHNavBar = new PanelHNavBar();

    public HomeFrame() {
        this.setTitle("Home");
        this.setPreferredSize(new Dimension(def.getFrameWidth(), def.getFrameHeight()));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(getPreferredSize().width, getPreferredSize().height);
        this.setResizable(false);
        setLayout(null);
        this.getContentPane().setBackground(colors.getColorBackground());
        this.setLocationRelativeTo(null);

        add(panelHNavBar);
    }
}
