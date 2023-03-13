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
    JLabel labelSlogan = new JLabel();
    JLabel labelWelcome1 = new JLabel();
    ImageIcon logo = new ImageIcon("Images/mhLogo.png");
    Image image = logo.getImage();
    Image resizedImg = image.getScaledInstance(128 * 2, 128 * 2, Image.SCALE_SMOOTH);
    ImageIcon newLogo = new ImageIcon(resizedImg);
    
    // Utilities
    Defaults def = new Defaults();
    int x = def.getFrameWidth() / 2;

    public PanelHeader() {
        // Header panel configuration
        setOpaque(false);
        setLayout(null);
        setBounds(x - (600 / 2), 40, 600, 400);

        // Icon Label
        labelWelcome.setIcon(newLogo);
        labelWelcome.setVerticalTextPosition(JLabel.BOTTOM);
        labelWelcome.setHorizontalTextPosition(JLabel.CENTER);
        labelWelcome.setBounds(600 / 2 - (128 * 2 / 2), 0, 128 * 2, 128 * 2);
        
        labelWelcome1.setText("Welcome To Miracle Holdings INC.");
        labelWelcome1.setFont(new Font(def.getFontFam(), Font.BOLD, 23));
        labelWelcome1.setForeground(Color.black);
        labelWelcome1.setHorizontalAlignment(JLabel.CENTER);
        labelWelcome1.setBounds(0, 200, 600, 50);

        labelSlogan.setText("You're in good hands with Miracle, Your success is our Miracle ");
        labelSlogan.setFont(new Font(def.getFontFam(), Font.BOLD, 19));
        labelSlogan.setForeground(Color.black);
        labelSlogan.setHorizontalAlignment(JLabel.CENTER);
        labelSlogan.setBounds(0, 230, 600, 50);

        // Add components
        add(labelWelcome);
        add(labelSlogan);
        add(labelWelcome1);
    }
}
