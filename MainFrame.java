// Imports
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
// --------

public class MainFrame extends JFrame {

    // Color
    ColorPalette colors = new ColorPalette();
    // --------

    // Images
    ImageIcon logo = new ImageIcon("BankLogoNB128.png");

    // Labels
    JLabel labelWelcome = new JLabel(), 
    labelIcon = new JLabel(),
    labelUsername = new JLabel(),
    labelPassword = new JLabel();
    // --------

    // Main frame
    public MainFrame() {
        // Main frame configuration
        this.setTitle("JGBank");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(720, 720);
        this.setResizable(false);
        this.getContentPane().setBackground(colors.getColorBackground());
        // --------

        // Icon Label
        labelIcon.setIcon(logo);
        // --------

        // Welcome Label
        labelWelcome.setText("Welcome To JGBank");
        labelWelcome.setVerticalAlignment(JLabel.TOP);
        labelWelcome.setHorizontalAlignment(JLabel.CENTER);
        // --------
        // import

        // Components
        this.add(labelIcon);
        this.add(labelWelcome);
        // --------
    }
    // --------
}
