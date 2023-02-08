package Containers;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Utils.ColorPalette;

public class PanelHFooterBar extends JPanel {

    private ColorPalette colorPalette = new ColorPalette();
    private JLabel labelIcon = new JLabel();

    ImageIcon logo = new ImageIcon("Images/BankLogoN.png");
    Image image = logo.getImage();
    Image resizedImg = image.getScaledInstance(64, 64, Image.SCALE_SMOOTH);
    ImageIcon newLogo = new ImageIcon(resizedImg);

    public PanelHFooterBar() {


        setOpaque(true);
        setBackground(colorPalette.getColorBackground1());
        setLayout(null);
        setBounds(0, 800, 80, 200);

        labelIcon.setIcon(newLogo);
        labelIcon.setHorizontalAlignment(JLabel.CENTER);
        labelIcon.setBounds(0,0, 80, 200);

        add(labelIcon);
    }
}
