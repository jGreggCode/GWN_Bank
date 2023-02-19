package Main;

import java.sql.Connection;
import Connection.DatabaseConnection;
import Backend.Session;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class Main {
    // Main thread
    public static void main(String[] args) {
        // Run this to execute the whole program

        // A new thread for clearing the console
        Main main = new Main();
        DatabaseThread dbThread = main.new DatabaseThread();
        ConsoleClearing consoleThread = main.new ConsoleClearing();
        dbThread.start();
        consoleThread.start();

        new MainFrame().setVisible(true);

    }
    
    // Clear the console every 10 seconds
    public class ConsoleClearing extends Thread {
        @Override
        synchronized public void run() {
            try {
                while (true) {
                    System.out.print("\033[H\033[2J");  
                    System.out.println("\nNOTE: Console will be cleared every 10 seconds.");
                    Thread.sleep(10000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Reload the database every 5 seconds
    public class DatabaseThread extends Thread {

        public Connection con;

        @Override
        synchronized public void run() {
            boolean connected = false;
            while (true) {
                try {
                    Thread.sleep(5000);
                    DatabaseConnection mysqlConnect = new DatabaseConnection();
                    con = mysqlConnect.connect();
    
                    if (!connected) {
                        System.out.println("| Database connection established successfully |\n| System log is currently running              |\n");
                        connected = true;
                    }
    
                    if (Session.userAccoundNumber == 0) {
                        System.out.println("Login Status | No user that is currently logged in.");
    
                        Session.userID = 0;
                        Session.userBalance = 0;
                        Session.userEmail = null;
                        Session.userName = null;
                        Session.userVerificationType = null;
    
                    } else {
                        System.out.println("Login Status | User " + Session.userAccoundNumber + " is currently logged in.");
    
                        PreparedStatement p = con.prepareStatement("SELECT userID, userBalance, userEmail, userName, verificationType FROM users where BINARY(userAccountNumber) = ? limit 1", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        p.setInt(1, Session.userAccoundNumber);
                        ResultSet r = p.executeQuery();
                        if (r.first()) {
                            int userID = r.getInt(1);
                            int userBalance = r.getInt(2);
                            String userEmail = r.getString(3);
                            String userName = r.getString(4);
                            String userVerificationType = r.getString(5);
    
                            Session.userID = userID;
                            Session.userBalance = userBalance;
                            Session.userEmail = userEmail;
                            Session.userName = userName;
                            Session.userVerificationType = userVerificationType;
                        }
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}