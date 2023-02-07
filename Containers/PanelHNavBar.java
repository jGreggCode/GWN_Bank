package Containers;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Utils.ColorPalette;

public class PanelHNavBar extends JPanel {

    private ColorPalette colorPalette = new ColorPalette();

    private JLabel labelProfile = new JLabel(),
    labelDeposit = new JLabel(),
    labelWIthdraw = new JLabel(),
    labelBankTransfer = new JLabel(),
    labelSettings = new JLabel();

    public PanelHNavBar() {
        setOpaque(true);
        setBackground(colorPalette.getColorBackground1());
        setLayout(null);
        setBounds(0, 0, 100, 1000);
    }
}
