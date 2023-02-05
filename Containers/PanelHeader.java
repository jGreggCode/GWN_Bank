package Containers;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import Utils.Defaults;

public class PanelHeader extends JPanel {

    JLabel labelWelcome = new JLabel();
    ImageIcon logo = new ImageIcon("Images/BankLogoN.png");
    Image image = logo.getImage();
    Image resizedImg = image.getScaledInstance(128 * 2, 128 * 2, Image.SCALE_SMOOTH);
    ImageIcon newLogo = new ImageIcon(resizedImg);
    Defaults def = new Defaults();

    int x = def.getFrameWidth() / 2;

    public PanelHeader() {
        this.setOpaque(false);
        // Icon Label
        labelWelcome.setIcon(newLogo);
        labelWelcome.setVerticalTextPosition(JLabel.BOTTOM);
        labelWelcome.setHorizontalTextPosition(JLabel.CENTER);
        labelWelcome.setIconTextGap(-10);
        // --------
        // Welcome Label
        labelWelcome.setText("Welcome To GWN Bank");
        labelWelcome.setForeground(Color.white);
        labelWelcome.setFont(new Font(def.getFontFam(), Font.BOLD, 26));
        setBounds(x - (320 / 2), 20, 320, 296);
        //setBounds(mFrame.getWidth() / 2 - (160 * 2 / 2), mFrame.getHeight() / 2 - (148 * 2 / 2), 160 * 2, 148 * 2);
        // --------


        this.add(labelWelcome);
    }
}
