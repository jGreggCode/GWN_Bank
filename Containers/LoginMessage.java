package Containers;

// Imports
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Utils.ColorPalette;
import Utils.Defaults;

public class LoginMessage extends JPanel {

    // Prerequisite Objects
    Defaults def = new Defaults();
    ColorPalette colorPalette = new ColorPalette();
    public JLabel labelMessageType = new JLabel();
    public JLabel labelMessageDetail = new JLabel();

    public LoginMessage() {
        // Login message configuration
        setOpaque(true);
        setBackground(colorPalette.getColorBackground1());
        setBorder(BorderFactory.createLineBorder(Color.red, 1));
        setLayout(null);
        setVisible(false);
        setBounds(1440 / 2 - (700 / 2), 40, 700, 50);

        // Configuration of components
        labelMessageType.setText("Login Failed");
        labelMessageType.setForeground(Color.white);
        labelMessageType.setFont(new Font(def.getFontFam(), Font.BOLD, 15));
        labelMessageType.setBounds(20, 0, 400, 50);

        labelMessageDetail.setForeground(Color.white);
        labelMessageDetail.setFont(new Font(def.getFontFam(), Font.BOLD, 15));
        labelMessageDetail.setHorizontalAlignment(JLabel.TRAILING);
        labelMessageDetail.setBounds(400, 0, 280, 50);

        // Components 
        add(labelMessageType);
        add(labelMessageDetail);
    }
}
