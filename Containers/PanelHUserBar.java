package Containers;

import javax.swing.BorderFactory;
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

    // User labels
    private JLabel labelUserIcon = new JLabel(),
    labelUserName = new JLabel(),
    labelAccountStatus = new JLabel(),
    labelUserLogout = new JLabel();

    // Info labels
    private JLabel labelCash = new JLabel(),
    labelCashAmmount = new JLabel(),
    labelCashDollars = new JLabel(),
    labelCashDollarsAmmount = new JLabel();

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

    private JPanel panelTrans = new JPanel() {
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

        String status = "Black Account"; // change later

        labelUserName.setText("John Gregg V. Felicisimo");
        labelAccountStatus.setText("Account Status: " + status);
        labelUserLogout.setText("Log out");

        labelUserName.setBounds(150, 30, 452, 20);
        labelUserName.setForeground(Color.white);
        labelUserName.setFont(new Font(def.getFontFam(), Font.BOLD, 15));

        labelAccountStatus.setBounds(150, 50, 452, 20);
        labelAccountStatus.setForeground(Color.white);
        labelAccountStatus.setFont(new Font(def.getFontFam(), Font.BOLD, 15));

        labelUserLogout.setBounds(150, 82, 72, 20);
        labelUserLogout.setHorizontalAlignment(JLabel.CENTER);
        labelUserLogout.setForeground(Color.white);
        labelUserLogout.setOpaque(true);
        labelUserLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelUserLogout.setBackground(colorPalette.getColorButtons());
        labelUserLogout.setBorder(BorderFactory.createLineBorder(colorPalette.getColorButtons(), 1));
        labelUserLogout.setFont(new Font(def.getFontFam(), Font.BOLD, 15));

        panelUser.add(labelUserName);
        panelUser.add(labelUserIcon);
        panelUser.add(labelAccountStatus);
        panelUser.add(labelUserLogout);
        // --------

        // Info Panel
        panelInfo.setLayout(null);
        panelInfo.setOpaque(false);
        panelInfo.setBackground(colorPalette.getColorBackground1());
        panelInfo.setBounds(680, 50, 620, 150);

        labelCash.setText("Balance:");
        labelCash.setBounds(15, 20, 200, 40);
        labelCash.setForeground(Color.white);
        labelCash.setFont(new Font(def.getFontFam(), Font.BOLD, 25));

        double cash = 10000000; // change later

        labelCashAmmount.setText(String.format("PHP %,.2f", cash)); 
        labelCashAmmount.setHorizontalAlignment(JLabel.TRAILING);
        labelCashAmmount.setBounds(350, 20, 250, 40);
        labelCashAmmount.setForeground(Color.white);
        labelCashAmmount.setFont(new Font(def.getFontFam(), Font.BOLD, 25));

        labelCashDollars.setText("Balance in dollars:");
        labelCashDollars.setBounds(15, 50, 200, 25);
        labelCashDollars.setForeground(Color.white);
        labelCashDollars.setFont(new Font(def.getFontFam(), Font.BOLD, 15));

        labelCashDollarsAmmount.setText(String.format("USD %,.2f", (cash * 54.79))); 
        labelCashDollarsAmmount.setHorizontalAlignment(JLabel.TRAILING);
        labelCashDollarsAmmount.setBounds(350, 50, 250, 25);
        labelCashDollarsAmmount.setForeground(Color.white);
        labelCashDollarsAmmount.setFont(new Font(def.getFontFam(), Font.BOLD, 15));

        panelInfo.add(labelCash);
        panelInfo.add(labelCashAmmount);
        panelInfo.add(labelCashDollars);
        panelInfo.add(labelCashDollarsAmmount);
        // --------

        // Trans panel
        panelTrans.setBounds(40, 220, 1260, 700);
        panelTrans.setLayout(null);
        panelTrans.setOpaque(false);
        panelTrans.setBackground(colorPalette.getColorBackground1());


        add(panelUser);
        add(panelInfo);
        add(panelTrans);
    }
}

