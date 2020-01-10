public class Node {
    private Node left;

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    private Node right;

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }


    private int data;

    public Node(int data) {
        this.data = data;
    }

}
