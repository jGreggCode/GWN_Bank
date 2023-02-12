package Backend;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Connection.DatabaseConnection;
import Model.ModelLogin;
import Model.ModelUser;

public class User {
    
    private final Connection con;

    public User() {
        DatabaseConnection mysqlConnect = new DatabaseConnection();
        con = mysqlConnect.connect();
    }

    public ModelUser login(ModelLogin login) throws SQLException {
        ModelUser data = null;
        PreparedStatement p = con.prepareStatement("SELECT userID, userBalance, userAccountNumber, userEmail, userName, verificationType FROM users where BINARY(userAccountNumber) = ? and BINARY(`userPinCode`) = ? limit 1", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        p.setInt(1, login.getAccountNumber());
        p.setString(2, login.getUserPinCode());
        ResultSet r = p.executeQuery();
        if (r.first()) {
            int userID = r.getInt(1);
            int userBalance = r.getInt(2);
            int userAccountNumber = r.getInt(3);
            String userEmail = r.getString(4);
            String userName = r.getString(5);
            String userVerificationType = r.getString(6);
            data = new ModelUser(userID, userBalance, userAccountNumber, userEmail, userName, "", userVerificationType);
        }
        r.close();
        p.close();
        return data;
    }
}
