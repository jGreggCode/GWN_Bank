package Backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.FormatStyle;
import java.sql.Connection;
import java.sql.PreparedStatement;

import Connection.DatabaseConnection;

public class Register {
    
    private final Connection con;

    public Register() {
        DatabaseConnection mysqlConnect = new DatabaseConnection();
        con = mysqlConnect.connect();
    }

    public void register(int userBalance, int accountNumber, String userEmail, String userName, String userPinCode, String verificationType) throws SQLException {
        
        PreparedStatement p = con.prepareStatement("INSERT INTO users (`userBalance`, `userAccountNumber`, `userEmail`, `userName`, `userPinCode`, `verificationType`) VALUES (?,?,?,?,?,?)", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
     
        p.setInt(1, userBalance);
        p.setInt(2, accountNumber);
        p.setString(3, userEmail);
        p.setString(4, userName);
        p.setString(5, userPinCode);
        p.setString(6, verificationType);

        p.execute();
        p.close();
    }

    public boolean checkDuplicate(int accountNumber) throws SQLException {
        boolean result = false;
        PreparedStatement checkDuplicate = con.prepareStatement("SELECT `userAccountNumber` FROM users where BINARY(userAccountNumber) = ? limit 1", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        checkDuplicate.setInt(1, accountNumber);
        ResultSet res = checkDuplicate.executeQuery();

        if (res.first()) {
            result = true;
        }

        return result;
    }
}
