package digitalatm;

class DenominationNode {
    int data;
    DenominationNode next;
    
    public DenominationNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DenominationStack {
    private DenominationNode top;
    
    public DenominationStack() {
        this.top = null;
    }
    
    public void push(int value) {
        DenominationNode newNode = new DenominationNode(value);
        newNode.next = top;
        top = newNode;
    }
}

