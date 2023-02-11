package Model;

public class ModelLogin {
    private int accountNumber;
    private String userPinCode;

    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getUserPinCode() {
        return userPinCode;
    }
    public void setUserPinCode(String userPinCode) {
        this.userPinCode = userPinCode;
    }

    public ModelLogin(int accountNumber, String userPinCode) {
        this.accountNumber = accountNumber;
        this.userPinCode = userPinCode;
    }

    public ModelLogin() {
        
    }
}
