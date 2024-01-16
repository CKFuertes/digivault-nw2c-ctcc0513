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
    
    public void push(String data) {
        DenominationNode newNode = new DenominationNode(data);
        newNode.next = top;
        top = newNode;
    }
    
    public String pop() {
        if (isEmpty()) {
            return null;
        }

        if (top.next == null) {
            String poppedValue = top.data;
            top = null;
            return poppedValue;
        }

        DenominationNode current = top;
        while (current.next.next != null) {
            current = current.next;
        }

        String poppedValue = current.next.data;
        current.next = null;
        return poppedValue;
    }
    
    public int getSize() {
        int count = 0;
        DenominationNode current = top;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    
    public boolean isEmpty() {
        return top == null;
    }
}


