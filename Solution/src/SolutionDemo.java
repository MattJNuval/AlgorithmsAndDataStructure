public class SolutionDemo {
    private Node root;

    private int height(Node curr) {
        if(curr == null) {
            return -1;
        }
        return curr.getHeight();
    }

    private int max(int a, int b) {
        if(a > b) {
            return a;
        }
        return b;
    }

    private int getBalance(Node curr) {
        if(curr == null) {
            return 0;
        }
        return height(curr.getLeft()) - height(curr.getRight());
    }

    public Node rotateRight(Node curr) {
        Node currLeft = curr.getLeft();
        Node currLeftRight = currLeft.getRight();

        currLeft.setRight(curr);
        curr.setLeft(currLeftRight);

        curr.setHeight(max(height(curr.getLeft()),height(curr.getRight()))+1);
        currLeft.setHeight(max(height(currLeft.getLeft()),height(currLeft.getRight()))+1);

        return currLeft;
    }

    public Node rotateLeft(Node curr) {
        Node currRight = curr.getRight();
        Node currRightLeft = currRight.getLeft();

        currRight.setLeft(curr);
        curr.setRight(currRightLeft);


        curr.setHeight(max(height(curr.getLeft()),height(curr.getRight()))+1);
        currRight.setHeight(max(height(currRight.getLeft()),height(currRight.getRight()))+1);

        return currRight;
    }

    public void insert(int data) {
        root = insertNode(data, root);
    }

    private Node insertNode(int data, Node curr) {
        if(curr == null) {
            System.out.println("Inserting " + data + " at root");
            Node newNode = new Node(data);
            curr = newNode;
        } else if(data <= curr.getData()) {
            if(curr.getLeft() == null) {
                System.out.println("Inserting " + data + " left of " + curr.getData());
                Node newNode = new Node(data);
                curr.setLeft(newNode);
            } else {
                insertNode(data, curr.getLeft());
            }
        } else {
            if(curr.getRight() == null) {
                System.out.println("Inserting " + data + " right of " + curr.getData());
                Node newNode = new Node(data);
                curr.setRight(newNode);
            } else {
                insertNode(data,curr.getRight());
            }
        }

        curr.setHeight(max(height(curr.getLeft()),height(curr.getRight()))+1);

        int balance = getBalance(curr);

        // left left case
        if(balance > 1 && data < curr.getLeft().getData()) {
            System.out.println("left left case");
            return rotateRight(curr);
        }
        //left right case
        if(balance > 1 && data > curr.getLeft().getData()) {
            System.out.println("left right case");
            curr.setLeft(rotateLeft(curr.getLeft()));
            return rotateRight(curr);
        }

        // right right case
        if(balance < -1 && data > curr.getRight().getData()) {
            System.out.println("right right case");
            return rotateLeft(curr);
        }

        // right left case
        if(balance < -1  && data < curr.getRight().getData()) {
            System.out.println("right left case");
            curr.setRight(rotateRight(curr.getRight()));
            return rotateLeft(curr);
        }

        return curr;
    }

    public void traverse() {
        traverseNode(root);
    }

    private void traverseNode(Node curr) {
        if(curr.getLeft() != null) {
            traverseNode(curr.getLeft());
        }
        System.out.print(curr.getData() + " ");
        if(curr.getRight() != null) {
            traverseNode(curr.getRight());
        }
    }
}
