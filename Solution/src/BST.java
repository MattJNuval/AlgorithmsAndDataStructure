public class BST {
    private TreeNode root;
    private boolean result = false;

    public void insert(int data) {
        insertNode(data, root);
    }

    private void insertNode(int data, TreeNode curr) {
        System.out.println("INSERTING: " + data );
        if(root == null) {
            System.out.println("Inserting " + data + " as root.");
            TreeNode newNode = new TreeNode(data);
            curr = newNode;
            root = curr;
        } else if(data <= curr.getData()) {
            System.out.println(data + " <= " + curr.getData());
            if(curr.getLeft() != null) {
                System.out.println("Shift left of " + curr.getData() + " to " + curr.getLeft().getData());
                insertNode(data, curr.getLeft());
            } else {
                System.out.println("Inserting " + data + " left of " + curr.getData());
                TreeNode newNode = new TreeNode(data);
                curr.setLeft(newNode);
                curr.getLeft();
            }
        } else if(data > curr.getData()) {
            System.out.println(data + " > " + curr.getData());
            if(curr.getRight() != null) {
                System.out.println("Shift right of " + curr.getData() + " to " + curr.getRight().getData());
                insertNode(data, curr.getRight());
            } else {
                System.out.println("Inserting " + data + " right of " + curr.getData());
                TreeNode newNode = new TreeNode(data);
                curr.setRight(newNode);
            }
        }
    }

    public void search(int data) {
        searchNode(data, root);
    }

    private void searchNode(int data, TreeNode curr) {
        if(root == null) {
            System.out.println("Tree is empty");
        } else if(data < curr.getData()) {
            if(curr.getLeft() != null) {
                searchNode(data, curr.getLeft());
            } else {
                System.out.println("Data not found ");
            }
        } else if(data > curr.getData()) {
            if(curr.getRight() != null) {
                searchNode(data, curr.getRight());
            } else {
                System.out.println("Data not found ");
            }
        } else if(data == curr.getData()) {
            System.out.println("Data: " + data + " is found");
        }
    }

    public void traverse() {
        System.out.println();
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(TreeNode curr) {
        if(curr.getLeft() != null) {
            inOrderTraversal(curr.getLeft());
        }
        System.out.print( curr.getData()+", ");
        if(curr.getRight() != null) {
            inOrderTraversal(curr.getRight());
        }
    }
}
