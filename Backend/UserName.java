package Backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import Connection.DatabaseConnection;

public class UserName {
    private final Connection con;

    public UserName() {
        DatabaseConnection mysqlConnect = new DatabaseConnection();
        con = mysqlConnect.connect();
    }

    public String getUserName(int accountNumber) throws SQLException {
        String userName = null;
        PreparedStatement p = con.prepareStatement(
                "SELECT userName FROM users where BINARY(userAccountNumber) = ? limit 1", 
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        p.setInt(1, accountNumber);
        ResultSet r = p.executeQuery();
        if (r.first()) {
            userName = r.getString(1);
        }

        r.close();
        p.close();
        return userName;
    }
}