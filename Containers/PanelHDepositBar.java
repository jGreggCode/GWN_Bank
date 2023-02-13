package Containers;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Backend.Session;
import Utils.*;
import Utils.Button;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class PanelHDepositBar extends JPanel implements ChangeListener {

    ColorPalette colorPalette = new ColorPalette();
    Defaults def = new Defaults();
    double cash;

    // top tab components
    private JLabel labelCash = new JLabel(),
    labelCashAmmount = new JLabel(),
    labelCashDollars = new JLabel(),
    labelCashDollarsAmmount = new JLabel(),
    labelDepositQuota = new JLabel(),
    labelWithdrawQuota = new JLabel(),
    labelDepositQuotaAmmount = new JLabel(),
    labelWithdrawQuotaAmmount = new JLabel();
    private JSeparator separatorLine = new JSeparator();
    private JSeparator separatorLine2 = new JSeparator();

    // bottom tab components
    private JLabel labelAmmount = new JLabel();
    private JLabel labelMoney = new JLabel();
    private JSliderCustom sliderCash = new JSliderCustom();
    private MyTextField txtCash = new MyTextField();
    private ButtonOutLine btnDeposit = new ButtonOutLine();
    private ButtonOutLine btnClear = new ButtonOutLine();

    public PanelHDepositBar() {
        setOpaque(false);
        setBackground(colorPalette.getColorBackground1());
        setVisible(false);
        setLayout(null);
        setBounds((1360 / 2 - (1000 / 2)) + 70,1000 / 2 - (700 / 2) - 20, 1000, 700);

        labelCash.setText("Balance:");
        labelCash.setBounds(20, 20, 200, 40);
        labelCash.setForeground(Color.white);
        labelCash.setFont(new Font(def.getFontFam(), Font.BOLD, 25));

        cash = Session.userBalance;
        double withdrawn = 0;
        double deposited = 0;

        labelCashAmmount.setText(String.format("PHP %,.2f", cash)); 
        labelCashAmmount.setHorizontalAlignment(JLabel.TRAILING);
        labelCashAmmount.setBounds(727, 20, 250, 40);
        labelCashAmmount.setForeground(Color.white);
        labelCashAmmount.setFont(new Font(def.getFontFam(), Font.BOLD, 25));

        labelCashDollars.setText("Balance in dollars:");
        labelCashDollars.setBounds(20, 50, 200, 25);
        labelCashDollars.setForeground(Color.white);
        labelCashDollars.setFont(new Font(def.getFontFam(), Font.PLAIN, 15));

        labelCashDollarsAmmount.setText(String.format("USD %,.2f", (cash * 54.79))); 
        labelCashDollarsAmmount.setHorizontalAlignment(JLabel.TRAILING);
        labelCashDollarsAmmount.setBounds(727, 50, 250, 25);
        labelCashDollarsAmmount.setForeground(Color.white);
        labelCashDollarsAmmount.setFont(new Font(def.getFontFam(), Font.BOLD, 15));

        separatorLine2.setForeground(colorPalette.getColorBackground());
        separatorLine2.setBounds(1000 / 2 - (500 / 2), 75, 500, 10);

        labelWithdrawQuota.setText("Daily withdraw quota:");
        labelWithdrawQuota.setBounds(20, 80, 200, 25);
        labelWithdrawQuota.setForeground(Color.white);
        labelWithdrawQuota.setFont(new Font(def.getFontFam(), Font.PLAIN, 15));

        labelWithdrawQuotaAmmount.setText(String.format("PHP %,.2f" + " / 100,000.00", withdrawn)); 
        labelWithdrawQuotaAmmount.setHorizontalAlignment(JLabel.TRAILING);
        labelWithdrawQuotaAmmount.setBounds(727, 80, 250, 25);
        labelWithdrawQuotaAmmount.setForeground(Color.white);
        labelWithdrawQuotaAmmount.setFont(new Font(def.getFontFam(), Font.BOLD, 15));

        labelDepositQuota.setText("Daily deposit quota:");
        labelDepositQuota.setBounds(20, 100, 200, 25);
        labelDepositQuota.setForeground(Color.white);
        labelDepositQuota.setFont(new Font(def.getFontFam(), Font.PLAIN, 15));

        labelDepositQuotaAmmount.setText(String.format("PHP %,.2f"  + " / 500,000.00", deposited)); 
        labelDepositQuotaAmmount.setHorizontalAlignment(JLabel.TRAILING);
        labelDepositQuotaAmmount.setBounds(727, 100, 250, 25);
        labelDepositQuotaAmmount.setForeground(Color.white);
        labelDepositQuotaAmmount.setFont(new Font(def.getFontFam(), Font.BOLD, 15));
        
        separatorLine.setForeground(colorPalette.getColorButtons());
        separatorLine.setBounds(1000 / 2 - (900 / 2), 140, 900, 10);

        labelAmmount.setText("AMMOUNT");
        labelAmmount.setFont(new Font(def.getFontFam(), Font.BOLD, 30));
        labelAmmount.setForeground(Color.white);
        labelAmmount.setHorizontalAlignment(JLabel.CENTER);
        labelAmmount.setBounds(0, 220, 1000, 25);

        labelMoney.setText("PHP " + "0.00");
        labelMoney.setFont(new Font(def.getFontFam(), Font.BOLD, 30));
        labelMoney.setForeground(Color.white);
        labelMoney.setHorizontalAlignment(JLabel.CENTER);
        labelMoney.setBounds(0, 250, 1000, 25);

        sliderCash.setBounds(1000 / 2 - (500 / 2), 280, 500, 50);
        sliderCash.addChangeListener(this);

        txtCash.setHint("Enter desire ammount");
        txtCash.setBounds(getVisibleRect());;

        btnDeposit.setText("Deposit");
        btnDeposit.setBounds(getVisibleRect());

        btnClear.setText("Clear");
        btnClear.setBounds(getVisibleRect());

        // Add components
        add(labelCash);
        add(labelCashAmmount);
        add(labelCashDollars);
        add(labelCashDollarsAmmount);

        add(separatorLine2);

        add(labelWithdrawQuota);
        add(labelWithdrawQuotaAmmount);
        add(labelDepositQuota);
        add(labelDepositQuotaAmmount);

        add(separatorLine);

        add(labelAmmount);
        add(labelMoney);
        add(sliderCash);

        add(txtCash);
        add(btnClear);
        add(btnDeposit);
    }

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

    @Override
    public void stateChanged(ChangeEvent e) {
        // TODO Auto-generated method stub
        labelMoney.setText("PHP " + sliderCash.getValue());
    }
}
