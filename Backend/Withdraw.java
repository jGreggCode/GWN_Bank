package Backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import Connection.DatabaseConnection;

public class Withdraw {

    private final Connection con;
    
    // Connection for user bar
    public Withdraw() {
        DatabaseConnection mysqlConnect = new DatabaseConnection();
        con = mysqlConnect.connect();


    }

    public void withdraw(double ammount, int accountNumber) {
        try {

            double userBalance = 0;
            double newAmmount = 0;

            PreparedStatement pf = con.prepareStatement(
                "SELECT userBalance FROM users where BINARY(userAccountNumber) = ? limit 1", 
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pf.setInt(1, accountNumber);
            ResultSet res = pf.executeQuery();
            if (res.first()) {
                userBalance = res.getDouble(1);
            }
            
            newAmmount = userBalance - ammount;

            res.close();
            pf.close();

            System.out.println(res);

            PreparedStatement p = con.prepareStatement(
                "UPDATE users SET `userBalance` = ? WHERE BINARY(`userAccountNumber`) = ? limit 1", 
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            p.setDouble(1, newAmmount);
            p.setInt(2, accountNumber);
            int r = p.executeUpdate();

            System.out.println(r);
            
            p.close();
        } catch (SQLException q) {
            System.out.println(q);
        }
    }
}
