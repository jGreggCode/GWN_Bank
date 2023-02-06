package Containers;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import Utils.MyTextField;
import Utils.MyPasswordField;
import Utils.Defaults;
import Utils.Button;
import Utils.ColorPalette;

public class PanelBody extends JPanel {

    private JLabel labelLogin = new JLabel();
    private MyTextField customTextField = new MyTextField();

    private MyPasswordField customPasswordField = new MyPasswordField();

    private Button login = new Button();
    private ColorPalette colorPalette = new ColorPalette();
    private Defaults def = new Defaults();

    public PanelBody() {
        this.setOpaque(false);
        setLayout(null);
        setBounds(def.getFrameWidth() / 2 - (1000 / 2), 306, 1000, 400);

        int x = this.getSize().width / 2;
        int y = this.getSize().height;

        labelLogin.setText("Login to your account");
        labelLogin.setForeground(Color.white);
        labelLogin.setFont(new Font(def.getFontFam(), Font.BOLD, 18));
        labelLogin.setHorizontalAlignment(JLabel.CENTER);
        labelLogin.setBounds(0, 20, 1000, 50);
        
        
        customTextField.setHint("Account Number");
        customTextField.setFont(new Font(def.getFontFam(), 0, 18));
        customTextField.setPrefixIcon(new ImageIcon(getClass().getResource("/Images/user.png")));
        customTextField.setBounds(x - (500 / 2), 100, 500, 60);
        
        customPasswordField.setHint("Pin Code");
        customPasswordField.setColumns(6);
        customPasswordField.setFont(new Font(def.getFontFam(), 0, 18));
        customPasswordField.setPrefixIcon(new ImageIcon(getClass().getResource("/Images/pass.png")));
        customPasswordField.setBounds(x - (500 / 2), 200, 500, 60);

        login.setBackground(colorPalette.getColorButtons());
        login.setForeground(Color.white);
        login.setText("L o g i n");
        login.setFont(new Font(def.getFontFam(), 0, 18));
        login.setBounds(x - (200 / 2), 300, 200, 60);

        this.add(login);
        this.add(labelLogin);
        this.add(customTextField);
        this.add(customPasswordField);
    }

    
}
