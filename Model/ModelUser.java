package Model;

public class ModelUser {

    // Same as the modellogin
    
    private int userID;
    private int userBalance;
    private int userAccoundNumber;
    private String userEmail;
    private String userName;
    private String userPinCode;
    private String verificationType;

    public ModelUser(int userID, int userBalance, int userAccoundNumber, String userEmail, String userName,
            String userPinCode, String verificationType) {
        this.userID = userID;
        this.userBalance = userBalance;
        this.userAccoundNumber = userAccoundNumber;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userPinCode = userPinCode;
        this.verificationType = verificationType;
    }

    public ModelUser() {
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

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

    public String getUserPinCode() {
        return userPinCode;
    }

    public void setUserPinCode(String userPinCode) {
        this.userPinCode = userPinCode;
    }

    public int getUserBalance() {
        return userBalance;
    }
    
    public void setUserBalance(int userBalance) {
        this.userBalance = userBalance;
    }

    public String getVerificationType() {
        return verificationType;
    }

    public void setVverificationType(String verificationType) {
        this.verificationType = verificationType;
    }
}
