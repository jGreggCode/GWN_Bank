package Components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class PanelHeader extends JPanel {

    JLabel labelWelcome = new JLabel();
    ImageIcon logo = new ImageIcon("Images/BankLogoN.png");
    Image image = logo.getImage();
    Image resizedImg = image.getScaledInstance(128, 128, Image.SCALE_SMOOTH);
    ImageIcon newLogo = new ImageIcon(resizedImg);

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
        labelWelcome.setFont(new Font("Monospace", Font.BOLD, 13));
        setBounds(280, 10, 148, 148);
        // --------


        this.add(labelWelcome);
    }
}
