package Components;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class PanelBody extends JPanel {

    JLabel labelUsername = new JLabel();

    public PanelBody() {
        this.setOpaque(true);
        this.setLayout(new GridLayout(7, 1));
        setBounds(105, 158, 500, 200);

        labelUsername.setText("Login to your account!");
        labelUsername.setHorizontalAlignment(JLabel.CENTER);

        this.add(labelUsername);
    }
}
