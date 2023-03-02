package Utils;

// Imports
import java.awt.Image;
import javax.swing.ImageIcon;

public class Methods {
    
    // I don't know why I made a separate class for this, I think I only used this method in one class.

    public ImageIcon imageResize(ImageIcon img, int width, int heigth) {
        Image imgToResize = img.getImage();
        Image imgResizing = imgToResize.getScaledInstance(width, heigth, Image.SCALE_SMOOTH);
        ImageIcon imgResized = new ImageIcon(imgResizing);
        return imgResized;
    }
}
