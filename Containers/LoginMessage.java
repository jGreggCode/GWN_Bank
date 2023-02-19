package Containers;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Utils.ColorPalette;
import Utils.Defaults;

public class LoginMessage extends JPanel {

    Defaults def = new Defaults();
    ColorPalette colorPalette = new ColorPalette();
    JLabel labelMessageType = new JLabel();
    JLabel labelMessageDetail = new JLabel();

    public LoginMessage() {
        setOpaque(true);
        setBackground(colorPalette.getColorBackground1());
        setBorder(BorderFactory.createLineBorder(Color.red, 1));
        setLayout(null);
        setVisible(false);
        setBounds(1440 / 2 - (700 / 2), 40, 700, 50);

        labelMessageType.setText("Login Failed");
        labelMessageType.setForeground(Color.white);
        labelMessageType.setFont(new Font(def.getFontFam(), Font.BOLD, 15));
        labelMessageType.setBounds(20, 0, 400, 50);

        labelMessageDetail.setForeground(Color.white);
        labelMessageDetail.setFont(new Font(def.getFontFam(), Font.BOLD, 15));
        labelMessageDetail.setHorizontalAlignment(JLabel.TRAILING);
        labelMessageDetail.setBounds(400, 0, 280, 50);

        this.add(labelMessageType);
        this.add(labelMessageDetail);
    }
}
