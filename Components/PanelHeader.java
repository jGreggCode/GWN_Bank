package Components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class PanelHeader extends JPanel {

    JLabel labelWelcome = new JLabel();
    ImageIcon logo = new ImageIcon("Images/BankLogoNB128.png");

    public PanelHeader() {
        this.setOpaque(false);
        // Icon Label
        labelWelcome.setIcon(logo);
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
