package Containers;

// Imports
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import Main.MainFrame;
import Main.RegisterFrame;
import Utils.ColorPalette;
import Utils.Defaults;
import Utils.Mail;
import Utils.MyTextField;

public class PanelFooter extends JPanel implements MouseListener {

    // Prerequisite Objects
    private JSeparator emailSeparator = new JSeparator();
    private MyTextField custoMyTextField = new MyTextField();
    private LoginMessage loginMessage;
    private MainFrame mainFrame;
    private RegisterFrame registerFrame;

    // Lables
    private JLabel labelNoCred = new JLabel(),
    labelStart = new JLabel(),
    labelCopyright = new JLabel(),
    labelEmailSend = new JLabel(),
    labelFooter = new JLabel(),
    labelFooterp = new JLabel(),
    labelPrivacy = new JLabel(),
    labelTerms = new JLabel(),
    labelProject = new JLabel();

    // Images
    ImageIcon logo = new ImageIcon("Images/JustLogo.png");
    Image image = logo.getImage();
    Image resizedImg = image.getScaledInstance(16, 20, Image.SCALE_SMOOTH);
    ImageIcon newLogo = new ImageIcon(resizedImg);
    
    ImageIcon footerLogo = new ImageIcon("Images/footerpic.png");
    Image footerImage = footerLogo.getImage();
    Image resizedFooterImg = footerImage.getScaledInstance((592 / 2) / 2 + 50, (422 / 2) / 2 + 50, Image.SCALE_SMOOTH);
    ImageIcon newFooterLogo = new ImageIcon(resizedFooterImg);
    
    boolean error = true;

    // Defaults
    private ColorPalette colorPalette = new ColorPalette();
    private Defaults def = new Defaults();

    public PanelFooter(LoginMessage emailMessage, MainFrame mainFrame, RegisterFrame registerFrame) {
        // To get the object
        this.loginMessage = emailMessage;
        this.mainFrame = mainFrame;
        this.registerFrame = registerFrame;
        // Panel footer configuration
        setOpaque(true);
        setBackground(colorPalette.getColorBackground1());
        setLayout(null);
        setBounds(0, 728, 1440, 294);

        labelNoCred.setText("E n r o l l   t o   G W N   O n l i n e !");
        labelNoCred.setForeground(colorPalette.getColorButtons());
        labelNoCred.setFont(new Font(def.getFontFam(), Font.PLAIN, 15));
        labelNoCred.setBounds(40, 40, 350, 20);

        labelStart.setText("Start using GWN Bank today.");
        labelStart.setForeground(Color.white);
        labelStart.setFont(new Font(def.getFontFam(), Font.BOLD, 26));
        labelStart.setBounds(40, 70, 400, 33);

        custoMyTextField.setHint("Enter your email to register");
        custoMyTextField.setFont(new Font(def.getFontFam(), Font.BOLD, 15));
        custoMyTextField.setForeground(Color.white);
        custoMyTextField.setBackground(colorPalette.getColorBackground1());
        custoMyTextField.setCaretColor(Color.white);
        custoMyTextField.setBounds(40, 110, 350, 40);

        labelEmailSend.setText("Get started");
        labelEmailSend.setBorder(BorderFactory.createLineBorder(colorPalette.getColorButtons(), 1));
        labelEmailSend.setFont(new Font(def.getFontFam(), Font.PLAIN, 12));
        labelEmailSend.setOpaque(true);
        labelEmailSend.setBackground(colorPalette.getColorButtons());
        labelEmailSend.setForeground(Color.white);
        labelEmailSend.setIconTextGap(5);
        labelEmailSend.setIcon(new ImageIcon(getClass().getResource("/Images/paper.png")));
        labelEmailSend.setBounds(390, 118, 100, 24);
        labelEmailSend.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelEmailSend.addMouseListener(this);

        emailSeparator.setForeground(Color.gray);
        emailSeparator.setBounds(40, 150, 450, 30);
        
        labelCopyright.setText("Copyright © 2023 GWN. | All rights reserved.");
        labelCopyright.setIcon(newLogo);
        labelCopyright.setFont(new Font(def.getFontFam(), Font.BOLD, 14));
        labelCopyright.setIconTextGap(5);
        labelCopyright.setForeground(Color.white);
        labelCopyright.setBounds(40, 180, 400, 20);

        labelFooter.setIcon(newFooterLogo);
        labelFooter.setBounds(922, 20, (592 / 2) / 2 + 50, (422 / 2) / 2 + 50);

        labelFooterp.setText("Make the right choice, choose GWN Bank.");
        labelFooterp.setFont(new Font(def.getFontFam(), Font.BOLD, 12));
        labelFooterp.setForeground(Color.white);
        labelFooterp.setBounds(1150, 50, 250, 30);

        labelPrivacy.setText("Privacy Policy".toUpperCase(getLocale()));
        labelPrivacy.setFont(new Font(def.getFontFam(), Font.BOLD, 12));
        labelPrivacy.setForeground(colorPalette.getColorButtons());
        labelPrivacy.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelPrivacy.setBounds(1150, 90, 250, 30);

        labelTerms.setText("Terms and condition".toUpperCase(getLocale()));
        labelTerms.setFont(new Font(def.getFontFam(), Font.BOLD, 12));
        labelTerms.setForeground(colorPalette.getColorButtons());
        labelTerms.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelTerms.setBounds(1150, 125, 250, 30);

        labelProject.setText("All users of our services are subject to our Privacy Statement");
        labelProject.setBounds(970, 180, 460, 30);
        labelProject.setFont(new Font(def.getFontFam(), Font.BOLD, 14));
        labelProject.setForeground(Color.white);

        // Components
        add(labelNoCred);
        add(labelStart);
        add(custoMyTextField);
        add(emailSeparator);
        add(labelEmailSend);
        add(labelCopyright);

        add(labelPrivacy);
        add(labelTerms);
        add(labelFooter);
        add(labelFooterp);
        add(labelProject);
    }

    // Mouse event
    @Override
    public void mouseClicked(MouseEvent e) {
        String email = custoMyTextField.getText().trim();
        LogMessage logMessage = new LogMessage();

        if (e.getSource() == labelEmailSend) {
            Mail mail = new Mail();
            boolean validEmail = mail.mail(email);

            if (validEmail) {
                Defaults.email = email;
                loginMessage.labelMessageType.setText("Sent Successfully");
                loginMessage.labelMessageDetail.setText("Check the verification code");
                loginMessage.setBorder(BorderFactory.createLineBorder(Color.green, 1));
                error = false;
                logMessage.start();
            } else {
                loginMessage.labelMessageType.setText("Sent Failed");
                loginMessage.labelMessageDetail.setText("Invalid Email Address");
                logMessage.start();
            }
        }
    }

    // Not needed but required to implements tsk
    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    
    // Thread to show the login message
    public class LogMessage extends Thread {

        @Override
        public void run() {

            try {

                loginMessage.setVisible(true);
                Thread.sleep(4000);
                loginMessage.setVisible(false);
                
                if (!error) {
                    mainFrame.dispose();
                    registerFrame.setVisible(true);
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }

    }

}
