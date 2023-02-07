package Containers;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Utils.ColorPalette;

public class PanelHNavBar extends JPanel {

    private ColorPalette colorPalette = new ColorPalette();

    private JLabel labelProfile = new JLabel(),
    labelDeposit = new JLabel(),
    labelWIthdraw = new JLabel(),
    labelBankTransfer = new JLabel(),
    labelSettings = new JLabel();

    public PanelHNavBar() {
        setOpaque(true);
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 50));
        setBackground(colorPalette.getColorBackground1());
        setBorder(BorderFactory.createLineBorder(colorPalette.getColorButtons(), 1));
        setBounds(0, 0, 100, 1000);

        labelProfile.setIcon(new ImageIcon(getClass().getResource("/Images/profile-user.png")));
        labelProfile.setText("Profile");
        labelProfile.setForeground(Color.white);
        labelProfile.setIconTextGap(5);
        labelProfile.setHorizontalTextPosition(JLabel.CENTER);
        labelProfile.setVerticalTextPosition(JLabel.BOTTOM);

        labelDeposit.setIcon(new ImageIcon(getClass().getResource("/Images/deposit.png")));
        labelDeposit.setText("Deposit");
        labelDeposit.setForeground(Color.white);
        labelDeposit.setIconTextGap(5);
        labelDeposit.setHorizontalTextPosition(JLabel.CENTER);
        labelDeposit.setVerticalTextPosition(JLabel.BOTTOM);

        labelWIthdraw.setIcon(new ImageIcon(getClass().getResource("/Images/withdraw.png")));
        labelWIthdraw.setText("Withdraw");
        labelWIthdraw.setForeground(Color.white);
        labelWIthdraw.setIconTextGap(5);
        labelWIthdraw.setHorizontalTextPosition(JLabel.CENTER);
        labelWIthdraw.setVerticalTextPosition(JLabel.BOTTOM);

        labelBankTransfer.setIcon(new ImageIcon(getClass().getResource("/Images/withdraw.png")));
        labelBankTransfer.setText("Transfer");
        labelBankTransfer.setForeground(Color.white);
        labelBankTransfer.setIconTextGap(5);
        labelBankTransfer.setHorizontalTextPosition(JLabel.CENTER);
        labelBankTransfer.setVerticalTextPosition(JLabel.BOTTOM);

        labelSettings.setIcon(new ImageIcon(getClass().getResource("/Images/switch.png")));
        labelSettings.setText("Settings");
        labelSettings.setForeground(Color.white);
        labelSettings.setIconTextGap(5);
        labelSettings.setHorizontalTextPosition(JLabel.CENTER);
        labelSettings.setVerticalTextPosition(JLabel.BOTTOM);

        add(labelProfile);
        add(labelDeposit);
        add(labelWIthdraw);
        add(labelBankTransfer);
        add(labelSettings);
    }
}
