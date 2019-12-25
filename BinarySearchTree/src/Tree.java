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


    public void find(int data) {
        System.out.println("\n\nFinding " + data);
        findNode(data, root);
    }

    private void findNode(int data, Node curr) {
        if(root == null) {
            System.out.println("Tree is empty");
        } else if(data < curr.getData()) {
            if(curr.getLeft() == null) {
                System.out.println("data not found");
            } else {
                System.out.println("Moving left from " + curr.getData() + " to " + curr.getLeft().getData());
                findNode(data, curr.getLeft());
            }
        } else if(data > curr.getData()) {
            if(curr.getRight() == null) {
                System.out.println("data not found");
            } else {
                System.out.println("Moving right from " + curr.getData() + " to " + curr.getLeft().getData());
                findNode(data, curr.getRight());
            }
        } else if(data == curr.getData()) {
            System.out.println("Current data: " + curr.getData() + " Expected data: " + data);
        }
    }

    public void inOrderTraversal() {
        System.out.println("\n\nTraversing");
        traverse(root);
    }

    private void traverse(Node curr) {
        if(root == null) {
            System.out.println("Tree is empty");
        }
        if(curr.getLeft() != null) {
            traverse(curr.getLeft());
        }
        System.out.print( curr.getData()+", ");
        if(curr.getRight() !=null) {
            traverse(curr.getRight());
        }
    }
}
