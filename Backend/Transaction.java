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
import Containers.PanelHDepositBar;
import Containers.PanelHTransferBar;
import Containers.PanelHUserBar;
import Containers.PanelHWithdrawBar;

public class Transaction {

    // Variables needed
    private final Connection con;
    PanelHUserBar userBar;
    PanelHDepositBar depositBar;
    PanelHWithdrawBar withBar;
    PanelHTransferBar transBar;
    
    // Connection for user bar
    public Transaction(PanelHUserBar userBar) {
        this.userBar = userBar;
        DatabaseConnection mysqlConnect = new DatabaseConnection();
        con = mysqlConnect.connect();
    }
    
    // Connection for deposit bar
    public Transaction(PanelHDepositBar depositBar) {
        this.depositBar = depositBar;
        DatabaseConnection mysqlConnect = new DatabaseConnection();
        con = mysqlConnect.connect();
    }

    // Connection for withdraw bar
    public Transaction(PanelHWithdrawBar withBar) {
        this.withBar = withBar;
        DatabaseConnection mysqlConnect = new DatabaseConnection();
        con = mysqlConnect.connect();
    }

    // Connection for withdraw bar
    public Transaction(PanelHTransferBar transBar) {
        this.transBar = transBar;
        DatabaseConnection mysqlConnect = new DatabaseConnection();
        con = mysqlConnect.connect();
    }

    // To get the transaction table in database for deposit bar
    public void transactionDepTable() { // To add comma to currency
        NumberFormat numberFormat = NumberFormat.getInstance();

        try {
            PreparedStatement p = con.prepareStatement("SELECT `Transaction ID`, `Transaction Type`, `Transaction Time`, `Transaction Location`, `Old Balance`, `New Balance` FROM transactions WHERE BINARY(`Transaction Account`) = ? and BINARY(`Transaction Type`) = ? limit 5", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            p.setInt(1, Session.userAccoundNumber);
            p.setString(2, "Deposit".trim());
            ResultSet r = p.executeQuery();
            ResultSetMetaData rsmd = (ResultSetMetaData) r.getMetaData();

            DefaultTableModel modelBlank = new DefaultTableModel();

            depositBar.tableTransaction.setModel(modelBlank);
            
            DefaultTableModel model = (DefaultTableModel) depositBar.tableTransaction.getModel();

            int cols = rsmd.getColumnCount();

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
                newBal = "PHP " + String.valueOf(numberFormat.format(r.getInt(6)));

                String[] row = {transactionID, transType, transTime, transLoc, oldBal, newBal};
                model.addRow(row);
            }

            r.close();
            p.close();
        } catch (SQLException q) {
            System.out.println(q);
        }
    }

    // To get the transaction table in database for withdraw bar
    public void transactionWithTable() { // To add comma to currency
        NumberFormat numberFormat = NumberFormat.getInstance();

        try {
            PreparedStatement p = con.prepareStatement("SELECT `Transaction ID`, `Transaction Type`, `Transaction Time`, `Transaction Location`, `Old Balance`, `New Balance` FROM transactions WHERE BINARY(`Transaction Account`) = ? and BINARY(`Transaction Type`) = ? limit 5", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            p.setInt(1, Session.userAccoundNumber);
            p.setString(2, "Withdraw".trim());
            ResultSet r = p.executeQuery();
            ResultSetMetaData rsmd = (ResultSetMetaData) r.getMetaData();

            DefaultTableModel modelBlank = new DefaultTableModel();

            withBar.tableTransaction.setModel(modelBlank);
            
            DefaultTableModel model = (DefaultTableModel) withBar.tableTransaction.getModel();

            int cols = rsmd.getColumnCount();

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
                newBal = "PHP " + String.valueOf(numberFormat.format(r.getInt(6)));

                String[] row = {transactionID, transType, transTime, transLoc, oldBal, newBal};
                model.addRow(row);
            }

            r.close();
            p.close();
        } catch (SQLException q) {
            System.out.println(q);
        }
    }

    // To get the transaction table in database for deposit bar
    public void transactionTransTable() { // To add comma to currency
        NumberFormat numberFormat = NumberFormat.getInstance();

        try {
            PreparedStatement p = con.prepareStatement("SELECT `Transaction ID`, `Transaction Type`, `Transaction Time`, `Transaction Location`, `Old Balance`, `New Balance` FROM transactions WHERE BINARY(`Transaction Account`) = ? and BINARY(`Transaction Type`) = ? limit 4", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            p.setInt(1, Session.userAccoundNumber);
            p.setString(2, "Bank Transfer".trim());
            ResultSet r = p.executeQuery();
            ResultSetMetaData rsmd = (ResultSetMetaData) r.getMetaData();

            DefaultTableModel modelBlank = new DefaultTableModel();

            transBar.tableTransaction.setModel(modelBlank);
            
            DefaultTableModel model = (DefaultTableModel) transBar.tableTransaction.getModel();

            int cols = rsmd.getColumnCount();

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
                newBal = "PHP " + String.valueOf(numberFormat.format(r.getInt(6)));

                String[] row = {transactionID, transType, transTime, transLoc, oldBal, newBal};
                model.addRow(row);
            }

            r.close();
            p.close();
        } catch (SQLException q) {
            System.out.println(q);
        }
    }

    // To get the transaction table in database for user bar
    public void transactionUserTable() {

        // To add comma to currency
        NumberFormat numberFormat = NumberFormat.getInstance();

        try {
            PreparedStatement p = con.prepareStatement("SELECT `Transaction ID`, `Transaction Type`, `Transaction Time`, `Transaction Location`, `Old Balance`, `New Balance` FROM transactions WHERE BINARY(`Transaction Account`) = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
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
                newBal = "PHP " + String.valueOf(numberFormat.format(r.getInt(6)));

                String[] row = {transactionID, transType, transTime, transLoc, oldBal, newBal};
                model.addRow(row);
            }

            r.close();
            p.close();
        } catch (SQLException q) {
            System.out.println(q);
        }
    }
}
