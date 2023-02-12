package Containers;

// Imports
import javax.swing.JPanel;
import java.awt.Color;

public class PanelHWithdrawBar extends JPanel {

    public PanelHWithdrawBar() {
        // Withdraw bar panel configuration
        setOpaque(true);
        setBackground(Color.red);
        setVisible(false);
        setBounds(80,0, 1360, 1000);
    }
    
}
