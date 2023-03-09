package Main;

// Imports
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import Containers.*;
import Utils.*;

public class HomeFrame extends JFrame {

    // Prerequisite Objects
    MainFrame mainFrame;
    ModalBox modalBox = new ModalBox();

    // Home panel navigation bars
    PanelHDepositBar panelDepBar = new PanelHDepositBar(modalBox);
    PanelHWithdrawBar withBar = new PanelHWithdrawBar(modalBox);
    PanelHTransferBar transBar = new PanelHTransferBar(modalBox);
    PanelHSettingBar settingBar = new PanelHSettingBar();
    PanelHUserBar panelHUserBar = new PanelHUserBar(this, mainFrame);
    PanelHNavBar panelHNavBar = new PanelHNavBar(panelHUserBar, panelDepBar, withBar, transBar, settingBar, this);
    PanelHFooterBar panelHFooter = new PanelHFooterBar();

    // Utilities
    ColorPalette colors = new ColorPalette();
    Defaults def = new Defaults();

    public HomeFrame() {
        // Home frame configuration
        setTitle("Home");
        setIconImage(new ImageIcon(getClass().getResource("/Images/newLogo.png")).getImage());
        setPreferredSize(new Dimension(def.getFrameWidth(), def.getFrameHeight()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(getPreferredSize().width, getPreferredSize().height);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(colors.getColorBackground());
        setLocationRelativeTo(null);

        // Add components
        add(panelHNavBar);
        add(panelHFooter);
        add(panelHUserBar);
        add(panelDepBar);
        add(withBar);
        add(transBar);
        add(settingBar);
    }

}
