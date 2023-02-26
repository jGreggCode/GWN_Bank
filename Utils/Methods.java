package Utils;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Methods {
    public ImageIcon imageResize(ImageIcon img, int width, int heigth) {
        Image imgToResize = img.getImage();
        Image imgResizing = imgToResize.getScaledInstance(width, heigth, Image.SCALE_SMOOTH);
        ImageIcon imgResized = new ImageIcon(imgResizing);
        return imgResized;
    }
}
