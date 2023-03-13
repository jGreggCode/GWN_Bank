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

    /* 
    private final Color colorText = Color.black;
    private final Color colorBackground = new Color(0x1A1A2E);
    private final Color colorBackground1 = new Color(0x23233d);
    private final Color colorBackground2 = new Color(0x37b6fa);
    private final Color colorButtons = new Color(0xef461e);
    */
    
    private final Color colorText = Color.black;
    private final Color colorWhite = new Color(0xFFFFF0); // white
    private final Color colorBackground = new Color(0xCC5801); // orange main
    private final Color colorBackground1 = new Color(0xFE8820); // orange
    private final Color colorBackground2 = new Color(0xF5761A); // pumpkin
    private final Color colorBackground3 = new Color(0xC35214); // Alloy Orange
    private final Color colorBackground4 = new Color(0xFDEE00); // yellow
    private final Color colorButtons = Color.decode("#DD571C"); // buttons etc

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

    public Color getColorBackground3() {
        return colorBackground3;
    }

    public Color getColorBackground4() {
        return colorBackground4;
    }

    public Color getColorWhite() {
        return colorWhite;
    }

}
