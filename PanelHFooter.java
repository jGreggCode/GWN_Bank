import javax.swing.JPanel;

import Utils.ColorPalette;

public class PanelHFooter extends JPanel {

    private ColorPalette colorPalette = new ColorPalette();

    public PanelHFooter() {
        setOpaque(true);
        setBackground(colorPalette.getColorButtons());
        setLayout(null);
        setBounds(500, 100, 500, 200);
    }
}
