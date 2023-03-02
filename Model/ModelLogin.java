package Model;

public class ModelLogin {
    
    /* Actually there's a lot of ways to implement this, but when I am creating this app
     * this is the easiest way to make a login system. I was about to change this to something
     * complex but detailed but I'm lazy
    */

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
