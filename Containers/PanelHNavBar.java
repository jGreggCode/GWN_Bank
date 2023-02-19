package Containers;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


import Backend.Session;
import Backend.Transaction;
import Connection.DatabaseConnection;
import Main.HomeFrame;

import java.awt.event.*;
import java.sql.Connection;

import Utils.ColorPalette;
import Utils.Defaults;

public class PanelHNavBar extends JPanel implements MouseListener {
    private final Connection con;

    HomeFrame hm;

    private ColorPalette colorPalette = new ColorPalette();
    private Defaults def = new Defaults();

    PanelHUserBar userBar;
    PanelHDepositBar depBar;
    PanelHWithdrawBar withBar;
    PanelHTransferBar transBar;

    // Just for design
    private boolean userOpen, withdrawOpen, depositOpen, transferOpen, settingOpen;

    private JLabel labelProfile = new JLabel(),
    labelDeposit = new JLabel(),
    labelWIthdraw = new JLabel(),
    labelBankTransfer = new JLabel(),
    labelSettings = new JLabel(),
    labelIcon = new JLabel();

    public PanelHNavBar(PanelHUserBar userBar, PanelHDepositBar depBar, PanelHWithdrawBar withBar, 
    PanelHTransferBar transBar, HomeFrame hm) {

        DatabaseConnection mysqlConnect = new DatabaseConnection();
        con = mysqlConnect.connect();

        this.userBar = userBar;
        this.depBar = depBar;
        this.withBar = withBar;
        this.transBar = transBar;
        this.hm = hm;

        setOpaque(true);
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 50));
        setBackground(colorPalette.getColorBackground1());
        //setBorder(BorderFactory.createLineBorder(colorPalette.getColorButtons(), 1));
        setBounds(0, 0, 80, 800);

        labelProfile.setIcon(new ImageIcon(getClass().getResource("/Images/account.png")));
        labelProfile.setText("Profile");
        labelProfile.setForeground(Color.white);
        labelProfile.setFont(new Font(def.getFontFam(), Font.BOLD, 13));
        labelProfile.setIconTextGap(5);
        labelProfile.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelProfile.setHorizontalTextPosition(JLabel.CENTER);
        labelProfile.setVerticalTextPosition(JLabel.BOTTOM);
        labelProfile.addMouseListener(this);

        labelDeposit.setIcon(new ImageIcon(getClass().getResource("/Images/deposit.png")));
        labelDeposit.setText("Deposit");
        labelDeposit.setForeground(Color.white);
        labelDeposit.setIconTextGap(5);
        labelDeposit.setHorizontalTextPosition(JLabel.CENTER);
        labelDeposit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelDeposit.setVerticalTextPosition(JLabel.BOTTOM);
        labelDeposit.addMouseListener(this);

        labelWIthdraw.setIcon(new ImageIcon(getClass().getResource("/Images/withdraw.png")));
        labelWIthdraw.setText("Withdraw");
        labelWIthdraw.setForeground(Color.white);
        labelWIthdraw.setIconTextGap(5);
        labelWIthdraw.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelWIthdraw.setHorizontalTextPosition(JLabel.CENTER);
        labelWIthdraw.setVerticalTextPosition(JLabel.BOTTOM);
        labelWIthdraw.addMouseListener(this);

        labelBankTransfer.setIcon(new ImageIcon(getClass().getResource("/Images/transfer.png")));
        labelBankTransfer.setText("Transfer");
        labelBankTransfer.setForeground(Color.white);
        labelBankTransfer.setIconTextGap(5);
        labelBankTransfer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelBankTransfer.setHorizontalTextPosition(JLabel.CENTER);
        labelBankTransfer.setVerticalTextPosition(JLabel.BOTTOM);
        labelBankTransfer.addMouseListener(this);

        labelSettings.setIcon(new ImageIcon(getClass().getResource("/Images/setting.png")));
        labelSettings.setText("Settings");
        labelSettings.setForeground(Color.white);
        labelSettings.setIconTextGap(5);
        labelSettings.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelSettings.setHorizontalTextPosition(JLabel.CENTER);
        labelSettings.setVerticalTextPosition(JLabel.BOTTOM);
        labelSettings.addMouseListener(this);

        labelIcon.setIcon(new ImageIcon(getClass().getResource("/Images/BankLogoN.png")));

        add(labelProfile);
        add(labelDeposit);
        add(labelWIthdraw);
        add(labelBankTransfer);
        add(labelSettings);
        add(labelIcon);
    }

    @Override
    public void mouseClicked(MouseEvent e) {


        if (e.getSource() == labelProfile) {

            hm.setTitle("User Profile");
            Double cash = (double) Session.userBalance;
            Transaction trans = new Transaction(userBar);

            trans.transactionUserTable();
            userBar.labelCashAmmount.setText(String.format("PHP %,.2f", cash));
            userBar.labelCashDollarsAmmount.setText(String.format("USD %,.2f", (cash * 54.79))); 
            userBar.labelUserName.setText(Session.userName); 

            userBar.setVisible(true);
            depBar.setVisible(false);
            withBar.setVisible(false);
            transBar.setVisible(false);

            userOpen = true;
            withdrawOpen = false;
            depositOpen = false;
            transferOpen = false;
            settingOpen = false;
            labelProfile.setIcon(new ImageIcon(getClass().getResource("/Images/accountClicked.png")));

            labelWIthdraw.setIcon(new ImageIcon(getClass().getResource("/Images/withdraw.png")));
            labelDeposit.setIcon(new ImageIcon(getClass().getResource("/Images/deposit.png")));
            labelBankTransfer.setIcon(new ImageIcon(getClass().getResource("/Images/transfer.png")));
            labelSettings.setIcon(new ImageIcon(getClass().getResource("/Images/setting.png")));
        }

        if (e.getSource() == labelWIthdraw) {

            hm.setTitle("Cash Withdrawal");
            Transaction trans = new Transaction(withBar);

            trans.transactionWithTable();

            Double cash = (double) Session.userBalance;
            withBar.labelCashAmmount.setText(String.format("PHP %,.2f", cash));
            withBar.labelCashDollarsAmmount.setText(String.format("USD %,.2f", (cash * 54.79)));
            
            withBar.setVisible(true);
            depBar.setVisible(false);
            userBar.setVisible(false);
            transBar.setVisible(false);

            userOpen = false;
            withdrawOpen = true;
            depositOpen = false;
            transferOpen = false;
            settingOpen = false;
            labelWIthdraw.setIcon(new ImageIcon(getClass().getResource("/Images/withdrawClicked.png")));

            labelProfile.setIcon(new ImageIcon(getClass().getResource("/Images/account.png")));
            labelDeposit.setIcon(new ImageIcon(getClass().getResource("/Images/deposit.png")));
            labelBankTransfer.setIcon(new ImageIcon(getClass().getResource("/Images/transfer.png")));
            labelSettings.setIcon(new ImageIcon(getClass().getResource("/Images/setting.png")));
        }

        if (e.getSource() == labelDeposit) {

            hm.setTitle("Cash Deposit");
            Transaction trans = new Transaction(depBar);

            trans.transactionDepTable();

            Double cash = (double) Session.userBalance;
            depBar.labelCashAmmount.setText(String.format("PHP %,.2f", cash));
            depBar.labelCashDollarsAmmount.setText(String.format("USD %,.2f", (cash * 54.79))); 

            depBar.setVisible(true);
            userBar.setVisible(false);
            withBar.setVisible(false);
            transBar.setVisible(false);

            userOpen = false;
            withdrawOpen = false;
            depositOpen = true;
            transferOpen = false;
            settingOpen = false;
            labelDeposit.setIcon(new ImageIcon(getClass().getResource("/Images/depositClicked.png")));
            
            labelProfile.setIcon(new ImageIcon(getClass().getResource("/Images/account.png")));
            labelWIthdraw.setIcon(new ImageIcon(getClass().getResource("/Images/withdraw.png")));
            labelBankTransfer.setIcon(new ImageIcon(getClass().getResource("/Images/transfer.png")));
            labelSettings.setIcon(new ImageIcon(getClass().getResource("/Images/setting.png")));
            
        }

        if (e.getSource() == labelBankTransfer) {

            hm.setTitle("Money Transfer");
            Transaction trans = new Transaction(transBar);

            trans.transactionTransTable();

            Double cash = (double) Session.userBalance;
            transBar.labelCashAmmount.setText(String.format("PHP %,.2f", cash));
            transBar.labelCashDollarsAmmount.setText(String.format("USD %,.2f", (cash * 54.79))); 

            transBar.setVisible(true);
            depBar.setVisible(false);
            userBar.setVisible(false);
            withBar.setVisible(false);

            userOpen = false;
            withdrawOpen = false;
            depositOpen = false;
            transferOpen = true;
            settingOpen = false;
            labelBankTransfer.setIcon(new ImageIcon(getClass().getResource("/Images/transferClicked.png")));

            
            labelProfile.setIcon(new ImageIcon(getClass().getResource("/Images/account.png")));
            labelWIthdraw.setIcon(new ImageIcon(getClass().getResource("/Images/withdraw.png")));
            labelDeposit.setIcon(new ImageIcon(getClass().getResource("/Images/deposit.png")));
            labelSettings.setIcon(new ImageIcon(getClass().getResource("/Images/setting.png")));
            
        }

        if (e.getSource() == labelSettings) {
            userOpen = false;
            withdrawOpen = false;
            depositOpen = false;
            transferOpen = false;
            settingOpen = true;
            labelSettings.setIcon(new ImageIcon(getClass().getResource("/Images/settingClicked.png")));

            
            labelProfile.setIcon(new ImageIcon(getClass().getResource("/Images/account.png")));
            labelWIthdraw.setIcon(new ImageIcon(getClass().getResource("/Images/withdraw.png")));
            labelBankTransfer.setIcon(new ImageIcon(getClass().getResource("/Images/transfer.png")));
            labelDeposit.setIcon(new ImageIcon(getClass().getResource("/Images/deposit.png")));
            
        }
        
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

        if (e.getSource() == labelProfile) {
            labelProfile.setIcon(new ImageIcon(getClass().getResource("/Images/accountClicked.png")));
        }

        if (e.getSource() == labelWIthdraw) {

            labelWIthdraw.setIcon(new ImageIcon(getClass().getResource("/Images/withdrawClicked.png")));
        }

        if (e.getSource() == labelDeposit) {
            labelDeposit.setIcon(new ImageIcon(getClass().getResource("/Images/depositClicked.png")));
            
        }

        if (e.getSource() == labelBankTransfer) {
            labelBankTransfer.setIcon(new ImageIcon(getClass().getResource("/Images/transferClicked.png")));
            
        }

        if (e.getSource() == labelSettings) {
            labelSettings.setIcon(new ImageIcon(getClass().getResource("/Images/settingClicked.png")));
            
        }
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
        if (e.getSource() == labelProfile && !userOpen) {
            labelProfile.setIcon(new ImageIcon(getClass().getResource("/Images/account.png")));
        }

        if (e.getSource() == labelWIthdraw && !withdrawOpen) {

            labelWIthdraw.setIcon(new ImageIcon(getClass().getResource("/Images/withdraw.png")));
        }

        if (e.getSource() == labelDeposit && !depositOpen) {
            labelDeposit.setIcon(new ImageIcon(getClass().getResource("/Images/deposit.png")));
            
        }

        if (e.getSource() == labelBankTransfer && !transferOpen) {
            labelBankTransfer.setIcon(new ImageIcon(getClass().getResource("/Images/transfer.png")));
            
        }

        if (e.getSource() == labelSettings && !settingOpen) {
            labelSettings.setIcon(new ImageIcon(getClass().getResource("/Images/setting.png")));
            
        }
        
    }
}
