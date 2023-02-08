package Model;

public class ModelUser {
    private int userID;
    private int userAccoundNumber;
    private String userName;
    private String userPassword;
    private int userBalance;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getUserAccoundNumber() {
        return userAccoundNumber;
    }

    public void setUserAccoundNumber(int userAccoundNumber) {
        this.userAccoundNumber = userAccoundNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserBalance() {
        return userBalance;
    }
    
    public void setUserBalance(int userBalance) {
        this.userBalance = userBalance;
    }
}
