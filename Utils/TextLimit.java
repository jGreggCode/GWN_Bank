package Utils;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class TextLimit extends PlainDocument {

    private int max;

    public TextLimit(int max) {
        this.max = max;
    }

    public void insertString(int offset, String str, AttributeSet set) throws BadLocationException {

        if (str == null) {
            return;

        } else if ((getLength() + str.length()) <= max) {
            super.insertString(offset, str, set);
        }

    }
}
