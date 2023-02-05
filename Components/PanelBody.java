package Components;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import java.awt.*;
import java.awt.event.*;

public class PanelBody extends JPanel implements FocusListener {

    JLabel labelLogin = new JLabel();
    DTextField usernameTextField = new DTextField();
    DPasswordField passwordField = new DPasswordField();
    JSeparator userSeparator = new JSeparator();
    JSeparator passSeparator = new JSeparator();

    public PanelBody() {
        this.setOpaque(false);
        setLayout(null);
        setBounds(105, 158, 500, 200);

        labelLogin.setText("L o g i n   t o   y o u r   a c c o u n t");
        labelLogin.setForeground(Color.white);
        labelLogin.setFont(new Font("Monospace", Font.BOLD, 13));
        labelLogin.setHorizontalAlignment(JLabel.CENTER);
        labelLogin.setBounds(0, 0, 500, 50);

        usernameTextField.addFocusListener(this);

        usernameTextField.setBounds(125, 50, 250, 30);
        usernameTextField.setForeground(Color.white);
        userSeparator.setOpaque(false);
        userSeparator.setBounds(125, 80, 250, 3);
        userSeparator.setForeground(Color.white);

        passwordField.setText("Password");
        passwordField.addFocusListener(this);
        passwordField.setBounds(125, 100, 250, 30);
        passwordField.setForeground(Color.white);
        passSeparator.setOpaque(false);
        passSeparator.setBounds(125, 130, 250, 3);
        passSeparator.setForeground(Color.white);

        this.add(labelLogin);
        this.add(usernameTextField);
        this.add(userSeparator);
        this.add(passwordField);
        this.add(passSeparator);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == usernameTextField) {
            usernameTextField.setForeground(Color.gray);
            usernameTextField.setText("");
        }

        if (e.getSource() == passwordField) {
            passwordField.setForeground(Color.gray);
            passwordField.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == usernameTextField) {
            usernameTextField.setForeground(Color.gray);
            usernameTextField.setText("Account Number");
        }

        if (e.getSource() == passwordField) {
            passwordField.setForeground(Color.gray);
            passwordField.setText("Password");
        }
        
    }

    
}
