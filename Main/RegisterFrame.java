package Main;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Backend.Register;
import Containers.LoginMessage;
import Containers.RegisterMessage;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Random;

import Utils.Button;
import Utils.ButtonOutLine;
import Utils.ColorPalette;
import Utils.Defaults;
import Utils.JCheckBoxCustom;
import Utils.JPanelCustom;
import Utils.Methods;
import Utils.MyPasswordField;
import Utils.MyTextField;

public class RegisterFrame extends JFrame implements MouseListener {
    
    MainFrame mainFrame;
    RegisterMessage registerMessage;
    // Components
    private JPanelCustom leftPanel = new JPanelCustom(50,0,50,0);
    private JPanel rightPanel = new JPanel();

    // Left Panel Components
    private JLabel labelBackground = new JLabel();

    // Right Panel Components
    private JLabel labelRegister = new JLabel(),
    labelGetStarted = new JLabel(),
    labelOptional = new JLabel(),
    labelSee = new JLabel(),
    labelHave = new JLabel(),
    labelHappy = new JLabel(),
    labelPassVisible = new JLabel();

    boolean visible = false;

    private MyTextField txtFirstName = new MyTextField(),
    txtMiddleName = new MyTextField(),
    txtLastName = new MyTextField(),
    txtPhoneNumber = new MyTextField(),
    txtBirthday = new MyTextField(),
    txtVerificationCode = new MyTextField(),
    txtReferalCode = new MyTextField();

    private MyPasswordField txtPassword = new MyPasswordField();
    char defChar = txtPassword.getEchoChar(); 

    private JCheckBoxCustom chkAgree = new JCheckBoxCustom();

    private Button btnRegister = new Button();
    private ButtonOutLine btnLogin = new ButtonOutLine();

    // Utilities
    ColorPalette colors = new ColorPalette();
    Defaults def = new Defaults();
    Methods methods = new Methods();
    Register register = new Register();

    public void clear() {
        txtFirstName.setText("");
        txtMiddleName.setText("");
        txtLastName.setText("");
        txtPhoneNumber.setText("");
        txtBirthday.setText("");
        txtVerificationCode.setText("");
        txtReferalCode.setText("");
        txtPassword.setText("");
        chkAgree.setSelected(false);
    }

    ImageIcon registerBg = new ImageIcon(getClass().getResource("/Images/registerVector.jpeg"));

    public RegisterFrame(MainFrame mainFrame, RegisterMessage registerMessage) {
        this.mainFrame = mainFrame;
        this.registerMessage = registerMessage;
        // Home frame configuration
        setTitle("Create an account");
        setIconImage(new ImageIcon(getClass().getResource("/Images/JustLogo.png")).getImage());
        setSize(1440,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(colors.getColorBackground1());
        setLocationRelativeTo(null);
        add(registerMessage);

        leftPanel.setLayout(null);
        leftPanel.setBackground(new Color(255,255,255));
        leftPanel.setBounds(50,100, 620, 760);

        labelBackground.setIcon(methods.imageResize(registerBg, 904 / 2 , 781 / 2));
        labelBackground.setBounds(620 / 2 - (940 / 2 / 2),50, 904 / 2, 781 / 2);

        labelHave.setText("Already have an account?");
        labelHave.setFont(new Font(def.getFontFam(), Font.BOLD, 28));
        labelHave.setHorizontalAlignment(JLabel.CENTER);
        labelHave.setForeground(Color.black);
        labelHave.setBounds(0,440, 620, 50);

        labelHappy.setText("We Are Happy To Have You Back");
        labelHappy.setFont(new Font(def.getFontFam(), Font.PLAIN, 18));
        labelHappy.setHorizontalAlignment(JLabel.CENTER);
        labelHappy.setForeground(Color.black);
        labelHappy.setBounds(0,470, 620, 50);

        btnLogin.setText("Login");
        btnLogin.setFont(new Font(def.getFontFam(), Font.PLAIN, 18));
        btnLogin.setForeground(Color.black);
        btnLogin.setBackground(Color.black);
        btnLogin.setFocusable(false);
        btnLogin.setBounds(620 / 2 - (350 / 2),550, 350, 50);
        btnLogin.addActionListener(e -> {
            this.dispose();
            mainFrame.setVisible(true);
        });

        leftPanel.add(labelBackground);
        leftPanel.add(labelHave);
        leftPanel.add(labelHappy);
        leftPanel.add(btnLogin);

        rightPanel.setBackground(colors.getColorBackground1());
        rightPanel.setBounds(755,0, 620, 1000);
        rightPanel.setLayout(null);

        labelRegister.setText("Create an account");
        labelRegister.setFont(new Font(def.getFontFam(), Font.BOLD, 30));
        labelRegister.setHorizontalAlignment(JLabel.CENTER);
        labelRegister.setForeground(Color.white);
        labelRegister.setBounds(0,30, 620, 100);

        labelGetStarted.setText("Get started by creating your new account");
        labelGetStarted.setFont(new Font(def.getFontFam(), Font.PLAIN, 18));
        labelGetStarted.setHorizontalAlignment(JLabel.CENTER);
        labelGetStarted.setForeground(Color.white);
        labelGetStarted.setBounds(0,80, 620, 50);

        txtFirstName.setHint("First Name");
        txtFirstName.setFont(new Font(def.getFontFam(), Font.PLAIN, 18));
        txtFirstName.setForeground(Color.black);
        txtFirstName.setBounds(620 / 2 - (400 / 2),150, 400, 50);
        
        txtMiddleName.setHint("Middle Name");
        txtMiddleName.setFont(new Font(def.getFontFam(), Font.PLAIN, 18));
        txtMiddleName.setForeground(Color.black);
        txtMiddleName.setBounds(620 / 2 - (400 / 2),220, 400, 50);
        
        txtLastName.setHint("Last Name");
        txtLastName.setFont(new Font(def.getFontFam(), Font.PLAIN, 18));
        txtLastName.setForeground(Color.black);
        txtLastName.setBounds(620 / 2 - (400 / 2),290, 400, 50);

        txtPhoneNumber.setHint("Phone Number");
        txtPhoneNumber.setFont(new Font(def.getFontFam(), Font.PLAIN, 18));
        txtPhoneNumber.setForeground(Color.black);
        txtPhoneNumber.setBounds(620 / 2 - (400 / 2),360, 400, 50);

        txtBirthday.setHint("Birthday");
        txtBirthday.setFont(new Font(def.getFontFam(), Font.PLAIN, 18));
        txtBirthday.setForeground(Color.black);
        txtBirthday.setBounds(620 / 2 - (400 / 2),430, 400, 50);

        txtPassword.setHint("Password");
        txtPassword.setFont(new Font(def.getFontFam(), Font.PLAIN, 18));
        txtPassword.setForeground(Color.black);
        txtPassword.setBounds(620 / 2 - (400 / 2),500, 400, 50);

        labelPassVisible.setIcon(new ImageIcon(getClass().getResource("/Images/passInvisible.png")));
        labelPassVisible.setOpaque(false);
        labelPassVisible.setBounds(350,0, 50, 50);
        labelPassVisible.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelPassVisible.addMouseListener(this);
        txtPassword.add(labelPassVisible);

        labelSee.setText("Check your mail to see the OTP");
        labelSee.setFont(new Font(def.getFontFam(), Font.BOLD, 18));
        labelSee.setForeground(Color.white);
        labelSee.setBounds(620 / 2 - (400 / 2),550, 400, 50);

        txtVerificationCode.setHint("Verification Code (OTP)");
        txtVerificationCode.setFont(new Font(def.getFontFam(), Font.PLAIN, 18));
        txtVerificationCode.setForeground(Color.black);
        txtVerificationCode.setBounds(620 / 2 - (400 / 2),590, 400, 50);

        labelOptional.setText("(Optional)");
        labelOptional.setFont(new Font(def.getFontFam(), Font.BOLD, 18));
        labelOptional.setForeground(Color.white);
        labelOptional.setBounds(620 / 2 - (400 / 2),650, 400, 50);

        txtReferalCode.setHint("Referal Code");
        txtReferalCode.setFont(new Font(def.getFontFam(), Font.PLAIN, 18));
        txtReferalCode.setForeground(Color.black);
        txtReferalCode.setBounds(620 / 2 - (400 / 2),690, 400, 50);

        chkAgree.setText("<html>By clicking, you agree to the GWN Bank's <br> terms and condition</html");
        chkAgree.setIconTextGap(10);
        chkAgree.setFont(new Font(def.getFontFam(), Font.PLAIN, 16));
        chkAgree.setForeground(Color.white);
        chkAgree.setBounds(620 / 2 - (400 / 2),750, 400, 50);

        btnRegister.setText("Register");
        btnRegister.setFont(new Font(def.getFontFam(), Font.PLAIN, 18));
        btnRegister.setForeground(Color.white);
        btnRegister.setBackground(colors.getColorButtons());
        btnRegister.setFocusable(false);
        btnRegister.setBounds(620 / 2 - (200 / 2),820, 200, 50);
        btnRegister.addActionListener(e -> {

            String fullname = txtFirstName.getText() + " " + txtMiddleName.getText().charAt(0) + ". " + txtLastName.getText();
            String password = String.valueOf(txtPassword.getPassword());
            int code = Defaults.verificationCode;
            int verificationCode = Integer.valueOf(txtVerificationCode.getText());
            //System.out.println(code);
            //System.out.println(verificationCode);

            Random random = new Random();
            int number = random.nextInt(20000000, 90000000);
            LogMessage logMessage = new LogMessage();

            try {
                while (register.checkDuplicate(number)) {
                    number = random.nextInt(20000000, 90000000);
                }

                if (chkAgree.isSelected()) {
                    if (code != verificationCode) {
                        registerMessage.labelMessageDetail.setText("Invalid Verification Code");
                        logMessage.start();
                    } else {
                        registerMessage.labelMessageType.setText("Register Successfully");
                        registerMessage.labelMessageDetail.setText("Your account number is: " + number);
                        registerMessage.setBorder(BorderFactory.createLineBorder(Color.green, 1));
                        logMessage.start();
                        clear();
                        int defaultCash = 20000;
                        if (txtReferalCode.getText().equalsIgnoreCase("gregg")) {
                            defaultCash = 50000;
                        }
                        register.register(defaultCash, 
                        number, 
                        Defaults.email, 
                        fullname, 
                        password, 
                        "Fully Verified");
                    }
                } else {
                    registerMessage.labelMessageDetail.setText("Please check the terms and condition");
                    logMessage.start();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }


        });

        rightPanel.add(labelRegister);
        rightPanel.add(labelGetStarted);
        rightPanel.add(txtFirstName);
        rightPanel.add(txtMiddleName);
        rightPanel.add(txtLastName);
        rightPanel.add(txtPhoneNumber);
        rightPanel.add(txtBirthday);
        rightPanel.add(txtPassword);
        rightPanel.add(labelSee);
        rightPanel.add(txtVerificationCode);
        rightPanel.add(labelOptional);
        rightPanel.add(txtReferalCode);
        rightPanel.add(chkAgree);

        rightPanel.add(btnRegister);

        add(rightPanel);
        add(leftPanel);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == labelPassVisible) {
            if (!visible) {
                txtPassword.setEchoChar((char)0); 
                labelPassVisible.setIcon(new ImageIcon(getClass().getResource("/Images/passVisible.png")));
                visible = true;
            } else {
                labelPassVisible.setIcon(new ImageIcon(getClass().getResource("/Images/passInvisible.png")));
                txtPassword.setEchoChar(defChar);
                visible = false;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public class LogMessage extends Thread {
        @Override
        public void run() {
            try {
                
                registerMessage.setVisible(true);
                Thread.sleep(4000);
                registerMessage.setVisible(false);
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }
}
