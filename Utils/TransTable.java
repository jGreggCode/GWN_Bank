package Utils;

// Imports
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class TransTable extends JTable {

    // For design

    ColorPalette colorPalette = new ColorPalette();
    Defaults def = new Defaults();

    public TransTable() {
        getTableHeader().setDefaultRenderer(new TableHeader());
        getTableHeader().setPreferredSize(new Dimension(0, 50));
        setDefaultRenderer(Object.class, new TableCell());
        setRowHeight(45);
    }

    private class TableHeader extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            // TODO Auto-generated method stub
            Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            com.setBackground(colorPalette.getColorBackground1());
            com.setForeground(Color.white);
            com.setFont(new Font(def.getFontFam(), Font.BOLD, 12));
            setHorizontalAlignment(JLabel.CENTER);
            return com;
        }
    }

    private class TableCell extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            // TODO Auto-generated method stub
            Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (isCellSelected(row, column)) {
                if (row % 2 == 0) {
                    com.setBackground(new Color(33, 103, 153));
                } else {
                    com.setBackground(new Color(33, 103, 127));
                }
            } else {
                if (row % 2 == 0) {
                    com.setBackground(colorPalette.getColorBackground());
                } else {
                    com.setBackground(colorPalette.getColorBackground1());
                }
            }
            com.setForeground(Color.white); 
            setBorder(new EmptyBorder(0, 5, 0, 5));
            return com;
        }
    }
}
