public class AVL {
    private Node root;

    private int height(Node curr) {
        if(curr == null) {
            return -1;
        }
        return curr.height;
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
        return height(curr.left) - height(curr.right);
    }

    private Node rotateRight(Node curr) {
        Node currLeft = curr.left;
        Node currLeftRight = currLeft.right;

        currLeft.right = curr;
        curr.left = currLeftRight;

        curr.height = max(height(curr.left), height(curr.right)) + 1;
        currLeft.height = max(height(currLeft.left), height(currLeft.right)) + 1;
        return currLeft;
    }

    private Node rotateLeft(Node curr) {
        Node currRight = curr.right;
        Node currRightLeft = currRight.left;

        currRight.left = curr;
        curr.right = currRightLeft;

        curr.height = max(height(curr.left), height(curr.right)) + 1;
        currRight.height = max(height(currRight.left), height(currRight.right)) + 1;
        return currRight;
    }



    public void insert(int data) {
        System.out.println("Current data: " + data);
        root = insertNode(data, root);
    }

    private Node insertNode(int data, Node curr) {
        if(curr == null) {
            System.out.println("Inserting " + data + " as root");
            return new Node(data);
        }
        if(data <= curr.data) {
            curr.left = insertNode(data, curr.left);
        } else if(data > curr.data){
            curr.right = insertNode(data, curr.right);
        }

        curr.height = max(height(curr.left), height(curr.right)) +1;

        int balance = getBalance(curr);

        // left left case
        if(balance > 1 && data < curr.left.data) {
            System.out.println("Left Left Case");
            return rotateRight(curr);
        }

        // left right case
        if(balance > 1 && data > curr.left.data) {
            System.out.println("Left Right Case");
            curr.left = rotateLeft(curr.left);
            return rotateRight(curr);
        }

        //right right case
        if(balance < -1 && data > curr.right.data) {
            System.out.println("Right Right Case");
            return rotateLeft(curr);
        }

        // right left case
        if(balance < -1 && data < curr.right.data) {
            System.out.println("Right Left Case");
            curr.right = rotateRight(curr.right);
            return rotateLeft(curr);
        }

        return curr;

    }


    public void traverse() {
        root = traverseNode(root);
    }

    public Node traverseNode(Node curr) {
        if(curr.left != null) {
            traverseNode(curr.left);
        }
        System.out.print(curr.data + " ");
        if(curr.right != null) {
            traverseNode(curr.right);
        }
        return curr;
    }

}
