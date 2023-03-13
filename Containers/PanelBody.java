package Containers;

import javax.swing.BorderFactory;
// Imports
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.regex.Pattern;
import Main.HomeFrame;
import Main.MainFrame;
import Model.ModelLogin;
import Model.ModelUser;
import Backend.Session;
import Backend.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import Utils.MyTextField;
import Utils.TextLimit;
import Utils.MyPasswordField;
import Utils.Defaults;
import Utils.Methods;
import Utils.Button;
import Utils.ColorPalette;

public class PanelBody extends JPanel implements ActionListener, MouseListener, KeyListener { 
    
    // Prerequisite Objects
    private MainFrame m;
    private LoginMessage loginMessage;
    private User log = new User();
    private ModelLogin dataLogin;
    private Methods methods = new Methods();

    // Label
    private JLabel labelLogin = new JLabel();
    private JLabel labelPassVisible = new JLabel();
    private JLabel labelforgotPassword = new JLabel();

    // Text field
    private MyTextField customTextField = new MyTextField();

    // Password field
    private MyPasswordField customPasswordField = new MyPasswordField();
    boolean visible = false;
    char defChar = customPasswordField.getEchoChar(); 

    // Button
    private Button login = new Button();

    // Defaults
    private ColorPalette colorPalette = new ColorPalette();
    private Defaults def = new Defaults();

    public PanelBody(MainFrame m, LoginMessage loginMessage) {
        // To get the object
        this.m = m;
        this.loginMessage = loginMessage;
        // Panel body configuration
        setOpaque(false);
        setLayout(null);
        setBounds(def.getFrameWidth() / 2 - (1000 / 2), 306, 1000, 400);

        int x = this.getSize().width / 2;
        

        labelLogin.setText("Sign in to your account");
        labelLogin.setForeground(Color.black);
        labelLogin.setFont(new Font(def.getFontFam(), Font.BOLD, 22));
        labelLogin.setHorizontalAlignment(JLabel.CENTER);
        labelLogin.setBounds(0, 20, 1000, 50);
        
        customTextField.setHint("Account Number");
        customTextField.setFont(new Font(def.getFontFam(), 0, 18));
        customTextField.setPrefixIcon(new ImageIcon(getClass().getResource("/Images/account.png")));
        customTextField.setBounds(x - (500 / 2), 100, 500, 60);
        customTextField.addKeyListener(this);
        customTextField.setDocument(new TextLimit(8));
        
        customPasswordField.setHint("Pin Code");
        customPasswordField.setColumns(6);
        customPasswordField.setFont(new Font(def.getFontFam(), 0, 18));
        customPasswordField.setPrefixIcon(new ImageIcon(getClass().getResource("/Images/pass.png")));
        customPasswordField.setBounds(x - (500 / 2), 200, 500, 60);
        customPasswordField.setDocument(new TextLimit(6));

        labelforgotPassword.setText("Forgot Password?");
        labelforgotPassword.setForeground(Color.blue);
        labelforgotPassword.setFont(new Font(def.getFontFam(), Font.BOLD, 15));
        labelforgotPassword.setHorizontalAlignment(JLabel.TRAILING);
        labelforgotPassword.setBounds(x - (480 / 2), 270, 480, 20);

        labelPassVisible.setIcon(methods.imageResize(new ImageIcon(getClass().getResource("/Images/passInvisible.png")), 24, 24));
        labelPassVisible.setOpaque(false);
        labelPassVisible.setBounds(450, 60 / 2 - (50 / 2), 50, 50);
        labelPassVisible.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelPassVisible.addMouseListener(this);
        customPasswordField.add(labelPassVisible);

        login.setBackground(colorPalette.getColorButtons());
        login.setForeground(Color.white);
        login.setText("Sign in");
        login.setFont(new Font(def.getFontFam(), 0, 18));
        login.setBounds(x - (200 / 2), 300, 200, 60);
        login.addActionListener(this);

        // Components
        add(login);
        add(labelLogin);
        add(customTextField);
        add(customPasswordField);
        add(labelforgotPassword);
    }

    // Action event
    @Override
    public void actionPerformed(ActionEvent e) {

        // Log message object
        LogMessage logMsg = new LogMessage();

        // Check if the account number typed is an integer
        boolean isNumber = Pattern.compile("^\\d+$")
               .matcher(customTextField.getText())
               .find(); 

        // If the account number is an integer
        if(isNumber) {
            // Account number has only 10 characters
            if (customTextField.getText().length() > 10) {
                loginMessage.labelMessageDetail.setText("Invalid Account Number");
                loginMessage.labelMessageDetail.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                logMsg.start();
            } else {
                // If account number is valid
                int accountNumber = Integer.valueOf(customTextField.getText());
                String userPinCode = String.valueOf(customPasswordField.getPassword());
                dataLogin = new ModelLogin(accountNumber, userPinCode);

                try {

                    ModelUser user = log.login(dataLogin);

                    if (user != null) {

                        m.dispose();

                        // Create the session of the user
                        Session.userID = user.getUserID();
                        Session.userBalance = user.getUserBalance();
                        Session.userAccoundNumber = user.getUserAccoundNumber();
                        Session.userEmail = user.getUserEmail();
                        Session.userName = user.getUserName();
                        Session.userVerificationType = user.getVerificationType();
                        // ----

                        // Show the home frame
                        new HomeFrame().setVisible(true);

                    } else {
                        // Show the login message
                        loginMessage.labelMessageDetail.setText("Incorrect Username and Password");
                        loginMessage.labelMessageDetail.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                        logMsg.start();
                    }

                } catch (SQLException s) {
                    System.out.println(s);
                }

            }
            
        } else {
            // If account number is a string
            loginMessage.labelMessageDetail.setText("Account Number must be a number");
            loginMessage.labelMessageDetail.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            logMsg.start();
        }

    }

    // Mouse event
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == labelPassVisible) {
            if (!visible) {
                customPasswordField.setEchoChar((char)0); 
                labelPassVisible.setIcon(methods.imageResize(new ImageIcon(getClass().getResource("/Images/passVisible.png")), 24, 24));
                visible = true;
            } else {
                labelPassVisible.setIcon(methods.imageResize(new ImageIcon(getClass().getResource("/Images/passInvisible.png")), 24, 24));
                customPasswordField.setEchoChar(defChar);
                visible = false;
            }
        }
    }
    
    // Thread to show log message
    public class LogMessage extends Thread {

        @Override
        public void run() {

            try {

                loginMessage.setVisible(true);
                Thread.sleep(4000);
                loginMessage.setVisible(false);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
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
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
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
            customTextField.setEditable(false);
        } else {
            customTextField.setEditable(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
    }
}
