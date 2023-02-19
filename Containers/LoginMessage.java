package Containers;

import javax.swing.JPanel;

import Utils.ColorPalette;

public class LoginMessage extends JPanel {

    ColorPalette colorPalette = new ColorPalette();

    public LoginMessage() {
        setOpaque(true);
        setBackground(colorPalette.getColorBackground1());
        setLayout(null);
        setVisible(false);
        setBounds(0, 0, 80, 100);
    }
}
