package Backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.FormatStyle;
import java.util.Random;
import java.sql.Connection;
import java.sql.PreparedStatement;

import Connection.DatabaseConnection;

public class TransactionData {
    
    private final Connection con;

    public TransactionData() {
        DatabaseConnection mysqlConnect = new DatabaseConnection();
        con = mysqlConnect.connect();
    }

    public void addDeposit(int accountNumber, String transactionType, String time, String location, int oldBalance, int newBalance) throws SQLException {
        Random random = new Random();

        String starting = "2023";
        int randomNumber = random.nextInt(100, 999);
        String transNumber = starting + randomNumber;

        PreparedStatement p = con.prepareStatement("INSERT INTO transactions (`Transaction ID`, `Transaction Account`, `Transaction Type`, `Transaction Time`, `Transaction Location`, `Old Balance`, `New Balance`) VALUES (?,?,?,?,?,?,?)", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
     
        p.setInt(1, Integer.valueOf(transNumber));
        p.setInt(2, accountNumber);
        p.setString(3, transactionType);
        p.setString(4, time);
        p.setString(5, location);
        p.setInt(6, oldBalance);
        p.setInt(7, newBalance);

        System.out.println("Deposit Transaction Added");
        p.execute();
        p.close();
    }
}
