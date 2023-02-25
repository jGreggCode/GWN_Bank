package Backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import Connection.DatabaseConnection;

public class Transfer {
    private final Connection con;
    
    // Connection for user bar
    public Transfer() {
        DatabaseConnection mysqlConnect = new DatabaseConnection();
        con = mysqlConnect.connect();
    }

    public boolean invalidUser(int accountNumber2) {
        try {
            PreparedStatement pfAccount2 = con.prepareStatement(
                "SELECT userBalance FROM users where BINARY(userAccountNumber) = ? limit 1", 
            ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pfAccount2.setInt(1, accountNumber2);
            ResultSet resAccount2 = pfAccount2.executeQuery();

            if (resAccount2.first()) {

            } else {
                return false;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }        
        return true;
    }

    public void transfer(double ammount, int accountNumber, int accountNumber2) {
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

            PreparedStatement pTransfer = con.prepareStatement(
                "UPDATE users SET `userBalance` = ? WHERE BINARY(`userAccountNumber`) = ? limit 1", 
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pTransfer.setDouble(1, newAmmount);
            pTransfer.setInt(2, accountNumber);
            int resTransfer1 = pTransfer.executeUpdate();

            pTransfer.close();

            PreparedStatement pTransfer2 = con.prepareStatement(
                "UPDATE users SET `userBalance` = `userBalance` + ? WHERE BINARY(`userAccountNumber`) = ? limit 1", 
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pTransfer2.setDouble(1, ammount);
            pTransfer2.setInt(2, accountNumber2);
            int resTransfer2 = pTransfer2.executeUpdate();

            pTransfer2.close();
        } catch (SQLException q) {
            System.out.println(q);
        }
    }
}
