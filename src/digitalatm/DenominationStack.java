package digitalatm;

//Denomination Node Class.
class DenominationNode {
    String data;
    DenominationNode next;
    
    public DenominationNode(String data) {
        this.data = data;
        this.next = null;
    }
}

//Denomination Stack.
public class DenominationStack {
    private DenominationNode top;
    
    public DenominationStack() {
        this.top = null;
    }
    
    //Push Method.
    public void push(String data) {
        DenominationNode newNode = new DenominationNode(data);
        newNode.next = top;
        top = newNode;
    }
    
    //Pop Method.
    public String pop() {
        String poppedValue = top.data;
        top = top.next;
        return poppedValue;
    }
    
    //Checks if stack is empty.
    public boolean isEmpty() {
        return top == null;
    }
}


