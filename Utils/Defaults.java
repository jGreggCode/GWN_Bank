package Utils;

public class Defaults {
    
    // Defaults, so that I don't need to put everything one by one

    private final int frameHeight = 1000;
    private final int frameWidth = 1440;
    private final String fontFam = "Karla";

    public static int verificationCode = 0;
    public static String email;

    public int getFrameHeight() {
        return frameHeight;
    }

    public int getFrameWidth() {
        return frameWidth;
    }

    public String getFontFam() {
        return fontFam;
    }
}
