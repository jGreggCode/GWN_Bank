package Containers;

// Imports
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.*;
import Backend.Session;
import Backend.TransactionData;
import Backend.Transfer;
import Backend.UserBalance;
import Backend.UserName;
import Utils.*;
import Utils.Button;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PanelHTransferBar extends JPanel implements ChangeListener, KeyListener {
    
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
    public JSeparator separatorLine = new JSeparator();
    public JSeparator separatorLine2 = new JSeparator();

    // bottom tab components
    public JLabel labelAmmount = new JLabel();
    public JSliderCustom sliderCash = new JSliderCustom();

    public MyTextField txtAccountNumber = new MyTextField() {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            if (getText().length() == 0) {
                int h = getHeight();
                int w = getWidth();
                ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                FontMetrics fm = g.getFontMetrics();
                g.setColor(new Color(200, 200, 200));
                g.drawString("Enter account number", w / 2 - 110, h / 2 + fm.getAscent() / 2 - 2);
            }
    }
    };

    public MyTextField txtCash = new MyTextField() {
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
    public Button btnTransfer = new Button();
    public ButtonOutLine btnClear = new ButtonOutLine();
    
    // Transaction components
    public TransTable tableTransaction = new TransTable();
    public JScrollPane tableScrollPane = new JScrollPane(tableTransaction);

    public InputPinCode inputPinCode = new InputPinCode();
    public boolean correctCode = false;

    public PanelHTransferBar(ModalBox modalBox) {
        this.modalBox = modalBox;
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

        labelAmmount.setText("Bank Transfer");
        labelAmmount.setFont(new Font(def.getFontFam(), Font.BOLD, 30));
        labelAmmount.setForeground(Color.white);
        labelAmmount.setHorizontalAlignment(JLabel.CENTER);
        labelAmmount.setBounds(0, 215, 1000, 25);

        txtAccountNumber.setBounds(1000 / 2 - (300 / 2), 250, 300, 50);
        txtAccountNumber.setFont(new Font(def.getFontFam(), Font.BOLD, 20));
        txtAccountNumber.setHorizontalAlignment(JLabel.CENTER);
        txtAccountNumber.setOpaque(false);
        txtAccountNumber.setDocument(new TextLimit(8));
        txtAccountNumber.addKeyListener(this);

        txtCash.setBounds(1000 / 2 - (300 / 2), 320, 300, 50);
        txtCash.setFont(new Font(def.getFontFam(), Font.BOLD, 20));
        txtCash.setHorizontalAlignment(JLabel.CENTER);
        txtCash.setOpaque(false);
        txtCash.setEditable(false);

        sliderCash.setBounds(1000 / 2 - (500 / 2), 370, 500, 50);
        sliderCash.addChangeListener(this);

        btnTransfer.setText("Transfer");
        btnTransfer.setFont(new Font(def.getFontFam(), Font.BOLD, 20));
        btnTransfer.setForeground(Color.white);
        btnTransfer.setBackground(colorPalette.getColorButtons());
        btnTransfer.setHorizontalAlignment(JLabel.CENTER);
        btnTransfer.setBounds(1000 / 2 - (150 / 2) - 100, 420, 150, 40);
        btnTransfer.setFocusable(false);
        btnTransfer.addActionListener(e -> {
            
            new InputPinCode().setVisible(true);

        });

        btnClear.setText("Clear");
        btnClear.setFont(new Font(def.getFontFam(), Font.BOLD, 20));
        btnClear.setForeground(Color.white);
        btnClear.setHorizontalAlignment(JLabel.CENTER);
        btnClear.setBounds(1000 / 2 - (150 / 2) + 100, 420, 150, 40);
        btnClear.setFocusable(false);
        btnClear.addActionListener(e2 -> {
            txtAccountNumber.setText("");
            txtCash.setText("");
        });

        tableScrollPane.setBounds(0,470,1000,280);
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

        add(txtAccountNumber);
        add(labelAmmount);
        add(sliderCash);

        add(txtCash);
        add(btnClear);
        add(btnTransfer);

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

    public class InputPinCode extends JFrame {

        private JLabel enterPinCode = new JLabel();
        private MyPasswordField psPinCode = new MyPasswordField();
        private Button btnConfirm = new Button();

        // Panel for code
        public InputPinCode() {
            setUndecorated(true);
            setPreferredSize(new Dimension(400, 300));
            setSize(getPreferredSize().width, getPreferredSize().height);
            setResizable(false);
            setLayout(null);
            getContentPane().setBackground(colorPalette.getColorBackground());
            setLocationRelativeTo(null);

            enterPinCode.setText("Enter your pin code");
            enterPinCode.setForeground(Color.white);
            enterPinCode.setHorizontalAlignment(JLabel.CENTER);
            enterPinCode.setFont(new Font(def.getFontFam(), Font.BOLD, 20));
            enterPinCode.setBounds(0, 80, 400, 50);

            psPinCode.setColumns(6);
            psPinCode.setHorizontalAlignment(JLabel.CENTER);
            psPinCode.setBounds(20, 130, 360, 50);
            psPinCode.setDocument(new TextLimit(6));

            btnConfirm.setText("Confirm");
            btnConfirm.setForeground(Color.white);
            btnConfirm.setBackground(colorPalette.getColorButtons());
            btnConfirm.setHorizontalAlignment(JLabel.CENTER);
            btnConfirm.setFont(new Font(def.getFontFam(), Font.BOLD, 15));
            btnConfirm.setBounds(400 / 2 - (100 / 2),190,100,50);
            btnConfirm.addActionListener(e -> {

                String password = String.valueOf(psPinCode.getPassword());
                    
                ModalMessage modalMessage = new ModalMessage();

                if (password.equalsIgnoreCase(Session.userPinCode)) {

                    System.out.println(txtCash.getText().equals(""));
                    
                    if (!txtCash.getText().equals("")) {
                        double ammount = Double.valueOf(txtCash.getText().substring(4));
                        UserBalance userBalance = new UserBalance();
                        UserName name = new UserName();
                        Transfer transfer = new Transfer();
                        int account2 = Integer.parseInt(txtAccountNumber.getText());
                        
                        double balance = 0;
                        String userName = null;

                        TransactionData transactionData = new TransactionData();
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
                        Date dateAndTime = new Date(); 
                        String dateToday = formatter.format(dateAndTime);
                        int oldBalance = Session.userBalance;

                        try {
                            balance = userBalance.getUserBalance(Session.userAccoundNumber);
                            userName = name.getUserName(account2);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        
                        String message = String.format("Do you want to transfer PHP %,.2f to %s", ammount, userName);

                        boolean userFound = transfer.invalidUser(account2);

                        if (userFound) {

                            //String pincode = JOptionPane.showInputDialog(null, "PLease enter you pin code");
                            if (ammount > balance) {
                                modalBox.labelMessageDetail.setText("Insufficient Balance");
                                modalBox.labelMessageType.setText("Transaction Failed");
                                modalBox.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                                modalMessage.start();
                            } else {
                                int answer = JOptionPane.showConfirmDialog(null, message, "Are you sure?", JOptionPane.YES_NO_OPTION);
                
                                if (answer == 0) {
                                    transfer.transfer(ammount, Session.userAccoundNumber, account2);
                                    try {
                
                                        double newAmmount = userBalance.getUserBalance(Session.userAccoundNumber);
                                        int newBalance = (int) newAmmount;
                                        labelCashAmmount.setText(String.format("PHP %,.2f", newAmmount)); 
                
                                        modalBox.setBorder(BorderFactory.createLineBorder(Color.green, 1));
                                        modalBox.labelMessageType.setText("Transaction Completed");
                                        modalBox.labelMessageDetail.setText("Thank you for using GWN BANK");
                                        transactionData.addDeposit(Session.userAccoundNumber, "Bank Transfer", dateToday, "Philippines", oldBalance, newBalance);
        
                                        modalMessage.start();
                                    } catch (SQLException e1) {
                                        // TODO Auto-generated catch block
                                        e1.printStackTrace();
                                    }
                                } else {
                                    modalBox.labelMessageType.setText("Transaction Canceled");
                                    modalBox.labelMessageDetail.setText("Thank you for using GWN BANK");
                                    modalBox.setBorder(BorderFactory.createLineBorder(Color.orange, 1));
                                    modalMessage.start();
                                }
                            } 

                        } else {
                            modalBox.labelMessageType.setText("Transaction Failed");
                            modalBox.labelMessageDetail.setText("Invalid Account Number");
                            modalBox.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                            modalMessage.start();
                        }
                    } else {
                        modalBox.labelMessageType.setText("Transaction Failed");
                        modalBox.labelMessageDetail.setText("Amount field is empty");
                        modalBox.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                        modalMessage.start();
                    }

                } else {
                    modalBox.labelMessageType.setText("Transaction Failed");
                    modalBox.labelMessageDetail.setText("Invalid Pin Code");
                    modalBox.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                    modalMessage.start();
                }

                this.dispose();
            });

            add(enterPinCode);
            add(psPinCode);
            add(btnConfirm);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        // TODO Auto-generated method stub
        txtCash.setText("PHP " + sliderCash.getValue());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        char c = e.getKeyChar();
        if (!Character.isDigit(c) && e.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
            txtAccountNumber.setEditable(false);
        } else {
            txtAccountNumber.setEditable(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
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