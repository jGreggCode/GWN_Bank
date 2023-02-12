package Containers;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import Backend.Session;
import Connection.DatabaseConnection;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Utils.ColorPalette;
import Utils.Defaults;
import Utils.TransTable;
import Main.*;

public class PanelHUserBar extends JPanel implements MouseListener {

    PanelBody panelBody;
    HomeFrame homeFrame;
    MainFrame mainFrame;

    private ColorPalette colorPalette = new ColorPalette();
    private Defaults def = new Defaults();
    public double cash;

    // User labels
    private JLabel labelUserIcon = new JLabel(),
    labelUserName = new JLabel(),
    labelAccountStatus = new JLabel(),
    labelUserLogout = new JLabel();

    // Info labels
    private JLabel labelCash = new JLabel(),
    labelCashAmmount = new JLabel(),
    labelCashDollars = new JLabel(),
    labelCashDollarsAmmount = new JLabel(),
    labelDepositQuota = new JLabel(),
    labelWithdrawQuota = new JLabel(),
    labelDepositQuotaAmmount = new JLabel(),
    labelWithdrawQuotaAmmount = new JLabel();

    // Transaction
    public TransTable tableTransaction = new TransTable();
    private JScrollPane tableScrollPane = new JScrollPane(tableTransaction);

    private JSeparator separatorLine = new JSeparator();

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

    public PanelHUserBar(HomeFrame homeFrame, MainFrame mainFrame) {

        

        this.homeFrame = homeFrame;
        this.mainFrame = mainFrame;
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

        String status = Session.verificationType; // change later
        String accountName = Session.userName;

        labelUserName.setText(accountName);
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
        labelUserLogout.addMouseListener(this);

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
         // change later
        cash = Session.userBalance;
        double withdrawn = 0;
        double deposited = 0;

        labelCashAmmount.setText(String.format("PHP %,.2f", cash)); 
        labelCashAmmount.setHorizontalAlignment(JLabel.TRAILING);
        labelCashAmmount.setBounds(350, 20, 250, 40);
        labelCashAmmount.setForeground(Color.white);
        labelCashAmmount.setFont(new Font(def.getFontFam(), Font.BOLD, 25));

        labelCashDollars.setText("Balance in dollars:");
        labelCashDollars.setBounds(15, 50, 200, 25);
        labelCashDollars.setForeground(Color.white);
        labelCashDollars.setFont(new Font(def.getFontFam(), Font.PLAIN, 15));

        labelCashDollarsAmmount.setText(String.format("USD %,.2f", (cash * 54.79))); 
        labelCashDollarsAmmount.setHorizontalAlignment(JLabel.TRAILING);
        labelCashDollarsAmmount.setBounds(350, 50, 250, 25);
        labelCashDollarsAmmount.setForeground(Color.white);
        labelCashDollarsAmmount.setFont(new Font(def.getFontFam(), Font.BOLD, 15));

        separatorLine.setForeground(colorPalette.getColorButtons());
        separatorLine.setBounds(620 / 2 - (300 / 2), 75, 300, 10);

        labelWithdrawQuota.setText("Daily withdraw quota:");
        labelWithdrawQuota.setBounds(15, 80, 200, 25);
        labelWithdrawQuota.setForeground(Color.white);
        labelWithdrawQuota.setFont(new Font(def.getFontFam(), Font.PLAIN, 15));

        labelWithdrawQuotaAmmount.setText(String.format("PHP %,.2f" + " / 100,000.00", withdrawn)); 
        labelWithdrawQuotaAmmount.setHorizontalAlignment(JLabel.TRAILING);
        labelWithdrawQuotaAmmount.setBounds(350, 80, 250, 25);
        labelWithdrawQuotaAmmount.setForeground(Color.white);
        labelWithdrawQuotaAmmount.setFont(new Font(def.getFontFam(), Font.BOLD, 15));

        labelDepositQuota.setText("Daily deposit quota:");
        labelDepositQuota.setBounds(15, 100, 200, 25);
        labelDepositQuota.setForeground(Color.white);
        labelDepositQuota.setFont(new Font(def.getFontFam(), Font.PLAIN, 15));

        labelDepositQuotaAmmount.setText(String.format("PHP %,.2f"  + " / 500,000.00", deposited)); 
        labelDepositQuotaAmmount.setHorizontalAlignment(JLabel.TRAILING);
        labelDepositQuotaAmmount.setBounds(350, 100, 250, 25);
        labelDepositQuotaAmmount.setForeground(Color.white);
        labelDepositQuotaAmmount.setFont(new Font(def.getFontFam(), Font.BOLD, 15));

        panelInfo.add(labelCash);
        panelInfo.add(labelCashAmmount);
        panelInfo.add(labelCashDollars);
        panelInfo.add(labelCashDollarsAmmount);

        panelInfo.add(separatorLine);

        panelInfo.add(labelWithdrawQuota);
        panelInfo.add(labelWithdrawQuotaAmmount);
        panelInfo.add(labelDepositQuota);
        panelInfo.add(labelDepositQuotaAmmount);
        // --------

        // Trans panel
        panelTrans.setBounds(40, 220, 1260, 700);
        panelTrans.setLayout(null);
        panelTrans.setOpaque(false);
        panelTrans.setBackground(colorPalette.getColorBackground1());

        tableScrollPane.setBounds(0,0,1260,700);
        tableTransaction.setDefaultEditor(Object.class, null);

        
        panelTrans.add(tableScrollPane);
        // --------


        add(panelUser);
        add(panelInfo);
        add(panelTrans);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        homeFrame.dispose();
        mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}

