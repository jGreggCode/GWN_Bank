package Containers;

import javax.swing.BorderFactory;
// Imports
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import Backend.Session;
import Backend.UserBalance;
import Backend.Withdraw;
import Utils.*;
import Utils.Button;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.sql.SQLException;

public class PanelHWithdrawBar extends JPanel implements ChangeListener {

    ColorPalette colorPalette = new ColorPalette();
    Defaults def = new Defaults();
    double cash;

    ModalBox modalBox;

    // top tab components
    public JLabel labelCash = new JLabel(),
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
    private JSliderCustom sliderCash = new JSliderCustom();
    private MyTextField txtCash = new MyTextField() {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            if (getText().length() == 0) {
                int h = getHeight();
                int w = getWidth();
                ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                FontMetrics fm = g.getFontMetrics();
                g.setColor(new Color(200, 200, 200));
                g.drawString("Enter desire ammount", w / 2 - 110, h / 2 + fm.getAscent() / 2 - 2);
            }
    }
    };
    private Button btnWithdraw = new Button();
    private ButtonOutLine btnClear = new ButtonOutLine();
    
    // Transaction components
    public TransTable tableTransaction = new TransTable();
    private JScrollPane tableScrollPane = new JScrollPane(tableTransaction);

    public PanelHWithdrawBar(ModalBox modalBox) {
        this.modalBox = modalBox;
        // Withdraw bar panel configuration
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

        labelAmmount.setText("Ammount to withdraw");
        labelAmmount.setFont(new Font(def.getFontFam(), Font.BOLD, 30));
        labelAmmount.setForeground(Color.white);
        labelAmmount.setHorizontalAlignment(JLabel.CENTER);
        labelAmmount.setBounds(0, 215, 1000, 25);

        //txtCash.setHint("Enter desire ammount");
        txtCash.setBounds(1000 / 2 - (300 / 2), 250, 300, 50);
        txtCash.setFont(new Font(def.getFontFam(), Font.BOLD, 20));
        txtCash.setHorizontalAlignment(JLabel.CENTER);
        txtCash.setOpaque(false);
        txtCash.setEditable(false);

        sliderCash.setBounds(1000 / 2 - (500 / 2), 300, 500, 50);
        sliderCash.addChangeListener(this);

        btnWithdraw.setText("Withdraw");
        btnWithdraw.setFont(new Font(def.getFontFam(), Font.BOLD, 20));
        btnWithdraw.setForeground(Color.white);
        btnWithdraw.setBackground(colorPalette.getColorButtons());
        btnWithdraw.setHorizontalAlignment(JLabel.CENTER);
        btnWithdraw.setBounds(1000 / 2 - (150 / 2) - 100, 360, 150, 40);
        btnWithdraw.setFocusable(false);
        btnWithdraw.addActionListener(e -> {

            double ammount = Double.valueOf(txtCash.getText().substring(4));
            UserBalance userBalance = new UserBalance();
            Withdraw with = new Withdraw();
            ModalMessage modalMessage = new ModalMessage();
            double balance = 0;
            try {
                balance = userBalance.getUserBalance(Session.userAccoundNumber);
            } catch (Exception e1) {
                e1.printStackTrace();
            }

            if (ammount > balance) {
                modalBox.labelMessageDetail.setText("Insufficient Balance");
                modalBox.labelMessageType.setText("Transaction Failed");
                modalBox.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                modalMessage.start();
            } else {

                with.withdraw(ammount, Session.userAccoundNumber);
                try {

                    double newAmmount = userBalance.getUserBalance(Session.userAccoundNumber);
                    labelCashAmmount.setText(String.format("PHP %,.2f", newAmmount)); 

                    modalBox.setBorder(BorderFactory.createLineBorder(Color.green, 1));

                    modalMessage.start();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }

        });

        btnClear.setText("Clear");
        btnClear.setFont(new Font(def.getFontFam(), Font.BOLD, 20));
        btnClear.setForeground(Color.white);
        btnClear.setHorizontalAlignment(JLabel.CENTER);
        btnClear.setBounds(1000 / 2 - (150 / 2) + 100, 360, 150, 40);
        btnClear.setFocusable(false);

        tableScrollPane.setBounds(0,420,1000,280);
        tableScrollPane.setOpaque(true);
        tableScrollPane.setBorder(BorderFactory.createEmptyBorder());

        tableTransaction.setDefaultEditor(Object.class, null);
        tableTransaction.setOpaque(true);
        tableTransaction.setFillsViewportHeight(true);
        tableTransaction.setBackground(colorPalette.getColorBackground1());

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
        add(sliderCash);

        add(txtCash);
        add(btnClear);
        add(btnWithdraw);

        add(tableScrollPane);
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
        txtCash.setText("PHP " + sliderCash.getValue());
    }

    public class ModalMessage extends Thread {
        @Override
        public void run() {
            try {
                add(modalBox);
                modalBox.setVisible(true);
                Thread.sleep(2000);
                modalBox.setVisible(false);
                remove(modalBox);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }
}
