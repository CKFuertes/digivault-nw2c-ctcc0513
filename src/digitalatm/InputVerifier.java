package digitalatm;

public class InputVerifier {
    
    //Verify the phoneNum is not blank, numericla, and 11 digits.
    public boolean verifyPhoneNum(String phoneNum) {
        if (phoneNum.length()==11) {
           for (int i=0; i<phoneNum.length(); i++) {
                if (!Character.isDigit(phoneNum.charAt(i))) {
                    return false;
                }
            }
       }
       else {
           return false;
        }
       return true;
    }
    
    //Verify the name is not blank, alphabetical and not taken in createAccount.
    public boolean verifyName(String name) {
        if (!name.isBlank()) { 
            for (int i=0; i<name.length(); i++) {
                if (!Character.isLetter(name.charAt(i))) {
                    return false;
                }
            }
        }
        else {
            return false;
        }
        return true;
    }
    
    //Verify the pin is not blank and numerical.
    public boolean verifyPin(String pin) {
       if (pin.length()==4) {
           for (int i=0; i<pin.length(); i++) {
                if (!Character.isDigit(pin.charAt(i))) {
                    return false;
                }
            }
       }
       else {
           return false;
        }
       return true;
    }
    
    //Verify the initialDeposit is not blank, numerical and greater than 500.
    public boolean verifyInitialDeposit(String initialDepositStr) {
        if (!initialDepositStr.isBlank()) {
           for (int i=0; i<initialDepositStr.length(); i++) {
                if (!Character.isDigit(initialDepositStr.charAt(i))) {
                    return false;
                }
           }
           int initialDeposit = Integer.parseInt(initialDepositStr);
           
           if (initialDeposit < 500) {
               return false;
           }
        }
        else {
            return false;
        }
       return true;
    }
    
    //Verify the depositAmount is numerical and not blank.
    public boolean verifyDepositAmount(String depositAmount) {
       if (!depositAmount.isBlank()) {
           for (int i=0; i<depositAmount.length(); i++) {
                if (!Character.isDigit(depositAmount.charAt(i))) {
                    return false;
                }
            }
       }
       else {
           return false;
        }
       return true;
    }
    
    //Verify the withdrawtAmount is numerical, greater than the current balance, and not blank.
    public boolean verifyWithdrawAmount(String withdrawAmountStr, int balance) {
        if (!withdrawAmountStr.isBlank()) {
           for (int i=0; i<withdrawAmountStr.length(); i++) {
                if (!Character.isDigit(withdrawAmountStr.charAt(i))) {
                    return false;
                }
           }
           int withdrawAmount = Integer.parseInt(withdrawAmountStr);
           
           if (withdrawAmount > balance) {
               return false;
           }
        }
        else {
            return false;
        }
       return true;
    }
    
}

