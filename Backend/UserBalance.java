package Backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import Connection.DatabaseConnection;

public class UserBalance {
    private final Connection con;

    public UserBalance() {
        DatabaseConnection mysqlConnect = new DatabaseConnection();
        con = mysqlConnect.connect();
    }

    public double getUserBalance(int accountNumber) throws SQLException {
        double cash = 0;
        PreparedStatement p = con.prepareStatement(
                "SELECT userBalance FROM users where BINARY(userAccountNumber) = ? limit 1", 
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        p.setInt(1, accountNumber);
        ResultSet r = p.executeQuery();
        if (r.first()) {
            cash = r.getDouble(1);
        }

        r.close();
        p.close();
        return cash;
    }
}
