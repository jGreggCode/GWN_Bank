package Containers;

// Imports
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import Utils.Defaults;

public class PanelHeader extends JPanel {

    // Header panel components
    JLabel labelWelcome = new JLabel();
    ImageIcon logo = new ImageIcon("Images/newLogo.png");
    Image image = logo.getImage();
    Image resizedImg = image.getScaledInstance(128 * 2, 128 * 2, Image.SCALE_SMOOTH);
    ImageIcon newLogo = new ImageIcon(resizedImg);
    
    // Utilities
    Defaults def = new Defaults();
    int x = def.getFrameWidth() / 2;

    public PanelHeader() {
        // Header panel configuration
        this.setOpaque(false);

        // Icon Label
        labelWelcome.setIcon(newLogo);
        labelWelcome.setVerticalTextPosition(JLabel.BOTTOM);
        labelWelcome.setHorizontalTextPosition(JLabel.CENTER);
        labelWelcome.setIconTextGap(10);

        // Welcome Label
        labelWelcome.setText("Welcome To Miracle Holdings INC.");
        labelWelcome.setForeground(Color.white);
        labelWelcome.setFont(new Font(def.getFontFam(), Font.BOLD, 19));
        setBounds(x - (320 / 2), 20, 320, 296);

        // Add components
        this.add(labelWelcome);
    }
}
