package Components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import Utils.*;
import Utils.Button;

public class PanelBody extends JPanel {

    private JLabel labelLogin = new JLabel();
    private MyTextField customTextField = new MyTextField();
    private MyPasswordField customPasswordField = new MyPasswordField();
    private Button login = new Button();

    public PanelBody() {
        this.setOpaque(false);
        setLayout(null);
        setBounds(105, 158, 500, 200);

        labelLogin.setText("L o g i n   t o   y o u r   a c c o u n t");
        labelLogin.setForeground(Color.white);
        labelLogin.setFont(new Font("Monospace", Font.BOLD, 13));
        labelLogin.setHorizontalAlignment(JLabel.CENTER);
        labelLogin.setBounds(0, 0, 500, 50);

        
        customTextField.setHint("Account Name");
        customTextField.setPrefixIcon(new ImageIcon(getClass().getResource("/Images/user.png")));
        customTextField.setBounds(125, 50, 250, 40);
        customPasswordField.setHint("Pin Code");
        customPasswordField.setPrefixIcon(new ImageIcon(getClass().getResource("/Images/pass.png")));
        customPasswordField.setBounds(125, 100, 250, 40);

        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.setText("L o g i n");
        login.setBounds(200, 150, 100, 40);

        this.add(login);
        this.add(labelLogin);
        this.add(customTextField);
        this.add(customPasswordField);
    }

    
}
