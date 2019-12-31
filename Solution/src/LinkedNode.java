public class LinkedNode {
    public int getData() {
        return data;
    }

    private int data;

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }

    private LinkedNode next;

    public LinkedNode(int data) {
        this.data = data;
    }


}
