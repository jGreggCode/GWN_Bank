package Containers;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import Utils.ColorPalette;
import Utils.Defaults;

public class PanelHUserBar extends JPanel {

    private ColorPalette colorPalette = new ColorPalette();
    private Defaults def = new Defaults();

    private JLabel labelUserIcon = new JLabel(),
    labelUserName = new JLabel(),
    labelAccountStatus = new JLabel(),
    labelUserLogout = new JLabel();

    private JPanel panelUser = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
           super.paintComponent(g);
           Dimension arcs = new Dimension(30,30);
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

    private JPanel panelInfo = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
           super.paintComponent(g);
           Dimension arcs = new Dimension(30,30);
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

    public PanelHUserBar() {
        setOpaque(true);
        setBackground(colorPalette.getColorBackground());
        setVisible(false);
        setLayout(null);
        setBounds(80,0, 1360, 1000);

        // User Panel
        panelUser.setLayout(null);
        panelUser.setOpaque(false);
        panelUser.setBackground(colorPalette.getColorBackground1());
        panelUser.setBounds(40, 50, 620, 150);

        
        labelUserIcon.setIcon(new ImageIcon(getClass().getResource("/Images/man.png")));
        labelUserIcon.setBounds(10, 11, 128, 128);

        labelUserName.setText("John Gregg V. Felicisimo");
        labelAccountStatus.setText("Black Account");
        labelUserLogout.setText("Log out");

        labelUserName.setBounds(150, 42, 452, 20);
        labelUserName.setForeground(Color.white);
        labelUserName.setFont(new Font(def.getFontFam(), Font.BOLD, 15));


        panelUser.add(labelUserName);
        panelUser.add(labelUserIcon);
        // --------

        // Info Panel
        panelInfo.setLayout(null);
        panelInfo.setOpaque(false);
        panelInfo.setBackground(colorPalette.getColorBackground1());
        panelInfo.setBounds(680, 50, 620, 150);
        // --------


        add(panelUser);
        add(panelInfo);
    }
}

