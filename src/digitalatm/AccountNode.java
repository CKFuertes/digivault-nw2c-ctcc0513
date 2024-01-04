package digitalatm;

public class AccountNode {
    //Declare variables. - Nami
    public String phoneNum, userName, pin;
    public int balance;
    public AccountNode next;
    
    //Empty Constructor. - Nami
    public AccountNode() {
        
    }
    
    //Constructor with parameters. - Nami
    public AccountNode(String phoneNum, String userName, String pin, int balance) {
        this.phoneNum = phoneNum;
        this.userName = userName;
        this.pin = pin;
        this.balance = balance; 
    }
}

