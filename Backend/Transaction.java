package Backend;

// Imports
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import javax.swing.table.DefaultTableModel;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import Connection.DatabaseConnection;
import Containers.PanelHUserBar;

public class Transaction {

    // Variables needed
    private final Connection con;
    PanelHUserBar userBar;
    
    // Connection
    public Transaction(PanelHUserBar userBar) {
        this.userBar = userBar;
        DatabaseConnection mysqlConnect = new DatabaseConnection();
        con = mysqlConnect.connect();
    }

    // To get the transaction table in database
    public void transactionTable() {

        // To add comma to currency
        NumberFormat numberFormat = NumberFormat.getInstance();

        try {
            PreparedStatement p = con.prepareStatement("SELECT `Transaction ID`, `Transaction Type`, `Transaction Time`, `Transaction Location`, `Old Balance`, `New Balance` FROM transactions WHERE BINARY(`Transaction Account`) = ? ", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            p.setInt(1, Session.userAccoundNumber);
            ResultSet r = p.executeQuery();
            ResultSetMetaData rsmd = (ResultSetMetaData) r.getMetaData();

            DefaultTableModel modelBlank = new DefaultTableModel();

            userBar.tableTransaction.setModel(modelBlank);
            
            DefaultTableModel model = (DefaultTableModel) userBar.tableTransaction.getModel();

            int cols = rsmd.getColumnCount();

            System.out.println("\nThere are " + cols + " columns in the transaction table\n");

            String[] colName = new String[cols];
            for (int i = 0; i < cols; i++) {
                colName[i] = " " + rsmd.getColumnName(i + 1).toUpperCase();
            }
            model.setColumnIdentifiers(colName);

            String transactionID, oldBal, newBal;
            String transType, transTime, transLoc;
            
            while (r.next()) {

                transactionID = String.valueOf(r.getInt(1));
                transType = r.getString(2);
                transTime = r.getString(3);
                transLoc = r.getString(4);
                oldBal = "PHP " + String.valueOf(numberFormat.format(r.getInt(5)));
                newBal = "PHP" + String.valueOf(numberFormat.format(r.getInt(6)));

                String[] row = {transactionID, transType, transTime, transLoc, oldBal, newBal};
                model.addRow(row);
            }

            System.out.println("Database connection established successfully | Using reload of transaction table"); 
            r.close();
            p.close();
        } catch (SQLException q) {
            System.out.println(q);
        }
    }
}
