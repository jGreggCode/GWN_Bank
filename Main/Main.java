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
        
        // To start the thread
        DatabaseThread dbThread = main.new DatabaseThread();
        ConsoleClearing consoleThread = main.new ConsoleClearing();
        dbThread.start();
        consoleThread.start();

        // Show the main frame
        new MainFrame().setVisible(true);

    }
    
    // Thread to clear the console every 30 seconds
    public class ConsoleClearing extends Thread {

        @Override
        synchronized public void run() {

            try {

                // Clear the console every 30 seconds
                while (true) {
                    System.out.print("\033[H\033[2J");  
                    System.out.println("\nNOTE: Console will be cleared every 10 seconds.");
                    Thread.sleep(30000);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    // Thread to reload the database every 5 seconds
    public class DatabaseThread extends Thread {

        // Databse connection
        public Connection con;

        @Override
        synchronized public void run() {

            // To check for connection
            boolean connected = false;

            // Loop while the program is open
            while (true) {

                try {
                    // Sleep every 5 seconds
                    Thread.sleep(5000);
                    DatabaseConnection mysqlConnect = new DatabaseConnection();
                    con = mysqlConnect.connect();
    
                    // If conneted to db set the connected to true
                    if (!connected) {
                        System.out.println("| Database connection established successfully |\n| System log is currently running              |\n");
                        connected = true;
                    }
    
                    // If no user is logged in Session must be empty
                    if (Session.userAccoundNumber == 0) {
                        System.out.println("Login Status | No user that is currently logged in.");
    
                        Session.userID = 0;
                        Session.userBalance = 0;
                        Session.userEmail = null;
                        Session.userName = null;
                        Session.userVerificationType = null;
    
                    } else {
                        // If a user is logged in
                        System.out.println("Login Status | User " + Session.userAccoundNumber + " is currently logged in.");
    
                        // SQL Syntax to get the user data
                        PreparedStatement p = con.prepareStatement("SELECT userID, userBalance, userEmail, userName, verificationType, userPinCode FROM users where BINARY(userAccountNumber) = ? limit 1", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        p.setInt(1, Session.userAccoundNumber);
                        ResultSet r = p.executeQuery();
                        
                        // Get the user data and store it in the session
                        if (r.first()) {
                            int userID = r.getInt(1);
                            int userBalance = r.getInt(2);
                            String userEmail = r.getString(3);
                            String userName = r.getString(4);
                            String userVerificationType = r.getString(5);
                            String userPinCode = r.getString(6);
    
                            Session.userID = userID;
                            Session.userBalance = userBalance;
                            Session.userEmail = userEmail;
                            Session.userName = userName;
                            Session.userVerificationType = userVerificationType;
                            Session.userPinCode = userPinCode;
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