package Utils;

// Import
import java.awt.Color;

public class ColorPalette {

    // Just some color pallete makes my coding easier

    // Logo Color Pallete
    // light blue = 37b6fa
    // dark blue = 005acc
    // orange = fb8b02
    // yellow = fecc0f

    private final Color colorText = Color.black;
    private final Color colorBackground = new Color(0x1A1A2E);
    private final Color colorBackground1 = new Color(0x23233d);
    private final Color colorBackground2 = new Color(0x37b6fa);
    private final Color colorButtons = new Color(0xef461e);

    public Color getColorText() {
        return colorText;
    }

    public Color getColorBackground() {
        return colorBackground;
    }

    public Color getColorButtons() {
        return colorButtons;
    }

    public Color getColorBackground2() {
        return colorBackground2;
    }

    public Color getColorBackground1() {
        return colorBackground1;
    }

}
