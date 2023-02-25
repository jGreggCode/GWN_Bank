package Containers;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import Utils.ColorPalette;
import Utils.Defaults;
import Utils.MyPasswordField;
import Utils.MyTextField;

import java.awt.Color;

public class PanelHSettingBar extends JPanel {

    ColorPalette colorPalette = new ColorPalette();
    private Defaults def = new Defaults();

    public JLabel labelSecurity = new JLabel(),
    labelLogin= new JLabel(),
    labelWhereLogin = new JLabel(),
    labelLastLogin = new JLabel(),
    labelPassword = new JLabel(),
    labelChangePassword = new JLabel();

    public MyPasswordField txtChangePassword = new MyPasswordField();

    private JPanel panelUserInfos = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
           super.paintComponent(g);
           Dimension arcs = new Dimension(60,60);
           int width = getWidth();
           int height = getHeight();
           Graphics2D graphics = (Graphics2D) g;
           graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   
   
           //Draws the rounded opaque panel with borders.
           graphics.setColor(getBackground());
           graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
           graphics.setColor(getForeground());
           graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
        }
    };

    public PanelHSettingBar() {
        setOpaque(true);
        setBackground(colorPalette.getColorBackground());
        setVisible(false);
        setLayout(null);
        setBounds(80,0, 1360, 1000);

        panelUserInfos.setBounds(50, 50, 1240, 300);
        panelUserInfos.setOpaque(false);
        panelUserInfos.setBackground(colorPalette.getColorBackground1());
        panelUserInfos.setLayout(null);

        labelSecurity.setText("ACCOUNT SECURITY");
        labelSecurity.setForeground(Color.white);
        labelSecurity.setFont(new Font(def.getFontFam(), Font.BOLD, 25));
        labelSecurity.setBounds(50, 20, 500, 25);

        labelWhereLogin.setText("Last Login");
        labelWhereLogin.setForeground(Color.white);
        labelWhereLogin.setFont(new Font(def.getFontFam(), Font.BOLD, 20));
        labelWhereLogin.setBounds(70, 60, 500, 25);

        labelLastLogin.setText("Last Login: Monday, 20 February | 12:16 am | Paranaque City | Windows");
        labelLastLogin.setForeground(Color.white);
        labelLastLogin.setFont(new Font(def.getFontFam(), Font.PLAIN, 16));
        labelLastLogin.setBounds(100, 90, 700, 25);

        labelLogin.setText("Login");
        labelLogin.setForeground(Color.white);
        labelLogin.setFont(new Font(def.getFontFam(), Font.BOLD, 20));
        labelLogin.setBounds(70, 130, 500, 25);

        labelPassword.setText("Password");
        labelPassword.setForeground(Color.white);
        labelPassword.setFont(new Font(def.getFontFam(), Font.PLAIN, 16));
        labelPassword.setBounds(100, 160, 100, 30);

        txtChangePassword.setText("Password");
        txtChangePassword.setEnabled(false);
        txtChangePassword.setBounds(200, 160, 300, 30);

        labelChangePassword.setText("Change password");

        panelUserInfos.add(labelSecurity);
        panelUserInfos.add(labelWhereLogin);
        panelUserInfos.add(labelLastLogin);
        panelUserInfos.add(labelLogin);
        panelUserInfos.add(labelPassword);
        panelUserInfos.add(txtChangePassword);

        add(panelUserInfos);
    }
}
