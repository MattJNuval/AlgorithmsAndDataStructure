public class Node {
    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public int getData() {
        return data;
    }

    private Node nextNode;
    private int data;

    public Node(int data) {
        this.data = data;
    }

}
