package Components;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class LabelWelcome extends JLabel {

    ImageIcon logo = new ImageIcon("Images/BankLogoNB128.png");

    public LabelWelcome() {
        // Icon Label
        this.setIcon(logo);
        this.setVerticalTextPosition(JLabel.BOTTOM);
        this.setHorizontalTextPosition(JLabel.CENTER);

        // --------

        // Welcome Label
        this.setText("Welcome To GWN Bank");
        this.setForeground(Color.black);
        this.setVerticalAlignment(JLabel.TOP);
        this.setHorizontalAlignment(JLabel.CENTER);
        // --------
    }
}
