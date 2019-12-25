public class Tree {
    private Node root;

    public void insert(int data) {
        insertNode(data, root);
    }

    private void insertNode(int data, Node curr) {
        if(root == null) {
            System.out.println("Inserting " + data + " at root.");
            Node newNode = new Node(data);
            curr = newNode;
            root = curr;
        } else if(data <= curr.getData()){
            if(curr.getLeft() == null) {
                System.out.println("Inserting " + data + " left of " + curr.getData());
                Node newNode = new Node(data);
                curr.setLeft(newNode);
            } else {
                System.out.println("Moving left from " + curr.getData());
                insertNode(data, curr.getLeft());
            }
        } else if(data > curr.getData()) {
            if(curr.getRight() == null) {
                System.out.println("Inserting " + data + " right of " + curr.getData());
                Node newNode = new Node(data);
                curr.setRight(newNode);
            } else {
                System.out.println("Moving right from " + curr.getData());
                insertNode(data, curr.getRight());
            }
        }
    }
}
