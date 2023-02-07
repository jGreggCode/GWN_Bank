package Main;
import java.awt.Dimension;
import javax.swing.JFrame;
import Containers.*;
import Utils.*;

public class MainFrame extends JFrame {

    // Main Frame Components
    PanelHeader panelHeader = new PanelHeader();
    PanelBody panelBody = new PanelBody(this);
    PanelFooter panelFooter = new PanelFooter();

    // Color
    ColorPalette colors = new ColorPalette();
    Defaults def = new Defaults();

    // Main frame
    public MainFrame() {
        // Main frame configuration
        setTitle("GWN Bank");
        setPreferredSize(new Dimension(def.getFrameWidth(), def.getFrameHeight()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(getPreferredSize().width, getPreferredSize().height);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(colors.getColorBackground());
        setLocationRelativeTo(null);

        // Add Components
        add(panelHeader);
        add(panelBody);
        add(panelFooter);

    }
}
