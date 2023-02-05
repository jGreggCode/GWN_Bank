package Containers;

import javax.swing.JPanel;
import Utils.ColorPalette;

public class PanelFooter extends JPanel {

    private ColorPalette colorPalette = new ColorPalette();

    public PanelFooter() {
        setOpaque(true);
        setBackground(colorPalette.getColorBackground1());
        setLayout(null);
        setBounds(0, 728, 1440, 294);
    }
}
