package Components;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;

import java.awt.Color;
import java.awt.Font;

public class DPasswordField extends JPasswordField {

    public DPasswordField() {
        setHorizontalAlignment(JPasswordField.CENTER);
        setOpaque(false);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
        setFocusable(true);
        setFont(new Font("Monospace", Font.PLAIN, 13));
    }
}