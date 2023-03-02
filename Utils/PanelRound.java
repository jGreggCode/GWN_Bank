package Utils;

// Imports
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;


public class PanelRound extends JPanel {

    // For design
    
    public PanelRound() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics grphc) {
        Graphics2D g2 = (Graphics2D) grphc;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(255,255,255));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        super.paintComponent(grphc);
    }
    
    
    
}
