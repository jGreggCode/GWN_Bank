package Backend;

public class RegisterValidation {

    public boolean fieldsNoOfChar(String password) {

        if (password.length() <= 10) {
            return false;
        }


        return true;
    }
}
